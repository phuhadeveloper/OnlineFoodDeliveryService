package bag;

import java.util.Arrays;

/**
 * This class is the Shopping Cart that implements the BagInterface
 * 
 * This implementation uses a fixed size array, default capacity of 25
 * 
 * author: Phu Ha
 * Date: February 18, 2024
 * 
 */

public class ShoppingCart<T> implements BagInterface<T> {
	private T[] myBag;
	private int numberOfProducts;
	private static final int DEFAULT_CAPACITY = 25;
	
	// default constructor
	public ShoppingCart() throws InvalidCapacityException {
		this(DEFAULT_CAPACITY);
	}
 	
	// parameterized constructor
	// should throw an error if capacity <= 0
	public ShoppingCart(int capacity) throws InvalidCapacityException {
		
		if (capacity <= 0) {
			throw new InvalidCapacityException("Bag capacity cannot be 0 or less than 0.");
		}
		
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[])new Object[capacity];
		myBag = tempArray;
		numberOfProducts = 0;
		
	}
	
	//isFull method
	public boolean isFull() {
		return myBag.length == numberOfProducts;
	}
	
	// interface methods
	// add to bag
	public boolean add(T newItem) {
		if (!isFull()) {
			myBag[numberOfProducts++] = newItem;
			return true;
		}
		return false;
	}
	
	// remove entry from bag
	public boolean remove(T item) {
		if (isEmpty()) return false;
		
		int index = getIndexOf(item);
		
		if (index == -1) return false;
		
		removeAtIndex(index);
		
		return true;
	}
	
	// clear the bag
	public void clear() {
		for (int i = numberOfProducts - 1; i >= 0; i--) {
			removeAtIndex(i);
		}
	}
	
	// return an array of the items in the bag
	public T[] toArray() {
		if (isEmpty()) return null;
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[numberOfProducts];
		for (int i = 0; i < numberOfProducts; i++) {
			temp[i] = myBag[i];
		}
		return temp;
	}
	
	// check if item is in the bag
	public boolean contains(T item) {
		return getIndexOf(item) != -1;
	}
	
	// return frequency of specify item
	public int frequencyOf(T item) {
		int frequency = 0;
		for (int i = 0; i < numberOfProducts; i++) {
			if (myBag[i].equals(item)) frequency++;
		}
		return frequency;
	}
	
	// private helper methods
	
	// check if bag is Empty
	private boolean isEmpty() {
		return numberOfProducts == 0;
	}
	
	// find index of the entry in the bag, return -1 if not in the bag
	private int getIndexOf(T item) {
		for (int i = 0; i < numberOfProducts; i++ ) {
			if (myBag[i].equals(item)) return i;
		}
		return -1;
	}
	
	// remove item at index 
	private void removeAtIndex(int index) {
		myBag[index] = myBag[numberOfProducts - 1];
		
		myBag[numberOfProducts - 1] = null;
		
		numberOfProducts--;
	}
	
	public static void main(String[] args) {
		try {
			CartItem item = new CartItem(123, "Fruit", 2.22);
			ShoppingCart<CartItem> cart = new ShoppingCart<>(3);
			System.out.println(cart.add(item));
			System.out.println(cart.getIndexOf(item));
			System.out.println(cart.remove(item));
			System.out.println(Arrays.toString(cart.toArray()));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
