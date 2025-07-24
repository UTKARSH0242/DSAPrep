package linkedList;

import java.util.Scanner;
import static linkedList.BasicOfLinkedList.createCharLinkedList;
import static linkedList.BasicOfLinkedList.printList;

public class RemoveTheNthNodeFromLast {
    public static void main(String[] args) {
        // Create linked list of Characters
        System.out.println("Create your linked list:");
        Node<Character> head = createCharLinkedList();

        System.out.println("Original Linked List:");
        printList(head);

        // Get n from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the position (n) from the end to remove:");
        int n = scanner.nextInt();

        // Remove N-th node from end
        head = removeNthFromEnd(head, n);

        System.out.println("Linked List after removing " + n + "th node from end:");
        printList(head);

        // scanner.close(); // Avoid closing System.in
    }

    public static <T> Node<T> removeNthFromEnd(Node<T> head, int n) {
        if (head == null || n <= 0) {
            System.out.println("Invalid input or empty list.");
            return head;
        }

        // Create dummy node to handle edge cases
        Node<T> dummy = new Node<>(null);
        dummy.next = head;

        // Initialize two pointers
        Node<T> fast = dummy;
        Node<T> slow = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                System.out.println("Invalid n: List is too short.");
                return head;
            }
            fast = fast.next;
        }

        // Move both pointers until fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return dummy.next;
    }
}