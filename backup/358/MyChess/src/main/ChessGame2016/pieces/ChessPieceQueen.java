package main.ChessGame2016.pieces;

import java.awt.Point;
import java.util.ArrayList;

import main.ChessGame2016.data.Board;
import main.ChessGame2016.data.ChessPiece;

public class ChessPieceQueen extends ChessPiece {
	
	public ChessPieceQueen(int col, int value) { super(col, value); }

	@Override
	public boolean isMoveValid(Point p1, Point p2, Integer player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Point> generatePossibleMoves(Point p1, Point p2) {
		// TODO Auto-generated method stub
		return null;
	}

}
