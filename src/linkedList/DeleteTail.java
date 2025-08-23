package linkedList;

public class DeleteTail {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        tail.next = null;
        print(head);
        deleteTail(head);
        print(head);
    }

    private static void print(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    private static void deleteTail(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
    }
}
