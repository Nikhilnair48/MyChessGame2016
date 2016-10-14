package main.ChessGame2016.pieces;

import java.awt.Point;
import java.util.ArrayList;

import main.ChessGame2016.data.Board;
import main.ChessGame2016.data.BoardSquare;
import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.myChessGame2016.ChessGame2016;
import main.ChessGame2016.myChessGame2016.GameManager;

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
	public ChessPiecePawn(int col, int value) { 
		super(col, value);
		isFirstMove = true;
	}

	@Override
	public boolean isMoveValid(Point p1, Point p2, Integer player) {
		boolean result = true;
		int xDifference = Math.abs(p2.x - p1.x);
		int yDifference = Math.abs(p2.y - p1.y);
		
		// ATTEMPTING TO MOVE GREATER THAN 2 SQUARES - NOPE!
		if(xDifference > 2 || yDifference > 2) { 
			result = false;  
		}
		
		// ATTEMPTING TO MOVE TWO SQUARES AFTER THE FIRST MOVE
		if(xDifference == 2 && !isFirstMove) {
			result = false;  
		}

		// IF THE PAWN IS MOVING FOR THE FIRST TIME, FILP THE FLAG 
		// TO PREVENT THE PAWN FROM MOVING 2 SQUARES IN THE FUTURE
		if(isFirstMove && result) isFirstMove = false;
		
		// SET THE DIRECTION TO MOVE TO POSITIVE IF IT'S PLAYER 1'S TURN
		// WHEN IT'S PLAYER 2'S TURN, directionToMove NEEDS TO BE -1
		// SINCE THE PIECES ARE MOVING DOWN ON THE BOARD
		if(GameManager.turn == 1) directionToMove = 1;
		else directionToMove = -1;
		
		// IS THE PAWN TRYING TO ATTACK?
		if(result && generatePossibleMoves(p1, p2).contains(p2)
				&& !Board.gameBoard[p2.x][p2.y].isEmpty()) {
			System.out.println("About to attack");
			
			// IF SO, MOVE THE PIECE THAT IS BEING ATTACKED FROM THE OPPOSTING PLAYERS' PIECES
			BoardSquare toBeRemoved = Board.gameBoard[p2.x][p2.y];
			ChessGame2016.chessManager.getNextPlayer().addToRemovedPieces(toBeRemoved.getPiece());
			ChessGame2016.chessManager.getNextPlayer().getPlayerPieces().remove(p2);
			
			// REMOVE THE PIECE FROM THE BOARD
			Board.gameBoard[p2.x][p2.y].setEmpty(true);
			Board.gameBoard[p2.x][p2.y].setPiece(null);	
		} else if(result && generatePossibleMoves(p1, p2).contains(p2)
				&& Board.gameBoard[p2.x][p2.y].isEmpty()) {
			result = true;
		} else result = false;
		
		return result;
	}
	
	public ArrayList<Point> generatePossibleMoves(Point p1, Point p2) {
		ArrayList<Point> possibleMoves = new ArrayList<Point>();
				
		// MOVE FORWARD BY ONE SQUARE
		if((p1.x + (1 * directionToMove)) < Board.MAX_ROWS 
				&& Board.gameBoard[p1.x + (1 * directionToMove)][p1.y].isEmpty())
			possibleMoves.add(new Point(p1.x + (1 * directionToMove), p1.y));
		
		// MOVE FORWARD BY TWO SQUARES
		if((p1.x + (2 * directionToMove)) < Board.MAX_COLS 
				&& Board.gameBoard[p1.x + (2 * directionToMove)][p1.y].isEmpty())
			possibleMoves.add(new Point(p1.x + (2 * directionToMove), p1.y));
		
		// MOVE FORWARD BY ONE SQUARE AND LEFT BY ONE SQUARE
		if((p1.x + (1 * directionToMove)) < Board.MAX_ROWS 
				&& p1.y-1 < Board.MAX_COLS // MIGHT NOT BE NECESSARY
				&& p1.y-1 >= 0
				&& !Board.gameBoard[p1.x + (1 * directionToMove)][p1.y-1].isEmpty())
			possibleMoves.add(new Point(p1.x + (1 * directionToMove), p1.y-1));
		
		// MOVE FORWARD BY ONE SQUARE AND RIGHT BY ONE SQUARE
		if((p1.x + (1 * directionToMove)) < Board.MAX_ROWS 
				&& p1.y+1 < Board.MAX_COLS
				&& p1.y+1 > 0 // MIGHT NOT BE NECESSARY
				&& !Board.gameBoard[p1.x + (1 * directionToMove)][p1.y+1].isEmpty())
			possibleMoves.add(new Point(p1.x + (1 * directionToMove), p1.y+1));
		
		System.out.println(possibleMoves);
		
		return possibleMoves;
	}
	
	public void setIsFirstMove(boolean b) { isFirstMove = b; }
	
	public boolean getIsFirstMove() { return isFirstMove; }
	
}

/*
int yDiff = p2.y - p1.y;
		int xDiff = p2.x - p1.x;
		// MOVE 1 UP
		
		// MOVE 1 SQUARE FORWARD
		if(xDiff == 1) {
			System.out.println("diff is 1"); 
			possibleMoves.add(new Point(p2.x, p2.y));
		} else if (xDiff == 1 && yDiff == 1 && board.gameBoard[p2.x])
		
		// MOVE 2 SQUARES FORWARD
		// BUG IF DIFFERENCE IS TWO AND A PIECE IS BETWEEN THE FIRST AND SECOND POSITION -WE JUMP!
		if(xDiff == 2 && board.gameBoard[p2.x][p2.y].getPiece() != null) { 
			System.out.println("difference is 2");
			for(int i = p1.x+1; i < p1.x+3; i++) {
				if(board.isSquareEmpty(new Point(i, p1.y))) {
					System.out.println("should be ok");
				}
			}
		}
		// MOVE 1 UP, 1 TO THE LEFT (ATTACK)
		
		// MOVE 1 UP, 1 TO THE RIGHT (ATTACK)
*/