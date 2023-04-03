package org.example.assignment;

public class PrimeNumbersRunnable implements Runnable {

    Integer N;
    PrimeNumbersRunnable(int N){
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
    public void run(){
        int i = 0;

        while(this.N>0){
            if(isPrime(i)) {
                System.out.println(i);
                this.N--;
            }
            i++;
        }

    }

}
