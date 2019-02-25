package course.oop.player;


public abstract class Player {
	String username;
	String marker;
	int playerID;
	int newMoveRow;
	int newMoveCol;
	public Player() {
		
	}
	
	public abstract void makeMove(int row, int col);
}