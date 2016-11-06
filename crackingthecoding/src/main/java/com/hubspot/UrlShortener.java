package com.hubspot;

public class UrlShortener {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int    BASE     = ALPHABET.length();

    public static String encode(int num) {
        final StringBuilder sb = new StringBuilder();
        while ( num > 0 ) {
            sb.append( ALPHABET.charAt( num % BASE ) );
            num /= BASE;
        }
        return sb.reverse().toString();
    }

    public static int decode(final String str) {
        int num = 0;
        for ( int i = 0; i < str.length(); i++ )
            num = num * BASE + ALPHABET.indexOf(str.charAt(i));
        return num;
    }

    public static void main(String...args) {
        final String encoded = encode(12);
        final int decoded = decode(encoded);
        if(12 == decoded){
            System.out.println("encoding/decoding works successfully.");
        }else{
            System.out.println("encoding/decoding failed.");
        }
    }
}
