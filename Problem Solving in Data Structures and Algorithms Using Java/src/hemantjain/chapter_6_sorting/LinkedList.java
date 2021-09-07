package hemantjain.chapter_6_sorting;

/**
 * @author Sadman
 */
public class LinkedList {
    private Node head;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addHead(int value) {
        head = new Node(value, head);
        size++;
    }

    public void addTail(int value) {
        Node newNode = new Node(value, null);
        Node curr = head;
        if (head == null)
            head = newNode;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public void sortedInsert(int value) {
        Node newNode = new Node(value, null);
        Node curr = head;
        if (curr == null || curr.value > value) {
            newNode.next = head;
            head = newNode;
            return;
        }
        while (curr.next != null && curr.next.value < value) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }

    public boolean isPresent(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == data)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public int removeHead() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("EmptyListException");
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public boolean deleteNode(int delValue) {
        Node temp = head;
        if (isEmpty())
            return false;
        if (delValue == head.value) {
            head = head.next;
            size--;
            return true;
        }
        while (temp.next != null) {
            if (temp.next.value == delValue) {
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void deleteNodes(int delValue) {
        Node currNode = head;
        Node nextNode;
        while (currNode != null && currNode.value == delValue)/*first node */ {
            head = currNode.next;
            currNode = head;
        }
        while (currNode != null) {
            nextNode = currNode.next;
            if (nextNode != null && nextNode.value == delValue) {
                currNode.next = nextNode.next;
            } else {
                currNode = nextNode;
            }
        }
    }

    public void freeList() {
        head = null;
        size = 0;
    }

    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public Node reverseRecurseUtil(Node currentNode, Node nextNode) {
        Node ret;
        if (currentNode == null)
            return null;
        if (currentNode.next == null) {
            currentNode.next = nextNode;
            return currentNode;
        }
        ret = reverseRecurseUtil(currentNode.next, currentNode);
        currentNode.next = nextNode;
        return ret;
    }

    public void reverseRecurse() {
        head = reverseRecurseUtil(head, null);
    }

    public void removeDuplicate() {
        Node curr = head;
        while (curr != null) {
            if (curr.next != null && curr.value == curr.next.value)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
    }

    public LinkedList CopyListReversed() {
        Node tempNode = null;
        Node tempNode2 = null;
        Node curr = head;
        while (curr != null) {
            tempNode2 = new Node(curr.value, tempNode);
            curr = curr.next;
            tempNode = tempNode2;
        }
        LinkedList ll2 = new LinkedList();
        ll2.head = tempNode;
        return ll2;
    }

    public LinkedList copyList() {
        Node headNode = null;
        Node tailNode = null;
        Node tempNode = null;
        Node curr = head;
        if (curr == null)
            return null;
        headNode = new Node(curr.value, null);
        tailNode = headNode;
        curr = curr.next;
        while (curr != null) {
            tempNode = new Node(curr.value, null);
            tailNode.next = tempNode;
            tailNode = tempNode;
            curr = curr.next;
        }
        LinkedList ll2 = new LinkedList();
        ll2.head = headNode;
        return ll2;
    }

    public boolean compareList(LinkedList ll) {
        return compareList(head, ll.head);
    }

    public boolean compareList(Node head1, Node head2) {
        if (head1 == null && head2 == null)
            return true;
        else if ((head1 == null) || (head2 == null) || (head1.value != head2.value))
            return false;
        else
            return compareList(head1.next, head2.next);
    }

    public int findLength() {
        Node curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public int nthNodeFromBegining(int index) {
        if (index > size() || index < 1)
            return Integer.MAX_VALUE;
        int count = 0;
        Node curr = head;
        while (curr != null && count < index - 1) {
            count++;
            curr = curr.next;
        }
        return curr.value;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
    }
}
