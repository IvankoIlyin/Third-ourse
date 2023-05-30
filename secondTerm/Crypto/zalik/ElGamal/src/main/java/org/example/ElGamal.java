package org.example;

import java.security.SecureRandom;
import java.util.*;
import java.math.BigInteger;


public class ElGamal {

    static BigInteger p, g, y;
    static BigInteger a, b, k, EC, M;
    static BigInteger secretKey = new BigInteger("1488");;
    static Random sc = new SecureRandom();

    public static BigInteger run (BigInteger num){
        publicKeyCalculation();
        encryption(num);
        return decryption();
    }

    private static void publicKeyCalculation(){
        p = BigInteger.probablePrime(64, sc);
        g = new BigInteger("3");
        y = g.modPow(secretKey, p);
    }

    private static void encryption(BigInteger X){
        k = new BigInteger(64, sc);
        EC = X.multiply(y.modPow(k, p)).mod(p);

        a = g.modPow(k, p);
        b = a.modPow(secretKey, p);
    }

    private static BigInteger decryption(){
        BigInteger d = b.modInverse(p);
        M = d.multiply(EC).mod(p);
        return M;
    }


}

