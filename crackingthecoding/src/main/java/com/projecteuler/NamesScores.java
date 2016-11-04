package main.java.com.projecteuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
 * <p>
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 * <p>
 * What is the total of all the name scores in the file?
 */
public class NamesScores {
    static final String A2Z = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String...args) throws FileNotFoundException {
        final File file = new File(loadResource("p022_names.txt"));
        Scanner scanner = new Scanner(file);
        final List<String> nameList = new ArrayList<>();
        while(scanner.hasNext()){
            final List<String> name = Arrays.asList(scanner.next().replace("\"","").split(","));
            nameList.addAll(name);
        }
        Collections.sort(nameList);
        long sum = 0;
        for(int i =0; i < nameList.size(); i++){
            sum += sumOfPosition(nameList.get(i).toCharArray()) * (i + 1);
        }
        System.out.println(sum);
    }

    public static String loadResource(String resource){
        return Thread.currentThread().getContextClassLoader().getResource(resource).getFile();
    }

    public static int sumOfPosition(char[] characters){
        int sum = 0;
        for(char character : characters) {
            sum += A2Z.indexOf(character) + 1;
        }
        return sum;
    }
}
