package core.java8.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by ehimnay on 01/10/2016.
 */
public class Encoding {
    public static void main(String...args) {
        String encodedString = encoding();
        decoding(encodedString);
    }

    public static String encoding() {
        Base64.Encoder encoder = Base64.getEncoder();
        String normalString = "username:password";
        String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));
        System.out.println(encodedString);
        return encodedString;
    }

    public static void decoding(String encodedString) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByteArray = decoder.decode(encodedString);
        System.out.println(new String(decodedByteArray));
    }
}
