package linkedList;

import static linkedList.BasicOfLinkedList.createCharLinkedList;
import static linkedList.BasicOfLinkedList.printList;

public class ReverseLinkedList {
    public static <T> Node<T> reverseLL(Node<T> head) {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        // Create linked list of Characters
        System.out.println("Create your linked list:");
        Node<Character> head = createCharLinkedList();

        System.out.println("Original Linked List:");
        printList(head);

        // Reverse the linked list
        head = reverseLL(head);
        System.out.println("Reversed Linked List:");
        printList(head);
    }
}