package bag;

public class CartItem {
	private int customerNumber;
	private String itemName;
	private double price;
	
	// constructor 
	public CartItem(int custNo, String itemName, double price) {
		this.customerNumber = custNo;
		this.itemName = itemName;
		this.price = price;
	}
	
	// getters
	public int getCustomerNumber() {return customerNumber;}
	public String getItemName() {return itemName;}
	public double getPrice() {return price;}
	
	// setters
	public void setCustomerNumber(int custNo) {this.customerNumber = custNo;}
	public void setItemName(String itemName) {this.itemName = itemName;}
	public void setPrice(double price) {this.price = price;}
	
	// equals, check if two CartItems are equal
	public boolean equals(CartItem item) {
		// compare customer number
		if (this.customerNumber != item.getCustomerNumber()) return false;
		
		// compare name
		if (this.itemName.compareTo(item.getItemName()) != 0) return false;
		
		// lastly, compare the price
		if (Math.abs(this.price - item.getPrice()) <= 0.000001 ) return true;
		else return false;
	}

	
	// toString
	@Override
	public String toString() {
		return "Customer Number: " + customerNumber + ", Item Name: " + itemName + ", Price: $" + price;
	}
}
