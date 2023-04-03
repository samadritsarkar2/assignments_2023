package org.example.assignment;

import java.util.concurrent.Semaphore;

public class OddNumber implements Runnable {

    int limit;
    Semaphore self, other;
    public OddNumber(int limit, Semaphore self, Semaphore other)
    {
        this.self = self;
        this.other = other;
        this.limit = limit;
    }

    @Override
    public void run(){

        for(int i=1;i<=limit;i++)
        {
            if (i % 2 != 0) {
                try {
                    self.acquire();
                } catch (InterruptedException e) {
                }
                System.out.println(i);
                other.release();

            }
        }

    }
}
