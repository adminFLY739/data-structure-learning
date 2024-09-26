package com.fly.hashMap;

import java.util.ArrayList;
import java.util.List;

public class HashMapByChaining {
    private int size = 0;
    private int capacity = 4;
    // 动态数组实现HashMap和链表
    List<List<Pair>> buckets;

    public HashMapByChaining() {
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    public int getIndex(int key) {
        return key % capacity;
    }

    public double getLoadThres() {
        return (double) size / capacity;
    }

    public String select(int key) {
        int index = getIndex(key);
        List<Pair> bucket = buckets.get(index);
        for (Pair pair : bucket) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return null;
    }

    public void insertAndUpdate(int key, String value) {
        double loadThres = 2.0 / 3.0;
        if (getLoadThres() > loadThres) {
            extend();
        }
        int index = getIndex(key);
        List<Pair> bucket = buckets.get(index);
        for (Pair pair : bucket) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }
        Pair pair = new Pair(key, value);
        bucket.add(pair);
        size++;
    }

    public void delete(int key) {
        int index = getIndex(key);
        List<Pair> bucket = buckets.get(index);
        for (Pair pair : bucket) {
            if (pair.key == key) {
                bucket.remove(pair);
                size--;
                return;
            }
        }
    }

    public void extend() {
        int extend = 2;
        capacity *= extend;
        List<List<Pair>> bucketsTemp = buckets;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
        size = 0;
        for (List<Pair> bucket : bucketsTemp) {
            bucket.addAll(bucket);
        }
    }

    public void print() {
        for (List<Pair> bucket : buckets) {
            for (Pair pair : bucket) {
                System.out.println(pair.key + ":" + pair.value);
            }
            System.out.println();
        }
    }
}
