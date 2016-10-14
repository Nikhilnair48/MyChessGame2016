package main.ChessGame2016.data;

import java.awt.Point;
import java.util.ArrayList;

import javafx.scene.image.ImageView;

public abstract class ChessPiece {
	// IS THE PIECE ON THE BOARD, OR HAS IT BEEN REMOVED?
	// 0 MEANS PIECE IS OFF THE BOARD, NON-ZERO MEANS IT'S ON THE BAORD
	private int onBoard;	// 1 ON BOARD, 0 NOT ON BOARD
	private int color;	// 1 FOR WHITE, 2 FOR BLACK
	private int value;
	private ImageView imageView;
	private String ID; // THE ID IS ATTACHED WHEN THE PIECE IS CREATED. EX: 1_rook_1 represents rook #1 that belongs to player 1.
	
	public ChessPiece() { }
	
	public ChessPiece(int c, int val, ImageView imageV, String id) {
		onBoard = 1;
		color = c;
		value = val;
		imageView = imageV;
		ID = id;
	}
	
	public String getID() { return ID; }

	public void setID(String iD) { ID = iD; }
	
	public String getPrefixOfID() { return ID.substring(0, 1); }
	
	public String getSuffixOfID() {
		String[] idComponents = ID.split("_");
		return idComponents[2]; 
	}

	public abstract boolean isMoveValid(Point p1, Point p2, Integer player);
	
	public abstract ArrayList<Point> generatePossibleMoves(Point p1, Point p2);
	
	public void setOnBoard(int onBoard) { this.onBoard = onBoard; }
	
	public int getOnBoard() { return onBoard; }
	
	public ImageView getImageView() { return imageView; }

	public void setImageView(ImageView imageView) { this.imageView = imageView; }

	public int getColor() { return color; }
	
	public void setColor(int color) { this.color = color; }
	
	public int getValue() { return value; }
	
	public void setValue(int value) { this.value = value; }
	
	public String toString() {
		String str = "onBoard status: " + onBoard 
				+ " Color (1-White;2-Black): " + color
				+ " Value: " + value;
		return str;
	}
}