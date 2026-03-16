package br.com.movielist.util;

import java.io.InputStream;
import java.security.MessageDigest;

public final class HashFileCalculator {
	
	private HashFileCalculator() {}

	public static String calcHash(InputStream inputStream) throws Exception {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");

        byte[] buffer = new byte[4096];
        int bytesLidos;

        while ((bytesLidos = inputStream.read(buffer)) != -1) {
            digest.update(buffer, 0, bytesLidos);
        }

        byte[] hashBytes = digest.digest();

        StringBuilder hex = new StringBuilder();
        
        for (byte b : hashBytes) {
            String s = Integer.toHexString(0xff & b);
            if (s.length() == 1) {
                hex.append('0');
            }
            hex.append(s);
        }
        return hex.toString();
    }
}
