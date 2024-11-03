package edu.collin.cosc.tutor3;

import java.util.Comparator;
import java.util.List;

public interface IGenericSortAlgorithm<T> {
	void sort(List<T> items, Comparator<T> comparator);
}
