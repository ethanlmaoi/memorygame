package cpp.edu.cs.cs141.memory;

/**
 * CS141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment #3
 *
 * This is assignment is a text-based MEMORY game. The grid is a two
 * dimensional array 4x4 containing 16 "CARDS" represented by O's.
 * The game ends when the PLAYER flipped all of the cards and the score
 * is the number of turns it takes the PLAYER to end the game.
 *
 * Ethan Liao
 */

/**
 * @param args
 * This will create an ENGINE then will start the the ENGINE
 * causing the console to pop up and starting a new game of MEMORY!
 */
public class Main 
{
	public static void main(String[] args) 
	{
		UI ui = new UI(new MEngine());
		ui.playGame();
	}
}