package main.ChessGame2016.pieces;

import java.awt.Point;
import java.util.ArrayList;
import javafx.scene.image.ImageView;
import main.ChessGame2016.data.ChessPiece;

public class ChessPieceQueen extends ChessPiece {
	
	public ChessPieceQueen(int col, int value, ImageView imgV, String id) { super(col, value, imgV, id); }

	@Override
	public boolean isMoveValid(Point p1, Point p2, Integer player) {
		return false;
	}

	@Override
	public ArrayList<Point> generatePossibleMoves(Point p1, Point p2) {
		return null;
	}

}
