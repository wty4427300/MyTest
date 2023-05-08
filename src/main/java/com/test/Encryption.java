package com.test;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;

/**
 * 加解密的简单例子
 */
public class Encryption {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private static String decryptS5(String sSrc, String sKey, String ivParameter) {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] raw = decoder.decodeBuffer(sKey);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            IvParameterSpec iv = new IvParameterSpec(decoder.decodeBuffer(ivParameter));
            byte[] myendicod = decoder.decodeBuffer(sSrc);
            byte[] data;
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
                data = cipher.doFinal(myendicod);
            } catch (Exception e) {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
                data = cipher.doFinal(myendicod);
            }
            return new String(data, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String decryptToString(String sSrc, String sKey, String ivParameter) throws GeneralSecurityException, IOException {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] raw = decoder.decodeBuffer(sKey);
            byte[] myendicod = decoder.decodeBuffer(sSrc);
            SecretKeySpec key = new SecretKeySpec(raw, "AES");
            IvParameterSpec iv = new IvParameterSpec(decoder.decodeBuffer(ivParameter));
            cipher.init(2, key, iv);
            byte[] data = cipher.doFinal(myendicod);
            return new String(data, StandardCharsets.UTF_8);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException var7) {
            throw new IllegalStateException(var7);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException var8) {
            throw new IllegalArgumentException(var8);
        }
    }

    public static void main(String[] args) {
    }
}
