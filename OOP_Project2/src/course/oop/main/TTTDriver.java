package course.oop.main;

import course.oop.controller.TTTControllerImpl;


public class  TTTDriver {
	public static void main(String[] args) {
		TTTControllerImpl ticTacToe = new TTTControllerImpl();
		ticTacToe.startNewGame(2,0);
	}
}