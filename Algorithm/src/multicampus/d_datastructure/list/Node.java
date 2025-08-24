package multicampus.d_datastructure.list;

public class Node<E> {
	
	private Node<E> next;
	private E data;
	
	public Node() {}
	
	public Node(E e) {
		// TODO Auto-generated constructor stub
	}

	public Node<E> next() {
		return next;
	}
	
	public void next(Node<E> next) {
		this.next = next;
	}
	
	public void data(E data) {
		this.data = data;
	}
	
	public E data() {
		return this.data;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
