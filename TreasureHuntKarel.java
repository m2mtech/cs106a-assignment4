/*
 * File: TreasureHuntKarel.java
 * ----------------------------
 * This program has Karel run a treasure hunt.
 */
import stanford.karel.*;

public class TreasureHuntKarel extends SuperKarel {
	
	public void run() {
		/* Continue treasure hunt until we face wall (by treasure). We
		 * are guaranteed not to encounter a wall until we reach treasure.
		 */
		while (frontIsClear()) {
			faceCorrectDirection();
			moveToNextPile();
		}
	}
	
	/* Turns Karel until he is facing East */
	private void faceEast() {
		while (notFacingEast()) {
			turnLeft();
		} 
	}
	
	/* To face the correct direction based on a clue represented by a 
	 * pile of beepers, we first face East and then make one left turn 
	 * for each beeper in the pile.
	 */
	private void faceCorrectDirection() {
		faceEast();
		while (beepersPresent()) {
			pickBeeper();
			turnLeft();
		} 
	}
	/* Move forward until you reach next clue or treasure (pile of beepers) */ 
	private void moveToNextPile() {
		while (noBeepersPresent()) {
			move();
		} 
	}
}