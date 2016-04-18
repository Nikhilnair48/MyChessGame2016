package data;

import java.awt.Point;
import java.util.ArrayList;

import myChessGame2016.ChessGame2016;
import myChessGame2016.GameManager;

public class ChessPiecePawn extends ChessPiece {
	boolean isFirstMove;
	
	public ChessPiecePawn() { }
	
	/* INSTANTIATE OBJ WITH COLOR AND VALUE */
	public ChessPiecePawn(int col, int value) { 
		super(col, value);
		isFirstMove = true;
	}

	@Override
	public boolean isMoveValid(Point p1, Point p2, Integer player) {
		boolean result = true;
		int xDifference = p2.x - p1.x;
		int yDifference = p2.y - p1.y;
		
		// ATTEMPTING TO MOVE GREATER THAN 2 SQUARES
		if(xDifference > 2 || yDifference > 2) { result = false; System.out.println("greater than 2"); }
		
		// ATTEMPTING TO MOVE TWO SQUARES AFTER THE FIRST MOVE
		if(xDifference == 2 && !isFirstMove) { result = false; System.out.println("not first move and attempting to move 2 squares"); }
		
		
		/*// IS THE PAWN BEING MOVED FOR THE FIRST TIME
		if (((ChessPiecePawn)ChessGame2016.chessManager.getCurrentPlayer().getPlayerPieces().get(p1).getPiece()).getIsFirstMove()) {
			//System.out.println("First move for pawn at " + ((ChessPiecePawn)ChessGame2016.chessManager.getCurrentPlayer().getPlayerPieces().get(p1).getPiece()).getIsFirstMove());
			isFirstMove = false;
		} else {
			result = false;
			System.out.println("well well well...");
		}*/
		
		// IF THE PAWN IS MOVING FOR THE FIRST TIME, FILP THE FLAG 
		// TO PREVENT THE PAWN FROM MOVING 2 SQUARES IN THE FUTURE
		if(isFirstMove) isFirstMove = false;
		
		return result;
	}
	
	public ArrayList<Point> generatePossibleMoves(Point p1, Point p2) {
		ArrayList<Point> possibleMoves = new ArrayList<Point>();
		
		Board board = ChessGame2016.chessManager.getBoard();
		
		int yDiff = p2.y - p1.y;
		int xDiff = p2.x - p1.x;
		// MOVE 1 UP
		if(yDiff == 1) { 
			possibleMoves.add(new Point(p1.x+1, p1.y));
			
			System.out.println("added one"); }
		
		// MOVE 2 UP
		// BUG IF DIFFERENCE IS TWO AND A PIECE IS BETWEEN THE FIRST AND SECOND POSITION -WE JUMP!
		if(xDiff == 2) { 
			System.out.println("difference is 2");
			for(int i = p1.x+1; i < p1.x+3; i++) {
				if(board.isSquareEmpty(new Point(i, p1.y))) {
					System.out.println("should be ok");
				}
			}
		}
		// MOVE 1 UP, 1 TO THE LEFT (ATTACK)
		
		// MOVE 1 UP, 1 TO THE RIGHT (ATTACK)
		
		return possibleMoves;
	}
	
	public void setIsFirstMove(boolean b) { isFirstMove = b; }
	
	public boolean getIsFirstMove() { return isFirstMove; }
	
}