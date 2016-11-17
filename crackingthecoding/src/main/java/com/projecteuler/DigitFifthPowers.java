package main.java.com.projecteuler;

/**
 * Surprisingly there are only three numbers that can be written as the sumOfAll of fourth powers of their digits:

 1634 = 1^4 + 6^4 + 3^4 + 4^4
 8208 = 8^4 + 2^4 + 0^4 + 8^4
 9474 = 9^4 + 4^4 + 7^4 + 4^4
 As 1 = 1^4 is not a sumOfAll it is not included.

 The sumOfAll of these numbers is 1634 + 8208 + 9474 = 19316.

 Find the sumOfAll of all the numbers that can be written as the sumOfAll of fifth powers of their digits.
 */
public class DigitFifthPowers {
    public static void main(String...args) {
        digitFourthPower(999999, 5);
    }

    public static void digitFourthPower(int n, int pow){
        if(n<10){
            return;
        }else{
            int sum = 0;
            for(int i = n; i>=10; i--){
                if(i == sumOfPower(i, pow)){
                    System.out.println(i);
                    sum += i;
                }
            }
            System.out.println("Sum : " + sum);
        }
    }

    public static int sumOfPower(int n, int pow){
        int sum = 0;
        while(n >=1){
            int digit = n % 10;
            sum += Math.pow(digit, pow);
            n = n / 10;
        }
        return sum;
    }
}
