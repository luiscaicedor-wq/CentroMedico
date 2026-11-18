package com.nestorsalinas.centromedico.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {
    public static String hashPassword(String password) {
        if (password == null) return "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return password;
        }
    }

    public static boolean checkPassword(String inputPassword, String storedHash) {
        if (inputPassword == null || storedHash == null) return false;
        String inputHash = hashPassword(inputPassword);
        return inputHash.equals(storedHash) || inputPassword.equals(storedHash);
    }
}