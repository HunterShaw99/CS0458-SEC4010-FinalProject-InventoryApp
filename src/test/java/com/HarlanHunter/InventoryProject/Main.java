package src.test.java.com.HarlanHunter.InventoryProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.ListIterator;
import java.io.FileNotFoundException;

public class Main {

	static File dataFile = new File("src/test/res/local/Data.dat");
	
	public static void main(String[] args) {
		/*		########	TESTING COLLECTIONS 	########
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
		*/
		Dictionary<String, Integer> dict = new HashDictionary<>();
		List<String> keyLst = new AList<>();
		List<Integer> valueLst = new AList<>();
		
		getData(dataFile, dict);
		dict.put("Coffee", 12);
		dict.put("WATER", 79);
		dict.put("LaVa", 64);
		saveData(dataFile, dict);
		
		
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
	 * @param File fileIn
	 * 
	 */
	public static void getData(File fileIn, Dictionary<String, Integer> dataDict) {
		
		 //Check if the Data.dat file exists, if so read from the file adding data into collections. 
		
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileIn))) {
			
			System.out.println("File is there and is ready to be read from!");
			
			
		} catch (FileNotFoundException ex) {
			System.err.println("No previous data found!, Creating a new inventory.");
			try  {
				fileIn.createNewFile();
			} catch(IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void saveData(File fileOut, Dictionary<String, Integer> dataDict) {
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileOut))) {
			Iterator<String> keyIt = dataDict.keys();
	        Iterator<Integer> valIt = dataDict.elements();
	        while(keyIt.hasNext()) {
	            if (!valIt.hasNext()) {
	                System.out.println("Problem with iterator, more keys than values");
	                break;
	            }
	            String k = keyIt.next();
	            int v = valIt.next();
	            output.writeObject(k);
	            output.writeObject(v);
	            if (v != dataDict.get(k)) {
	                System.out.printf("(%s, %d) Do not match, Error saving data!\n", k, v);
	                break;
	            }
	        }
		} catch(FileNotFoundException e) {
			System.err.println("Something went wrong!");
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}
