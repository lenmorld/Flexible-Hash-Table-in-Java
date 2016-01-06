/*NAMES: 
 * LENMOR DIMANALATA
 * DEXTER KWOK 27709110
 * 
 *COMP 352 - ASSIGNMENT 4
 * 
 * 
 * Class Driver
 * 
 * Objective:
 * - Test the implementation of our Hash Table
 * - Check for differences in execution times between different marking schemes, load factors, collision handlers, and resizing factors
 * - Understand and determine the most efficient combination of schemes to avoid high collisions and high execution times
 * 
 * The following Driver contains multiple output cases which test for every individual method which we have implemented in our HashMap class:
 * - Put a string into a hash table
 * - Remove a string from a hash table
 * - Get a string from a hash table
 * - Hash function/mapping
 * - Double hash function
 * - Size of the hash table
 * - Check if the hash table is empty
 * - Return an iterable collection of the elements that the hash table holds
 * - Display the statistics of a certain hashing method
 * - And many accessor and mutator methods...
 * 
 * 
 * The test cases in the Driver class will show the different execution times between different options of hashing and it will also display the statistics 
 * after each case.
 * 
 * -Further information can be found in the PDF file-
 * 
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

	public static void main(String [] args){


		/*
		HashMap h1 = new HashMap(100);
		h1.setEmptyMarkerScheme('N');
		h1.setCollisionHandling('D');
		h1.setRehashFactor("1.3");
		h1.setRehashThreshold(0.4);

		h1.put("i", "i");
		h1.put("dex", "dex");
		h1.put("a", "a");
		h1.put("e", "e");
		h1.put("lenn", "lenn");
		h1.put("knn", "knn");
		h1.put("bn", "bn");
		h1.put("ann", "ann");
		h1.put("lna", "lna");
		h1.put("dn", "dn");
		h1.put("z", "z");
		h1.put("trial", "trial");
		h1.put("hcbn", "hcbn");
		h1.put("n", "n");
		h1.put("8EtSyfiwy5qScLq7jkLFmonomaniac0QtIj0LleC","aaa");

		System.out.println("First output");
		for(HashEntry h: h1.values()){
			System.out.println(h);
		}

		System.out.println(h1.size());

		System.out.println();
		System.out.println(h1.get("stew"));

		h1.remove("zzenn");

		System.out.println();

		for(HashEntry h: h1.values()){
			System.out.println(h);
		}


		h1.printHastableStatistic();
		 */

		/*
		HashMap ha = new HashMap(100);
		ha.setEmptyMarkerScheme('N');
		ha.setCollisionHandling('D');
		ha.setRehashFactor("1.3");
		ha.setRehashThreshold(0.7);

		for (int i=0; i < 900; i++) {
			ha.put("put", "put");
		}
		 */

		
		//*******************************************************
		//1ST TEST - DIFFERENT RESIZING FACTORS
		//
		//Negative marking
		//Quadratic
		//resize = 1.5 & 1.2
		//loadFactor = 0.75
		//*******************************************************

		
		//deliverableC('A','Q',"1.5",0.75, "hash_test_file1.txt" ); 
		
		//deliverableC('A','Q',"1.2",0.75, "hash_test_file1.txt" ); 

		//*******************************************************
		//2ND TEST (2nd file) - DIFFERENT LOAD FACTORS
		//						
		//Negative marking
		//Quadratic
		//resize = 1.3
		//loadFactor = 0.75 & 0.5
		//*******************************************************
		
		//deliverableC('A','Q',"1.3",0.75, "hash_test_file2.txt"); 
		
		//deliverableC('A','Q',"1.3",0.5, "hash_test_file2.txt"); 
		
		//*******************************************************
		//3RD TEST 	          - DIFFERENT MARKER SCHEME
		//						DIFFERENT LOAD FACTOR
		//						DIFFERENT HANDLING
		//Negative marking
		//Quadratic
		//resize = 1.3
		//loadFactor = 0.75 & 0.5
		//*******************************************************

		//deliverableC('A','D',"1.3",0.75, "hash_test_file1.txt" ); 

		//deliverableC('A','D',"1.3",0.5, "hash_test_file1.txt" ); 

		//*******************************************************
		//4TH TEST 			  - DIFFERENT MARKER SCHEME
		//						DIFFERENT RESIZE & LOAD FACTOR
		//Negative marking
		//Quadratic
		//resize = 1.3 & 1.1
		//loadFactor = 0.6 & 0.4
		//*******************************************************
		
		
		//deliverableC('N','D',"1.3",0.6, "hash_test_file2.txt" ); 

		//deliverableC('N','D',"1.1",0.4, "hash_test_file2.txt" ); 
		
		//*******************************************************
		//5TH TEST 			  - DIFFERENT HANDLING
		//						
		//Negative marking
		//Quadratic
		//resize = 1.3 & 1.1
		//loadFactor = 0.6 & 0.4
		//*******************************************************

		//deliverableC('N','Q',"1.3",0.6, "hash_test_file1.txt" ); 

		//deliverableC('N','Q',"1.1",0.4, "hash_test_file1.txt" );


		//*******************************************************
		//6TH TEST 			  - DIFFERENT MARKER
		//						
		//Negative marking
		//Quadratic
		//resize = 1.3
		//loadFactor = 0.4
		//*******************************************************		
		

		deliverableC('R','D',"1.3",0.4, "hash_test_file2.txt" );

		deliverableC('R','D',"1.3",0.4, "hash_test_file2.txt" );
		
		//*******************************************************
		//7TH TEST 			  - DIFFERENT HANDLING
		//						DIFFERENT LOAD FACTOR
		//Negative marking
		//Quadratic
		//resize = 1.3
		//loadFactor = 0.3 & 0.5
		//*******************************************************	

		deliverableC('R','Q',"1.3",0.3, "hash_test_file1.txt" );

		deliverableC('R','Q',"1.3",0.5, "hash_test_file1.txt" );

	}


	//METHOD TO SET UP THE HASH TABLE WITH ITS RESPECTIVE MARKER SCHEME, COLLISION HANDLING, REHASH FACTOR AND THRESHOLD (SIZING)
	
	/**
	 * 
	 * @param h HashMap
	 * @param e Marker scheme which will be used to remove entries in HashMap
	 * @param c Collision Handler for hashing function
	 * @param rf Rehash factor for the sizing (add or multiply)
	 * @param rt Rehash Threshold which tells us when to resize
	 */	
	private static void setHashTable(HashMap h, char e, char c, String rf, double rt){

		h.setEmptyMarkerScheme(e);
		h.setCollisionHandling(c);
		h.setRehashFactor(rf);
		h.setRehashThreshold(rt);	

	}


	/**
	 * 
	 * @param h HashMap
	 * @param filename filename to load
	 * @param bound first N elements in the file to load, -1 for all
	 */
	private static void readFile (HashMap h, String filename, int bound)  {

		boolean bounded = true; //check if the insert of entries to the hash map has a bound
		int ctr=0; //counter to see when to stop, if there is a bound

		if (bound == -1)
			bounded = false;

		Scanner inFile = null;	

		try {
			inFile = new Scanner(new FileInputStream(filename));	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (inFile.hasNextLine() ) {

			if (bounded &&  ctr >= bound  )		//if bound given, break upon hitting
				break;

			String line = inFile.nextLine();		
			h.put(line, line);
			//System.out.println(line);			//##### UNCOMMENT IT TO SEE Strings ###

			ctr++;
		}

		inFile.close();

	}

	//MAIN TESTING METHOD TO CHECK IF THE HASH TABLE IS FUNCTIONNING CORRECTLY
	/**
	 * 
	 * @param e Marker scheme which will be used to remove entries in HashMap
	 * @param c Collision Handler for hashing function
	 * @param rf Rehash factor for the sizing (add or multiply)
	 * @param rt Rehash Threshold which tells us when to resize
	 * @param filename name of the file from which strings are read
	 */
	public static void deliverableC(char e, char c, String rf, double rt, String filename)
	{
		Scanner kb = new Scanner(System.in);

		double startTime = 0;					// 3 long variables used for measuring run time of each case
		double stopTime = 0;
		double elapsedTime = 0;
		double  totalElapsed = 0; 				//value which will be displayed after the deliverable method has completed its execution


		HashMap h = new HashMap(100); 			//instantiate a hashmap with size of approximately 100

		//---------------------------------------------------------------------
		//FIRST 1000 STRINGS
		//---------------------------------------------------------------------
		startTime = System.currentTimeMillis();	//TIMING###### get starting time before processing

		setHashTable(h, e, c, rf, rt); 			//Set up the hash table with the corresponding options	
		readFile(h, filename, 1000);			//first n elements
		System.out.println("> First 1000 of file " + filename);
		h.printHastableStatistic();				//print the statistics for this current hashing
		h.resetHashtableStatistics();			//reset the statistics for the next case

		stopTime = System.currentTimeMillis();	//TIMING######## get finishing time after call
		elapsedTime = stopTime - startTime;		//TIMING ######## get time elapsed
		totalElapsed += elapsedTime;			//Keep track of the total

		System.out.println("Elapsed time for first 1000: " + elapsedTime + " ms");

		System.out.println("\nPress ENTER to continue to next test...");
		kb.nextLine();
		//--------------------------------------------------------------------

		//***************************************************************************
		//PLEASE NOTE THAT THE FOLLOWING FUNCTIONS ARE VERY SIMILAR TO THE ONE ABOVE.
		//THE ONLY DIFFERENCE WOULD BE THE NUMBER OF STRINGS BEING READ FROM THE FILE.
		//***************************************************************************

		//---------------------------------------------------------------------
		//FIRST 3000 STRINGS
		//---------------------------------------------------------------------
		setHashTable(h, e, c, rf, rt);
		startTime = System.currentTimeMillis();	//TIMING###### get starting time before processing

		readFile(h, filename, 3000);		//first n elements
		System.out.println("> First 3000 of file " + filename);
		h.printHastableStatistic();
		h.resetHashtableStatistics();

		stopTime = System.currentTimeMillis();	//TIMING######## get finishing time after call
		elapsedTime = stopTime - startTime;			//TIMING ######## get time elapsed
		totalElapsed += elapsedTime;

		System.out.println("Elapsed time for first 3000: " + elapsedTime + " ms");

		System.out.println("\nPress ENTER to continue to next test...");
		kb.nextLine();
		//--------------------------------------------------------------------


		//---------------------------------------------------------------------
		//FIRST 5000 STRINGS
		//---------------------------------------------------------------------
		setHashTable(h, e, c, rf, rt);
		startTime = System.currentTimeMillis();	//TIMING###### get starting time before processing

		readFile(h, filename, 5000);		//first n elements
		System.out.println("> First 5000 of file " + filename);
		h.printHastableStatistic();
		h.resetHashtableStatistics();

		stopTime = System.currentTimeMillis();	//TIMING######## get finishing time after call
		elapsedTime = stopTime - startTime;			//TIMING ######## get time elapsed
		totalElapsed += elapsedTime;

		System.out.println("Elapsed time for first 5000: " + elapsedTime + " ms");

		System.out.println("\nPress ENTER to continue to next test...");
		kb.nextLine();
		//--------------------------------------------------------------------


		//---------------------------------------------------------------------
		//FIRST 10000 STRINGS
		//---------------------------------------------------------------------
		setHashTable(h, e, c, rf, rt);
		startTime = System.currentTimeMillis();	//TIMING###### get starting time before processing

		readFile(h, filename, 10000);		//first n elements
		System.out.println("> First 10000 of file " + filename);
		h.printHastableStatistic();
		h.resetHashtableStatistics();

		stopTime = System.currentTimeMillis();	//TIMING######## get finishing time after call
		elapsedTime = stopTime - startTime;			//TIMING ######## get time elapsed
		totalElapsed += elapsedTime;

		System.out.println("Elapsed time for first 10000: " + elapsedTime + " ms");

		System.out.println("\nPress ENTER to continue to next test...");
		kb.nextLine();
		//--------------------------------------------------------------------

		//---------------------------------------------------------------------
		//FIRST 50000 STRINGS
		//---------------------------------------------------------------------
		setHashTable(h, e, c, rf, rt);
		startTime = System.currentTimeMillis();	//TIMING###### get starting time before processing

		readFile(h, filename, 50000);		//first n elements
		System.out.println("> First 50000 of file " + filename);
		h.printHastableStatistic();
		h.resetHashtableStatistics();

		stopTime = System.currentTimeMillis();	//TIMING######## get finishing time after call
		elapsedTime = stopTime - startTime;			//TIMING ######## get time elapsed
		totalElapsed += elapsedTime;

		System.out.println("Elapsed time for first 50000: " + elapsedTime + " ms");

		System.out.println("\nPress ENTER to continue to next test...");
		kb.nextLine();
		//--------------------------------------------------------------------

		//---------------------------------------------------------------------
		//FIRST 100000 STRINGS
		//---------------------------------------------------------------------
		setHashTable(h, e, c, rf, rt);
		startTime = System.currentTimeMillis();	//TIMING###### get starting time before processing

		readFile(h, filename, 100000);		//first n elements
		System.out.println("> First 100000 of file " + filename);
		h.printHastableStatistic();
		h.resetHashtableStatistics();

		stopTime = System.currentTimeMillis();	//TIMING######## get finishing time after call
		elapsedTime = stopTime - startTime;			//TIMING ######## get time elapsed
		totalElapsed += elapsedTime;

		System.out.println("Elapsed time for first 100000: " + elapsedTime + " ms");

		System.out.println("\nPress ENTER to continue to next test...");
		kb.nextLine();
		//--------------------------------------------------------------------

		//---------------------------------------------------------------------
		//FIRST 150000 STRINGS
		//---------------------------------------------------------------------
		setHashTable(h, e, c, rf, rt);
		startTime = System.currentTimeMillis();	//TIMING###### get starting time before processing

		readFile(h, filename, 150000);		//first n elements
		System.out.println("> First 150000 of file " + filename);
		h.printHastableStatistic();
		h.resetHashtableStatistics();

		stopTime = System.currentTimeMillis();	//TIMING######## get finishing time after call
		elapsedTime = stopTime - startTime;			//TIMING ######## get time elapsed
		totalElapsed += elapsedTime;

		System.out.println("Elapsed time for first 150000: " + elapsedTime + " ms");

		System.out.println("\nPress ENTER to continue to next test...");
		kb.nextLine();
		//--------------------------------------------------------------------


		//---------------------------------------------------------------------
		//FIRST 200000 STRINGS
		//---------------------------------------------------------------------
		setHashTable(h, e, c, rf, rt);
		startTime = System.currentTimeMillis();	//TIMING###### get starting time before processing

		readFile(h, filename, 200000);		//first n elements
		System.out.println("> First 200000 of file " + filename);
		h.printHastableStatistic();
		h.resetHashtableStatistics();

		stopTime = System.currentTimeMillis();	//TIMING######## get finishing time after call
		elapsedTime = stopTime - startTime;			//TIMING ######## get time elapsed
		totalElapsed += elapsedTime;

		System.out.println("Elapsed time for first 200000: " + elapsedTime + " ms");

		System.out.println("\nPress ENTER to continue to next test...");
		kb.nextLine();
		//--------------------------------------------------------------------


		//---------------------------------------------------------------------
		//DISPLAY ALL THE STRINGS
		//---------------------------------------------------------------------
		setHashTable(h, e, c, rf, rt);
		startTime = System.currentTimeMillis();	//TIMING###### get starting time before processing

		readFile(h, filename, -1);		//first n elements
		System.out.println("> ALL of file " + filename);
		h.printHastableStatistic();
		//We do not reset the statistics in this case because we are not done with our test case
		
		stopTime = System.currentTimeMillis();		//TIMING######## get finishing time after call
		elapsedTime = stopTime - startTime;			//TIMING ######## get time elapsed
		totalElapsed += elapsedTime;
		
		System.out.println("Elapsed time for ALL: " + elapsedTime + " ms");
		
		System.out.println("\nPress ENTER to continue to next test...");
		kb.nextLine();
		//--------------------------------------------------------------------
		
		//********************************************************************
		//REMOVING FIRST 10000 STRINGS
		//********************************************************************
		int counter = 0;
		
		startTime = System.currentTimeMillis();		//TIMING###### get starting time before processing
		//There is a function that returns an iterable collection of entries, we use it to go through all the entries
		for(HashEntry entry: h.values()){ 			//Remove only the first 10000 strings in the Hash Table
			if(counter > 10000){ 				
				break;
			}
			if(entry == null){						//If the entry has nothing, then go to the next entry
				continue;
			}
			h.remove(entry.getKey());				//Remove this entry
			counter++;
		}
		h.printHastableStatistic();					//Print the statistic - should have less elements that before
		
		stopTime = System.currentTimeMillis();		//TIMING######## get finishing time after call
		elapsedTime = stopTime - startTime;			//TIMING ######## get time elapsed
		totalElapsed += elapsedTime;
		
		System.out.println("Elapsed time to Remove 10000: " + elapsedTime + " ms");
		//----------------------------------------------------------------
		
		System.out.println("\nPress ENTER to continue to...");
		kb.nextLine();
		
		//********************************************************************
		//GET OPERATION FOR 240 000 STRINGS AFTER 10000 STRINGS REMOVED
		//********************************************************************
		startTime = System.currentTimeMillis();		//TIMING###### get starting time before processing

		for(HashEntry entry: h.values()){
			if(entry == null)
				System.out.println("null");
			else
				System.out.println(h.get(entry.getValue())); //Display the value 
		}
		
		stopTime = System.currentTimeMillis();		//TIMING######## get finishing time after call
		elapsedTime = stopTime - startTime;			//TIMING ######## get time elapsed
		totalElapsed += elapsedTime;
		
		System.out.println("Elapsed time for Get After remove 10000: " + elapsedTime + " ms");
		
		//------------------------------------------------------------------
		
		System.out.println("\nPress ENTER to continue to add the first 10000 strings from " + filename + "...");
		kb.nextLine();

		//********************************************************************
		//ADDING 10000 STRINGS
		//********************************************************************
		startTime = System.currentTimeMillis();		//TIMING###### get starting time before processing

		readFile(h, filename, 10000);	
		System.out.println("\nModified Hash Table of file " + filename);
		h.printHastableStatistic();		
		
		stopTime = System.currentTimeMillis();		//TIMING######## get finishing time after call
		elapsedTime = stopTime - startTime;			//TIMING ######## get time elapsed
		totalElapsed += elapsedTime;
		
		System.out.println("Elapsed time for Adding 10000: " + elapsedTime + " ms");
		//------------------------------------------------------
		
		//********************************************************************
		//Get operations for all ~240000 AFTER adding 10000
		//********************************************************************
		startTime = System.currentTimeMillis();	//TIMING###### get starting time before processing
		
		for(HashEntry entry: h.values()){
			if(entry == null)
				System.out.println("null");
			else
				System.out.println(h.get(entry.getValue()));
		}
		
		stopTime = System.currentTimeMillis();	//TIMING######## get finishing time after call
		elapsedTime = stopTime - startTime;			//TIMING ######## get time elapsed
		totalElapsed += elapsedTime;
		
		System.out.println("Elapsed time for Get After Adding 10000: " + elapsedTime + " ms");
		
		//********************************************************************
		//TOTAL EXECUTION TIME OF THE CURRENT HASHING OPTION
		//********************************************************************
		System.out.println("\n- SUMMARY -");
		System.out.println("Total time of all performed operations for this case");
		System.out.println("(Excluding user input)");
		System.out.println("Total elapsed time: " + totalElapsed + " ms");
		
		
		System.out.println("Finished current case\nPress ENTER to continue to next test...");
		kb.nextLine();
		
		//------------------------------------------------------------------

	}

}
