package src.test.java.com.HarlanHunter.InventoryProject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		///*		########	TESTING COLLECTIONS 	########
		List<String> keyLst = new AList<>();
		List<Integer> valueLst = new AList<>();
		Dictionary<String, Integer> dict = new HashDictionary<>();
		keyLst.add("Mike");
		keyLst.add("Joe");
		keyLst.add("Weirach");
		keyLst.remove(2);
		keyLst.add("Beyza");
		dict.put("Coffee", 12);
		dict.put("WATER", 79);
		dict.put("LaVa", 64);
		System.out.println(dict.size());
		System.out.println(keyLst.size());
		//*/
		
		
		/**
		 * Here we are using the List lst's iterator to go from Object to Object storing 
		 * each object inside the file Data.dat.
		 */
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/test/res/local/Data.dat"))) {
			ListIterator<String> it = keyLst.listIterator();

			while (it.hasNext()) {
				output.writeObject(it.next());
			}
			
		} catch (IOException E) {
			System.err.println("KJHFLKSDJ");
		}
		
		
		
		/*
		 * Main loop of program should check always before anything if there is a data file. This data file is where the products
		 * within the collections will be stored. If the program checks and there is no data file create a new one, if there is a data file 
		 * and it contains data load the collections with the data. Again, this will be done before any interactions with the actual user. 
		 * 
		 * Once we get or create the data file we will ask to input data if the data file was just created as there is no data. However, if the data
		 * file does exist then we will display a current list of the products. There will be commands to navigate the list of products. 
		 * 
		 * COMMANDS: How the user will interact with the data inside of the collections. 
		 *  - ADD
		 *  - REMOVE
		 *  - SEARCH
		 *  
		 * The ADD command will be how the user can add an element(product) to the collections and when an ADD is successful, display the updated list. 
		 * 
		 * The REMOVE command is used to remove a specific element(product) from the collections and if successful, the newly updated list is automatically displayed. 
		 * 
		 * The SEARCH command will used to search for a unique product in the list, if the search is successful display that single product to the user. Prompt them 
		 * to go back to the list and wait for a response. 
		 */
		
		
		
		
		
	}
	
	/**
	 * Function used to get the Data file, if no file is found this function
	 * will create the Data file. The data file is used to store the information 
	 * preserved in the data structures. 
	 */
	/*
	public static void getData() {
		try (ObjectInputStream input = new ObjectInputStream()
			) 
		{
			
		} catch () {
			
		}
	}
	*/

}
