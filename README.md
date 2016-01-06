# COMP352_4
Lenmor and Dexter


/*NAMES: 
 * LENMOR DIMANALATA 27699727
 * DEXTER KWOK 27709110
 * 
 *COMP 352 - ASSIGNMENT 4
 * 
 * Class HashMap
 * 
 * Objective:
 * - Create a hash table which will accept entries consisting of a key and a value
 * - Use the key to partition the corresponding entries into its table
 * - Avoid as many collisions as possible by implementing a hash function which will decrease the likelihood of collisions
 * - Allow user to choose between different hashing options to view the difference in execution time and collision numbers
 * 
 * The HashMap is the core of this program. It will accept an entry that contains a key and a value. The key will serve as a value which will determine the 
 * position at which the entry should be placed. This process will be associated with a hash function which will turn the key into an integer value. 
 * The resulting integer value will act as the index at which the entry will be placed. 
 * 
 * More information about the hash function can be found in the PDF file.
 * 
 * In short, we use a prime number and the MAD function to hash the key value into an integer and we use that value to place the entry in its respective index.
 * 
 * In this design, we have decided to use a prime number to represent the capacity (size) of our hash table. According to certain mathematicians, using a prime
 * number as the size of the hash table will reduce the number collisions. Also, the use of 33, 37, or 41 in our hash function will also reduce collisions.
 * 
 * To find these prime numbers, we have included two methods which determines if the number is prime and find the next prime number from a given value:
 * - isPrime(integer)
 * - findNextPrime(integer)
 * 
 * We also keep track of many factors such as the emptyMarkerScheme, collisionHandlingType, maxCollisionCtr,...
 * The above attributes are used for our statistics method which displays interesting information about different hashing methods.
 * We are able to display these statistics since we keep track of all collisions.
 * 
 * 
 * Performance and design:
 * 
 * put(k, v)		- expected O(1), assuming good HashTable settings, 
 *                  - first checks if the table needs to be resized based on loadFactor, then if it needs to be, resizes it based on the rehashFactor
 *                  - handles collisions effectively, either Q or D, (it seemed D is better) 
 *                  - if collisions happen, they are put into the HashEntry attribute as the last collision, and the previous collision for that entry
 * 
 * get(k)		- expected O(1), assuming good HashTable settings, 
 * 				- checks the collisionHalding setting (Q or D) for which jump to use
 * 				- gets hash then jumps to next hash (if needed), until desired entry is found
 * 
 * remove()		- expected O(1)
 * 		3 modes
 * 			Available - uses AVAILABLE as the marker for removed entries
 * 			Negative  - uses negative value of the removed key
 * 			Replace  - uses the 2 extra attributes in HashEntry that keeps track of the lastCollidedValue and previousCollidedValue  
 * 				     - recursive method that replaces the entry to be removed with the last collision that happened 
 *  				 - instead of shifting all entries to fill up the removed entry (which will be O(n))
 * 
 * hashMe()		- O(1)	 hash code map, including Polynomial method and MAD, uses prime numbers
 * 							(see comment below for details)
 * 
 * hashSec()	- O(1)	 Double hash for one mode of collision handling, uses prime numbers
 * 						(see comment below for details)
 * 
 * 
 * Collision-Handling Schemes
 * 
 * Q - Quadratic Probing  ########################
 * iteratively tries the next buckets, until finds an empty one
 * A[(h(k) + f(i))  mod N], i = 0,1,2,.. where f(i) = i^2
 * it avoids some clustering patterns that occur with linear probing
 * might create some secondary clustering
 * 
 * its guaranteed to find an empty slot, because we keep N as prime
 * 
 *  D - Double hashing #######################
 * prevents clustering, even the sec. clustering produced by linear
 * provides a constant jump when there's a collision
 * 
 * h'(k) = q - (k mod q) is used
 * q < N, q and N prime numbers
 * 
 */

