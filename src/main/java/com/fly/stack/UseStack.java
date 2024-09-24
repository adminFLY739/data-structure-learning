package com.fly.stack;

import java.util.Stack;

public class UseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        int peek = stack.peek();
        int pop = stack.pop();
        int size = stack.size();
        boolean isEmpty = stack.isEmpty();
    }
}
