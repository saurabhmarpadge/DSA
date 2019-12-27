package com.primenumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SieveOfEratosthenes {
    public static final int MAX_LIMIT = 2000000;
    public static void main(String[] args){

        List<Integer> primes = sieveOfEratosthenes();
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        while(tc-->0){
            int limit = in.nextInt();
            System.out.println(primes.stream().filter(t->t<=limit).mapToLong(t->t).sum());
        }
    }
    public static List<Integer> sieveOfEratosthenes(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 2500000; i++) {
            list.add(0);
        }
        for(int idx=2;idx<MAX_LIMIT;idx++){
            if(list.get(idx)==1){
                continue;
            }
            for(int nIdx = 2*idx;nIdx<MAX_LIMIT;nIdx+=idx){
                list.set(nIdx,1);
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int idx=2;idx<MAX_LIMIT;idx++){
            if(list.get(idx)==0){
                primes.add(idx);
            }
        }
        return primes;
    }
}
