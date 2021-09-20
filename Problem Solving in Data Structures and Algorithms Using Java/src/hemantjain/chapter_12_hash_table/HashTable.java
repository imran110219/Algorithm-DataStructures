package hemantjain.chapter_12_hash_table;

/**
 * @author Sadman
 */
public class HashTable {
    private static int EMPTY_NODE = -1;
    private static int LAZY_DELETED = -2;
    private static int FILLED_NODE = 0;
    private int tableSize;
    int[] Arr;
    int[] Flag;

    public HashTable(int tSize) {
        tableSize = tSize;
        Arr = new int[tSize + 1];
        Flag = new int[tSize + 1];
        for (int i = 0; i <= tSize; i++)
            Flag[i] = EMPTY_NODE;
    }

    public int ComputeHash(int key) {
        return key % tableSize;
    }

    public int resolverFun(int index) {
        return index;
    }

    public boolean InsertNode(int value) {
        int hashValue = ComputeHash(value);
        for (int i = 0; i < tableSize; i++) {
            if (Flag[hashValue] == EMPTY_NODE || Flag[hashValue] == LAZY_DELETED) {
                Arr[hashValue] = value;
                Flag[hashValue] = FILLED_NODE;
                return true;
            }
            hashValue += resolverFun(i);
            hashValue %= tableSize;
        }
        return false;
    }

    public boolean FindNode(int value) {
        int hashValue = ComputeHash(value);
        for (int i = 0; i < tableSize; i++) {
            if (Flag[hashValue] == EMPTY_NODE)
                return false;
            if (Flag[hashValue] == FILLED_NODE && Arr[hashValue] == value)
                return true;
            hashValue += resolverFun(i);
            hashValue %= tableSize;
        }
        return false;
    }

    public boolean DeleteNode(int value) {
        int hashValue = ComputeHash(value);
        for (int i = 0; i < tableSize; i++) {
            if (Flag[hashValue] == EMPTY_NODE)
                return false;
            if (Flag[hashValue] == FILLED_NODE && Arr[hashValue] == value) {
                Flag[hashValue] = LAZY_DELETED;
                return true;
            }
            hashValue += resolverFun(i);
            hashValue %= tableSize;
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < tableSize; i++)
        {
            if (Flag[i] == FILLED_NODE)
                System.out.println("Node at index [" +i+ " ] :: "+Arr[i] );
        }
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable(1000);
        ht.InsertNode(89);
        ht.InsertNode(18);
        ht.InsertNode(49);
        ht.InsertNode(58);
        ht.InsertNode(69);
        ht.InsertNode(89);
        ht.InsertNode(18);
        ht.InsertNode(49);
        ht.InsertNode(58);
        ht.InsertNode(69);
        ht.print();
        System.out.println("");
        ht.DeleteNode(89);
        ht.DeleteNode(18);
        ht.DeleteNode(49);
        ht.DeleteNode(58);
        ht.DeleteNode(69);
        ht.print();
    }
}
