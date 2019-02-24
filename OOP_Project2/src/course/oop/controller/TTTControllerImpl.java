package course.oop.controller;
import course.oop.board.Board;
import course.oop.board.BasicGameBoard;
public class TTTControllerImpl implements TTTControllerInterface {
	
	private int numberPlayer = 0;
	private int timeout = 0;
	private BasicGameBoard gameBoard;
	/**
	 * Initialize or reset game board. Set each entry back to a default value.
	 * 
	 * @param numPlayers Must be valid. 2 = two human players, 1 = human plays against computer
	 * @param timeoutInSecs Allow for a user's turn to time out. Any
	 * 						int <=0 means no timeout.  Any int > 0 means to time out
	 * 						in the given number of seconds.
	 */
	public void startNewGame(int numPlayers, int timeoutInSecs) {
		if (numPlayers != 2 && numPlayers != 1) {
			System.out.println("The number of players is invalid.");
		}
		else {
			numberPlayer = numPlayers;
			timeout = timeoutInSecs;
			gameBoard = new BasicGameBoard();	
		}
		
		
	}
	
	
	/**
	 * Create a player with specified user name, marker, 
	 * and player number (either 1 or 2) 
	 **/
	public void createPlayer(String username, String marker, int playerNum) {
		
	}
	
	public boolean setSelection(int row, int col, int currentPlayer) {
		return false;
	}
	
	public int determineWinner() {
		return 1;
	}
	
	public String getGameDisplay() {
		return gameBoard.display();
	}
}