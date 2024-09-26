package com.fly.queue;

public class DequeByArray {
    private int[] arr;
    private int front;
    private int sizeOfQueue;

    public DequeByArray(int capacity) {
        arr = new int[capacity];
        front = sizeOfQueue = 0;
    }

    public int getCapacity() {
        return arr.length;
    }

    public int getSize() {
        return sizeOfQueue;
    }

    public boolean isEmpty() {
        return sizeOfQueue == 0;
    }

    public int getIndex(int num) {
        return (num + getCapacity()) % getCapacity();
    }

    public void pushFirst(int num) {
        if (sizeOfQueue == getCapacity()) {
            System.out.println("队列为满");
            return;
        }
        front = getIndex(front - 1);
        arr[front] = num;
        sizeOfQueue++;
    }

    public void pushLast(int num) {
        if (sizeOfQueue == getCapacity()) {
            System.out.println("队列为满");
            return;
        }
        int rear = getIndex(front + sizeOfQueue);
        arr[rear] = num;
        sizeOfQueue++;
    }

    public void popFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        front = getIndex(front + 1);
        sizeOfQueue--;
    }

    public void popLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        sizeOfQueue--;
    }

    public int peekFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        return arr[front];
    }

    public int peekLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        return arr[getIndex(front + sizeOfQueue - 1)];
    }

    public int[] toArray() {
        int[] nums = new int[getSize()];
        for (int i = 0, j = front; i < getSize(); i++, j++, j %= getCapacity()) {
            nums[i] = arr[j];
        }
        return nums;
    }
}
