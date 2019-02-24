package course.oop.controller;

public class TTTControllerImpl implements TTTControllerInterface {
	
	private int numberPlayer = 0;
	private int timeout = 0;
	/**
	 * Initialize or reset game board. Set each entry back to a default value.
	 * 
	 * @param numPlayers Must be valid. 2 = two human players, 1 = human plays against computer
	 * @param timeoutInSecs Allow for a user's turn to time out. Any
	 * 						int <=0 means no timeout.  Any int > 0 means to time out
	 * 						in the given number of seconds.
	 */
	public void startNewGame(int numPlayers, int timeoutInSecs) {
		if (numPlayers != 2 || numPlayers != 1) {
			System.out.println("The number of players is invalid.");
		}
		else {
			numberPlayer = numPlayers;
			timeout = timeoutInSecs;
			
		}
		
		
	}
	
	public void createPlayer(String username, String marker, int playerNum) {
		
	}
	
	public boolean setSelection(int row, int col, int currentPlayer) {
		return false;
	}
	
	public int determineWinner() {
		return 1;
	}
	
	public String getGameDisplay() {
		return "2";
	}
}