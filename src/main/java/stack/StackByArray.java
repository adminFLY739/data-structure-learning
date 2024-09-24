package stack;

import java.util.ArrayList;

public class StackByArray {
    private ArrayList<Integer> stack;

    public StackByArray() {
        stack = new ArrayList<>();
    }

    public int getSize() {
        return stack.size();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void push(int num) {
        stack.add(num);
    }

    public void pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("栈为空");
        }
        stack.remove(getSize() - 1);
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("栈为空");
        }
        return stack.get(getSize() - 1);
    }

    public int[] toArray() {
        int[] nums = new int[getSize()];
        for (int i = 0; i < getSize(); i++) {
            nums[i] = stack.get(i);
        }
        return nums;
    }
}
