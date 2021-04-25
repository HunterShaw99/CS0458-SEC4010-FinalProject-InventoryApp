package src.test.java.com.HarlanHunter.InventoryProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileNotFoundException;


/**
 * Main area of the inventory project. This is where the core logic of
 * the program is at. This logic includes binary file I/O & checks for
 * input from the user with the Dictionary & Stack objects instantiated
 * here for holding data. 
 * 
 * @author Hunter Mark Shaw
 * @author Harlan Chandler
 *
 */
public class Main {

	private static File dataFile = new File("src/test/res/local/Data.dat");
	private static boolean fileFlag = false;
	private static boolean exitFlag = false;
	private static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
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
		 *  - PRINT
		 *  
		 * The ADD command will be how the user can add an element(product) to the collections and when an ADD is successful, display the updated list. 
		 * 
		 * The REMOVE command is used to remove a specific element(product) from the collections and if successful, the newly updated list is automatically displayed. 
		 * 
		 * PRINT is a command useful for printing out the current Inventory of products inside the dictionary.
		 */
		
		//Main loop of the program
		Dictionary<String, Integer> dict = new HashDictionary<>();
		Stack<String> stack = new AStack<>();
		getData(dataFile, dict);
		StringBuilder strBuilder = new StringBuilder();
		/*
		 * Check the fileFlag which is set to true or false from the getData() function
		 * call that happens above. 
		 * If fileFlag is true then there is previous data and we will keep this data.
		 * First we loop through the data already in the Data.dat file. Then enter
		 * the main input loop of the program and stay there till the quit command
		 * is entered. When Q is read set exitFlag to true and end program. 
		 */
		if (fileFlag) {
			//iterate over the dictionary
			System.out.println("Printing current data. . .");
			displayDict(dict);
		} 
			
		// prompt to enter a command & arguments.
		System.out.println("Enter a command in this structure (command name quantity ;)");
		System.out.println("Commands: ADD, REMOVE, PRINT, Q");
		System.out.println("To quit enter (Q ;)");
		/*
		 * Loop calling getInput() & performing query(s) from the stack. 
		 * Do this simple loop until the quit command Q is entered. When
		 * that command is entered check the exitFlag to true, write the data
		 * from the dictionary dict and end the program. 
		 */
		while (!exitFlag) {
			getInput(in, strBuilder, stack);
			strBuilder.setLength(0);
			while (!stack.empty()) {
				String command = stack.pop();
				switch (command) {
					case "ADD":
						String k = stack.pop();
						int v = Integer.parseInt(stack.pop());
						dict.put(k, v);
						System.out.println("Added " + v + " " + k + " to inventory");
						break;
					case "REMOVE":
						String k1 = stack.pop();
						int v1 = Integer.parseInt(stack.pop());
						dict.remove(k1);
						System.out.println("Removed " + v1 + " " + k1 + " to inventory");
						break;
					case "PRINT":
						displayDict(dict);
						break;
					case "UPDATE":
						String k2 = stack.pop();
						int v2 = Integer.parseInt(stack.pop());
						System.out.println("Updating " + k2 + " amount to: " + v2);
						dict.updateValue(k2, v2);
						break;
					case "Q":
						System.out.println("Program saving, then terminating...");
						saveData(dataFile, dict);
						exitFlag = true; 
				}
			}
		}
		
	}
	
	/**
	 * Called to display to current data inside the dictionary. 
	 * @param inventory A linked chain dictionary which contains
	 * 			the products(Key) and quantity(Value)
	 */
	public static void displayDict(Dictionary<String, Integer>inventory) {
		Iterator<String> keyIt = inventory.keys();
        Iterator<Integer> valIt = inventory.elements();
        while(keyIt.hasNext()) {
            if (!valIt.hasNext()) {
                System.out.println("Problem with iterator, more keys than values");
            }
            String k = keyIt.next();
            int v = valIt.next();
            if (v == inventory.get(k)) {
                System.out.printf("[ %s, %d ] in inventory\n", k, v);
            } else {
                System.out.println("Problem with iterators, key-value pair not matching.");
            }
                    
        }
        if(valIt.hasNext()) {
            System.out.println("Problem with inventory, item quantity mismatch");
        }
	}
	
	/**
	 * get the Data file, if no file is found this function
	 * will create the Data file. The data file is used to store the information 
	 * preserved in the data structures. 
	 * @param filePath A constant directory path of where the Data.dat file will
	 * 			be stored for the program. 
	 * @param inventory A linked chain dictionary which contains
	 * 			the products(Key) and quantity(Value)
	 */
	public static void getData(File filePath, Dictionary<String, Integer> inventory) {
		 //Check if the Data.dat file exists, if so read from the file adding data into collections. 
		try (FileInputStream inStream = new FileInputStream(filePath);
				ObjectInputStream input = new ObjectInputStream(inStream)) {
			fileFlag = true;
			System.out.println("File is there and is ready to be read from!");
			while(inStream.available() > 0) {
				String k = (String)input.readObject();
				Integer v = (Integer) input.readObject();
				inventory.put(k, v);
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException ex) {
			System.err.println("No previous data found!, Creating a new inventory.\n");
			try  {
				filePath.createNewFile();
				fileFlag = false;
			} catch(IOException e) {
				e.printStackTrace();
				System.err.println("Something went wrong! cannot create a new inventory. Program will terminate now.");
				System.exit(1);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Something went wrong! data cannot be accessed. Program will terminate now.");
			System.exit(1);
		}
		
	}
	
	/**
	 * used by the program to save all data put into the collection from the user. 
	 * The objects within the collection dataDict will be written to the Data.dat file.
	 * @param filePath A constant directory path of where the Data.dat file will
	 * 			be stored for the program.
	 * @param inventory A linked chain dictionary which contains
	 * 			the products(Key) and quantity(Value)
	 */
	public static void saveData(File filePath, Dictionary<String, Integer> inventory) {
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filePath))) {
			Iterator<String> keyIt = inventory.keys();
	        Iterator<Integer> valIt = inventory.elements();
	        while(keyIt.hasNext()) {
	            if (!valIt.hasNext()) {
	                System.out.println("Problem with iterator, more keys than values");
	                break;
	            }
	            String k = keyIt.next();
	            int v = valIt.next();
	            output.writeObject(k);
	            output.writeObject(v);
	            if (v != inventory.get(k)) {
	                System.out.printf("(%s, %d) Do not match, Error saving data!\n", k, v);
	                break;
	            }
	        }
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("Something went wrong! data cannot be saved. Program will terminate now.");
			System.exit(2);
		} catch(IOException e) {
			e.printStackTrace();
			System.err.println("Something went wrong! data cannot be saved. Program will terminate now.");
			System.exit(2);
		}
	}
	
	/**
	 * get input directly from the user, and order the input in the logical manner they would be
	 * executed naturally. Adding each command and argument onto the stack for use later. 
	 * @param input Scanner used to get input from the keyBoard
	 * @param strBuilder StringBuilder 
	 * @param commandQue Stack that should be empty, and is used to hold the
	 * 			commands and arguments from the user. Will be emptied in the
	 * 			main loop before getInput is ever called again. 
	 */
	public static void getInput(Scanner input, StringBuilder strBuilder, Stack<String> commandQue) {
		strBuilder.append(' ');
		while (!input.hasNext(";")) {
			strBuilder.append(input.next());
			strBuilder.append(' ');
		}
		input.nextLine();
		char currentQuery[] = strBuilder.toString().toCharArray();
		// Reverse array to mimic the order the commands will be executed on the stack.
		// Add elements from array to stack & leave function.
		int i = 0;
		int j = currentQuery.length - 1;
		char temp = ' ';
		while (i < j) {
			temp = currentQuery[i];
			currentQuery[i] = currentQuery[j];
			currentQuery[j] = temp;
			i++;
			j--;
		}
		char[] buffer = new char[currentQuery.length];
		int bufferIndex = 0;
		for (int index = 0; index < currentQuery.length; index++) {
			// If there is not a space we add the char to the buffer array.
			// We do this up until there is a space.
			if (currentQuery[index] != ' ') {
				buffer[bufferIndex++] = currentQuery[index];
				// here we check is the next element in the array a space.
				// If so we manipulate our current command or argument.
				if (currentQuery[index + 1] == ' ') {
					String userInput = "";
					int k = bufferIndex;
					while (k >= 0) {
						if (buffer[k] != ' ') {
							userInput += buffer[k--];
						}
					}
					int inputLen = 0;
					// Here since the String userInput has a space always infront, which we dont want
					// we will remove it. By adding all the char elements within the String excluding the first element. 
					char[] returnInput = new char[userInput.length()-1];
					while (inputLen < userInput.length()-1) {
						returnInput[inputLen++] = userInput.charAt(inputLen);
					}
					userInput = String.valueOf(returnInput);
					commandQue.push(userInput);
				}
				// Else there is a new command or argument to take in so we reset our main variables.
			} else {
				bufferIndex = 0;
				buffer = new char[currentQuery.length];
			}
		}
	}
	
}