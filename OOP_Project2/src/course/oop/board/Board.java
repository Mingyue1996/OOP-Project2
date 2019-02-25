package course.oop.board;

import course.oop.board.square.Square;

public class  Board {
	private Square[][] basicTwoD = new Square[3][3];
	
	// constructor
	public Board() {
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
		String board_display = "|";
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j++) {
				board_display += String.format("%-5s", basicTwoD[i][j].display());	
				board_display += "|";
			}
			if (i+1 <3)
				board_display += "\n|";
			else
				board_display += "\n";
		}
		return board_display;
	}
	
	// return the basicGameBoard
	public boolean markBoard(int row, int col, String marker) {
		if((!basicTwoD[row][col].getIsMarked())) {
			basicTwoD[row][col].setMarker(marker);
			return true;
		}
		return false;
		
	}
	

}