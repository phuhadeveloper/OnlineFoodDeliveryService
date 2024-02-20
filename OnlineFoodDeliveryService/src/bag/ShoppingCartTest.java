package bag;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {
	
	private static ShoppingCart<CartItem> shoppingCart;
	
	@BeforeEach
	void setUp() {
		try {
			shoppingCart = new ShoppingCart<>(3);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		shoppingCart.add(new CartItem(123, "Fruit", 2.22));
	}
	
	@Test
	void add() {
		assertTrue(shoppingCart.add(new CartItem(123, "Fruit", 2.22)));
		assertTrue(shoppingCart.add(new CartItem(124, "Soda", 0.99)));
		assertFalse(shoppingCart.add(new CartItem(134, "Candy", 3.30)));
	}
	
	@Test
	void remove() {
		assertFalse(shoppingCart.remove(new CartItem(124, "Soda", 0.99)));
		assertTrue(shoppingCart.remove(new CartItem(123, "Fruit", 2.22)));
		assertFalse(shoppingCart.remove(new CartItem(123, "Fruit", 2.22)));
	}
	
	@Test 
	void isFull() {
		assertFalse(shoppingCart.isFull());
		assertTrue(shoppingCart.add(new CartItem(123, "Fruit", 2.22)));
		assertFalse(shoppingCart.isFull());
		assertTrue(shoppingCart.add(new CartItem(123, "Fruit", 2.22)));
		assertTrue(shoppingCart.isFull());
	}
	
	@Test 
	void contains() {
		assertTrue(shoppingCart.contains(new CartItem(123, "Fruit", 2.22)));
		assertFalse(shoppingCart.contains(new CartItem(124, "Soda", 0.99)));
	}
	
	@Test
	void frequency() {
		assertEquals(1, shoppingCart.frequencyOf(new CartItem(123, "Fruit", 2.22)));
		assertEquals(0, shoppingCart.frequencyOf(new CartItem(124, "Soda", 0.99)));
	}
}
