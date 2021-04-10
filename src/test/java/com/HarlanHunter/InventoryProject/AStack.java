package src.test.java.com.HarlanHunter.InventoryProject;

public class AStack<E> implements Stack<E> {
	
	private Object[] ar;
	private int size;
	private int capacity;
	private final int DEFAULT_CAPACITY = 5;
	
	public AStack() {
		capacity = DEFAULT_CAPACITY;
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
		return size > 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		return (E) ar[size-1];
	}

	@SuppressWarnings("unchecked")
	@Override
	public E pop() {
		// TODO Auto-generated method stub
		E toRemove = (E) ar[size-1];
		size--;
		return toRemove;
	}

	@Override
	public E push(E item) {
		// TODO Auto-generated method stub
		return null;
	}

}
