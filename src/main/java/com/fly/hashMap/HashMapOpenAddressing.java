package com.fly.hashMap;

public class HashMapOpenAddressing {
    private int size;
    private int capacity = 4;
    private final double loadThres = 2.0 / 3.0;
    private final int extend = 2;
    private Pair[] buckets;
    private final Pair TOMBSTONE = new Pair(-1, "-1");

    public HashMapOpenAddressing() {
        size = 0;
        buckets = new Pair[capacity];
    }

    public int getIndex(int key) {
        return key % capacity;
    }

    public double getLoadThres() {
        return (double) size / capacity;
    }

    public int target(int key) {
        int index = getIndex(key);
        int firstTombstone = -1;
        // 线性探测，直到遇到空桶，墓碑不属于空桶
        while (buckets[index] != null) {
            // select成功
            if (buckets[index].key == key) {
                // 遇到过墓碑，回收墓碑
                if (firstTombstone != -1) {
                    buckets[firstTombstone] = buckets[index];
                    buckets[index] = TOMBSTONE;
                    return firstTombstone;
                }
                // 没有遇到过墓碑
                return index;
            }
            // 记录遇到的第一个墓碑，用于墓碑回收
            if (firstTombstone == -1 && buckets[index] == TOMBSTONE) {
                firstTombstone = index;
            }
            index = (index + 1) % capacity;
        }
        // 没有遇到过墓碑，则返回第一个遇到的空桶；遇到过墓碑，则准备回收墓碑
        return firstTombstone == -1 ? index : firstTombstone;
    }

    public String select(int key) {
        int index = target(key);
        // 成功找到有值的桶
        if (buckets[index] != null && buckets[index] != TOMBSTONE) {
            return buckets[index].value;
        }
        return null;
    }

    public void insertAndUpdate(int key, String value) {
        if (getLoadThres() > loadThres) {
            extend();
        }
        int index = target(key);
        if (buckets[index] != TOMBSTONE && buckets[index] != null) {
            buckets[index].value = value;
        }
        buckets[index] = new Pair(key, value);
        size++;
    }

    public void delete(int key) {
        int index = target(key);
        if (buckets[index] != TOMBSTONE && buckets[index] != null) {
            buckets[index] = TOMBSTONE;
            size--;
        }
    }

    public void extend() {
        capacity *= extend;
        Pair[] bucketsTemp = buckets;
        buckets = new Pair[capacity];
        size = 0;
        for (Pair bucket : bucketsTemp) {
            if (bucket != null && bucket != TOMBSTONE) {
                insertAndUpdate(bucket.key, bucket.value);
            }
        }
    }

    public void print() {
        for (Pair bucket : buckets) {
            if (bucket == null) {
                System.out.println("null");
            } else if (bucket == TOMBSTONE) {
                System.out.println("TOMBSTONE");
            } else {
                System.out.println(bucket.key + "->" + bucket.value);
            }
        }
    }
}
