package com.example.soccer_week_11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Repository<T extends SoccerEntity> {
    private final List<T> items;

    {
        items = new ArrayList<>();
    }

    public void add(T item) {
        if (item == null) throw new IllegalArgumentException("Cannot add null item");
        items.add(item);
    }
    public List<T> getAll() {
        return new ArrayList<>(items);
    }
    public List<T> filter(Predicate<T> condition) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
