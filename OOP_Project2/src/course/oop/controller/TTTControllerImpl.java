package course.oop.controller;
import course.oop.board.Board;
import course.oop.board.BasicGameBoard;
import course.oop.board.square.Square;
import course.oop.player.HumanPlayer;
import java.util.ArrayList;
public class TTTControllerImpl implements TTTControllerInterface {
	
	private int numberPlayer = 0;
	private int timeout = 0;
	private BasicGameBoard basicGameBoard;
	private int playerID = 1;
	private ArrayList<HumanPlayer> player = new ArrayList<>();
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
			basicGameBoard = new BasicGameBoard();	
		}
		
		
	}
	
	
	/**
	 * Create a player with specified user name, marker, 
	 * and player number (either 1 or 2) 
	 **/
	public void createPlayer(String username, String marker, int playerNum) {
		player.add(playerNum-1, new HumanPlayer(username, marker, playerNum));
	}
	
	/**
	 * Allow user to specify location for marker.  
	 * Return true if the location is valid and available.
	 * 
	 * @param row Must be valid. 0,1,2
	 * @param col Must be valid. 0,1,2
	 * @param currentPlayer Must be valid. 1 = player1; 2 = player2
	 * @return
	 */
	public boolean setSelection(int row, int col, int currentPlayer) {
		if ((row == 0 || row == 1 || row == 2) && 
			(col == 0 || col == 1 || col == 2) && 
			(currentPlayer == 1 || currentPlayer == 2) &&
			(updatePlayerMove(row, col, currentPlayer))) {
			return true;
		}
			
		else {
			System.out.println("Invalid Move.");
		}
		return false;
	}
	
	/**
	 * Determines if there is a winner and returns the following:
	 * 
	 * 0=no winner / game in progress / not all spaces have been selected; 
	 * 1=player1; 
	 * 2=player2; 
	 * 3=tie/no more available locations
	 * 
	 * @return
	 */
	
	public int determineWinner() {
		return 1;
	}
	
	public String getGameDisplay() {
		return basicGameBoard.display();
	}
	
	/*
	 * call makeMove() in player method and update moves
	 * */
	public boolean updatePlayerMove(int row, int col, int playerID) {
		player.get(playerID-1).makeMove(row, col);
		if (basicGameBoard.markBoard(row, col, player.get(playerID-1).getMarker())) {
			setCurrentPlayer(playerID);
			return true;
		}
		return false;
       
	}
	
	// change turn
	public void setCurrentPlayer(int playerID) {
		if (playerID == 1)
			this.playerID = 2;
		else
			this.playerID = 1;
			
	}
	
	// return playerID
	public int getPlayerID() {
		return playerID;
	}
}