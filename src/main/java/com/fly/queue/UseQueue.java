package com.fly.queue;

import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        Integer peek = queue.peek();
        Integer pop = queue.poll();
        int size = queue.size();
        boolean isEmpty = queue.isEmpty();
    }
}
