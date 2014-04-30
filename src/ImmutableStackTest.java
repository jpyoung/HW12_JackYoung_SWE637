
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Jack Young
 * @date October 08, 2013
 * SWE 619 Assignment 6
 */

public class ImmutableStackTest {

	//Exception Section
	
	//Testing Exception for the choose method in the ImmutableBag class
	@Test (expected = IllegalStateException.class)
	public void chooseISETest1() {
		ImmutableStack<String> g = new ImmutableStack<String>();
		g.choose();
	}
	
	//Testing the exception for the get method in the ImmutableBag class
	@Test (expected = IllegalStateException.class)
	public void chooseISETest2() {
		ImmutableStack<String> g = new ImmutableStack<String>();
		g = (ImmutableStack<String>) g.get();
	}
	
	//put() Section
	
	@Test		//Test size of a double put()
	public void stackPutSizeTest() {
		ImmutableStack<String> g = new ImmutableStack<String>();
		g = (ImmutableStack<String>) g.put("Jack");
		g = (ImmutableStack<String>) g.put("Young");
		assertTrue("Bag does not equal expected size", 2 == g.elements.size());
	}
	
	@Test		//Test double put() and choose()
	public void stackPutChooseTest() {
		ImmutableStack<String> g = new ImmutableStack<String>();
		g = (ImmutableStack<String>) g.put("Jack");
		g = (ImmutableStack<String>) g.put("Young");
		assertTrue("Returned name of choose() does not meeet expected name", "Young".equals(g.choose()));
	}
	
	@Test		//Test double put() and get()
	public void stackPutGetTest() {
		ImmutableStack<String> g = new ImmutableStack<String>();
		g = (ImmutableStack<String>) g.put("Jack");
		g = (ImmutableStack<String>) g.put("Young");
		g = (ImmutableStack<String>)g.get();
		assertTrue("The size is not correct", 1 == g.elements.size());
		assertTrue("Returned name of choose() does not meeet expected name", "Jack".equals(g.choose()));
	}
	
	@Test		//Test four put() and double get()
	public void stackPutGetTest2() {
		ImmutableStack<String> g = new ImmutableStack<String>();
		g = (ImmutableStack<String>) g.put("Jack");
		g = (ImmutableStack<String>) g.put("Young");
		g = (ImmutableStack<String>) g.put("Ryan");  //this will be removed by the second get
		g = (ImmutableStack<String>) g.put("Mark");  //this will be removed by the first get
		g = (ImmutableStack<String>)g.get();
		g = (ImmutableStack<String>)g.get();
		assertTrue("The size is not correct", 2 == g.elements.size());
		assertTrue("Returned name of choose() does not meeet expected name", "Young".equals(g.choose()));
	}

}
