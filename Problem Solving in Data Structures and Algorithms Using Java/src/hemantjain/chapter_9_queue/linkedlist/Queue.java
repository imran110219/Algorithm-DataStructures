package hemantjain.chapter_9_queue.linkedlist;

/**
 * @author Sadman
 */
public class Queue {
    private static class Node {
        private int value;
        private Node next;

        public Node(int v, Node n) {
            value = v;
            next = n;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public int peek() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("QueueEmptyException");
        return head.value;
    }

    public void add(int value) {
        Node temp = new Node(value, null);
        if (head == null)
            head = tail = temp;
        else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public int remove() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("QueueEmptyException");
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        for (int i = 1; i <= 100; i++) {
            q.add(i);
        }
        for (int i = 1; i <= 50; i++) {
            q.remove();
        }
        q.print();
    }
}
