package main.ChessGame2016.data;

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
