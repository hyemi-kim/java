package com.company.queue;

import java.util.List;

/**
 * Created by hyemi on 2015. 12. 29..
 */
public interface Queue<E> {
	void enqueue(E item);
	E dequeue();
	int getSize();
	List<E> getAllElements();
}
