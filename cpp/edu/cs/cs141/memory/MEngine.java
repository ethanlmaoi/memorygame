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
 * This class represents the ENGINE of the game and is
 * the entity that represents an instance of the game. 
 * The ENGINE Keeps track of the player's number of moves
 * (the win condition of the game).
 * 
 * @author Ethan Liao
 */
public class MEngine 
{
	/**
	 * This variable represents the number of moves the PLAYER is
	 * currently on.
	 */
	private int moves;
	
	/**
	 * This constructor creates an ENGINE with the number
	 * of moves starting at 0.
	 */
	public MEngine()
	{
		moves = 0;
	}
	
	/**
	 * @return moves
	 * 
	 * This method will return the number of moves the game is on.
	 */
	public int getMoves()
	{
		return moves;
	}
	
	/**
	 * This method will increment the number of moves by 1.
	 */
	public void addMove()
	{
		moves++;
	}
	
	/**
	 * This method will reset the moves to 0.
	 */
	public void resetMoves()
	{
		moves = 0;
	}
}