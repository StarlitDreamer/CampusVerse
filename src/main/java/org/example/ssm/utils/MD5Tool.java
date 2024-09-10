package org.example.ssm.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Tool {

    /**
     * 生成输入字符串的 MD5 哈希值。
     *
     * @param inputString 需要哈希的字符串
     * @return MD5 哈希值的十六进制表示
     */
    public static String generateMD5(String inputString) {
        try {
            // 创建 MD5 哈希算法实例
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 计算哈希值
            byte[] hashBytes = md.digest(inputString.getBytes());

            // 将哈希值转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 算法不可用", e);
        }
    }

    /**
     * 验证输入字符串的 MD5 哈希值是否与给定的哈希值匹配。
     *
     * @param inputString 需要验证的字符串
     * @param md5Hash     需要比对的 MD5 哈希值
     * @return 如果匹配返回 true，否则返回 false
     */
    public static boolean verifyMD5(String inputString, String md5Hash) {
        return generateMD5(inputString).equals(md5Hash);
    }

    public static void main(String[] args) {
        String text = "Hello, World!";
        String md5Value = generateMD5(text);
        System.out.println("MD5: " + md5Value);

        // 验证哈希
        boolean isValid = verifyMD5(text, md5Value);
        System.out.println("验证结果: " + isValid);
    }
}

