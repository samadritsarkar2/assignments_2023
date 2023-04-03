package org.example.assignment;

public class Question1 {

    // Print first 5 prime numbers using runnable



    public static void main(String[] args){

        System.out.println("Running Q1: ");

        Thread printPrimeNumbers = new Thread(new PrimeNumbersRunnable(6) );

        printPrimeNumbers.run();

    }



}
