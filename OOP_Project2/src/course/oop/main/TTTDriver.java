package course.oop.main;

import course.oop.controller.TTTControllerImpl;
import java.util.Scanner;
import java.util.ArrayList;

public class  TTTDriver {
	public static void main(String[] args) {
		int numPlayers;
		int timeout;
		ArrayList<String> username = new ArrayList<>();
		ArrayList<String> marker = new ArrayList<>();
		boolean isPlaying = true;
		String boardDemo = "|";
		int row;
		int col;
		
		System.out.println("Welcome to play Tic Tac Toe.");
		System.out.println("Enter Quit to quit the game.");
		Scanner inputs = new Scanner(System.in);  // Reading from System.in
		
		// get number of players
		while (true) {
			System.out.println("Enter the number of players (1 or 2): ");
			if (inputs.hasNextInt()) {
				numPlayers = inputs.nextInt();
				if (numPlayers == 2 || numPlayers == 1) {
					break;
				}
				else {
					System.out.println("Please enter a valid number of players.");
				}
				
			}
			else {
				if (inputs.next().equalsIgnoreCase("Quit")) {
					System.exit(0);
				}
				else {
					System.out.println("Please enter a valid number of players.");
				}
			}
			
		} // end of while true (valid num of players)
		
		//get timeout
		while (true) {
			System.out.println("Enter the time in seconds for each turn. Enter a negative number for no timer.");
			if (inputs.hasNextInt()) {
				timeout = inputs.nextInt();
				break;
			}
			else {
				if (inputs.next().equalsIgnoreCase("Quit")) {
					System.exit(0);
				}
				else {
					System.out.println("Please enter a valid time.");
				}
			}
		} // end of while true time out
		
		// get user name
		System.out.println("Enter your user name. If you enter Quit, you would exit the game.");			
		username.add(inputs.next());

		if (username.get(0).equalsIgnoreCase("Quit")) {
			System.exit(0);
		}
		
		if (numPlayers == 2) {
			System.out.println("Enter player 2's  user name. If you enter Quit, you would exit the game.");	
			username.add(inputs.next());
			if (username.get(1).equalsIgnoreCase("Quit")) {
				System.exit(0);
			}
		}
			
		
		// get marker
		System.out.println("Enter player 1's  marker. If you enter Quit, you would exit the game.");			
		marker.add(inputs.next());

		if (marker.get(0).equalsIgnoreCase("Quit")) {
			System.exit(0);
		}
		
		if (numPlayers == 2) {
			System.out.println("Enter player 2's  marker. If you enter Quit, you would exit the game.");	
			marker.add(inputs.next());
			if (marker.get(1).equalsIgnoreCase("Quit")) {
				System.exit(0);
			}
		}
	
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
		int time = 0;
		while (time <= 5) {
			
			System.out.println("\nCurrent Board:\n");
			System.out.println(ticTacToe.getGameDisplay());
			System.out.println("Player " + ticTacToe.getPlayerID()+ ", " + "Enter row and column separated by a white space: ");
			row = inputs.nextInt();
			col = inputs.nextInt();
			ticTacToe.setSelection(row, col, ticTacToe.getPlayerID());
			time ++;
		}
		
		
		inputs.close();
	} // main method
}