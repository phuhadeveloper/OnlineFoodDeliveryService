package bag;

/**
 * This is the BagInterface
 * methods
 *  +add
 *  +remove
 *  +clear
 *  +toArray
 *  +contains
 *  +frequencyOf
 *  
 *  author: Phu Ha
 *  February 18, 2024
 */

public interface BagInterface<T> {
	public boolean add(T newEntry);
		// add a new entry to the  bag
		// return true if added successfully, else return false
	
	public boolean remove(T entry);
		// remove the specify entry from the bag
		// return true if removed successfully, else return false
	
	public void clear();
		// empty the bag
	
	public T[] toArray();
		// return an array that contains all the items currently in the bag
	
	public boolean contains(T entry);
		// return true if the entry is present in the bag, else return false
	
	public int frequencyOf(T entry);
		// return the total number of specify entry present in the bag
}
