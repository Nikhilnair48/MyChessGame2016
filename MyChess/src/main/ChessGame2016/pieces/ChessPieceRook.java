package main.ChessGame2016.pieces;

import java.awt.Point;
import java.util.ArrayList;

import javafx.scene.image.ImageView;
import main.ChessGame2016.data.Board;
import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.data.Constants;

public class ChessPieceRook extends ChessPiece {
	
	public ChessPieceRook() { }
	
	public ChessPieceRook(int col, int value, ImageView imgV, String id) { super(col, value, imgV, id); }
	
	public boolean isMoveValid(Point p1, Point p2, Integer player) {
		// ALL POSSIBLE MOVES FOR THE BISHOP FROM POINT p1
		// INCLUDES MOVES THAT 
		ArrayList<Point> possibleMoves = generatePossibleMoves(p1, p2);
		
		return possibleMoves.contains(p2);
	}

	@Override
	// BUG - INCLUDES THE CURRENT PLAYER'S PIECES IN THE POSSIBLE ATTACH PIECE
	public ArrayList<Point> generatePossibleMoves(Point p1, Point p2) {
		ArrayList<Point> possibleMoves = new ArrayList<>();
		
		// POSSIBLE MOVES FORWARD
		boolean result = true;
		int i = 1;
		boolean pieceToAttackDetected = false;
		while(result) {
			if((p1.x+i) < Constants.MAX_ROWS
					&& !pieceToAttackDetected) {
				possibleMoves.add(new Point(p1.x+i, p1.y));
				
				if(!Board.gameBoard[p1.x+i][p1.y].isEmpty() 
						&& Board.gameBoard[p1.x+i][p1.y].getPiece().getColor() != this.getColor())
					pieceToAttackDetected = true;
				
				i++;
			} else {
				result = false;
			}
		}
		
		// POSSIBLE MOVES BACKWARD
		result = true;
		i = 1;
		pieceToAttackDetected = false;
		while(result) {
			if((p1.x-i) >= 0
					&& !pieceToAttackDetected) {
				possibleMoves.add(new Point(p1.x-i, p1.y));
				
				if(!Board.gameBoard[p1.x-i][p1.y].isEmpty()
						&& Board.gameBoard[p1.x-i][p1.y].getPiece().getColor() != this.getColor())
					pieceToAttackDetected = true;
				i++;
			} else {
				result = false;
			}
		}
		
		// POSSIBLE MOVES TO THE RIGHT
		result = true;
		i = 1;
		pieceToAttackDetected = false;
		while(result) {
			if((p1.y+i) < Constants.MAX_COLS
					&& !pieceToAttackDetected) {
				possibleMoves.add(new Point(p1.x, p1.y+i));
				
				if(!Board.gameBoard[p1.x][p1.y+i].isEmpty()
						&& Board.gameBoard[p1.x][p1.y+i].getPiece().getColor() != this.getColor())
					pieceToAttackDetected = true;
				
				i++;
			} else {
				result = false;
			}
		}
		
		// POSSIBLE MOVES TO THE LEFT
		result = true;
		i = 1;
		pieceToAttackDetected = false;
		while(result) {
			if((p1.y-i) >= 0
					&& !pieceToAttackDetected) {
				possibleMoves.add(new Point(p1.x, p1.y-i));
				
				if(!Board.gameBoard[p1.x][p1.y-i].isEmpty()
						&& Board.gameBoard[p1.x][p1.y-i].getPiece().getColor() != this.getColor())
					pieceToAttackDetected = true;
				
				i++;
			} else {
				result = false;
			}
		}
		
		//System.out.println(possibleMoves);
		//System.out.println(possibleMoves.size());
		return possibleMoves;
	}

}
