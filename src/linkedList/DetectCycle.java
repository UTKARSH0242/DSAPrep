package linkedList;

public class DetectCycle {
    public static void main(String[] args) {
        System.out.println("Create your linked list:");
        Node<Character> head = BasicOfLinkedList.createCharLinkedList();

        System.out.println("Original Linked List:");
        BasicOfLinkedList.printList(head);

        Node<Character> cycleNode = detectCycle(head);

        // Add null check before accessing cycleNode.data
        if (cycleNode != null) {
            System.out.println("Cycle detected at node: " + cycleNode.data);
        } else {
            System.out.println("No cycle detected in the linked list");
        }
    }

    private static Node<Character> detectCycle(Node<Character> head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node<Character> slow = head;
        Node<Character> fast = head;

        // Floyd's Cycle Detection Algorithm (Tortoise and Hare)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                System.out.println("Cycle detected at node: " + slow.data);
                return slow;
            }
        }

        // No cycle found
        return null;
    }
}