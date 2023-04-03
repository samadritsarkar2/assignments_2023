package org.example;

public class RunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Runnable Thread running " + Thread.currentThread());
    }
}
