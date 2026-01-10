package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * IMPLEMENTATION 1: Two-Queue Approach
 * Time Complexity: Push O(n), Pop O(1)
 */
class MyStackTwoQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        // Swap references
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) return -1;
        return q1.poll();
    }

    public int top() {
        return q1.isEmpty() ? -1 : q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * IMPLEMENTATION 2: One-Queue Approach (Optimized)
 * Time Complexity: Push O(n), Pop O(1)
 * Space Complexity: O(n) - Uses 50% less memory than the 2-queue version
 */
class MyStackOneQueue {
    private Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.add(x);
        int size = q.size();
        // Rotate the queue to bring the newest element to the front
        for (int i = 0; i < size - 1; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        if (q.isEmpty()) return -1;
        return q.poll();
    }

    public int top() {
        return q.isEmpty() ? -1 : q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

// Main class to run and test both
public class StackUsingQueue {
    public static void main(String[] args) {
        System.out.println("--- Testing Two-Queue Stack ---");
        MyStackTwoQueues s2 = new MyStackTwoQueues();
        s2.push(10);
        s2.push(20);
        System.out.println("Top: " + s2.top()); // 20
        System.out.println("Popped: " + s2.pop()); // 20

        System.out.println("\n--- Testing One-Queue Stack ---");
        MyStackOneQueue s1 = new MyStackOneQueue();
        s1.push(100);
        s1.push(200);
        System.out.println("Top: " + s1.top()); // 200
        System.out.println("Popped: " + s1.pop()); // 200
    }
}