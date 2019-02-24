package course.oop.main;

import course.oop.controller.TTTControllerImpl;
import course.oop.controller.TTTControllerInterface;

public class  TTTDriver {
	public static void main(String[] args) {
		TTTControllerImpl ticTacToe = new TTTControllerImpl();
		ticTacToe.startNewGame(3,0);
	}
}