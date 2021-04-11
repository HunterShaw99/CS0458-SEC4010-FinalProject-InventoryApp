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

public class Main {

	static File dataFile = new File("src/test/res/local/Data.dat");
	static boolean fileFlag = false;
	static boolean exitFlag = false;
	
	public static void main(String[] args) {
		
		
		/*		########	TESTING COLLECTIONS 	########
		dict.put("Coffee", 12);
		dict.put("WATER", 79);
		dict.put("LaVa", 64);
		*/
		Dictionary<String, Integer> dict = new HashDictionary<>();
		Stack<String> stack = new AStack<>();
		
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
		 * PRINT is a command useful for printing out the current Inventory of products inside the dictionary.
		 */
		//TODO: add the commands for the user to easily navigate through the collections and interact with the data.
		//TODO: add the main loop for the user which will handle all command inputs, and check for proper command syntax throughout the program life.
		
		/**
		 * Main loop of the program - Implementation by @author Hunter shaw
		 * Will use two stacks one for the commands entered by the user the next for the arguments of each command. 
		 * getData(dataFile, dict);
		 * */
		Scanner in = new Scanner(System.in);
		StringBuilder strBuilder = new StringBuilder();
		if (fileFlag) {
			//iterate over the dictionary
			// prompt to enter a command then prompt for arguments.
		} else {
			while (!exitFlag) {
				getInput(in, strBuilder, stack);
				while (!stack.empty()) {
					//Perform queries from the stack & repeat until user exits program.
					String command = stack.pop();
					String k = stack.pop();
					int v = Integer.parseInt(stack.pop());
					
					System.out.println(v + " " + k + " " + command);
					exitFlag = true;
				}
			}
			
		}
		 
		
		/*
		
		String check = "y";
		String operation;
		String entery;
		int num = 0;
		
		while (check == "Y" || check == "y") {
			System.out.println("What operation (ADD, REMOVE, SEARCH) and entery would you like to preform?:");
			operation = in.next();
			
			while (operation != "ADD" && operation != "REMOVE" && operation != "SEARCH") {
				System.out.println("Please enter a valid operation (ADD, REMOVE, SEARCH):");
				operation = in.next();
			}
			
			while (operation == "ADD" || operation == "REMOVE" || operation == "SEARCH") {
			
				switch(operation) {
				case "ADD":
					entery = in.next();
					stack.push(entery);
					dict.put(stack.peek(), num);
					num++;
					break;
				case "REMOVE":
					entery = in.next();
					
					num--;
					break;
				case "SEARCH":
					entery = in.next();
					
					break;
				}
				
				operation = in.next();
			}
			
			
			saveData(dataFile, dict);
			System.out.print("Would you like to preform another search? (Y/N): ");
			check = in.next();
		}
		*/
		
		
	}
	
	/**
	 * Function used to get the Data file, if no file is found this function
	 * will create the Data file. The data file is used to store the information 
	 * preserved in the data structures. 
	 * @author Hunter Mark Shaw
	 * @param File fileIn
	 * @param Dictionary<String, Integer> dataDict
	 */
	public static void getData(File fileIn, Dictionary<String, Integer> dataDict) {
		 //Check if the Data.dat file exists, if so read from the file adding data into collections. 
		
		try (FileInputStream inStream = new FileInputStream(fileIn);
				ObjectInputStream input = new ObjectInputStream(inStream)) {
			fileFlag = true;
			System.out.println("File is there and is ready to be read from!");
			while(inStream.available() > 0) {
				String k = (String)input.readObject();
				Integer v = (Integer) input.readObject();
				dataDict.put(k, v);
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException ex) {
			System.err.println("No previous data found!, Creating a new inventory.");
			try  {
				fileIn.createNewFile();
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
	 * Function used by the program to save all data put into the collection from the user. 
	 * The objects within the collection dataDict will be written to the Data.dat file.
	 * @author Hunter Mark Shaw
	 * @param File fileOut
	 * @param Dictionary<String, Integer> dataDict
	 */
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
	 * Function to get input directly from the user, and order the input in the logical manner they would be
	 * executed naturally. Adding each command and argument onto the stack for use later. 
	 * @author Hunter Mark Shaw
	 * @param Scanner input
	 * @param StringBuilder b
	 * @param Stack commandQue
	 */
	public static void getInput(Scanner input, StringBuilder b, Stack<String> commandQue) {
		System.out.println("Enter a command: ADD, REMOVE, PRINT");
		b.append(' ');
		while (!input.hasNext(";")) {
			b.append(input.next());
			b.append(' ');
		}
		input.nextLine();
		char currentQuery[] = b.toString().toCharArray();
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
			if (currentQuery[index] != ' ') {
				buffer[bufferIndex++] = currentQuery[index];
				if (currentQuery[index + 1] == ' ') {
					String userInput = "";
					int k = bufferIndex;
					while (k >= 0) {
						if (buffer[k] != ' ') {
							userInput += buffer[k--];
						}
					}
					int inputLen = 0;
					char[] returnInput = new char[userInput.length()-1];
					while (inputLen < userInput.length()-1) {
						returnInput[inputLen++] = userInput.charAt(inputLen);
					}
					userInput = String.valueOf(returnInput);
					commandQue.push(userInput);
				}
			} else {
				bufferIndex = 0;
				buffer = new char[currentQuery.length];
			}
		}
	}
	
	

}
