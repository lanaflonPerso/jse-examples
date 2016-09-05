/*
 * Write a function that, given an input array of real values, a target value and a threshold, 
 * returns the number of combinations of input values, of any length, that, multiplied among each other, 
 * are equal to the target value within a maximum error as defined by the provided threshold.
EXAMPLE:
==============
total_combinations = calculate_combinations([7, 1.5, 2], target_val=3.05, threshold=0.1)

ANSWER:
====================
should return 1, because we have only:
1.5*2=3, which differs from the target 3.05 of less than the threshold 0.1

EXAMPLE 2:
==========
total_combinations = calculate_combinations([1, 1.1, 2, 3], target_val=2, threshold=0.5)

ANSWER 2:
====================
should return 4, as we have all of these subsets

2 alone = 2
1.1 * 2 = 2.2
1 * 2 = 2
1 * 1.1 * 2 = 2.2

multiplying to a value that differs from the target for less than the threshold.
 */

package core.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateCombination {
    private static final List<List<Double>> ALL_COMBINATION = new ArrayList<List<Double>>();

    public static void main(String... strings) {
        List<Double> realNumbers = Arrays.asList(1D, 1.1d, 2d, 3d);
        double targetNumber = 2d;
        double threasholdValue = 0.5;

        listAllCombination(realNumbers);
        filterCombination(targetNumber, threasholdValue);
    }

    private static void listAllCombination(List<Double> realNumbers) {
        for (int size = 1; size <= realNumbers.size(); size++) {
            createCombinationListRecursive(realNumbers, new ArrayList<Double>(1), size);
        }
    }

    private static void filterCombination(double targetNumber, double threasholdValue) {
        for (List<Double> numbers : ALL_COMBINATION) {
            double product = 1.0;
            for (double number : numbers) {
                product *= number;
            }
            Double diff = Math.abs(targetNumber - product);
            if (diff <= threasholdValue) {
                System.out.println(numbers);
            }
        }
    }

    private static void createCombinationListRecursive(List<Double> realNumbers, List<Double> set, int sizeOfset) {

        if (set.size() == sizeOfset) {
            ALL_COMBINATION.add(set);
        }
        for (int index = 0; index < realNumbers.size(); index++) {
            List<Double> subSetCombination = new ArrayList<Double>();
            for (int j = index + 1; j < realNumbers.size(); j++) {
                subSetCombination.add(realNumbers.get(j));
            }
            Double number = realNumbers.get(index);
            List<Double> partial_rec = new ArrayList<Double>(set);
            partial_rec.add(number);
            createCombinationListRecursive(subSetCombination, partial_rec, sizeOfset);
        }
        //		System.out.println(ALL_COMBINATION);
    }

}
