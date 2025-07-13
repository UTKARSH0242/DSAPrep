package linkedList;

import java.util.Scanner;

public class BasicOfLinkedList {
    public static void printList(Node<?> head) {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        Node<?> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to create a linked list of Characters
    public static Node<Character> createCharLinkedList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the linked list:");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Invalid input. Returning null.");
            return null;
        }

        System.out.println("Enter " + n + " characters (single characters only):");
        scanner.nextLine(); // Consume newline
        Node<Character> head = new Node<>(scanner.nextLine().charAt(0));
        Node<Character> current = head;

        for (int i = 1; i < n; i++) {
            current.next = new Node<>(scanner.nextLine().charAt(0));
            current = current.next;
        }

        // scanner.close(); // Commented to avoid closing System.in
        return head;
    }
}