package hemantjain.chapter_8_stack;

import java.util.ArrayDeque;

/**
 * @author Sadman
 */
public class BalancedParenthesis {
    public static boolean isBalancedParenthesis(String expn) {
        ArrayDeque<Character> stk = new ArrayDeque<Character>();
        for (char ch : expn.toCharArray()) {
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stk.push(ch);
                    break;
                case '}':
                    if (stk.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (stk.pop() != '[')
                        return false;
                    break;
                case ')':
                    if (stk.pop() != '(')
                        return false;
                    break;
            }
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {
        String expn = "{()}[";
        boolean value = isBalancedParenthesis(expn);
        System.out.println("Given Expn:" + expn);
        System.out.println("Result after isParenthesisMatched:" + value);
    }
}
