package main.java.com.projecteuler;

import java.util.Arrays;

/**
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 * 
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p How many different ways can £2 be made using any number of coins?
 */
public class CoinSums {
    public static void main(String...args) {
        coinSum();
    }

    public static void coinSum(){
        int target = 200;
        int[] coinSizes = { 1, 2, 5, 10, 20, 50, 100, 200 };
        int[] ways = new int[target+1];
        ways[0] = 1;

        for (int i = 0; i < coinSizes.length; i++) {
            for (int j = coinSizes[i]; j <= target; j++) {
                ways[j] += ways[j - coinSizes[i]];
            }
        }

        for(int way : ways){
            System.out.println(way);
        }
    }
}
