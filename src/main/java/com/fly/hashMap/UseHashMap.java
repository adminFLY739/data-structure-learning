package com.fly.hashMap;

import java.util.HashMap;
import java.util.Map;

public class UseHashMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "world");
        String name = map.get(1);
        map.remove(1);
        for (Map.Entry<Integer, String> kv : map.entrySet()) {
            System.out.println(kv.getKey() + "->" + kv.getValue());
        }
        map.forEach((k, v) -> System.out.println(k + "->" + v));
        for (Integer key : map.keySet()) {
            System.out.println(key);
        }
        for (String value : map.values()) {
            System.out.println(value);
        }
    }
}
