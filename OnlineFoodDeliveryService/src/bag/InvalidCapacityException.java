package bag;

/**
 * This class is a custom exception 
 * To use when an invalid capacity is entered
 * 
 * author: Phu Ha
 * Date: February 18, 2024
 */

public class InvalidCapacityException extends Exception{
	public InvalidCapacityException(String message) {
		super(message);
	}
}
