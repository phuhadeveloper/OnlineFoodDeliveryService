package bag;
/**
 * This is a demo class that implements the Shopping Cart
 * 
 * author: Phu Ha 
 * date: February 18, 2024
 */
public class BagDemo {

	public static void main(String[] args) {
		try {
			// Testing add without filling up to capacity
			System.out.println("Testing add without filling up to capacity: ");
			// bag contents
			String[][] contents = {{"Cookies", "3.99"}, {"Sushi", "19.99"}, {"Noodle", "5.99"}, {"Fish", "4.99"}};
			// create cart and CartItem array
			ShoppingCart<CartItem> cart = new ShoppingCart<CartItem>();
			CartItem[] items = new CartItem[contents.length];
			for (int i = 0; i < contents.length; i++) {
				items[i] = new CartItem(i, contents[i][0], Double.parseDouble(contents[i][1]));
			}
			testAdd(cart, items);
	
			System.out.println();
			
			// Testing add with reaching a bag capacity of 3
			System.out.println("Testing bag with a capacity of 3: ");
			ShoppingCart<CartItem> cartCapacity3 = new ShoppingCart<CartItem>(3);
			testAdd(cartCapacity3, items);
		} 
		catch (InvalidCapacityException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void testAdd(ShoppingCart<CartItem> cart, CartItem[] items) {
		System.out.println("Testing Add:");
		for (CartItem item: items) {
			if (cart.add(item)) {
				System.out.println("Added: " + item.toString());
			} else {
				System.out.println("Unable to Add: " + item.toString());
			}
		}
		displayBag(cart);
	}
	
	private static void displayBag(ShoppingCart<CartItem> cart) {
		System.out.println("Current cart contents: ");
		Object[] bag = cart.toArray();
		for (int i = 0; i < bag.length; i++) {
			System.out.println(bag[i].toString());
		}
	}
}
