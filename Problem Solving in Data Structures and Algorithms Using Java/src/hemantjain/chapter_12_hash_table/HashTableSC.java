package hemantjain.chapter_12_hash_table;

/**
 * @author Sadman
 */
public class HashTableSC {
    private class Node {
        private int value;
        private Node next;

        public Node(int v, Node n) {
            value = v;
            next = n;
        }
    }

    private int tableSize;
    Node[] listArray; //double pointer

    public HashTableSC() {
        tableSize = 512;
        listArray = new Node[tableSize];
        for (int i = 0; i < tableSize; i++)
            listArray[i] = null;
    }

    private int ComputeHash(int key) {
        int hashValue = 0;
        hashValue = key;
        return hashValue % tableSize;
    }

    public void insert(int value) {
        int index = ComputeHash(value);
        listArray[index] = new Node(value, listArray[index]);
    }

    public boolean find(int value) {
        int index = ComputeHash(value);
        Node head = listArray[index];
        while (head != null) {
            if (head.value == value)
                return true;
            head = head.next;
        }
        return false;
    }

    public boolean delete(int value) {
        int index = ComputeHash(value);
        Node nextNode, head = listArray[index];
        if (head != null && head.value == value) {
            listArray[index] = head.next;
            return true;
        }
        while(head != null)
        {
            nextNode = head.next;
            if (nextNode != null && nextNode.value == value) {
                head.next = nextNode.next;
                return true;
            }
            else
            {
                head = nextNode;
            }
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < tableSize; i++) {
            System.out.println("Printing for index value :: " + i + "List of value printing :: ");
            Node head = listArray[i];
            while (head != null) {
                System.out.println(head.value);
                head = head.next;
            }
        }
    }

    public static void main(String[] args) {
        HashTableSC ht = new HashTableSC();
        for (int i = 100; i < 110; i++)
            ht.insert(i);
        System.out.println("search 100 :: " + ht.find(100));
        System.out.println("remove 100 :: " + ht.delete(100));
        System.out.println("search 100 :: " + ht.find(100));
        System.out.println("remove 100 :: " + ht.delete(100));
    }
}