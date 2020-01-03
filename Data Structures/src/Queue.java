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
        front = 0;
        rear = -1;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int peek(int data){
        return arr[front];
    }

    public void enqueue(int data){
        if(isFull())
            System.out.println("Queue Overflow");
        else{
            rear++;
            if(rear == capacity-1)
                rear = 0;
            arr[rear] = data;
            size++;
        }
    }

    public void dequeue(){
        if(isEmpty())
            System.out.println("Queue Underflow");
        else{
            front++;;
            if(front == capacity - 1)
                front = 0;
            size--;
        }
    }

    public void printQueue(){
        int start = front;
        int end = rear;
        for(int i =0; i<capacity; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printQueue();
//        queue.enqueue(6);
    }
}
