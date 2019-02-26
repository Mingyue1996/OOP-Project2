package course.oop.player;


public abstract class Player {
	String username;
	String marker;
	int playerID;
	int newMoveRow;
	int newMoveCol;
	public Player() {
		
	}
	
	// return new row
	public int getNewMoveRow() {
		return newMoveRow;
	}
	
	//  return new col
	public int getNewMoveCol() {
		return newMoveCol;
	}
	
	public abstract void makeMove(int row, int col);
}