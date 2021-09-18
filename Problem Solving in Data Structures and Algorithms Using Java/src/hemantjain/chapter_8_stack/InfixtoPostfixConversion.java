package hemantjain.chapter_8_stack;

import java.util.ArrayDeque;

/**
 * @author Sadman
 */
public class InfixtoPostfixConversion {
    public static char[] infixToPostfix(char[] expn) {
        ArrayDeque<Character> stk = new ArrayDeque<Character>();
        String output = "";
        char out;
        for (char ch : expn) {
            if (ch <= '9' && ch >= '0') {
                output = output + ch;
            } else {
                switch (ch) {
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                    case '%':
                    case '^':
                        while (!stk.isEmpty()) {
                            out = stk.pop();
                            output = output + " " + out;
                        }
                        stk.push(ch);
                        output = output + " ";
                        break;
                    case '(':
                        stk.push(ch);
                        break;
                    case ')':
                        while (!stk.isEmpty() && (out = stk.pop()) != '(') {
                            output = output + " " + out + " ";
                        }
                        break;
                }
            }
        }
        while (!stk.isEmpty()) {
            out = stk.pop();
            output = output + out + " ";
        }
        return output.toCharArray();
    }

    public static String infixToPostfix(String expn) {
        String output="";
        char[] out = infixToPostfix(expn.toCharArray( ));
        for(char ch : out)
            output = output + ch ;
        return output;
    }

    public static void main(String[] args) {
        String expn = "10+((3))*5/(16-4)";
        String value = infixToPostfix (expn);System.out.println("Infix Expn: "+expn);
        System.out.println("Postfix Expn: "+value);
    }
}
