package main.ChessGame2016.data;

/*
 TO CREATE A CUSTOM MOVE OR TO NOT MAKE A CUSTOM MOVE OBJECT IS THE QUESTION...
 LET'S GO WITH JAVA.LANG.POINT
 */

public class Move {
	
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private boolean isAttack;
	
	public Move() { }
	
	public Move(int initX, int initY, int eX, int eY) {
		startX = initX;
		startY = initY;
		endX = eX;
		endY = eY;
		isAttack = false;
	}
	
	

}
