package com.design_patterns.composite.test1;

import lombok.Getter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 让用户已处理FileSystemNode的方式
 * 统一的处理文件和目录
 */
@Getter
public class FileSystemNode {

    private final String path;

    private boolean isFile;

    private final List<FileSystemNode> subNodes = new ArrayList<>();

    public FileSystemNode(String path) {
        this.path = path;
    }

    public FileSystemNode(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
    }

    /**
     * 统计文件个数
     */
    public int countNumOfFiles() {
        //是文件返回1
        if (isFile) {
            return 1;
        }
        int numOfFiles = 0;
        //是目录就递归
        for (FileSystemNode fileOrDir : subNodes) {
            numOfFiles += fileOrDir.countNumOfFiles();
        }
        return numOfFiles;
    }

    public long countSizeOfFiles() {
        //是文件返回文件大小
        if (isFile) {
            File file = new File(path);
            if (!file.exists()) return 0;
            return file.length();
        }
        //递归目录
        long sizeofFiles = 0;
        for (FileSystemNode fileOrDir : subNodes) {
            sizeofFiles += fileOrDir.countSizeOfFiles();
        }
        return sizeofFiles;
    }

    public void addSubNode(FileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    public void removeSubNode(FileSystemNode fileOrDir) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; ++i) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }
        }
        if (i < size) {
            subNodes.remove(i);
        }
    }
}