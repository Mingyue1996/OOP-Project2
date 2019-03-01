package course.oop.main;

import course.oop.controller.TTTControllerImpl;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random; 

public class  TTTDriver {
	private static int inputToCheck;
	private static int inputToCheck2;
	private static String user_name;
	private static int staticRow;
	private static int staticCol;

	public static void main(String[] args) {
		int numPlayers = 0;
		int timeout = 0;;
		
		ArrayList<String> username = new ArrayList<>();
		ArrayList<String> marker = new ArrayList<>();
		String boardDemo;
		int row = -1;
		int col = -1;
		int humanPlayerID = 1;
		boolean isPlaying = true;
		boolean isValid = false;
		boolean isLastMoveValid = true;
		
		// create a tic tac toe game
		TTTControllerImpl ticTacToe = new TTTControllerImpl();
		// create instance of Random class 
        Random rand = new Random(); 
		System.out.println("Welcome to play Tic Tac Toe.");
		System.out.println("Enter Quit (case insensitive) to quit the game at any time.");
		Scanner inputs = new Scanner(System.in);  // Reading from System.in
		
		// start the game
		while (isPlaying) {
			username.clear();
			marker.clear();
			boardDemo = "";
			
			// get number of players
			isValid = false;
			while (!isValid) {
				System.out.println("Enter the number of players (1 or 2): ");
				isValid = checkInputsNumeric(inputs,1);
				if (isValid && inputToCheck != 1 && inputToCheck != 2) {	
					isValid = false;
					System.out.println("Invalid Input.");
				}
				else {
					numPlayers = inputToCheck;					
				}
			} // end of while true (valid number of players)
			
			//get timeout
			isValid = false;
			while (!isValid) {	
				System.out.println("Enter the time in seconds for each turn. Enter a negative number or zero for no timer.");
				isValid = checkInputsNumeric(inputs, 1);
				if (isValid) {
					timeout = inputToCheck;
				}
			} // end of while true time out
			
			
			if (numPlayers == 1) {
				// ask who wants to go first
				isValid = false;
				while (!isValid) {
					System.out.println("Do you want to play first? Enter 1 to play first; if you enter 2, computer will play first.");
					isValid = checkInputsNumeric(inputs,1);
					if (isValid && inputToCheck != 1 && inputToCheck != 2) {	
						isValid = false;
						System.out.println("Invalid Input.");
					}
					else {
						humanPlayerID = inputToCheck;					
					}
				} // end of while true (valid number of players)
				
			} // end of (ask who goes first)
			
			
			// get user name			
			String username1;
			while (true) {
				if (numPlayers == 2) {
					System.out.println("Player 1 will start first. \nEnter player 1's user name. If you enter Quit (case insensitive), you would exit the game.");
				}
				else {
					System.out.println("Enter your user name. If you enter Quit (case insensitive), you would exit the game.");
				}
				
				username1 = inputs.nextLine();
				if (username1.trim().isEmpty()) {
					System.out.println("You cannot enter an empty user name.");
				}
				else if (username1.equalsIgnoreCase("Quit")) {
					System.out.println("You quitted the game. Bye~");
					System.exit(0);
				}
				else {
					if (numPlayers == 2 || humanPlayerID == 1) {
						username.add(username1);
					}
					// one human player and computer goes first
					else {
						username.add("Computer");
						username.add(username1);
					}
					
					break;
				}
			} // end of while true (make sure user name is not empty)
			
		    
			// get player 2's user name
			if (numPlayers == 2) {
				String username2;
				while (true) {
					System.out.println("Enter player 2's user name. You cannot have the same user name as Player 1. If you enter Quit (case insensitive), you would exit the game.");	
					username2 = inputs.nextLine();
					if (username2.equalsIgnoreCase("Quit")) {
						System.out.println("You quitted the game. Bye~");
						System.exit(0);
					}
					if (username2.equals(username.get(0))) {
						System.out.println("Invalid. Player 2's  user name is the same as Player 1.");
					}
					else if (username2.trim().isEmpty()) {
						System.out.println("You cannot enter an empty user name.");
					}
					else {
						username.add(username2);
						break;
					}				
					
				} // end of while true (check same marker)
			} // end of get player 2's user name
			
			// one human player --- store AI's user name
			else if (numPlayers == 1 && humanPlayerID == 1) {
				username.add("Computer");
			}
				
			
			// get player 1's marker
			String marker1;
			while (true) {
				if (numPlayers == 2) {
					System.out.println("Enter player 1's marker. If you enter Quit (case insensitive), you would exit the game.");
				} else {
					System.out.println("Enter your marker. If you enter Quit (case insensitive), you would exit the game.");
				}
				marker1 = inputs.nextLine();
				if (marker1.trim().isEmpty()) {
					System.out.println("You cannot enter an empty marker.");
				}
				else if (marker1.equalsIgnoreCase("Quit")) {
					System.out.println("You quitted the game. Bye~");
					System.exit(0);
				}
				// valid marker, store marker
				else {
					if (numPlayers == 2 || humanPlayerID == 1) {
						marker.add(marker1);
					}
					// one human player and computer goes first
					else {
						// store marker as O if human player's marker is not O
						if (!marker1.equals("O")) {
							marker.add("O");
						}
						else {
							marker.add("X");
						}
						marker.add(marker1);
					}
					
					break;
				}
			} // end of while true (make sure user name is not empty)
				
			// get player 2's marker
			if (numPlayers == 2) {
				String marker2;
				while (true ) {
					System.out.println("Enter player 2's  marker. You cannot have the same marker as Player 1. If you enter Quit, you would exit the game.");	
					marker2 = inputs.nextLine();
					if (marker2.equalsIgnoreCase("Quit")) {
						System.out.println("You quitted the game. Bye~");
						System.exit(0);
					}
					if (marker2.equals(marker.get(0))) {
						System.out.println("Invalid. Player 2's marker is the same as Player 1.");
					}
					else if (marker2.trim().isEmpty()) {
						System.out.println("You cannot enter an empty marker.");
					}
					else {
						marker.add(marker2);
						break;
					}				
					
				} // end of while true (check same marker)
				
			} // end of if playerID = 2
			
			// store computer's marker
			else if (numPlayers == 1 && humanPlayerID == 1) {
				// store marker as O if human player's marker is not O
				if (!marker1.equals("O")) {
					marker.add("O");
				}
				else {
					marker.add("X");
				}
			}
			
			// create a game board
			ticTacToe.startNewGame(numPlayers,timeout);
		
			// create players
			// two human players
			if (numPlayers == 2) {
				ticTacToe.setIsHumanPlayer(true);
				ticTacToe.createPlayer(username.get(0), marker.get(0), 1);
				ticTacToe.createPlayer(username.get(1), marker.get(1), 2);				
			}
			// one human player
			else {
				// human plays first
				if (humanPlayerID == 1) {
					ticTacToe.setIsHumanPlayer(true);
					ticTacToe.createPlayer(username.get(0), marker.get(0), 1);
					ticTacToe.setIsHumanPlayer(false);
					ticTacToe.createPlayer(username.get(1), marker.get(1), 2);
				}
				// computer plays first
				else {
					ticTacToe.setIsHumanPlayer(false);
					ticTacToe.createPlayer(username.get(0), marker.get(0), 1);
					ticTacToe.setIsHumanPlayer(true);
					ticTacToe.createPlayer(username.get(1), marker.get(1), 2);
				}
				
			}
			
			// start game
			System.out.println(username.get(0) + " will start first.\nEnter the corresponding row and column number as shown below to mark the board.");
			boardDemo = "|";
			for (int i = 0; i < 3; i ++) {
				for (int j = 0; j < 3; j++) {
					boardDemo += String.format("%-5s", "  " + "row "+ i + " " + "col " + j + "  " );	
					boardDemo += "|";
				}
				if (i+1 <3)
					boardDemo += "\n|";
				else
					boardDemo += "\n";
			}
			System.out.println(boardDemo);
			
			// user enters location of the marker
			while (ticTacToe.getGameState() == 0) {	
				if (isLastMoveValid) {
					System.out.println("\nCurrent Board:\n");
					System.out.println(ticTacToe.getGameDisplay());	
				}
								
				// ask human player inputs
				if (numPlayers == 2 || (numPlayers == 1 && humanPlayerID == ticTacToe.getPlayerID())){
					// check if the input (row & column) is a number
					user_name = username.get(ticTacToe.getPlayerID()-1);
					getRowCol(inputs);
					row = staticRow;
					col = staticCol;
					// mark the board if a move is valid
					if (ticTacToe.setSelection(row, col, ticTacToe.getPlayerID())) {
						isLastMoveValid = true;
					}
					else {
						isLastMoveValid = false;
					}
				}
				// computer player generates a valid random move
				else {
					user_name = username.get(ticTacToe.getPlayerID()-1);
					// generate row & column, call updatePlayerMove
					int computerRow = rand.nextInt(3); 
					int computerCol = rand.nextInt(3);
					while (!ticTacToe.updatePlayerMove(computerRow, computerCol, ticTacToe.getPlayerID())) {
						computerRow = rand.nextInt(3); 
						computerCol = rand.nextInt(3);
					}
					isLastMoveValid = true;
					System.out.println("\nComputer generated a move with row " + computerRow + " and column " + computerCol + ".");
				}			
				
			} // end of while (game over)
			
			System.out.println("\nCurrent Board:\n");
			System.out.println(ticTacToe.getGameDisplay());
			// print out results
			if (ticTacToe.getGameState() == 3) {
				System.out.println("No winner. There is a tie.");
			}
			else {
				System.out.println(user_name + " won the game.");	
			}
					
		isValid = false;
	    // ask user(s) to play again or quit
		while (!isValid) {			
			System.out.println("Enter 1 to Play Again. Enter Quit to exit the game.");	
			isValid = checkInputsNumeric(inputs, 1);
			if (isValid && inputToCheck != 1) {
				isValid = false;
				System.out.println("Invalid Input.");
			}
			else if (isValid && inputToCheck == 1) {
				ticTacToe.setIsReplay(true);
			}
		} // end of while true (valid options)
		
	} // while true (the whole game)
		
		inputs.close();
	} // end of main method
	
	// check the validity of inputs
	public static boolean checkInputsNumeric(Scanner userInputs, int numInputs) {
		try {
			String extraString;
			inputToCheck = userInputs.nextInt();
			if (numInputs == 2) {
				inputToCheck2 = userInputs.nextInt();
			}
			extraString = userInputs.nextLine();
			// valid input
			if (extraString.trim().isEmpty()) {
				return true;
			}
			// the input might be 1 a
			else {
				System.out.println("Invalid input.");
				return false;
		}

		// string is the input (including quit)
		} catch (InputMismatchException e) {
			String input = userInputs.nextLine();
			// quit the game
			if (input.equalsIgnoreCase("Quit")) {
				System.out.println("You quitted the game. Bye~");
				System.exit(0);
			}
			System.out.println("Invalid input.");
			return false;
		} // end of catch			
	} // end of checkValidity
	
	// ask player's row and column
	public static void getRowCol (Scanner inputs) {
		boolean isNumeric = false;
		while (!isNumeric) {	
			System.out.println(user_name + ", " + "enter the row and column (separated by white space; enter the row first) of your next move.");
			isNumeric = checkInputsNumeric(inputs, 2);
			if (isNumeric) {
				staticRow = inputToCheck;
				staticCol = inputToCheck2;
			}
		} // end of while (check if move is a number)
		
	}
	
} // end of TTTDriver class