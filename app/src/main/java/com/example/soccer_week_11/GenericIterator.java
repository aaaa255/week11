package com.example.soccer_week_11;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class GenericIterator<T> implements Iterator<T> {
    private final List<T> items;
    private int position = 0;

    public GenericIterator(List<T> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException("No more items");
        return items.get(position++);
    }
}
