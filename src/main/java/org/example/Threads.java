package org.example;

import org.example.RunnableThread;
import org.example.Thread1;

public class Threads {


        public static void main(String[] args){
            System.out.println("hello threads");

            Thread thread1 = new Thread1("first thread");

            thread1.start();

            Thread thread2 = new Thread(new RunnableThread(), "runnable");
            thread2.start();

        }

}