package core.collection.infix;

import java.io.IOException;

/*
1. send only the operator and not the operand.
2. concat the operand to HashMapCustom string "OUTPUT".
3. + - precedence 1 
4. * / precedence 2
while{
	5. if the top precedence is more then the "current operator" then concat the top else put it back to stack.
}
6. put the "current operator" back to the stack
*/

public class InfixToPostMain {
    private StackCustom stack;
    private String expression;
    private StringBuffer output = new StringBuffer();

    public InfixToPostMain(String expression) {
        this.expression = expression;
        stack = new StackCustom(expression.length());
    }

    public static void main(String...args) throws IOException {
        String input = "1+2*(4/5)-7+3/6";
        String output;
        InfixToPostMain theTrans = new InfixToPostMain(input);
        output = theTrans.prefix();
        System.out.println("Infix is : " + input);
        System.out.println("Postfix is : " + output + '\n');
    }

    public String prefix() {
        for (int j = 0; j < expression.length(); j++) {
            char ch = expression.charAt(j);
            switch (ch) {
            case '+':
            case '-':
                gotOper(ch, 1);
                break;
            case '*':
            case '/':
                gotOper(ch, 2);
                break;
            case '(':
                stack.push(ch);
                break;
            case ')':
                closedParenthesis(ch);
                break;
            default:
                output = output.append(ch);
                break;
            }
        }
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }
        return output.toString();
    }

    public void gotOper(char operator, int expPrecedence) {
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top == '(') {
                stack.push(top);
                break;
            } else {
                int stackPrecedence;
                if (top == '+' || top == '-')
                    stackPrecedence = 1;
                else
                    stackPrecedence = 2;
                if (stackPrecedence < expPrecedence) {
                    stack.push(top);
                    break;
                } else
                    output.append(top);
            }
        }
        stack.push(operator);
    }

    public void closedParenthesis(char ch) {
        while (!stack.isEmpty()) {
            char chx = stack.pop();
            if (chx == '(')
                break;
            else
                output.append(chx);
        }
    }
}
