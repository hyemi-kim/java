package com.company.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyemi on 2015. 12. 29..
 */


public class QueueImpl<E> implements Queue<E> {
	private E[] queue;
	private int size;
	private int headIdx;
	private static final int DEFAULT_INITIAL_CAPACITY = 100;

	public QueueImpl()
	{
		this.headIdx = 0;
		this.size = 0;
		this.queue = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}

	@Override
	public void enqueue(E item){
		if(this.headIdx + this.size + 1 > queue.length)
		{
			E[] copyArray = (E[]) new Object[this.size];
			for(int i=0;i<size;i++){
				copyArray[i] = queue[i+headIdx];
			}
			queue = (E[]) new Object[queue.length*2];
			for(int i=0;i<size;i++){
				queue[i] = copyArray[i];
			}
			headIdx = 0;
		}
		queue[headIdx+size] = item;
		size++;
	}

	@Override
	public E dequeue() {
		if(size == 0)
		{
			return null;
		}

		E item = (E) queue[headIdx++];
		size--;

		if(headIdx >= queue.length/2 || this.size < queue.length/2) {
			E[] copyArray =(E[]) new Object[this.size];
			for(int i=0;i<size;i++){
				copyArray[i] = queue[i+headIdx];
			}
			queue = (E[]) new Object[queue.length/2+1];
			for(int i=0;i<size;i++){
				queue[i] = copyArray[i];
			}
			headIdx = 0;
		}

		return item;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public List<E> getAllElements() {
		List<E> entryList = new ArrayList<E>();
		for(int i=0;i<this.size;i++){
			entryList.add(queue[headIdx+i]);
		}
		return entryList;
	}
}
