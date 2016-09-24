package core.collection.stack;

public class StackMain {

    public static void main(String...args) {
        Stack stack = new ArrayBasedStack();
        // stack.pop();
        System.out.println(stack.isEmpty());
        stack.push(new Integer(4));
        System.out.println(stack.top());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
    }

}