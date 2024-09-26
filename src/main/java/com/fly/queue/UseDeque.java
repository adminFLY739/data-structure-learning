package com.fly.queue;

import java.util.Deque;
import java.util.LinkedList;

public class UseDeque {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(3);
        deque.offerLast(4);
        deque.offerLast(5);
        deque.offerFirst(2);
        deque.offerFirst(1);
        int peekFirst = deque.peekFirst();
        int peekLast = deque.peekLast();
        int popFirst = deque.pollFirst();
        int popLast = deque.pollLast();
        int size = deque.size();
        boolean isEmpty = deque.isEmpty();
    }
}
