package com.vladis1350.services;

import java.util.ArrayList;
import java.util.List;

public class ConversionFromIterableToList<T> {
    public List iterableToList(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
}
