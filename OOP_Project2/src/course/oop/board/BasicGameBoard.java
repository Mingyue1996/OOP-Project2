package course.oop.board;

import course.oop.board.square.Square;

public class BasicGameBoard {
	private boolean hasWon = true;
	private Square[][] basicTwoD = new Square[3][3];
	
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
	
	
	// reset the board
	public void reset() {
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j++) {
				basicTwoD[i][j].setMarker("   ", true);
			}
		}
	}
	
	// display
	public String display() {
		String boardDisplay = "";
		for (int num = 0; num <40; num++) {
			if (num % 13 == 0) {
				boardDisplay += String.format("+");
			}
			else {
				boardDisplay += String.format("=");
			}
			
		}
		boardDisplay += String.format("\n");	
		boardDisplay += "|";
			for (int i = 0; i < 3; i ++) {
				for (int j = 0; j < 3; j++) {
					
					boardDisplay += String.format("%-12s", basicTwoD[i][j].display());	
					boardDisplay += "|";
				}
				boardDisplay += String.format("\n");
				for (int num = 0; num <40; num++) {
					if (num % 13 == 0) {
						boardDisplay += String.format("+");
					}
					else {
						boardDisplay += String.format("=");
					}
					
				}
				//boardDisplay += String.format("\n");
				
				if (i+1 <3)
					boardDisplay += "\n|";
				else
					boardDisplay += "\n";
			}
			return boardDisplay;
	}
	
	// mark the board
	public boolean markBoard(int row, int col, String marker) {
		if((!basicTwoD[row][col].getIsMarked())) {
			basicTwoD[row][col].setMarker(marker, false);
			return true;
		}
		return false;
		
	}
	
	// check if there is at least an empty space in the board
	public boolean isEmptySpaceAvailable() {
		
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j++) {
				if (!basicTwoD[i][j].getIsMarked()) {
					return true;
				}
			}
		}
		return false;
	}
	
	// check if there is a winner
	public boolean hasWon(int row, int col, String marker) {
			hasWon = true;
			// check row
	        for(int i=0; i<3; i++){
	            if(!(basicTwoD[row][i].display()).equals(marker)){
	            	hasWon = false;
	            }
	        }
	        
	        if (hasWon) {
	        	return hasWon;
	        }
	        
	        hasWon = true;
        	// check column
	        for(int i=0; i<3; i++){
	            if(!(basicTwoD[i][col].display()).equals(marker)){
	            	hasWon = false;
	            }
	        }
		    
		    if (hasWon) return hasWon;
		    
		    hasWon = true;
            // check back diagonal
	        for(int i=0; i<3; i++){
	        	if(!(basicTwoD[i][i].display()).equals(marker)){		        		
	        		hasWon = false;
	        	}
	        }

	        if (hasWon) return hasWon;
	        
	        hasWon = true;
            // check forward diagonal
	        for(int i=0, j=2; i<3; i++, j--){
	        	if(!(basicTwoD[i][j].display()).equals(marker)){
	        		hasWon = false;	
	        	}
	        }
	    
		    
	        return hasWon;
	} // end of hasWon
	

}