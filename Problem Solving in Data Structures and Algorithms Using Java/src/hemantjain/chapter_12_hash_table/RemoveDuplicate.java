package hemantjain.chapter_12_hash_table;

import java.util.HashSet;

/**
 * @author Sadman
 */
public class RemoveDuplicate {
    public static void removeDuplicate(char[] str) {
        int index = 0;
        HashSet<Character> hs = new HashSet<Character>();
        for (char ch : str) {
            if (!hs.contains(ch)) {
                str[index++] = ch;
                hs.add(ch);
            }
        }
        str[index] = '\0';
    }
}
