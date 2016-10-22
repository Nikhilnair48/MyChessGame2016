package main.ChessGame2016.pieces;

import java.awt.Point;
import java.util.ArrayList;

import javafx.scene.image.ImageView;
import main.ChessGame2016.data.Board;
import main.ChessGame2016.data.ChessPiece;

public class ChessPieceKing extends ChessPiece {
	
	public ChessPieceKing(int col, int value, ImageView imgV, String id) { super(col, value, imgV, id); }

	@Override
	public boolean isMoveValid(Point p1, Point p2, Integer player) {
		
		generatePossibleMoves(p1, p2);
		
		return true;
	}

	@Override
	public ArrayList<Point> generatePossibleMoves(Point p1, Point p2) {
		ArrayList<Point> possibleMoves = new ArrayList<>();
		
		// MOVE LEFT/RIGHT BY 1  
		if(p1.x+1 < Board.MAX_ROWS)
			possibleMoves.add(new Point(p1.x+1, p1.y));
		
		if((p1.x-1) > 0)
			possibleMoves.add(new Point(p1.x-1, p1.y));
		
		// MOVE FORWARD/BACKWARD BY 1
		if((p1.y+1) < Board.MAX_COLS) 
			possibleMoves.add(new Point(p1.x, p1.y+1));
		
		if((p1.y-1) > 0)
			possibleMoves.add(new Point(p1.x, p1.y-1));
		
		// MOVE 1 UP 1 RIGHT
		if(p1.x+1 < Board.MAX_ROWS && (p1.y+1) < Board.MAX_COLS)
			possibleMoves.add(new Point(p1.x+1, p1.y+1));
		
		// MOVE 1 BACK 1 RIGHT
		if((p1.x-1) >= 0 && (p1.y+1) < Board.MAX_COLS)
			possibleMoves.add(new Point(p1.x-1, p1.y+1));
		
		// MOVE 1 LEFT 1 UP
		if((p1.y-1) >= 0 && (p1.x+1) <= Board.MAX_ROWS)
			possibleMoves.add(new Point(p1.x+1, p1.y-1));
		
		// MOVE 1 LEFT 1 BACK
		if((p1.y-1) >= 0 && (p1.x-1) >= 0)
			possibleMoves.add(new Point(p1.x-1, p1.y-1));
		
		System.out.println(possibleMoves);
		System.out.println(possibleMoves.size());
		return possibleMoves;
	}

}