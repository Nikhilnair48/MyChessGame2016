package data;

import java.awt.Point;

public class ChessPiecePawn extends ChessPiece {
	public ChessPiecePawn() { }
	
	/* INSTANTIATE OBJ WITH COLOR AND VALUE */
	public ChessPiecePawn(int col, int value) { super(col, value); }

	@Override
	//public boolean data.ChessPiecePawn.isMoveValid(java.awt.Point,java.awt.Point,java.lang.Integer)
	public boolean isMoveValid(Point p1, Point p2, Integer player) {
		//System.out.println(p1 + "\n" + p2 + "\n" + player); 
		return true;
	}
	
}