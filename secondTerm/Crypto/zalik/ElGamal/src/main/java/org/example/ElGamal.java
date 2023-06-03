package org.example;

import java.security.SecureRandom;
import java.util.*;
import java.math.BigInteger;


public class ElGamal {

    static BigInteger p, g, y;
    static BigInteger a, b, k, EC, M;
    static BigInteger secretKey = new BigInteger("1488");;
    static Random sc = new SecureRandom();

    //виконує повний цикл шифрування та розшифрування для заданого числа num за допомогою алгоритму Ель-Гамаля
    public static BigInteger run (BigInteger num){
        //обчислює відкритий ключ для алгоритму Ель-Гамаля
        publicKeyCalculation();
        //шифрування вхідного числа num
        encryption(num);
        //розшифрування шифрованого повідомлення
        return decryption();
    }

    //обчислення відкритого ключа для алгоритму Ель-Гамаля
    private static void publicKeyCalculation(){
        //Генерується випадкове просте число з 64-бітною довжиною
        p = BigInteger.probablePrime(64, sc);
        //генератор групи чисел за модулем p в алгоритмі Ель-Гамаля
        g = new BigInteger("3");
        //Обчислюється значення відкритого ключа y за формулою y = g^secretKey mod p
        y = g.modPow(secretKey, p);
    }

    //шифрування повідомлення з використанням алгоритму Ель-Гамаля
    private static void encryption(BigInteger X){
        //Генерується випадкове число k з 64-бітною довжиною
        k = new BigInteger(64, sc);
        //обчислюється шифрований текст EC за формулою EC = X * y^k mod p
        EC = X.multiply(y.modPow(k, p)).mod(p);

        //обчислюється значення a за формулою a = g^k mod p
        a = g.modPow(k, p);
        //обчислюється значення b за формулою b = a^secretKey mod p
        b = a.modPow(secretKey, p);
    }

    //розшифрування зашифрованого повідомлення з використанням алгоритму Ель-Гамаля
    private static BigInteger decryption(){
        //обчислюється обернене значення d для b за модулем p
        BigInteger d = b.modInverse(p);
        //обчислюється розшифроване повідомлення M за формулою M = d * EC mod p, де d - обернене значення b, EC - шифрований текст, p - просте число
        M = d.multiply(EC).mod(p);
        return M;
    }


}

