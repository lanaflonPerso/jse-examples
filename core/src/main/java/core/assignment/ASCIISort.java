package core.assignment;

import static java.lang.System.out;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ASCIISort {

    /**
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String...args) throws UnsupportedEncodingException {
        char stringChar[] = { 'Z', 'Y', 'X', 'W', 'V', 'U' };
        String string = new String(stringChar);
        byte[] bytes = string.getBytes(StandardCharsets.US_ASCII);
        Arrays.sort(bytes);
        String sortString = new String(bytes, StandardCharsets.US_ASCII);
        out.println(sortString);
    }
}