package core.assignment;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

public class WellFormedEquation {

    static Map<Character, Character> bracketMap = new HashMap<Character, Character>() {
        private static final long serialVersionUID = -1951897548253955006L;

        {
            put('[', ']');
            put('{', '}');
            put('(', ')');
        }
    };

    public static boolean evaluateExpression(String string) {

        Stack<Character> bracketStack = new Stack<Character>();

        for (int counter = 0; counter < string.length(); counter++) {
            char character = string.charAt(counter);
            if (checkOpenBracket(character)) {
                bracketStack.push(character);
            } else if (checkCloseBracket(character) && !bracketStack.isEmpty()) {
                checkBracket(bracketStack, character);
            }
        }
        if (bracketStack.isEmpty()) {
            return true;
        } else {
            return false;
        }

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

    @Test
    public void evaluateExpressionValidTest() {
        final String EXPRESSION = "(ABC{3}[WW]DD}WW)";
        assertTrue("Expression is valid", evaluateExpression(EXPRESSION));
    }

    @Test
    public void evaluateExpressionInvalidTest() {
        final String EXPRESSION = "[{(})]";
        assertFalse("Invalid expression", evaluateExpression(EXPRESSION));

    }

}