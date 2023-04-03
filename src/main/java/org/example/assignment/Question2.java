package org.example.assignment;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Question2 {

    // Prints first 5 numbers using Callable

    public static void main(String[] args){

        int N = 5;

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

       Future<List<Integer>> future = singleThreadExecutor.submit(new PrimeNumberCallable(N));

        try {
           List<Integer> result = future.get();

            System.out.printf("List of first %d prime numbers are: \n", N);
            for(Integer i : result){
                System.out.println(i);
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        singleThreadExecutor.shutdown();
    }

}
