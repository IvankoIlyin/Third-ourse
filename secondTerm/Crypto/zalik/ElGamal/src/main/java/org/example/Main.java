package org.example;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        final String[] arr = {"4", "6", "8", "9", "10", "12", "14", "15", "16", "18", "20", "21", "22",
                "24", "25", "26", "27", "28","30", "32", "33", "34", "35", "36", "38",
                "39", "40", "42", "44", "45", "46", "48", "49", "50", "51", "52", "54"};

        final int NUMBER_OF_TESTS = arr.length;

        for(int i = 0; i < NUMBER_OF_TESTS; i++){
            BigInteger num = new BigInteger(arr[i]);
            BigInteger currElGamal = new ElGamal().run(num);
            if(num.equals(currElGamal)){
                System.out.println("Correct: "+num+" / "+ currElGamal);
            }
            else{
                System.out.println("Non correct: "+num+" / "+ currElGamal);
            }
        }
    }
}