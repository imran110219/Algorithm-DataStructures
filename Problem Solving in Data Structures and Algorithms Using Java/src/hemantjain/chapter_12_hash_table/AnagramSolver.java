package hemantjain.chapter_12_hash_table;

/**
 * @author Sadman
 */
public class AnagramSolver {
    public static boolean isAnagram(char[] str1, char[] str2) {
        int size1 = str1.length;
        int size2 = str2.length;
        if (size1 != size2)
            return false;
        CountMap<Character> cm = new CountMap<Character>();
        for (char ch : str1)
            cm.add(ch);
        for (char ch : str2)
            cm.remove(ch);
        return (cm.size() == 0);
    }
}
