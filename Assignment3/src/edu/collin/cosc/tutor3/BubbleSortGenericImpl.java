package edu.collin.cosc.tutor3;

import java.util.Comparator;
import java.util.List;

public class BubbleSortGenericImpl<T> implements IGenericSortAlgorithm<T> {
    @Override
    public void sort(List<T> items, Comparator<T> comparator) {
        int n = items.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(items.get(j), items.get(j + 1)) > 0) {
                    T temp = items.get(j);
                    items.set(j, items.get(j + 1));
                    items.set(j + 1, temp);
                }
            }
        }
    }
}


