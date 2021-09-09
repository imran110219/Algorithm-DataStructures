package hemantjain.chapter_7_linkedlist;

/**
 * @author Sadman
 */
public class Node {
    int value;
    Node next;

    public Node(int v, Node n) {
        value = v;
        next = n;
    }

    public Node(int v) {
        value = v;
        next = null;
    }
}
