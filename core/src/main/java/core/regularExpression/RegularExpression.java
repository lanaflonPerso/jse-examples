package core.regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

    public static void main(String...args) {
        Pattern pattern = Pattern.compile("MAN", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Himansu Nayak");
        while (matcher.find()) {
            System.out.println("Found the text \"" + matcher.group() + "\" starting at " + matcher.start()
                    + " index and ending at index " + matcher.end());
        }
        /*
         * pattern = Pattern.compile("\\W"); String...argswords = pattern.split("one@two#three:four$five"); for (String
         * s : words) { System.out.println("Split using Pattern.split(): " + s); }
         * 
         * // using Matcher.replaceFirst() and replaceAll() methods pattern = Pattern.compile("1*2"); matcher =
         * pattern.matcher("11234512678"); System.out.println("Using replaceAll: " + matcher.replaceAll("_"));
         * System.out.println("Using replaceFirst: " + matcher.replaceFirst("_"));
         */
    }

}