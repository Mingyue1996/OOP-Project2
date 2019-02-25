package course.oop.player;


public class HumanPlayer extends Player {
	
	public HumanPlayer(String username, String marker, int playerID) {
		super.username = username;
		super.marker = marker;
		super.playerID = playerID;
	}
	
	public void makeMove(int row, int col) {
		super.newMoveRow = row;
		super.newMoveCol = col;
	}
	
	public String getMarker() {
		return marker;
	}

}