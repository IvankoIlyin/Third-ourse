package org.example;

import javax.crypto.Cipher;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;


public final class JavaPGP {


    //шифрування повідомлення з використанням публічного ключа RSA
    public static byte[] encrypt(byte[] message, PublicKey key) throws GeneralSecurityException {
        //Створюється об'єкт KeyPair за допомогою виклику generateKeyPair()
        KeyPair pair = generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();

        //Створюється об'єкт Cipher з використанням алгоритму RSA
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        //Застосовується метод doFinal об'єкта Cipher до повідомлення message, щоб зашифрувати його
        byte[] encryptedMessage = cipher.doFinal(message);

        cipher.init(Cipher.ENCRYPT_MODE, key);

        //Застосовується метод doFinal об'єкта Cipher до закодованого публічного ключа pair.getPublic().getEncoded()
        byte[] encryptedPublicKey = cipher.doFinal(pair.getPublic().getEncoded());


        //Створюється об'єкт ByteBuffer, якому відводиться пам'ять для зберігання закодованого публічного ключа та зашифрованого повідомлення
        ByteBuffer buffer = ByteBuffer.allocate((encryptedPublicKey.length + encryptedMessage.length) + 4);
        //Записується довжина закодованого публічного ключ
        buffer.putInt(encryptedPublicKey.length);
        //Записується закодований публічний ключ
        buffer.put(encryptedPublicKey);
        //Записується зашифроване повідомлення
        buffer.put(encryptedMessage);
        //Повертається масив байтів, отриманий з ByteBuffer
        return buffer.array();
    }

    //виконує розшифрування повідомлення з використанням приватного ключа RSA
    public static byte[] decrypt(byte[] message, PrivateKey key) throws GeneralSecurityException {
        ByteBuffer buffer = ByteBuffer.wrap(message);
        //читується довжина закодованого публічного ключа
        int keyLength = buffer.getInt();
        byte[] encyptedPublicKey = new byte[keyLength];
        buffer.get(encyptedPublicKey);

        // об'єкт Cipher з використанням алгоритму RSA
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);

        //Застосовується метод doFinal об'єкта Cipher до encyptedPublicKey, щоб розшифрувати його
        byte[] encodedPublicKey = cipher.doFinal(encyptedPublicKey);


        //Викликається метод getPublicKey, який приймає encodedPublicKey і повертає об'єкт PublicKey
        PublicKey publicKey = getPublicKey(encodedPublicKey);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        //Створюється байтовий масив encryptedMessage, якому присвоюється решта байтів з ByteBuffer
        byte[] encryptedMessage = new byte[buffer.remaining()];
        buffer.get(encryptedMessage);

        //Застосовується метод doFinal об'єкта Cipher до encryptedMessage, щоб розшифрувати його
        return cipher.doFinal(encryptedMessage);
    }


    //отримує закодований у форматі байтів ключ і використовує його для створення об'єкту PublicKey
    protected static PublicKey getPublicKey(byte[] encodedKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //об'єкт використовується для створення ключів з використанням алгоритму RSA
        KeyFactory factory = KeyFactory.getInstance("RSA");
        //б'єкт представляє закодований ключ у форматі X.509
        X509EncodedKeySpec encodedKeySpec = new X509EncodedKeySpec(encodedKey);
        //генерує об'єкт PublicKey з використанням закодованого ключа.
        return factory.generatePublic(encodedKeySpec);
    }

    //генерує пару ключів за допомогою алгоритму RSA
    protected static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        //об'єкт використовується для генерації ключевої пари RSA
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        //встановлює параметри генерації ключів
        keyPairGenerator.initialize(1024, SecureRandom.getInstance("SHA1PRNG"));
        return keyPairGenerator.generateKeyPair();
    }


}