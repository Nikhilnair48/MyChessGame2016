package main.ChessGame2016.pieces;

import java.awt.Point;
import java.util.ArrayList;

import javafx.scene.image.ImageView;
import main.ChessGame2016.data.Board;
import main.ChessGame2016.data.ChessGame2016Data;
import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.data.Constants;

public class ChessPiecePawn extends ChessPiece {
	private boolean isFirstMove;
	
	// WE NEED TO KNOW THE DIRECTION THE PAWN IS ABOUT TO MOVE
	// IN ORDER TO HANDLE PLAYER 1 (STARTING AT ROWS 1 & 2)
	// AND PLAYER TWO (STARTING AT ROWS 7 & 6) MOVING IN OPPOSITE
	// DIRECTIONS. SO IF PLAYER 1 IS MAKING THE MOVE, directionToMove
	// WILL BE POSITIVE; IF PLAYER 2 IS MAKING THE MOVE, directionToMove
	// WILL BE NEGATIVE TO ENSURE THAT THE PIECES DO NOT GO BACKWARDS ON 
	// THE BOARD.
	private int directionToMove;
	
	public ChessPiecePawn() { }
	
	/* INSTANTIATE OBJ WITH COLOR AND VALUE */
	public ChessPiecePawn(int col, int value, ImageView imgV, String id) { 
		super(col, value, imgV, id); 
		isFirstMove = true;
	}

	@Override
	public boolean isMoveValid(Point p1, Point p2, Integer player) {
		boolean result = true;
		int xDifference = Math.abs(p2.x - p1.x);
		int yDifference = Math.abs(p2.y - p1.y);
		
		// TRYING TO MOVE HORIZONTALLY? NOPE!
		if(xDifference == 0) {
			result = false;
		}
		
		// ATTEMPTING TO MOVE GREATER THAN 2 SQUARES - NOPE!
		if(xDifference > 2 || yDifference > 1) { 
			result = false;  
		}
		
		// ATTEMPTING TO MOVE TWO SQUARES AFTER THE FIRST MOVE
		if(xDifference == 2 && !isFirstMove) {
			result = false;  
		}

		// SET THE DIRECTION TO MOVE TO POSITIVE IF IT'S PLAYER 1'S TURN
		// WHEN IT'S PLAYER 2'S TURN, directionToMove NEEDS TO BE -1
		// SINCE THE PIECES ARE MOVING DOWN ON THE BOARD
		if(ChessGame2016Data.turn == 1) directionToMove = 1;
		else directionToMove = -1;
		
		ArrayList<Point> possibleMoves = generatePossibleMoves(p1, p2);
		// IS THE PAWN TRYING TO ATTACK? -- SHOULD WE BE BOTHERED ABOUT ATTACKS HERE? NOT CONSIDERING IT NOW.
		if(!possibleMoves.contains(p2)	//result &&
				&& !Board.gameBoard[p2.x][p2.y].isEmpty()) {
			result = false;
		} //else result = false;
		
		// IF THE PAWN IS MOVING FOR THE FIRST TIME, FILP THE FLAG 
		// TO PREVENT THE PAWN FROM MOVING 2 SQUARES IN THE FUTURE
		if(isFirstMove && result) isFirstMove = false;
		
		return result;
	}
	
	public ArrayList<Point> generatePossibleMoves(Point p1, Point p2) {
		ArrayList<Point> possibleMoves = new ArrayList<Point>();
				
		System.out.println("starting x " + p1.x + " starting y " + p1.y);
		// MOVE FORWARD BY ONE SQUARE
		if((p1.x + (1 * directionToMove)) < Constants.MAX_COLS 
				&& Board.gameBoard[p1.x + (1 * directionToMove)][p1.y].isEmpty())
			possibleMoves.add(new Point(p1.x + (1 * directionToMove), p1.y));
		
		// MOVE FORWARD BY TWO SQUARES
		if((p1.x + (2 * directionToMove)) < Constants.MAX_COLS 
				&& Board.gameBoard[p1.x + (2 * directionToMove)][p1.y].isEmpty())
			possibleMoves.add(new Point(p1.x + (2 * directionToMove), p1.y));
		
		// MOVE FORWARD BY ONE SQUARE AND LEFT BY ONE SQUARE
		if((p1.x + (1 * directionToMove)) < Constants.MAX_ROWS 
				&& p1.y-1 < Constants.MAX_COLS // MIGHT NOT BE NECESSARY
				&& p1.y-1 >= 0
				&& !Board.gameBoard[p1.x + (1 * directionToMove)][p1.y-1].isEmpty())
			possibleMoves.add(new Point(p1.x + (1 * directionToMove), p1.y-1));
		
		// MOVE FORWARD BY ONE SQUARE AND RIGHT BY ONE SQUARE
		if((p1.x + (1 * directionToMove)) < Constants.MAX_ROWS 
				&& p1.y+1 < Constants.MAX_COLS
				&& p1.y+1 > 0 // MIGHT NOT BE NECESSARY
				&& !Board.gameBoard[p1.x + (1 * directionToMove)][p1.y+1].isEmpty())
			possibleMoves.add(new Point(p1.x + (1 * directionToMove), p1.y+1));
		
		System.out.println("chesspiecepawn: possiblemoves - "+ possibleMoves);
		
		return possibleMoves;
	}
	
	public void setIsFirstMove(boolean b) { isFirstMove = b; }
	
	public boolean getIsFirstMove() { return isFirstMove; }
	
	public void loadImageForPawn() {
		
	}
}