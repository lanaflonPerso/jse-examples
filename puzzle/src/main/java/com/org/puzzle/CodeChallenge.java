package com.org.puzzle;

import java.util.*;

public class CodeChallenge {
    public static void main(String...args) {
        // write your code here

        like(5, Arrays.asList("1M3G5G", "2G3M4G", "5M"));
        like(1, Arrays.asList("1G", "1M"));
        like(5, Arrays.asList("2M", "5G", "1G", "5G1G4M", "3G", "5G", "3G5G1G", "3G", "2M", "5G1G", "2M", "5G", "4M",
                "5G4M"));
        like(2, Arrays.asList("1G2M", "1M"));

    }

    private static void like(int colors, List<String> customers) {
        Map<String, String> colorGrades = new HashMap<>();
        boolean noSolution = false;

        // may be we can avoid this for loop and do something in main for loop below
        for (int i = 1; i <= colors; i++) {
            colorGrades.put("" + i, "G");
        }

        for (int k = 0; k < customers.size(); k++) {
            String customer = customers.get(k);
            int mFound = -1;
            boolean found = false;
            for (int i = 1; i <= colors; i++) {
                for (int j = 0; j < customer.length() - 1; j += 2) {
                    String customerLike = customer.substring(j, j + 2);
                    if (customerLike.equals("" + i + colorGrades.get("" + i))) {
                        found = true;
                        break;
                    } else {
                        if (customerLike.equals("" + i + "M")) {
                            mFound = Integer.parseInt("" + customer.charAt(j));
                        }
                    }
                }
                if (found) {
                    break;
                }
            }
            if (!found && mFound != -1) {
                colorGrades.put("" + (mFound), "M");
                k = -1;
            } else if (!found) {
                noSolution = true;
                break;
            }
        }
        if (noSolution) {
            System.out.println("No Solution exists");
        } else {
            for (int i = 1; i <= colors; i++) {
                System.out.print(colorGrades.get("" + i) + "  ");
            }
            System.out.println("");
        }
    }
}