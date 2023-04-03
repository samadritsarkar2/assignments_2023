package org.example.assignment;

import java.util.concurrent.Semaphore;

public class Question3 {



    public static void main(String[] args) throws InterruptedException {

        int limit = 20;

        Semaphore a = new Semaphore(1);
        Semaphore b = new Semaphore(0);


        Thread oddThread = new Thread(new OddNumber(limit, a, b) );
        Thread evenThread = new Thread(new EvenNumber(limit, b, a));


            oddThread.start();
        evenThread.start();

    }

}
