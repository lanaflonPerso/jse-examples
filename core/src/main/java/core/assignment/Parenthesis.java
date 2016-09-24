package core.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parenthesis {

    static Map<Character, Character> bracketMap = new HashMap<Character, Character>() {
        private static final long serialVersionUID = -1951897548253955006L;

        {
            put('[', ']');
            put('{', '}');
            put('(', ')');
        }
    };

    public static void main(String...args) throws IOException {
        readFile(args[0]);
    }

    public static void readFile(String filePath) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String expression;
            while ((expression = bufferedReader.readLine()) != null) {
                evaluateExpression(expression);
            }
            System.exit(0);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }

    public static void evaluateExpression(String string) {

        Stack<Character> bracketStack = new Stack<Character>();

        for (int counter = 0; counter < string.length(); counter++) {
            char character = string.charAt(counter);
            if (checkOpenBracket(character)) {
                bracketStack.push(character);
            } else if (checkCloseBracket(character) && !bracketStack.isEmpty()) {
                checkBracket(bracketStack, character);
            }
        }
        System.out.println("String : " + string + " is well formed : " + bracketStack.isEmpty());
    }

    public static boolean checkOpenBracket(char character) {
        return character == '[' || character == '{' || character == '(';
    }

    public static boolean checkCloseBracket(char character) {
        return character == ']' || character == '}' || character == ')';
    }

    public static void checkBracket(Stack<Character> openBracket, Character closeBracket) {
        char bracket = openBracket.peek();
        if (bracketMap.get(bracket).equals(closeBracket)) {
            openBracket.pop();
        }
    }
}