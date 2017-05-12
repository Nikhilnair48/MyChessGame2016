package main.ChessGame2016.data;

import java.awt.Point;

/*
	BOARDSQUARE.JAVA
	THE CLASS REPRESENTS A SQUARE ON THE BOARD, WHICH MAY OR
	MAY NOT CONTAIN A CHESSPIECE. 
	
	**WE ARE NOT SAVING THE COLOR OF THE SQUARE AS OF NOW, AS THAT MAY BE CALCULATED 
	GIVEN THE POSITION OF THE SQUARE. 
 */

public class BoardSquare {
	
	private Point position;
	private boolean isEmpty;	// true = empty; false = not empty
	private ChessPiece piece;
	// DO WE REALLY NEED THE COLOR OF THE SQUARE? IDK YET private int color;		// 1 FOR WHITE SQUARE, 2 FOR BLACK SQUARE
	
	public BoardSquare() {
		piece = null;
		isEmpty = true;
		position = new Point();
	}
	
	public BoardSquare(Point p, boolean status, ChessPiece cPiece) {	//, int c
		position = p;
		isEmpty = status;
		piece = cPiece;
		//color = c;
	}

	public Point getPosition() { return position; }

	public void setPosition(Point position) { this.position = position;	}

	public boolean isEmpty() { return isEmpty; }

	public void setEmpty(boolean isEmpty) { this.isEmpty = isEmpty; }

	public ChessPiece getPiece() { return piece; }

	public void setPiece(ChessPiece piece) { this.piece = piece; }

	@Override
	public String toString() {
		return "BoardSquare [position=" + position + ", isEmpty=" + isEmpty
				+ ", piece=" + piece + "]";
	}
	
	/*public int getColor() { return color; }
	
	public void setColor(int nColor) { color = nColor; }*/

}
