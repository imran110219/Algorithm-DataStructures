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

    public void insertFirst(int newData){
        Node node = new Node(newData);
        node.next = head;
        head = node;
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
            temp.next = node;
        }
    }

    public void deleteByKey(int newData){
        int flag = 0;
        Node temp = head;
        if(temp != null && temp.data == newData){
            head = temp.next;
            flag = 1;
        }
        else {
            while (temp.next != null) {
                if (temp.next.data == newData) {
                    temp.next = temp.next.next;
                    flag = 1;
                    break;
                }
                temp = temp.next;
            }
        }
        if(flag == 0)
            System.out.println(newData+ " not found.");
    }

    public void deleteByPosition(int position){
        int counter = 1;
        int flag = 0;
        Node temp = head;
        if(temp != null && position == 1){
            head = temp.next;
            flag = 1;
        }
        else {
            while (counter < position - 1) {
                temp = temp.next;
                counter++;
            }
            flag = 1;
            temp.next = temp.next.next;
        }
        if(flag == 0)
            System.out.println(position+ " not found.");
    }

    public void printList(){
        while(head != null){
            System.out.print(head.data+ " ");
            head = head.next;
        }
    }

    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.insertLast(1);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertByPosition(2,2);
        list.insertFirst(0);

        list.deleteByKey(0);
        list.deleteByPosition(2);
        list.deleteByKey(-1);
//        System.out.println(list.head.next.data);
//        System.out.println(list.isEmpty(list.head));

        list.printList();
    }
}
