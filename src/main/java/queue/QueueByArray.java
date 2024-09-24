package queue;

public class QueueByArray {
    private int[] arr;
    private int front;
    private int sizeOfQueue;

    public QueueByArray(int capacity) {
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

    public void push(int num) {
        if (sizeOfQueue == getCapacity()) {
            System.out.println("队列为满");
            return;
        }
        int rear = (front + sizeOfQueue) % getCapacity();
        arr[rear] = num;
        sizeOfQueue++;
    }

    public void pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        front = (front + 1) % getCapacity();
        sizeOfQueue--;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        return arr[front];
    }

    public int[] toArray() {
        int[] nums = new int[getSize()];
        for (int i = 0, j = front; i < getSize(); i++, j++, j %= getCapacity()) {
            nums[i] = arr[j];
        }
        return nums;
    }
}
