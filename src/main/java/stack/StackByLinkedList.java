package stack;

import com.fly.linkedlist.SinglyListNode;

public class StackByLinkedList {
    private SinglyListNode stackPeek;
    private int stackSize = 0;

    public StackByLinkedList() {
        stackPeek = null;
    }

    public int getSize() {
        return stackSize;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void push(int num) {
        SinglyListNode node = new SinglyListNode(num);
        node.next = stackPeek;
        stackPeek = node;
        stackSize++;
    }

    public void pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("栈为空");
        }
        stackPeek = stackPeek.next;
        stackSize--;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("栈为空");
        }
        return stackPeek.value;
    }

    public int[] toArray() {
        SinglyListNode node = stackPeek;
        int[] nums = new int[getSize()];
        for (int i = 0; i < getSize(); i++) {
            nums[i] = node.value;
            node = node.next;
        }
        return nums;
    }
}
