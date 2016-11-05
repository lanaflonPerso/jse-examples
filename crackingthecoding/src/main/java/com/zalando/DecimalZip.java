package com.zalando;

/**
 * The decimal zip of two non-negative integers A and B is an integer C whose decimal representation is created from the decimal representations of A and B
 * as follows:
 * the first (i.e. the most significant) digit of C is the first digit of A;
 * the second digit of Cis the first digit of B;
 * the third digit of C is the second digit of A;
 * the fourth digit of C is the second digit of B;
 * If one of the integers A and B runs out of digits, the remaining digits of the other integer are appended to the result.
 * The decimal representation of 0 is assumed. be "0". For example, the decimal zip of 12 and 56 is 1526. The decimal zip of 56 and 12 is 5162.
 * The decimal zip of 12345 and 678 is 16273845. The decimal zip of 123 and 67890 is 16273890. The decimal zip of 1234 and 0 is 10234.
 * Write a function that, given two non-negative integers A and B, returns their decimal zip. The function should return , if the result exceeds 100,000,000.
 * For example, given A =12345 and B = 678 the function should return 16273845, as explained above.
 * Assume that:
 * A and B are integers within the range [0...100,000,0001]
 * A your solution, focus on correctness. The performance of your solution will not be the focus of the assessment
*/
public class DecimalZip {
    public static void main(String...args){
        System.out.println(new DecimalZip().solution(12, 56));
        System.out.println(new DecimalZip().solution(123, 67890));
        System.out.println(new DecimalZip().solution(56, 12));
        System.out.println(new DecimalZip().solution(0, 10234));
        System.out.println(new DecimalZip().solution(12345, 678));
        System.out.println(new DecimalZip().solution(0, 0));
    }

    public int solution(int A, int B) {
        final String sA = Integer.toString(A), sB = Integer.toString(B);
        final int minLen;

        if (sA.length() < sB.length()) {
            minLen = sA.length();
        } else {
            minLen = sB.length();
        }

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            sb.append(sA.charAt(i));
            sb.append(sB.charAt(i));
        }

        sb.append(sA.substring(minLen, sA.length()));
        sb.append(sB.substring(minLen, sB.length()));

        final long zip = Long.parseLong(sb.toString());

        return zip > 100_000_000 ? -1 : (int)zip;
    }
}
