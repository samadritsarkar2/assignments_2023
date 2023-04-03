package org.example.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PrimeNumberCallable implements Callable {

    int N;
   public PrimeNumberCallable(int N)
    {
        this.N = N;
    }

    Boolean isPrime(int n){
        if(n==1||n==0)return false;

        for(int i=2; i<n; i++){

            if(n%i==0)return false;
        }

        return true;
    }
    @Override
    public List<Integer> call() throws Exception {

        int i = 0;
        List<Integer> res = new ArrayList<Integer>(N);

        while(this.N>0){
            if(isPrime(i)) {
                res.add(i);
                this.N--;
            }
            i++;
        }


        return res;
    }
}
