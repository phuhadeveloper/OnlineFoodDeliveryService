package bag;

public class ShoppingCart<T> implements BagInterface<T> {
	private T[] myBag;
	private int numberOfProducts;
	private static final int DEFAULT_CAPACITY = 25;
	
	// default constructor
	public ShoppingCart() {
		this(DEFAULT_CAPACITY);
	}
 	
	// parameterized constructor
	public ShoppingCart(int capacity) {
		
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
	public boolean add(CartItem newItem) {return false;}
	public boolean remove(CartItem entry) {return false;}
	public void clear() {}
	public T[] toArray() {return null;}
	public boolean contains(CartItem entry) {return false;}
	public int frequencyOf(CartItem entry) {return -1;}

}
