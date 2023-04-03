package org.example;

public class Thread1 extends Thread{

    public Thread1(String name){
        super(name);
    }


    @Override
    public void run(){
        System.out.println("Running Thread : "+  Thread.currentThread() + " ");
    }

}
