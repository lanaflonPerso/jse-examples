package main.java.com.zalando;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class HotelElevator {
    public static void main(String[] args) {
        int A[] = {40, 40, 100, 80, 20};
        int B[] = {3, 3, 2, 2, 3};
        System.out.println(new HotelElevator().solution(A, B, 3, 5, 200));
    }

    public int solution(int[] A, int[] B, int M, int X, int Y) {
        Set<Integer> stops = new HashSet<>();

        int weight = 0;
        int count = 0;
        int stopsTotal = 0;

        for (int i = 0; i < A.length; i++) {

            count++;
            weight += A[i];

            if (count > X || weight > Y) {
                stopsTotal += stops.size();
                stops.clear();
                count = 0;
                weight = 0;
                i--;
                stopsTotal++;

            } else {
                stops.add(B[i]);
            }
        }

        return stopsTotal + 1 + stops.size();
    }
}