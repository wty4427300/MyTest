package com.utils;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.GeneralBasicOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.GeneralBasicOCRResponse;
import com.tencentcloudapi.ocr.v20181119.models.TextDetection;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OcrUtils {

    public static Set<String> set = Set.of("IJOYxCGT*凉国际司游戏E*t",
            "|CGF中国游戏节",
            "2024/4/04-4/05 北京国家会议中心(地铁奥林匹克公园站E*H出)",
            "COSER",
            "自由行",
            "请自由行通过的小可爱添加一下本届自由行群",
            "QQ群:952454739",
            "出镜矮乐多",
            "COSER自由行通过名单最终弹",
            "04/04",
            "序号",
            "CN",
            "手机号",
            "04/05",
            "IJOYXCGT|北京国际动国游B征欢,※请自由行通过的小可爱添加一下本届自由行群");


    public static Optional<GeneralBasicOCRResponse> ocrRequest(String imgBase64) {
        try {
            Credential cred = new Credential("AKID9FF74GeTL9sYBj8QfostoqmbM0XwDKIE", "10ukbacoBhCmis2JazUzWDFTpPxTp8NY");
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("ocr.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            OcrClient client = new OcrClient(cred, "ap-beijing", clientProfile);

            GeneralBasicOCRRequest req = new GeneralBasicOCRRequest();
            req.setImageBase64(imgBase64);
            GeneralBasicOCRResponse resp = client.GeneralBasicOCR(req);
            return Optional.of(resp);
        } catch (TencentCloudSDKException e) {
            System.out.println(e);
        }
        return Optional.empty();
    }

    private static List<String> readAndConvertImagesToBase64(String resourcePath) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = Objects.requireNonNull(classLoader.getResource(resourcePath)).getPath();
        String substring = path.substring(1);
        try (Stream<Path> walk = Files.walk(Paths.get(substring))) {
            return walk
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .filter(s -> s.matches(".*\\.(jpg|jpeg|png)")) // Include only JPEG and PNG files
                    .map(OcrUtils::readImageAndEncodeToBase64)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error reading images from directory: " + path, e);
        }
    }

    public static String readImageAndEncodeToBase64(String imagePath) {
        try {
            Path imageFilePath = Paths.get(imagePath);
            BufferedImage image = ImageIO.read(imageFilePath.toFile());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", outputStream);
            return Base64.getEncoder().encodeToString(outputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Error reading or encoding image: " + imagePath, e);
        }
    }

    private static final int OCR_THREAD_COUNT = 32; // 调整OCR线程数量
    private static final int WRITER_THREAD_COUNT = 1; // 单独的写入线程数量
    private static final Path OUTPUT_FILE_PATH = Paths.get("output.txt"); // 指定输出文件路径

    public static void main(String[] args) throws IOException, InterruptedException {
        String resourcePath = "img";
        List<String> base64EncodedImages = readAndConvertImagesToBase64(resourcePath);

        ExecutorService ocrExecutorService = Executors.newFixedThreadPool(OCR_THREAD_COUNT);
        ExecutorService writerExecutorService = Executors.newFixedThreadPool(WRITER_THREAD_COUNT);

        ConcurrentLinkedQueue<String> outputQueue = new ConcurrentLinkedQueue<>();
        AtomicInteger taskCount = new AtomicInteger(base64EncodedImages.size());

        for (String base64EncodedImage : base64EncodedImages) {
            ocrExecutorService.submit(() -> {
                Optional<GeneralBasicOCRResponse> optional = OcrUtils.ocrRequest(base64EncodedImage);
                if (optional.isPresent()) {
                    GeneralBasicOCRResponse response = optional.get();
                    Arrays.stream(response.getTextDetections())
                            .map(TextDetection::getDetectedText)
                            .filter(detectedText -> !set.contains(detectedText))
                            .forEach(outputQueue::add);
                }

                if (taskCount.decrementAndGet() == 0) {
                    outputQueue.add(null); // 添加一个特殊标记表示所有OCR任务已完成
                }
            });
        }

        writerExecutorService.submit(() -> {
            try (BufferedWriter writer = Files.newBufferedWriter(OUTPUT_FILE_PATH, StandardCharsets.UTF_8)) {
                int count = 0;
                while (true) {
                    String output = outputQueue.poll();
                    if (output == null) {
                        if (taskCount.get() == 0) {
                            break; // 所有OCR任务已完成，且队列已清空，退出循环
                        } else {
                            continue; // 未收到特殊标记，继续等待
                        }
                    }
                    count += 1;
                    try {
                        writer.write(output + ",");
                        if (count == 3) {
                            writer.newLine();
                            count = 0;
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        ocrExecutorService.shutdown();
        ocrExecutorService.awaitTermination(1, TimeUnit.MINUTES);

        writerExecutorService.shutdown();
        writerExecutorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}