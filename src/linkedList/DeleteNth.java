package linkedList;

import static linkedList.BasicOfLinkedList.printList;

public class DeleteNth {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);
        int n = 1;
        head = deleteNth(head, n);
        printList(head);
    }

    private static Node<Integer> deleteNth(Node<Integer> head, int n) {

        if (head == null){
            return null;
        }
        if (n == 1){
            return head.next;
        }
        int count = 0;
        Node<Integer> current = head;
        while (current != null){
            count++;
            current = current.next;
        }
        if (count < n){
            return head;
        }
        current = head;
        for (int i = 1; i < count - n; i++){
            current = current.next;
        }
        current.next = current.next.next;
        return head;


    }
}
