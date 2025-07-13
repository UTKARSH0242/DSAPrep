package linkedList;

import static linkedList.MiddleOfTheLinkedList.findMiddle;
import static linkedList.ReverseLinkedList.reverseLL;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        // Create linked list of Characters
        System.out.println("Create your linked list:");
        Node<Character> head = BasicOfLinkedList.createCharLinkedList();

        System.out.println("Original Linked List:");
        BasicOfLinkedList.printList(head);

        // Find if the linked list is a palindrome
        boolean isPalindrome = isPalindrome(head);

        if (isPalindrome) {
            System.out.println("The linked list is a Palindrome.");
        } else {
            System.out.println("The linked list is not a Palindrome.");
        }
    }

    public static <T extends Comparable<T>> boolean isPalindrome(Node<T> head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node<T> mid = findMiddle(head);
        Node<T> last = reverseLL(mid.next);
        Node<T> cur = head;
        while (last != null) {
            if (last.data.compareTo(cur.data) != 0) {
                return false;
            }
            last = last.next;
            cur = cur.next;
        }
        return true;
    }
}