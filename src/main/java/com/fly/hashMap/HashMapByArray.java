package com.fly.hashMap;

import java.util.ArrayList;
import java.util.List;

public class HashMapByArray {
    private List<Pair> buckets;

    public HashMapByArray() {
        buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(null);
        }
    }

    public int getIndex(int key) {
        return key % 100;
    }

    public String select(int key) {
        int index = getIndex(key);
        Pair pair = buckets.get(index);
        if (pair == null) {
            return null;
        }
        return pair.value;
    }

    public void insert(int key, String value) {
        Pair pair = new Pair(key, value);
        int index = getIndex(key);
        buckets.set(index, pair);
    }

    public void delete(int key) {
        buckets.set(getIndex(key), null);
    }

    public List<Pair> pairSet() {
        return buckets;
    }

    public List<Integer> keySet() {
        List<Integer> keyset = new ArrayList<>();
        for (Pair pair : buckets) {
            if (pair != null) {
                keyset.add(pair.key);
            }
        }
        return keyset;
    }

    public List<String> valueSet() {
        List<String> valueset = new ArrayList<>();
        for (Pair pair : buckets) {
            if (pair != null) {
                valueset.add(pair.value);
            }
        }
        return valueset;
    }

    public void print() {
        for (Pair kv : pairSet()) {
            System.out.println(kv.key + "->" + kv.value);
        }
    }
}
