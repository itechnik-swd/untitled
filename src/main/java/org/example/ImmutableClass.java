package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ImmutableClass {
    private final Map<String, String> data;
    private final List<String> items;

    public ImmutableClass(Map<String, String> map, List<String> list) {
        // Глубокое копирование карты
        Map<String, String> copyMap = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            copyMap.put(entry.getKey(), entry.getValue());
        }

        // Копирование списка
        List<String> copyList = new ArrayList<>(list);

        this.data = copyMap;
        this.items = copyList;
    }

    // Возвращаем копии объектов вместо ссылок на оригинальные
    public Map<String, String> getData() {
        return new HashMap<>(data);
    }

    public List<String> getItems() {
        return new ArrayList<>(items);
    }
}

