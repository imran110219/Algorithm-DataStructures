package stack;

/**
 * Created by Imran on 12/27/2019.
 */
public class Stack {
    private int capacity;
    private int top;
    private int[] arr;

    public Stack(int Capacity){
        capacity = Capacity;
        top = -1;
        arr = new int[capacity];
    }

    public void push(int value){
        if(isFull())
            System.out.println("Stack Overflow");
        else
            arr[++top] = value;
    }

    public void pop(){
        if(size() == 0)
            System.out.println("Stack Underflow");
        else
            --top;
    }

    public int peek(){
        if(size() == 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        else
            return arr[top];
    }

    public int size(){
        return top+1;
    }

    public boolean isFull(){
        return capacity == top+1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.pop();
        System.out.println(stack.peek());
    }
}
