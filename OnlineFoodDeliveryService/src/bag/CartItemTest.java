package bag;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartItemTest {
	private CartItem cartItem;

	@BeforeEach
	void setUp() {
		cartItem = new CartItem(123, "Fruit", 2.22);
	}
	
	@Test
	void equalsTest() {
		assertTrue(cartItem.equals(new CartItem(123, "Fruit", 2.22)));
	}
}
