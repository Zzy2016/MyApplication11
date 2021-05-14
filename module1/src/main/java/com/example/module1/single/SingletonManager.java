package com.example.module1.single;

import java.util.HashMap;
import java.util.Map;

public class SingletonManager {
    private static Map<String, Object> map = new HashMap<>();

    private SingletonManager() {
    }

    public static void registerService(String key, Object instance) {
        if (!map.containsKey(key)) {
            map.put(key, instance);
        }
    }

    public static Object getService(String key) {
        return map.get(key);
    }

}
