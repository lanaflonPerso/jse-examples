package core.encrypt;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

public class Base64Binary {
    public static void main(String... himansu) throws UnsupportedEncodingException {
        System.out.println(DatatypeConverter.parseBase64Binary("Himansu"));
        System.out.println(new String(DatatypeConverter.parseBase64Binary("Himansu"), "UTF-8"));
    }
}
