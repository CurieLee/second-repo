package multicampus.d_datastructure.list;

import java.util.Arrays;
import java.util.Iterator;

public class _LinkedList<E> implements Iterable<E> {
	// ArrayList: O(1)
	// LinkedList: O(n)-> 순차탐색 수정/삭제 용이
	
	private Node<E> head;
	private int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean add(E e) {
		Node<E> node = new Node<>();
		node.data(e);
		
		if (head == null) {
			head = node;
			size++;
			return true;
		}
		
		Node<E> link = head;
		while (link.next() != null) {
			link = link.next();
		}
		
		link.next(node);
		size++;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public E get(int index) {
		if (index < 0 || size <= index) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다. ");
		
		Node <E> link = head;
		for (int i = 0; i < index; i ++) {
			link = link.next();
		}
		
		return link.data();
	}
	
	@SuppressWarnings("unchecked")
	public E set(int index, E element) {
		if (index < 0 || size <= index) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다. ");
		
		Node <E> link = head;
		for (int i = 0; i < index; i ++) {
			link = link.next();
		}
		
		E prevNode = link.data();
		link.data(element);
		return prevNode;
	}
	
	@SuppressWarnings("unchecked")
	public E remove(int index) {
		if (index < 0 || size <= index) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다. ");
		if (index == 0) {
			E removed = head.data();
			head = head.next();
			size--;
			return removed;
		}
		
		
		Node<E> prevNode = head;
		Node<E> link = head.next();
		
		for (int i = 0; i < index; i++) {
			prevNode = link;
			link = link.next();
		}
		
		prevNode.next(link.next());
		E removed = link.data();
		size--;
		return null;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		
		for (int i = 0; i < size; i++) {
			sb.append(get(i));
			sb.append(", ");
		}
		
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append("]");
		return sb.toString();
	}
	
	// contains
	public boolean contains(Object e) {
		Node<E> link = head;
		
		if (head.equals(e))	return true;
		
		while (link.next() != null) {
			if (link.data().equals(e))	return true;
			link = link.next();
		}
		
		return false;
	}
	
	// indexOf
	public int indexOf(Object e) {
		Node<E> link = head;
		int index = 0;
		
		for (int i = 0; i < size; i++) {
			if (link.data().equals(e))	return i;
			link = link.next();
		}
		
		return -1;
	}
	
	// iterator
	@Override
	@SuppressWarnings("unchecked")
	public Iterator<E> iterator() {
		return new Iterator<E> () {
			
			private int pointer = 0;
				
			public boolean hasNext() {
				return pointer < size;
			}
				
			public E next() {
				E e = get(pointer);
				pointer++;
				return e;
			}
		};
	}
	
}
