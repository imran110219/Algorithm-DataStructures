/**
 * Created by Imran on 1/2/2020.
 */
public class Queue {
    private int capacity;
    private int front, rear, size=0;
    private int[] arr;

    public Queue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = size;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(int data){
        if(isFull())
            System.out.println("Queue Overflow");
        else{

        }
    }
}
