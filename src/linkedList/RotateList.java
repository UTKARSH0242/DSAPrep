package linkedList;

public class RotateList {

    /**
     * Definition for singly-linked list.
     * This is typically provided, but we include it here as a static nested class
     * for a self-contained, runnable example.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Rotates a linked list to the right by k places.
     * @param head The head of the list.
     * @param k The number of places to rotate.
     * @return The new head of the rotated list.
     */
    public static ListNode rotateRight(ListNode head, int k) {
        // Handle edge cases: empty list, single-node list, or zero rotations
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Find the length of the list and the old tail.
        ListNode oldTail = head;
        int length = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            length++;
        }

        // 2. Connect the tail to the head to form a circular list.
        oldTail.next = head;

        // 3. Calculate the effective rotations and find the new tail.
        // The new tail will be at index (length - (k % length) - 1).
        int rotations = k % length;
        int stepsToNewTail = length - rotations - 1;

        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // 4. Find the new head and break the circular link.
        ListNode newHead = newTail.next;
        newTail.next = null;

        // 5. Return the head of the newly rotated list.
        return newHead;
    }

    /**
     * A helper function to print the list for verification.
     * @param head The head of the list to print.
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // The main method to test the functionality.
    public static void main(String[] args) {
        // --- Test Case 1 ---
        System.out.println("--- Test Case 1 ---");
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.print("Original list:  ");
        printList(head1);

        int k1 = 2;
        ListNode rotatedHead1 = rotateRight(head1, k1);

        System.out.print("Rotated by " + k1 + ":    ");
        printList(rotatedHead1); // Expected: 4 -> 5 -> 1 -> 2 -> 3 -> null
        System.out.println();


        // --- Test Case 2 ---
        System.out.println("--- Test Case 2 ---");
        ListNode head2 = new ListNode(0, new ListNode(1, new ListNode(2)));
        System.out.print("Original list:  ");
        printList(head2);

        int k2 = 4;
        ListNode rotatedHead2 = rotateRight(head2, k2);

        System.out.print("Rotated by " + k2 + ":    ");
        printList(rotatedHead2); // Expected: 2 -> 0 -> 1 -> null
        System.out.println();

        // --- Test Case 3 (No effective rotation) ---
        System.out.println("--- Test Case 3 ---");
        ListNode head3 = new ListNode(10, new ListNode(20));
        System.out.print("Original list:  ");
        printList(head3);

        int k3 = 2;
        ListNode rotatedHead3 = rotateRight(head3, k3);

        System.out.print("Rotated by " + k3 + ":    ");
        printList(rotatedHead3); // Expected: 10 -> 20 -> null
    }
}