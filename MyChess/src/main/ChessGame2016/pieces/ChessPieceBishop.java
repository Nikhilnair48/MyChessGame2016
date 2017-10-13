package main.ChessGame2016.pieces;

import java.awt.Point;
import java.util.ArrayList;

import javafx.scene.image.ImageView;
import main.ChessGame2016.data.Board;
import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.data.Constants;

// ENTERING A RELATIONSHIP IS LIKE WALING INTO THE NO MANS LAND.
// YOU COULD EITHER WAIT IN THE TRENCH FOREVER OR
// BE VULNERABLE OUT IN THE MIDDLE. YOU PICK.

// HOW ABOUT A MOVIE WHERE YOU CAN DELETE MEMORY SELECTIVELY. WOULD REALLY HELP IF YOU'RE GOING
// TO DO A CRIME. DO IT, DELETE MEMORY AND NOW YOU WILL NO LONGER LIE ABOUT IT! 

public class ChessPieceBishop extends ChessPiece {
	
	public ChessPieceBishop() { }
	
	public ChessPieceBishop(int col, int value, ImageView imgV, String id) { super(col, value, imgV, id); }
	
	@Override
	public boolean isMoveValid(Point p1, Point p2, Integer player) {
		// ALL POSSIBLE MOVES FOR THE BISHOP FROM POINT p1
		// INCLUDES MOVES THAT 
		ArrayList<Point> possibleMoves = generatePossibleMoves(p1, p2);
		
		return possibleMoves.contains(p2);
	}
	
	@Override
	public ArrayList<Point> generatePossibleMoves(Point p1, Point p2) {
		
		ArrayList<Point> possibleMoves = new ArrayList<Point>();
		
		// POSSIBLE MOVES GOING FORWARD LEFT
		boolean result = true;
		int i = 1;
		boolean pieceToAttackDetected = false;
		while(result) {
			if((p1.x+i) < Constants.MAX_ROWS && (p1.y+i) < Constants.MAX_COLS
					&& !pieceToAttackDetected) {
				possibleMoves.add(new Point(p1.x+i, p1.y+i));
				
				if(!Board.gameBoard[p1.x+i][p1.y+i].isEmpty())
					pieceToAttackDetected = true;
				i++;
			} else {
				result = false;
			}
		}
		
		// POSSIBLE MOVES GOING BACKWARD LEFT
		result = true;
		i = 1;
		pieceToAttackDetected = false;
		while(result) {
			if((p1.x+i) < Constants.MAX_ROWS && (p1.y-i) >= 0
					&& !pieceToAttackDetected) {
				possibleMoves.add(new Point(p1.x+i, p1.y-i));
				
				if(!Board.gameBoard[p1.x+i][p1.y-i].isEmpty())
					pieceToAttackDetected = true;
				
				i++;
			} else {
				result = false;
			}
		}
		
		// POSSIBLE MOVES GOING FORWARD RIGHT
		result = true;
		i = 1;
		pieceToAttackDetected = false;
		while(result) {
			if((p1.x-i) >= 0 && (p1.y+i) < Constants.MAX_COLS
					&& !pieceToAttackDetected) {
				possibleMoves.add(new Point(p1.x-i, p1.y+i));
				
				if(!Board.gameBoard[p1.x-i][p1.y+i].isEmpty())
					pieceToAttackDetected = true;
				
				i++;
			} else {
				result = false;
			}
		}
		
		// POSSIBLE MOVES GOING BACKWARD RIGHT
		result = true;
		i = 1;
		pieceToAttackDetected = false;
		while(result) {
			if((p1.x-i) >= 0 && (p1.y-i) >= 0
					&& !pieceToAttackDetected) {
				possibleMoves.add(new Point(p1.x-i, p1.y-i));
				
				if(!Board.gameBoard[p1.x-i][p1.y-i].isEmpty())
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
