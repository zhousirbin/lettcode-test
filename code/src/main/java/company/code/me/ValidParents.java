package company.code.me;


import java.util.Stack;

public class ValidParents {

    public static void main(String[] args){

        String string = "[()]]";
        boolean a = isValid(string);
        System.out.println(a);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
