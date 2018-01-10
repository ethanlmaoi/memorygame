package cpp.edu.cs.cs141.memory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
 * This class represents a GRID. A GRID can print out the board and will
 * have a 4x4 2D array. The Grid will have 16 CARDS. 8 symbols; 2 cards for each symbol.
 *
 * @author Ethan Liao
 */
public class Grid
{
	/**
	 * This variable represents a 2D array that can hold CARDs.
	 */
	Card[][] grid;
	
	/**
	 * 
	 */
	public Grid()
	{
		grid = new Card[4][4];
		
		Card[] cards = {new AsteriskCard(), new AsteriskCard(), new ExclamationCard(), 
						new ExclamationCard(), new MinusCard(), new MinusCard(), new PercentCard(), 
						new PercentCard(), new PlusCard(), new PlusCard(), new PoundCard(), 
						new PoundCard(), new QuestionCard(), new QuestionCard(),
						new SlashCard(), new SlashCard()};
		
		ArrayList<Card> cardList = new ArrayList<Card>(Arrays.asList(cards));
		Collections.shuffle(cardList);
		
		for (int row = 0; row < 4; row++)
		{
			for (int column = 0; column < 4; column++)
			{
				Card card = cardList.get(0);
				grid[row][column] = card;
				cardList.remove(0);
			}
		}
	}
	
	/**
	 * This method will print out the GRID. It will display 4 lines on the console,
	 * each line having 4 symbols that are either 'O' (face down) or the CARD's
	 * original symbol (face up)
	 */
	public void printGrid()
	{
		System.out.print("G 0 1 2 3\n");
		for (int row = 0; row < 4; row++)
		{
			System.out.print(Integer.toString(row) + " ");
			for (int column = 0; column < 4; column++)
			{
				System.out.print(grid[row][column].getCardName() + " ");
				if (column == 3)
				{
					System.out.print("\n");
				}
			}
		}
	}
	
	/**
	 * This method will flip all cards upside down. On the grid, it
	 * would print out 16 'O's.
	 */
	public void hideGrid()
	{
		for (int row = 0; row < 4; row++)
		{
			for (int column = 0; column < 4; column++)
			{
				grid[row][column].flipDown();

			}
		}
	}
	
	/**
	 * @param row
	 * @param column
	 * @return Card
	 * 
	 * This method returns the CARD in the row and column specified in the parameters.
	 */
	public Card getCard(int row, int column)
	{
		return grid[row][column];
	}
	
	/**
	 * @param row
	 * @param column
	 * 
	 * This method flips up the CARD in the row and column specified in the parameters.
	 */
	public void revealCard(int row, int column)
	{
		grid[row][column].flipUp();
	}
	
	/**
	 * @param row
	 * @param column
	 * 
	 * This method flips down the CARD in the row and column specified in the parameters.
	 */
	public void concealCard(int row, int column)
	{
		grid[row][column].flipDown();
	}
	
	/**
	 * @param row
	 * @param column
	 * 
	 * This method solves the CARD in the row and column specified in the parameters.
	 */
	public void solveCard(int row, int column)
	{
		grid[row][column].cardSolved(row, column);
	}
	
	/**
	 * @param row
	 * @param column
	 * @return boolean
	 * 
	 * This method check if the CARD is solved in the specified row and column.
	 */
	public boolean checkCardSolved(int row, int column)
	{
		return grid[row][column].checkSolved();
	}
	
	/**
	 * @return boolean
	 * 
	 * This method checks if the GRID is cleared. This will return true
	 * if every single CARD in the 4x4 GRID isCleared.
	 */
	public boolean checkCleared()
	{
		boolean isCleared = true;
		for (int row = 0; row < 4; row++)
		{
			for (int column = 0; column < 4; column++)
			{
				if (!grid[row][column].checkFlipped())
				{
					isCleared = false;
				}

			}
		}
		return isCleared;
	}
}
