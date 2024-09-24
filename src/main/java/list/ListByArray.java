package list;

import java.util.Arrays;

public class ListByArray {
    private int[] arr;
    private int size = 0;
    private int extend = 2;

    /**
     * init
     */
    public ListByArray(int capacity) {
        arr = new int[capacity];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return arr.length;
    }

    /**
     * select
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        return arr[index];
    }

    /**
     * update
     *
     * @param index
     * @param num
     */
    public void set(int index, int num) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        arr[index] = num;
    }

    /**
     * delete
     *
     * @param index
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    /**
     * delete
     */
    public void clear() {
        size = 0;
    }

    /**
     * insert
     *
     * @param num
     */
    public void add(int num) {
        if (size == getCapacity()) {
            extendCapacity();
        }
        arr[size] = num;
        size++;
    }

    /**
     * insert
     *
     * @param index
     * @param num
     */
    public void insert(int index, int num) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == getCapacity()) {
            extendCapacity();
        }
        arr[index] = num;
    }

    public void extendCapacity() {
        arr = Arrays.copyOf(arr, getCapacity() * extend);
    }

    public int[] toArray() {
        int[] nums = new int[getSize()];
        for (int i = 0; i < getSize(); i++) {
            nums[i] = get(i);
        }
        return nums;
    }
}
