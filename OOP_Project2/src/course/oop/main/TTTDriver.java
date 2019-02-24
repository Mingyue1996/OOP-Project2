package course.oop.main;

import course.oop.controller.TTTControllerImpl;
import java.util.Scanner;


public class  TTTDriver {
	public static void main(String[] args) {
		int numPlayers;
		int timeout;
		String username;
		String marker;
		boolean isPlaying = true;
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
		username = inputs.next();

		if (username.equalsIgnoreCase("Quit")) {
			System.exit(0);
		}
		
		// get marker
		System.out.println("Enter your marker. If you enter Quit, you would exit the game.");			
		marker = inputs.next();

		if (username.equalsIgnoreCase("Quit")) {
			System.exit(0);
		}
	
		// create a tic tac toe game
		TTTControllerImpl ticTacToe = new TTTControllerImpl();
		// create a game board
		ticTacToe.startNewGame(numPlayers,timeout);
		System.out.print(ticTacToe.getGameDisplay());
		
		// create player(s)
		// two human players
		ticTacToe.createPlayer(username, marker, numPlayers);
		inputs.close();
	}
}