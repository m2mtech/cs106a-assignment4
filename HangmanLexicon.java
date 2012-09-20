/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.util.*;
import java.io.*;

public class HangmanLexicon {

	private static final String DATA_FILE = "HangmanLexicon.txt";

	private ArrayList<String> wordList;
	
	// This is the HangmanLexicon constructor
	public HangmanLexicon() {
		try {
			BufferedReader rd = new BufferedReader(
					new FileReader(DATA_FILE)
			);
			
			wordList = new ArrayList<String>();
			
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				if (!wordList.contains(line)) {
					wordList.add(line);
				}
			}
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}

	/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return wordList.size();
	}

	/** Returns the word at the specified index. */
	public String getWord(int index) {
		return wordList.get(index);
	};
}
