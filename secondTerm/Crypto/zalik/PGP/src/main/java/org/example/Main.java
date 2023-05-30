package org.example;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        try {
            // Генерация ключевой пары
            KeyPair keyPair = JavaPGP.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();


            String message = "World!";
            byte[] messageBytes = message.getBytes();


            byte[] encryptedMessage = JavaPGP.encrypt(messageBytes, publicKey);


            byte[] decryptedMessage = JavaPGP.decrypt(encryptedMessage, privateKey);

            String decryptedString = new String(decryptedMessage);

            // Вывод результатов
            System.out.println("Original message: " + message);
            System.out.println("Encrypted message: " + Base64.getEncoder().encodeToString(encryptedMessage));
            System.out.println("Decrypted message: " + decryptedString);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}