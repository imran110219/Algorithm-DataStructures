package hemantjain.chapter_8_stack;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * @author Sadman
 */
public class PostfixEvaluate {
    public static int postfixEvaluate(String expn) {
        ArrayDeque<Integer> stk = new ArrayDeque<Integer>();
        Scanner tokens = new Scanner(expn);
        while (tokens.hasNext()) {
            if (tokens.hasNextInt()) {
                stk.push(tokens.nextInt());
            }
            else {
                int num1 = stk.pop();
                int num2 = stk.pop();
                char op = tokens.next().charAt(0);
                switch (op) {
                    case '+':
                    stk.push(num1 + num2);
                    break;
                    case '-':
                        stk.push(num1 - num2);
                        break;
                    case '*':
                        stk.push(num1 * num2);
                        break;
                    case '/':
                        stk.push(num1 / num2);
                        break;
                }
            }
        }
        tokens.close();
        return stk.pop();
    }

    public static void main3(String[] args) {
        String expn = "6 5 2 3 + 8 * + 3 + *";
        int value = postfixEvaluate(expn);
        System.out.println("Given Postfix Expn: " + expn);
        System.out.println("Result after Evaluation: " + value);
    }
}
