/*
 * File: UniqueNames.java
 * ----------------------
 * This program asks the user for a list of names (one per line)
 * until the user enters a blank line. Then the program prints
 * out the list of names entered, where each name is listed only
 * once (i.e., uniquely) no matter how many times the user entered 
 * the name in the program.
 */
import acm.program.*;
import java.util.*;

public class UniqueNames extends ConsoleProgram {

	public void run() {
		ArrayList<String> list = new ArrayList<String>(); 
		while (true) {
			String name = readLine("Enter name: "); 
			if (name.equals("")) break;
			if (!list.contains(name)) {
				list.add(name);
			}
		}
		println("Unique name list contains:");
		printList(list);
	}

	/* Prints out contents of ArrayList, one element per line */ 
	private void printList(ArrayList list) {
		for(int i = 0; i < list.size(); i++) {
			println(list.get(i));
		} 
	}
	
}