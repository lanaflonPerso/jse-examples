package main.java.com.zalando;

/**
 * Created by ehimnay on 04/11/2016.
 */
public class DecimalZip {
    public static void mina(String...args){

    }

    public static int solution(int A, int B) {
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

        if (zip > 100_000_000) {
            return -1;
        }
        return (int)zip;
    }
}
