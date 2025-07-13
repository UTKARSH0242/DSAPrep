package linkedList;

import static linkedList.ReverseLinkedList.reverseLL;
import static linkedList.BasicOfLinkedList.printList;
import static linkedList.BasicOfLinkedList.createCharLinkedList;

public class MiddleOfTheLinkedList {
    public static <T> Node<T> findMiddle(Node<T> head) {
        if (head == null) {
            return null;
        }
        Node<T> slow = head;
        Node<T> fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        // Create linked list of Characters
        System.out.println("Create your linked list:");
        Node<Character> head = createCharLinkedList();

        System.out.println("Original Linked List:");
        printList(head);

        // Find the middle element
        Node<Character> middle = findMiddle(head);
        if (middle != null) {
            System.out.println("Middle Element: " + middle.data);
        } else {
            System.out.println("No middle element (list is empty).");
        }

        // Reverse the linked list
        head = reverseLL(head);
        System.out.println("Reversed Linked List:");
        printList(head);
    }
}