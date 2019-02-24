package course.oop.board;

import course.oop.board.square.Square;

public class BasicGameBoard extends Board {
	public Square[][] basicTwoD = new Square[3][3];
	
	// constructor
	public BasicGameBoard() {
		int id = 0;
		// initialize basicTwoD
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j++, id++) {
				basicTwoD[i][j] = new Square(id, "   ");
			}
		}
		 
	} // end of constructor
	
	// display
	public String display() {
		String board_display = "";
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j++) {
				board_display += String.format("%-5s", basicTwoD[i][j].display());	
				board_display += "|";
			}
			board_display += "\n";
		}
		return board_display;
	}
	
	
}