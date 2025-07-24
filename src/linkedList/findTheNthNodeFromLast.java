package linkedList;

public class findTheNthNodeFromLast {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);
        int n = 2;
        Node<Integer> nthNode = findNthNodeFromLast(head, n);
        if (nthNode != null) {
            System.out.println("The " + n + "th node from the last is: " + nthNode.data);
        } else {
            System.out.println("The list is empty or the index is out of range.");
    }
}

    private static Node<Integer> findNthNodeFromLast(Node<Integer> head, int n) {
        if (head == null) {
            return null;
        }
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
