package linkedlist;

public class DoublyLinkedList {
    public static void main(String[] args) {
        DoublyListNode n0 = new DoublyListNode(5);
        DoublyListNode n1 = new DoublyListNode(4);
        DoublyListNode n2 = new DoublyListNode(3);
        DoublyListNode n3 = new DoublyListNode(2);
        DoublyListNode n4 = new DoublyListNode(1);
        n0.pre = null;
        n0.next = n1;
        n1.pre = n0;
        n1.next = n2;
        n2.pre = n1;
        n2.next = n3;
        n3.pre = n2;
        n3.next = n4;
        n4.pre = n3;
        n4.next = null;
    }
}