package hemantjain.chapter_8_stack;

/**
 * @author Sadman
 */
public class InfixtoPrefixConversion {
    public static String infixToPrefix(String expn) {
        char[] arr = expn.toCharArray();
        reverseString(arr);
        replaceParanthesis(arr);
        arr = InfixtoPostfixConversion.infixToPostfix(arr);
        reverseString(arr);
        expn = new String(arr);
        return expn;
    }

    public static void replaceParanthesis(char[] a) {
        int lower = 0;
        int upper = a.length - 1;
        while (lower <= upper) {
            if (a[lower] == '(')
                a[lower] = ')';
            else if (a[lower] == ')')
                a[lower] = '(';
            lower++;
        }
    }

    public static void reverseString(char[] expn) {
        int lower = 0;
        int upper = expn.length - 1;
        char tempChar;
        while (lower < upper) {
            tempChar = expn[lower];
            expn[lower] = expn[upper];
            expn[upper] = tempChar;
            lower++;
            upper--;
        }
    }

    public static void main(String[] args) {
        String expn = "10+((3))*5/(16-4)";
        String value = infixToPrefix(expn);
        System.out.println("Infix Expn: " + expn);
        System.out.println("Prefix Expn: " + value);
    }
}
