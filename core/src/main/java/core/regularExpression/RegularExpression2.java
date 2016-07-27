package core.regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression2 {
    public static void main(String... strings) {
        final String SEARCH = "man";
        final String EXPRESSION = "Himansu Nayak";
        splitWhiteSpace();
    }

    public static void find(String search, String expression) {
        Pattern pattern = Pattern.compile(search, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            System.out.println("Search : " + matcher.group());
            System.out.println("Index : " + matcher.start());
            System.out.println("End : " + matcher.end());
        }
    }

    public static void replace(String replace, String expression) {
        Pattern pattern = Pattern.compile("man", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(expression);
        System.out.println("Replace : " + matcher.replaceAll(replace));
    }

    public static void splitWordsSpecialCharacter() {
        String expression = "http://java.sun.com/j2se/1.4.2/docs/api/java/net/URL.html";
        Pattern pattern = Pattern.compile("\\W");
        String[] words = pattern.split(expression);
        for (String split : words) {
            System.out.println("Split Words : " + split);
        }

        pattern = Pattern.compile("\\w");
        words = pattern.split(expression);
        for (String split : words) {
            System.out.println("Split Special Character : " + split);
        }
    }

    public static void splitNumber() {
        String expression = "127.0.0.1";
        Pattern pattern = Pattern.compile("\\d");
        String split[] = pattern.split(expression);
        for (String token : split) {
            System.out.println(token);
        }
    }

    public static void splitWhiteSpace() {
        String expression = "I was HashMapCustom bit surprised the other day";
        Pattern pattern = Pattern.compile("\\s");
        String split[] = pattern.split(expression);
        for (String token : split) {
            System.out.println(token);
        }
    }
}
