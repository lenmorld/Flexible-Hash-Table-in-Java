/*
 * Class HashEntry
 * 
 * Objective: 
 * - Allocate each entry to a certain location in a Hash Table. 
 * - Use hashing functions to determine the index in which the entry should be placed.
 * 
 * Each entry holds a key and a value. The key will be used in a hashing function to determine the index at which the entry should be placed in a Hash Table.
 * There are several accessor and mutator methods which will allow us to obtain informmation about each entry.
 * 
 * Most importantly, we have a lastHashCollisionValue and a prevHashCollisionValue which will be used for the 'R' empty marker scheme. Each entry holds a 
 * hash value that corresponds to the position of the last collision it had with an entry. It also holds a hash value which corresponds to the position of the 
 * entry in which it collided with before it got placed in its current position.
 * 
 * These two attributes and its accessor/mutator methods will allow us to swap the elements in O(1) time without depending on an AVAILABLE object or other markers.
 * It will also decrease the search time since the newly placed entry is located at the right index. 
 * 
 * HashEntry also extends available which allows us to mark a cell in the Hash Table as "AVAILABLE"
 * 
 */
public class HashEntry extends Available{
	
	private String key; 
	private String value; //Each entry will contain a key and a value
	private int hashValue; //Each entry will be associate to its TRUE hash value
	private int collisionNumber; //Keeps track of the number of collisions
	private int lastHashCollisionValue; //LAST entry that collided with this entry
	private int prevHashCollisionValue; //The last entry that THIS entry collided with
	
	HashEntry(String k, String v) {
		key = k;
		value = v;
	}

	HashEntry(Available av, String k){
		key = "_AVAILABLE_";
		value = k;
	}
	
	
	//ACCESSOR AND MUTATOR METHODS
	public String getKey() {
		return key;
	}
	
	
	public void setValue(String v){
		value = v;
	}
	
	public void setKey(String k){
		key = k;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setHashValue(int hash){
		hashValue = hash;
	}
	
	public int getHashValue(){
		return hashValue;
	}
	
	//THE FOLLOWING METHODS ARE USED FOR THE 'R' empty marker scheme
	//SWAP THE ENTRY WITH THE LAST COLLISION
	public void setLastHashCollisionValue(int hash){
		lastHashCollisionValue = hash;
	}
	
	public int getLastHashCollisionValue(){
		return lastHashCollisionValue;
	}
	
	public void setPrevHashCollisionValue(int hash){
		prevHashCollisionValue = hash;
	}
	
	public int getPrevHashCollisionValue(){
		return prevHashCollisionValue;
	}
	
	
	public void resetCollisionNumber(){
		collisionNumber = 0;
	}
	
	public void incNumOfCollision(){
		collisionNumber++;
	}
	
	public int getNumOfCollision(){
		return collisionNumber;
	}

	public String toString() {
		return "[" + key + "] " + value; 
	}
}
