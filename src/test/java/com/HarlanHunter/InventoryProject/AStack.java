package src.test.java.com.HarlanHunter.InventoryProject;

import java.util.EmptyStackException;

/**
 * Array based implementation of Stack interface.
 * @author Hunter Shaw
 *
 * @param <E>
 */
public class AStack<E> implements Stack<E> {
	
	private Object[] ar;
	private int size;
	private int capacity;
	final private int MAX_CAPACITY = 10;
	
	
	
	//########### CONSTRUCTORS ###########
	
	public AStack() {
		capacity = MAX_CAPACITY;
		ar = new Object[capacity];
		size = 0;
	}
	
	public AStack(int definedCapacity) {
		capacity = definedCapacity;
		ar = new Object[capacity];
		size = 0;
	}
	
	
	
	@Override
	public boolean empty() {
		return size == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		return (E) ar[size-1];
	}

	@SuppressWarnings("unchecked")
	@Override
	public E pop() {
		E toRemove;
		if (size > 0) {
			toRemove = (E) ar[size-1];
			size--;
			ar[size] = null;
			return toRemove;
		} else if (size == 0) {
			toRemove = (E) ar[size];
			ar[size] = null;
			return toRemove;
		}
		else {
			throw new EmptyStackException();
		}
		
	}

	@Override
	public E push(E item) {
		if (size <= capacity) {
			ar[size] = item;
			size++;
			return item;
		} else {
			return null;
		}
	}

}
