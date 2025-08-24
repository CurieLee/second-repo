package multicampus.d_datastructure.stack;

import java.util.EmptyStackException;

import multicampus.d_datastructure.list.Node;

public class _Stack<E> {
	
	private Node<E> top;
	private int size;
	
	public E push(E e) {
		Node<E> newNode = new Node<>(e);
		
		if (top == null) {
			top = newNode;
			size++;
			return e;
		}
		
		newNode.next(top);
		size++;
		return e;
	}
	
	public E peek() {
		if (size == 0) throw new EmptyStackException();
		return top.data();
	}
	
	public E pop() {
		if (size == 0) throw new EmptyStackException();
		E res = top.data();
		top = top.next();
		size--;
		return res;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}
