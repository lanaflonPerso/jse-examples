package com.zalando;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * You would like to set a password for an email account. However, there are two restrictions on the format of the password.
 * It has to contain at least one uppercase character and it cannot contain any digits
 * You are given a string S consisting of N alphanumerical characters. You would like to find the longest substring of S that is a valid password.
 * A substring is defined as a contiguous segment of a string. For example, given "a0Ba" the sub-strings that are valid passwords are 1s.
 * <p>
 * Write a function that, given a non-empty string S consisting of N characters, returns the length of its longest substring that is a valid
 * password. If there is no such substring, your function should return -1.
 * For example, given "1a0Ba", your function should return 2, as explained above. Given "aebb", your function should return -1,
 * since there is no substring that satisfies the restrictions on the format of a valid password.
 */

public class Password {
    public static void main(String... args) {
        System.out.println(new Password().solution("a0Ba"));  // Ba
        System.out.println(new Password().solution("a0bb"));  // bb
        System.out.println(new Password().solution("a0bb1aB2xyZ2mnoP2aA")); // xyZ, mnoP, aA
    }

    public int solution(String S) {
        if (S.length() > 200) {
            throw new IllegalArgumentException("Length of the String is greater than 200");
        }

        // split the string based on number
        // filter the stream of substring containing capital letter
        // order the substring (using comparator) based on the asc order of there size
        // take the first one which will be the longest one.
        Optional<String> validPassword = Stream.of(S.split("[0-9]"))
                .filter(s -> s.chars().anyMatch(Character::isUpperCase))
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst();

        return validPassword.isPresent() ? validPassword.get().length() : -1;
    }
}
