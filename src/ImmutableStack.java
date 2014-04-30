
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jack Young
 * @date October 06, 2013
 */

public class ImmutableStack<E> extends AbstractIBag<E> {
	// OVERVIEW:   ImmutableStacks are immutable and are a subclass of AbstractIBag.
	//			   This class is a collection that is mean't to hold elements in the 
	//			   (first-in-last-out) manner.	
	
	
	/**
	 * Default constructor for the ImmutableStack class.  
	 */
	public ImmutableStack() {
		// EFFECTS: Initializes the List
		this.elements = new ArrayList<E>();
	}
	
	
	/**
	 * This method retrieves the last element of the stack.  
	 * 
	 * @return Object
	 * @throws IllegalStateException if this is empty
	 */
	public Object choose() throws IllegalStateException {
	   // Effects:  if this is empty throws ISE else returns the last element of the stack.  
		if (this.elements.isEmpty()) {
			throw new IllegalStateException("ImmutableStack.choose()");
		}
		return this.elements.get(this.elements.size() - 1);
	}

	
	/**
	 * This method retrieves the head of the queue.  
	 * 
	 * @return Abstract<E>
	 * @throws IllegalStateException if this is empty
	 */
	public AbstractIBag<E> get() throws IllegalStateException {
	    // Effects:  if this is empty throw ISE else produce an 
		//			 AbstractIBag equal to this less the element
		//			 that choose() selects.
		
		if (this.elements.isEmpty()) {
			throw new IllegalStateException("ImmutableStack.get()");
		}
		List<E> newEls = new ArrayList<E>(this.elements);
		newEls.remove(choose());
		AbstractIBag<E> temp = getNewBag();
		temp.elements = newEls;
		return temp;
	}
	
	
	/**
	 * Returns an empty AbstractIBag  
	 * 
	 * @return Abstract<E>
	 * 
	 * @throws IllegalStateException if this is empty
	 */
	protected AbstractIBag<E> getNewBag() {
		//Effects:  Produce an empty AbstractIBag; for use by producers
		
		AbstractIBag<E> temp = new ImmutableStack<E>();
		return temp;
	}
	
	
	/**
	 * toString method
	 * 
	 * @return string 
	 */
	public String toString() {
		// EFFECTS: Returns a string that textually represents this object.
		String str = "ImmutableStack [elements=";
		for (int i = 0; i < elements.size(); i++) {
			str += this.elements.get(i) + " ";
		}
		str += "]";
		return str;
	}
	
	
}
