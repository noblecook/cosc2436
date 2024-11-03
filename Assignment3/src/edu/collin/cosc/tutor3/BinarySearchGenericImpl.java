package edu.collin.cosc.tutor3;

import java.util.List;

public class BinarySearchGenericImpl<T extends Comparable<T>> implements IGenericSearchAlgorithm<T> {
    @Override
    public T search(List<T> items, T key) {
        int left = 0;
        int right = items.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            T midItem = items.get(mid);
            int comparison = midItem.compareTo(key);

            if (comparison == 0) {
                return midItem;
            }
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

