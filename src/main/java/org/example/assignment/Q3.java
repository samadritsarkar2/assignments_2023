package org.example.assignment;


import java.util.concurrent.Semaphore;

public class Q3 {

    private static Semaphore sem = new Semaphore(1);
    private static int curr = 1;

    private static int limit = 20;

    public static void main(String[] args) throws InterruptedException {

        Thread odd = new Thread(new Runnable() {

            @Override
            public void run() {
                while (curr <= limit)
                {
                    try {
                        sem.acquire();
                        if (curr % 2 != 0) {
                            System.out.println(curr);
                            curr++;
                        }
                        sem.release();
                    }catch (Exception e)
                    {

                    }

                }
            }
        });

        Thread even = new Thread(new Runnable() {

            @Override
            public void run() {
                while(curr <= limit)
                {
                    try {
                        sem.acquire();
                        if (curr % 2 == 0) {
                            System.out.println(curr);
                            curr++;
                        }
                        sem.release();
                    }catch (Exception e)
                    {

                    }

                }
            }
        });

      odd.start();
      even.start();


    }
}
