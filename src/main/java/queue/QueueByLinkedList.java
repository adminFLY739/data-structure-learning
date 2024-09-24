package queue;

import com.fly.linkedlist.SinglyListNode;

public class QueueByLinkedList {
    private SinglyListNode front, rear;
    private int sizeOfQueue;

    public QueueByLinkedList() {
        front = null;
        rear = null;
    }

    public int getSize() {
        return sizeOfQueue;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void push(int num) {
        SinglyListNode node = new SinglyListNode(num);
        if (front == null) {
            front = node;
        } else {
            rear.next = node;
        }
        rear = node;
    }

    public void pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        front = front.next;
        sizeOfQueue--;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        return front.value;
    }

    public int[] toArray() {
        SinglyListNode node = front;
        int[] nums = new int[getSize()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = node.value;
            node = node.next;
        }
        return nums;
    }

}
