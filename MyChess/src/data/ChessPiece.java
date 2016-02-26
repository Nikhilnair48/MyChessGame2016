package data;



public class ChessPiece {
	// IS THE PIECE ON THE BOARD, OR HAS IT BEEN REMOVED?
	// 0 MEANS PIECE IS OFF THE BOARD, NON-ZERO MEANS IT'S ON THE BAORD
	private int onBoard;
	private int color;	// 1 FOR WHITE, 2 FOR BLACK
	private int value;
	
	public ChessPiece() { }
	
	public ChessPiece(int c, int val) {
		onBoard = 0;
		color = c;
		value = val;
	}
	
	public int isOnBoard() { return onBoard; }
	
	public void setOnBoard(int onBoard) { this.onBoard = onBoard; }
	
	public int getColor() { return color; }
	
	public void setColor(int color) { this.color = color; }
	
	public int getValue() { return value; }
	
	public void setValue(int value) { this.value = value; }
	
	public String toString() {
		String str = "onBoard status: " + onBoard 
				+ " Color (1-White;2-Black): " + color
				+ " Value: " + value;
		return str;
	}
}