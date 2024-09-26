package com.fly.queue;

import com.fly.linkedlist.DoublyListNode;

public class DequeByLinkedList {
    private DoublyListNode front, rear;
    private int sizeOfDeque;

    public DequeByLinkedList() {
        front = null;
        rear = null;
    }

    public int getSize() {
        return sizeOfDeque;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void push(int num, boolean isFront) {
        DoublyListNode node = new DoublyListNode(num);
        if (isEmpty()) {
            front = node;
            rear = node;
        } else if (isFront) {
            front.pre = node;
            node.next = front;
            front = node;
        } else {
            rear.next = node;
            node.pre = rear;
            rear = node;
        }
        sizeOfDeque++;
    }

    public void pushFront(int num) {
        push(num, true);
    }

    public void pushLast(int num) {
        push(num, false);
    }

    public void pop(boolean isFront) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        } else {
            if (isFront) {
                DoublyListNode node = front.next;
                if (node != null) {
                    node.pre = null;
                    front.next = null;
                }
                front = node;
            } else {
                DoublyListNode node = rear.pre;
                if (node != null) {
                    node.next = null;
                    rear.pre = null;
                }
                rear = node;
            }
            sizeOfDeque--;
        }
    }

    public void popFront() {
        pop(true);
    }

    public void popLast() {
        pop(false);
    }

    public int peek(boolean isFront) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        } else {
            return isFront ? front.value : rear.value;
        }
    }

    public int peekFront() {
        return peek(true);
    }

    public int peekLast() {
        return peek(false);
    }

    public int[] toArray() {
        DoublyListNode node = front;
        int[] nums = new int[getSize()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = node.value;
            node = node.next;
        }
        return nums;
    }
}
