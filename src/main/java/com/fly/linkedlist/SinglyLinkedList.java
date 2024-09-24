package com.fly.linkedlist;

public class SinglyLinkedList {
    public static void main(String[] args) {
        SinglyListNode n0 = new SinglyListNode(5);
        SinglyListNode n1 = new SinglyListNode(4);
        SinglyListNode n2 = new SinglyListNode(3);
        SinglyListNode n3 = new SinglyListNode(2);
        SinglyListNode n4 = new SinglyListNode(1);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
    }

    /**
     * 在p之后插入n节点
     *
     * @param n
     * @param p
     */
    void insert(SinglyListNode n, SinglyListNode p) {
        n.next = p.next;
        p.next = n;
    }

    /**
     * 删除n的后继节点
     *
     * @param n
     */
    void delete(SinglyListNode n) {
        if (n.next == null) {
            return;
        }
        n.next = n.next.next;
    }

    SinglyListNode access(SinglyListNode n, int index) {
        for (int i = 0; i < index; i++) {
            if (n.next == null) {
                return null;
            }
            n = n.next;
        }
        return n;
    }

    SinglyListNode select(SinglyListNode n, int value) {
        while (n.next != null) {
            if (n.value == value) {
                return n;
            }
            n = n.next;
        }
        return null;
    }
}