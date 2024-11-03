package edu.collin.cosc.tutor3;

import java.util.List;

public interface IGenericSearchAlgorithm<T> {
	T search(List<T> items, T key);
}
