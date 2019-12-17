/**
 * Created by Imran on 12/17/2019.
 */
public class LinkedList {

    class Node {
        int data;
        Node next;
        public Node(int d)
        {
            data = d;
            next = null;
        }
    }

    Node head;

    public boolean isEmpty(Node node){
        return (node==null);
    }

    public void insert(int newData){
        Node node = new Node(newData);
        node.next = head;
        head = node;
    }

    public void insertLast(int newData){
        Node node = new Node(newData);
//        while (){
//
//        }
        node.next = head;
        head = node;
    }
}
