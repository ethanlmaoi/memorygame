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
 * This class represents the SLASH CARD (/). This is a subclass
 * of the abstract class CARD.
 * 
 * @author Ethan Liao
 */
public class SlashCard extends Card
{
	public SlashCard()
	{
		super("/", "/", false);
	}
}