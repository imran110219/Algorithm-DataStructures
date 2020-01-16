package linkedlist;

/**
 * Created by Imran on 12/27/2019.
 */
public class DoublyLinkedList {
    class Node {
        int data;
        Node next, prev;
        public Node(int d)
        {
            data = d;
            prev = next = null;
        }
    }

    Node head;

    public boolean isEmpty(Node node){
        return (node==null);
    }

    public void insertFirst(int newData){
        Node node = new Node(newData);
        if(isEmpty(head))
            head = node;
        else {
            node.prev = null;
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    public void insertByPosition(int newData, int position){
        Node node = new Node(newData);
        int counter = 1;
        Node temp = head;
        while (counter<position-1){
            temp = temp.next;
            counter++;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public void insertLast(int newData){
        Node node = new Node(newData);
        if(head == null)
            head = node;
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            node.prev = temp;
            node.next = null;
            temp.next = node;
        }
    }

    public void printList(){
        while(head != null){
            System.out.print(head.data+ " ");
            head = head.next;
        }
    }

    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertLast(2);
//        list.insertLast(3);
//        list.insertLast(4);
//        list.insertLast(5);
//        list.insertByPosition(2,2);
        list.insertFirst(1);
        list.insertFirst(0);
//
//        list.deleteByKey(0);
//        list.deleteByPosition(2);
//        list.deleteByKey(-1);
//
        list.printList();
    }
}
