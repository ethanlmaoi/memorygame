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
 * This class represents a CARD. This class is abstract meaning we cannot create an
 * instance of this object. This gives all the CARDs variables and methods that a CARD
 * has and can do. This class is here so there is no repetition and copy and pasting.
 * 
 * @author Ethan Liao
 */
public abstract class Card
{
	/**
	 * This STRING holds the original symbol of each CARD. This is so when the symbol
	 * changes to an 'O' when flipped down, the CARD still knows what its original
	 * symbol was.
	 */
	private String originalSymbol;
	
	/**
	 * This STRING is the current symbol that represents the CARD on the GRID.
	 * Can either be the original symbol when flipped up, or an 'O' which mean
	 * the card is flipped down.
	 */
	private String symbol;
	
	/**
	 * This BOOLEAN is false when the card is flipped down ('O')
	 * True when the card is flipped up (original symbol)
	 */
	private boolean isFlipped;
	
	/**
	 * This BOOLEAN is true when two cards are matched on a GRID.
	 */
	private boolean isSolved;
	
	
	/**
	 * @param OGSYMBOL
	 * @param SYMBOL
	 * @param flipped
	 * 
	 * This constructor creates a card where the user can input the original symbol
	 * which is the same as the symbol. All cards start flipped and are NOT
	 * solved.
	 */
	public Card(String OGSYMBOL, String SYMBOL, boolean flipped)
	{
		originalSymbol = OGSYMBOL;
		symbol = SYMBOL;
		isFlipped = flipped;
		isSolved = false;
	}
	
	/**
	 * This method flips up a card. It changes the BOOLEAN isFlipped to true and
	 * it changes the symbol back to its original symbol. CARD is face up on the grid.
	 */
	public void flipUp()
	{
		isFlipped = true;
		symbol = originalSymbol;
	}
	
	/**
	 * This method flips down a card. It changes the BOOLEAN isFlipped to false and
	 * it changes the symbol to an 'O', which means the CARD is face down shown
	 * on the grid.
	 */
	public void flipDown()
	{
		isFlipped = false;
		symbol = "O";
	}
	
	/**
	 * @return symbol
	 * 
	 * This method returns the CURRENT card name.
	 */
	public String getCardName()
	{
		return symbol;
	}
	
	/**
	 * @return isFlipped
	 * 
	 * This method returns the BOOLEAN isFlipped. True if the card is face up.
	 * False if the card is face down.
	 */
	public boolean checkFlipped()
	{
		return isFlipped;
	}
	
	/**
	 * @param row
	 * @param column
	 * 
	 * This solves a card in the specified row and column. The PLAYER can no longer flip this card.
	 */
	public void cardSolved(int row, int column)
	{
		isSolved = true;
	}
	
	/**
	 * @return
	 * 
	 * This checks if the card is solved. If the card is solved, then
	 * the method will return true.
	 * 
	 */
	public boolean checkSolved()
	{
		return isSolved;
	}
}