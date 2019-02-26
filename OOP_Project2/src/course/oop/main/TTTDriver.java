package course.oop.main;

import course.oop.controller.TTTControllerImpl;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class  TTTDriver {
	public static void main(String[] args) {
		int numPlayers;
		int timeout;
		ArrayList<String> username = new ArrayList<>();
		ArrayList<String> marker = new ArrayList<>();
		String boardDemo = "|";
		int row;
		int col;
		boolean isPlaying = true;
		
		System.out.println("Welcome to play Tic Tac Toe.");
		System.out.println("Enter Quit to quit the game.");
		Scanner inputs = new Scanner(System.in);  // Reading from System.in
		
		while (isPlaying) {
			// get number of players
			while (true) {
				String extraString;
				try {
					System.out.println("Enter the number of players (1 or 2): ");
					numPlayers = inputs.nextInt();
					extraString = inputs.nextLine();
					// valid input
					if ((numPlayers == 2 || numPlayers == 1) && extraString.trim().isEmpty()) {
						break;
					}
					// the input might be 2 a
					else {
						System.out.println("Invalid input.");
					}
			
					// string is the input (including quit)
				} catch (InputMismatchException e) {
					String input = inputs.nextLine();
					// quit the game
					if (input.equalsIgnoreCase("Quit")) {
						System.exit(0);
					}
					System.out.println("Invalid input.");
				}	// end of catch			
			} // end of while true (valid num of players)
			
			//get timeout
			while (true) {
				String extraString;
			try {
				System.out.println("Enter the time in seconds for each turn. Enter a negative number for no timer.");
				timeout = inputs.nextInt();
				extraString = inputs.nextLine();
				// valid input
				if (extraString.trim().isEmpty()) {
					break;
				}
				// the input might be 2 a
				else {
					System.out.println("Invalid input.");
				}
		
				// string is the input (including quit)
			} catch (InputMismatchException e) {
					String input = inputs.nextLine();
					// quit the game
					if (input.equalsIgnoreCase("Quit")) {
						System.exit(0);
					}
					System.out.println("Invalid input.");
				}				
			} // end of while true time out
			
			// get user name			
			String username1;
			while (true) {
				System.out.println("Enter your user name. If you enter Quit (case insensitive), you would exit the game.");
				username1 = inputs.nextLine();
				if (username1.trim().isEmpty()) {
					System.out.println("You cannot enter an empty user name.");
				}
				else if (username1.equalsIgnoreCase("Quit")) {
					System.exit(0);
				}
				else {
					username.add(username1);
					break;
				}
			} // end of while true (make sure user name is not empty)
			
		    
			// get player 2's username
			if (numPlayers == 2) {
				String username2;
				while (true) {
					System.out.println("Enter player 2's  user name. You cannot have the same  user name as Player 1. If you enter Quit, you would exit the game.");	
					username2 = inputs.nextLine();
					if (username2.equalsIgnoreCase("Quit")) {
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
			}
				
			
			// get player 1's marker
			String marker1;
			while (true) {
				System.out.println("Enter your marker. If you enter Quit (case insensitive), you would exit the game.");
				marker1 = inputs.nextLine();
				if (marker1.trim().isEmpty()) {
					System.out.println("You cannot enter an empty marker.");
				}
				else if (marker1.equalsIgnoreCase("Quit")) {
					System.exit(0);
				}
				else {
					marker.add(marker1);
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
			
			// create a tic tac toe game
			TTTControllerImpl ticTacToe = new TTTControllerImpl();
			// create a game board
			ticTacToe.startNewGame(numPlayers,timeout);
			
			
			// create player(s)
			ticTacToe.createPlayer(username.get(0), marker.get(0), 1);
			if (numPlayers == 2) {
				ticTacToe.createPlayer(username.get(1), marker.get(1), 2);
			}
			
			// start game
			System.out.println("Player 1 will start first.\nEnter the corresponding number as shown below to mark the board.");
			int id = 0;
			for (int i = 0; i < 3; i ++) {
				for (int j = 0; j < 3; j++, id++) {
					boardDemo += String.format("%-5s", "  " + id + "  " );	
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
				System.out.println("\nCurrent Board:\n");
				System.out.println(ticTacToe.getGameDisplay());
				
				System.out.println("Player " + ticTacToe.getPlayerID()+ ", " + "Enter row and column separated by a white space: ");
				while (!inputs.hasNextInt()) {
					
					String option = inputs.nextLine();
					if (option.equalsIgnoreCase("Quit")) {
						System.exit(0);
					}
					else {
						System.out.println("Please enter a valid input.");
						System.out.println("Player " + ticTacToe.getPlayerID()+ ", " + "Enter row and column separated by a white space: ");
					}				
				} // end of while (check valid move)
				
				row = inputs.nextInt();
				col = inputs.nextInt();
				ticTacToe.setSelection(row, col, ticTacToe.getPlayerID());
			} // end of while (game over)
			
			System.out.println("\nCurrent Board:\n");
			System.out.println(ticTacToe.getGameDisplay());
			if (ticTacToe.getGameState() == 3) {
				System.out.println("No winner. There is a tie.");
			}
			else {
				System.out.println("Player " + ticTacToe.getPlayerID() + " won the game.");	
			}
					
		
	    // ask user(s) to play agin or quit
		while (true) {
			
				try {
					System.out.println("Enter 1 for Play Again. Enter Quit to exit the game.");
					String extraString;
					int option;
					option = inputs.nextInt();
					extraString = inputs.nextLine();
					// valid input
					if ((option == 1) && extraString.trim().isEmpty()) {
						break;
					}
					// the input might be 1 a
					else {
						System.out.println("Invalid input.");
					}
			
					// string is the input (including quit)
				} catch (InputMismatchException e) {
					String input = inputs.nextLine();
					// quit the game
					if (input.equalsIgnoreCase("Quit")) {
						System.exit(0);
					}
					System.out.println("Invalid input.");
				}	// end of catch			
			
			
		} // end of while true (valid num of players)
		
	} // while true (the whole game)
		
		inputs.close();
	} // main method
}