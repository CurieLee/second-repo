package multicampus.d_datastructure;

import java.util.Arrays;

public class ArrayList<E> {
	
	private Object[] elementData;
	private int size;
	private int arraySize = 10;
	
	public ArrayList() {
		elementData = new Object[arraySize];
	}
	
	public ArrayList(int initialCapacity) {
		this.arraySize = initialCapacity;
		elementData = new Object[arraySize];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean add(E e) {
		if (size < arraySize) {
			elementData[size] = e;
			size++;
			return true;
		}
		
		arraySize *= 2;
		elementData = Arrays.copyOf(elementData, arraySize);
		elementData[size] = e;
		size++;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public E get(int index) {
		if (index < 0 || size <= index) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다. ");
		return (E) elementData[index];
	}
	
	@SuppressWarnings("unchecked")
	public E set(int index, E element) {
		if (index < 0 || size <= index) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다. ");
		E prevElement = (E) elementData[index];
		elementData[index] = element;
		return prevElement;
	}
	
	@SuppressWarnings("unchecked")
	public E remove(int index) {
		if (index < 0 || size <= index) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다. ");
		E prevElement = (E) elementData[index];
		
		for (int i = index; i < size - 1; i ++) {
			elementData[i] = elementData[i + 1];
		}
		
		elementData[size - 1] = null;
		size--;
		return prevElement;
	}
	
	@Override
	public String toString() {
		return "ArrayList [elementData = " + Arrays.toString(elementData) + "]";
	}
}
