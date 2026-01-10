package stack;

public class StackUsingArray {

    private final int[] arr;
    private int top;
    private final int capacity;

    public StackUsingArray(int capacity){
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.top = -1;
    }

    public void push(int data) throws Exception {
        if (top == capacity-1){
            throw new Exception();
        }
        top++;
        arr[top] = data;
    }

    public int pop() throws Exception {
        if(top == -1){
            throw new Exception("Stack is empty");
        }
        top--;
        return arr[top+1];
    }

    public int peek() throws Exception {
        if(top == -1){
            throw new Exception("Stack is Empty");
        }
        return arr[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == capacity-1;
    }

    public int size(){
        return top+1;
    }

    public static void main(String[] args) throws Exception {
        StackUsingArray stack = new StackUsingArray(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());    // 30
        System.out.println("Current size: " + stack.size()); // 3

        System.out.println("Popped: " + stack.pop());       // 30
        System.out.println("New Top: " + stack.peek());      // 20

        System.out.println("Is stack empty: " + stack.isEmpty()); // false
        System.out.println("Is stack full: " + stack.isFull()); // false
        System.out.println("Stack size: " + stack.size()); // 2
    }
}
