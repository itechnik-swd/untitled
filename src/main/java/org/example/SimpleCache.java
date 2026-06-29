package org.example;

import java.util.HashMap;
import java.util.Map;

// Устная задача. Перед вами представлена простая реализация in-memory кэша.
// Необходимо озвучить проблемы и недочёты данной реализации.

public class SimpleCache {
    private static Map<String, String> cache = new HashMap<>();

    public void store(String key, String value) {
        // lru, lfu
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public void remove(String key) {
        cache.remove(key);
    }
}
