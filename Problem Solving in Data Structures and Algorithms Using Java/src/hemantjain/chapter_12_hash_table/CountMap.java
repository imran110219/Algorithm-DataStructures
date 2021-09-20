package hemantjain.chapter_12_hash_table;

import java.util.HashMap;

/**
 * @author Sadman
 */
public class CountMap<T> {
    HashMap<T, Integer> hm = new HashMap<T, Integer>();

    public void add(T key) {
        if (hm.containsKey(key)) {
            int count = hm.get(key);
            hm.put(key, count + 1);
        } else {
            hm.put(key, 1);
        }
    }

    public void remove(T key) {
        if (hm.containsKey(key)) {
            if (hm.get(key) == 1)
                hm.remove(key);
            else {
                int count = hm.get(key);
                hm.put(key, count - 1);
            }
        }
    }

    public int get(T key) {
        if (hm.containsKey(key))
            return hm.get(key);
        return 0;
    }

    public boolean containsKey(T key) {
        return hm.containsKey(key);
    }

    public int size() {
        return hm.size();
    }

    public static void main(String[] args) {
        CountMap<Integer> cm = new CountMap<Integer>();
        cm.add(2);
        cm.add(2);
        cm.remove(2);
        System.out.println("count is : " + cm.get(2));
        System.out.println("count is : " + cm.get(3));
    }
}
