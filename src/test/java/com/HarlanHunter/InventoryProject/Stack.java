package src.test.java.com.HarlanHunter.InventoryProject;
/**
 * interface stack<E> for the ADT stack. Not a vector stack, just a original ole'stack. 
 * @author Hunter Mark Shaw
 *
 * @param <E>
 */
public interface Stack<E> {
	
	/**
	 * Checks if the stack is empty.
	 * @return boolean
	 */
	public boolean empty();
	
	/**
	 * Looks at the top of the stack, does not remove the top of the stack.
	 * @return E
	 */
	public E peek();
	
	/**
	 * Removes the object at the top of the stack. 
	 * @return
	 */
	public E pop();
	
	/**
	 * Pushed an item to the top of the stack.
	 * @param item
	 * @return E
	 */
	public E push(E item);
	
}
