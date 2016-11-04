package main.java.com.zalando;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by ehimnay on 04/11/2016.
 */
public class Password {
    public static void main(String[] args) throws Exception {
        System.out.println(new Password().solution("a0Ba"));
        System.out.println(new Password().solution("a0bb"));
    }

    public int solution(String S) {
        if (S.length() > 200) {
            throw new IllegalArgumentException("Length of the String is greater than 200");
        }
        Optional<String> bestPassword = Stream.of(S.split("[0-9]"))
                .filter(Password::containsCapital)
                .sorted((o1, o2) -> o1.length() > o2.length() ? 1 : 0)
                .findFirst();

        if (bestPassword.isPresent()) {
            return bestPassword.get().length();
        } else {
            return -1;
        }
    }

    private static boolean containsCapital(final String word) {
        return word.chars().anyMatch(Character::isUpperCase);
    }
}
