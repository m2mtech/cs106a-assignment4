/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;


public class Hangman extends ConsoleProgram {
	
	private String wordToGuess;
	private String currentWord;

    public void run() {
		println("Welcome to Hangman!");
		
		HangmanLexicon lexicon = new HangmanLexicon();
		RandomGenerator rgen = RandomGenerator.getInstance();
		
		wordToGuess = lexicon.getWord(rgen.nextInt(lexicon.getWordCount()));
		currentWord = dashifyWord();
		int numberOfGuesesLeft = 8;

		boolean gameWon = false;
		while (!gameWon && (numberOfGuesesLeft > 0)) {
			println("The word now looks like this: " + currentWord);
			println("You have " + numberOfGuesesLeft + " guesses left.");
			String guessInput = readLine("Your guess: ");
			char guess = guessInput.charAt(0);
			if ((guessInput.length() > 1) || !Character.isLetter(guess)) {
				println("Please enter single letters only!");
				continue;			
			}
			if (guessCorrect(guess)) {
				println("That guess is correct.");
				if (wordToGuess.equals(currentWord)) {
					gameWon = true;
				}
			} else  {
				println("There are no " + guess + "'s in the word.");
				numberOfGuesesLeft--;
			}						
		}
		
		if (gameWon) {
			println("You guessed the word: " + wordToGuess);
			println("You win.");			
		} else {
			println("You are completely hung.");
			println("The word was: " + wordToGuess);
			println("You lose.");
		}
			
	}
    
    private boolean guessCorrect(char guess) {
    	guess = Character.toUpperCase(guess);
    	boolean guessCorrect = false;
    	String newWord = "";
    	for (int i = 0; i < wordToGuess.length(); i++) {
    		if (wordToGuess.charAt(i) == guess) {
    			newWord += guess;
    			guessCorrect = true;
    		} else {
    			newWord += currentWord.charAt(i);
    		}
    	}
    	if (guessCorrect) {
    		currentWord = new String(newWord);
    	}
    	return guessCorrect;
    }
    
    private String dashifyWord() {
    	String result = "";
    	for(int i = 0 ; i < wordToGuess.length(); i++) {
    	      result += "-";
    	   }
    	   return result;
    }

}
