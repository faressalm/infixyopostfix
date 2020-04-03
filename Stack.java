package eg.edu.alexu.csd.datastructure.stack;

import java.util.EmptyStackException;
public class Stack implements IStack{
	private  class Node {
		Object data=null ;
		Node next=null; 
     public Node(Object element,Node n) {
    	 data=element;
    	 next=n;
     } 
		
	}
	 private Node top;
	 private int size;
	 public Stack() {
		 top=null;
		 size=0;
	 }
	 /**
	 * Removes the element at the top of stack and returns that element.
	 *
	 * @return top of stack element, or through exception if empty
	 */
	public Object pop() {
		if (isEmpty()) throw new EmptyStackException() ;
	
		Object data=top.data;
		top=top.next;
		size--;
		return data;
	}

	/**
	* Get the element at the top of stack without removing it from stack.
	*
	* @return top of stack element, or through exception if empty
	*/
	public Object peek() {
		if (isEmpty()) throw new EmptyStackException() ;

		return top.data;
	}
 
  
  
	/**
	* Pushes an item onto the top of this stack.
	*
	* @param element
	* to insert
	*/
	public void push(Object element) {
		Node n=new Node(element,top);
		top=n;
		size++;
		
	}

	/**
	* Tests if this stack is empty
	*
	* @return true if stack empty
	*/
	public boolean isEmpty() {
		if (size==0) {
			return true;
		}
		return false;
	}

	/**
	* Returns the number of elements in the stack.
	*
	* @return number of elements in the stack
	*/
	public int size() {
		return size;
		
	}

	
}
