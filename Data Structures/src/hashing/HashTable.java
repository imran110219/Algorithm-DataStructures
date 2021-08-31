package hashing;

/**
 * Created by Sadman on 3/10/2020.
 */
public class HashTable {

    private static int INITIAL_SIZE = 16;
    private HashNode[] hashTable = new HashNode[INITIAL_SIZE];

    private int getHash(String key) {
        // piggy backing on java string
        // hashcode implementation.
        return key.hashCode() % INITIAL_SIZE;
    }

    void insert(String s) {
        int index = getHash(s);
        HashNode hashNode = new HashNode(s);
        if (hashTable[index] == null)
            hashTable[index] = hashNode;
        else {
            HashNode temp = hashTable[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = hashNode;
        }
    }

    String search(String s) {
        int index = getHash(s);
        if (hashTable[index] != null) {
            HashNode temp = hashTable[index];

            // Check the entry linked list for march
            // for the given 'key'
            while (!temp.equals(s)
                    && temp.next != null) {
                temp = temp.next;
            }
            return temp.value;
        }
        return null;
    }

    void delete(String s) {
        int index = getHash(s);
        if (hashTable[index] != null) {
            HashNode temp = hashTable[index];

            // Check the entry linked list for march
            // for the given 'key'
            while (!temp.equals(s)
                    && temp.next != null) {
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        HashTable hashTables = new HashTable();
        // Put some key values.
        for (int i = 0; i < 30; i++) {
            final String key = String.valueOf(i);
            hashTables.insert(key);
        }
        for (int i = 0; i < 30; i++) {
            System.out.println(hashTables.hashTable[i].value);
        }
    }

}
