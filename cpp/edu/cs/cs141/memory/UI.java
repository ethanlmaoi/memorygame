package cpp.edu.cs.cs141.memory;
import java.util.Scanner;

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

/** This class represents the User Interface. The UI
 * will have a grid and an instance of the Scanner class.
 * The class will also have values to hold the values for rows
 * and columns that the player will always be selecting.
 * 
 * @author Ethan Liao
 */
public class UI 
{
	/** 
	 * This creates an instance of the engine for the game, which will hold
	 * the number of moves.
	 */
	private MEngine game = null;
	
	/**
	 * This creates an instance of the GRID, so information can be displayed onto the console.
	 */
	private Grid grid = null;
	
	/**
	 * This creates an instance of the Scanner named keyboard.
	 * This allows the PLAYER to input information into the console.
	 */
	private Scanner keyboard = null;
	
	/**
	 * These variables hold values for rows and columns the PLAYER will be selecting.
	 */
	int row1, column1, row2, column2;
	
	/**
	 * @param game
	 * 
	 * This constructor creates the user interface and initializes the
	 * game, the grid, and an instance of the Scanner.
	 */
	public UI(MEngine game)
	{
		this.game = game;
		grid = new Grid();
		keyboard = new Scanner(System.in);
	}
	
	/**
	 * This method will start the game. This method is called in the
	 * main method of this package.
	 */
	public void playGame()
	{
		welcomeMsg();
		startGamePlay();
	}
	
	public void welcomeMsg()
	{
		System.out.print("Welcome to the MEMORY game!\n\n");
		delay();
		grid.hideGrid();
		grid.printGrid();
		delay();
		System.out.print("\nThis is your GRID!\n\n");
		delay();
		System.out.print("Each 'O' represents the back of a CARD. On the front of each CARD, there is a symbol.\n");
		delay();
		System.out.print("There are currently 8 symbols (2 of each symbol).\n");
		delay();
		System.out.print("You will be asked to select two CARDs. If your two CARDs match, then they will remain turned.\n");
		delay();
		System.out.print("Your score will be based off of how many turns you take to complete the game.\n\n");
		delay();
		System.out.print("Enter the ROW and COLUMN of the CARD that you want to choose.\n\n");
		delay();
	}
	
	/**
	 * This method will start the actual gameplay for the memory game.
	 */
	public void startGamePlay()
	{
		while (!grid.checkCleared())
		{
			grid.printGrid();
			
			askPlayerInput1();
			grid.revealCard(row1, column1);
			System.out.print("\n");
			grid.printGrid();
			
			askPlayerInput2();
			grid.revealCard(row2, column2);
			System.out.print("\n");
			grid.printGrid();
			System.out.print("\n");
			
			if ((grid.getCard(row1, column1)).getCardName() == (grid.getCard(row2, column2)).getCardName())
			{
				System.out.print("You got a match!\n");
				game.addMove();
				delay();
				delay();
				clearScreen();
				System.out.print("Try to find another match!\n\n");
				grid.solveCard(row1, column1);
				grid.solveCard(row2, column2);
			}
			else
			{
				System.out.print("That is not a match..\n\n");
				game.addMove();
				delay();
				delay();
				clearScreen();
				System.out.print("Try to find another match!\n\n");
				grid.concealCard(row1, column1);
				grid.concealCard(row2, column2);
			}
		}
		delay();
		clearScreen();
		System.out.print("\nCongratulations! You matched all of the cards! It only took you " + Integer.toString(game.getMoves()) + " moves!\n\n");
		delay();
		playAgain();
		
		
	}
	
	/**
	 * @return row
	 * 
	 * This asks the player to input a row number. Will not work
	 * if you input a non-integer, or a number less that 0 || greater than 3.
	 */
	public int askPlayerRowInput()
	{
		int row;
		System.out.print("\nROW: ");
		
		while (!keyboard.hasNextInt()) 
		{
			   System.out.print("A number, please!\n\n");
			   keyboard.nextLine();
		}
		
		row = keyboard.nextInt();
		if (row < 0 || row > 3)
		{
			System.out.print("That isn't an option!\n\n");
			askPlayerRowInput();
		}
		return row;
	}
	
	/**
	 * @return column
	 * 
	 * This asks the player to input a column number. Will not work
	 * if you input a non-integer, or a number less that 0 || greater than 3.
	 */
	public int askPlayerColumnInput()
	{
		System.out.print("COLUMN: ");
		
		while (!keyboard.hasNextInt()) 
		{
			   System.out.print("A number, please!\n\n");
			   keyboard.nextLine();
		}
		
		int column = keyboard.nextInt();
		if (column < 0 || column > 3)
		{
			System.out.print("That isn't an option!\n\n");
			askPlayerColumnInput();
		}
		return column;
	}
	
	/**
	 * This method asks for the first row and column input from the player.
	 * You are not allowed to input a card that has already been "solved".
	 */
	public void askPlayerInput1()
	{
		row1 = askPlayerRowInput();
		column1 = askPlayerColumnInput();
		
		if (grid.checkCardSolved(row1, column1))
		{
			System.out.print("\nYou already matched that card!\n");
			askPlayerInput1();
		}
	}
	
	/**
	 * This method asks for the second row and column input from the player.
	 * If the values match with the first row and column input, then the console
	 * will prompt the PLAYER to input again.
	 */
	public void askPlayerInput2()
	{
		row2 = askPlayerRowInput();
		column2 = askPlayerColumnInput();
		
		if (grid.checkCardSolved(row2, column2))
		{
			System.out.print("You already matched that card!\n\n");
			askPlayerInput2();
		}
		
		if (row2 == row1 && column2 == column1)
		{
			System.out.print("You cannot flip the same card!\n");
			askPlayerInput2();
		}
	}
	
	/**
	 * This method gives the PLAYER the option to play again.
	 */
	public void playAgain()
	{
		System.out.print("Play Again?\n\n1. Yes\n2. No\n\n");
		
		while (!keyboard.hasNextInt()) 
		{
			   System.out.print("A number, please!\n\n");
			   keyboard.nextLine();
		}
		
		int option = keyboard.nextInt();
		if (option == 1)
		{
			System.out.print("Starting New Game...\n\n");
			game.resetMoves();
			grid = new Grid();
			delay();
			playGame();
		}
		else if (option == 2)
		{
			System.out.print("\nThanks for playing!\n");
		}
		else
		{
			System.out.print("That isn't an option!\n");
			delay();
			playAgain();
		}
	}
	
	/**
	 * This method inputs a delay between two lines of code.
	 */
	public void delay()
	{
		try
		{
			Thread.sleep(1250);
		}
		catch (InterruptedException ex)
		{
			// do nothing
		}
	}
	
	/**
	 * This method simulates the console being cleared.
	 */
	public void clearScreen() 
	{  
		for (int i = 0; i < 50; i++)
		{
			System.out.println();
		}
	}
}