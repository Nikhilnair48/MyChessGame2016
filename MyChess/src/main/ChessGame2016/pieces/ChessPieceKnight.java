package main.ChessGame2016.pieces;

import java.awt.Point;
import java.util.ArrayList;

import javafx.scene.image.ImageView;
import main.ChessGame2016.data.Board;
import main.ChessGame2016.data.ChessGame2016Data;
import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.data.Constants;

public class ChessPieceKnight extends ChessPiece {

	private int directionToMove;
	
	public ChessPieceKnight() { }

	public ChessPieceKnight(int col, int value, ImageView imgV, String id) { super(col, value, imgV, id); }

	@Override
	public boolean isMoveValid(Point p1, Point p2, Integer player) {
		
		boolean result = true;
		int xDifference = Math.abs(p2.x - p1.x);
		int yDifference = Math.abs(p2.y - p1.y);
		
		// SET THE DIRECTION TO MOVE TO POSITIVE IF IT'S PLAYER 1'S TURN
		// WHEN IT'S PLAYER 2'S TURN, directionToMove NEEDS TO BE -1
		// SINCE THE PIECES ARE MOVING DOWN ON THE BOARD
		if (ChessGame2016Data.turn == 1)
			directionToMove = 1;
		else
			directionToMove = -1;
		
		if(xDifference > 2 || yDifference > 2)
			result = false;

		ArrayList<Point> possibleMoves = generatePossibleMoves(p1, p2);
		// IS THE KNIGHT TRYING TO ATTACK?
		/*if (result && possibleMoves.contains(p2) && !Board.gameBoard[p2.x][p2.y].isEmpty()) {
			System.out.println("About to attack - KNIGHT");
			
			// IF SO, MOVE THE PIECE THAT IS BEING ATTACKED FROM THE OPPOSTING PLAYERS' PIECES
			ChessGame2016.chessManager.getNextPlayer().getPlayerPieces().remove(p2);
			
			// REMOVE THE PIECE FROM THE BOARD
			Board.gameBoard[p2.x][p2.y].setEmpty(true);
			Board.gameBoard[p2.x][p2.y].setPiece(null);
			
		} else */if(result && !possibleMoves.contains(p2)	// MOVING TO AN EMPTY BOARD SQUARE
				&& Board.gameBoard[p2.x][p2.y].isEmpty()) {
			result = false;
		} /*else {	// NO OTHER CASES TO CHECK FOR MOVE TO BE VALID
			result = false;
		}*/

		return result;
	}

	@Override
	public ArrayList<Point> generatePossibleMoves(Point p1, Point p2) {
		ArrayList<Point> possibleMoves = new ArrayList<Point>();

		// MOVE 2 BACK 1 RIGHT
		if (p1.x + (2 * directionToMove * -1) < Constants.MAX_ROWS
				&& (p1.y + 1) < Constants.MAX_COLS)	//&& Board.gameBoard[p1.x + (2 * directionToMove)][p1.y + 1].isEmpty()
			possibleMoves.add(new Point(p1.x + (2 * directionToMove * -1), p1.y + 1));
		
		// MOVE 2 BACK 1 LEFT
		if (p1.x + (2 * directionToMove * -1) < Constants.MAX_ROWS
				&& (p1.y - 1) >= 0)	//&& Board.gameBoard[p1.x + (2 * directionToMove)][p1.y - 1].isEmpty()
			possibleMoves.add(new Point(p1.x + (2 * directionToMove * -1), p1.y - 1));

		// MOVE 1 BACK 2 RIGHT
		if (p1.x + (1 * directionToMove * -1) < Constants.MAX_ROWS
				&& (p1.y + 2) < Constants.MAX_COLS)	//&& Board.gameBoard[p1.x + (1 * directionToMove)][p1.y + 2].isEmpty()
			possibleMoves.add(new Point(p1.x + (1 * directionToMove * -1), p1.y + 2));

		// MOVE 1 BACK 2 LEFT
		if (p1.x + (1 * directionToMove * -1) < Constants.MAX_ROWS
				&& (p1.y - 2) >= 0)	//&& Board.gameBoard[p1.x + (1 * directionToMove)][p1.y - 2].isEmpty()
			possibleMoves.add(new Point(p1.x + (1 * directionToMove * -1), p1.y - 2));
		
		// MOVE 2 FORWARD 1 RIGHT
		if (p1.x + (2 * directionToMove) < Constants.MAX_ROWS
				&& (p1.y + 1) < Constants.MAX_COLS)	//&& Board.gameBoard[p1.x + (2 * directionToMove)][p1.y + 1].isEmpty()
			possibleMoves.add(new Point(p1.x + (2 * directionToMove), p1.y + 1));

		// MOVE 2 FORWARD 1 LEFT
		if (p1.x + (2 * directionToMove) < Constants.MAX_ROWS
				&& (p1.y - 1) >= 0)	//&& Board.gameBoard[p1.x + (2 * directionToMove)][p1.y - 1].isEmpty()
			possibleMoves.add(new Point(p1.x + (2 * directionToMove), p1.y - 1));

		// MOVE 1 FORWARD 2 RIGHT
		if (p1.x + (1 * directionToMove) < Constants.MAX_ROWS
				&& (p1.y + 2) < Constants.MAX_COLS)	//&& Board.gameBoard[p1.x + (1 * directionToMove)][p1.y + 2].isEmpty()
			possibleMoves.add(new Point(p1.x + (1 * directionToMove), p1.y + 2));

		// MOVE 1 FORWARD 2 LEFT
		if (p1.x + (1 * directionToMove) < Constants.MAX_ROWS
				&& (p1.y - 2) >= 0)	//&& Board.gameBoard[p1.x + (1 * directionToMove)][p1.y - 2].isEmpty()
			possibleMoves.add(new Point(p1.x + (1 * directionToMove), p1.y - 2));
		
		//System.out.println(possibleMoves);
		return possibleMoves;
	}

}
