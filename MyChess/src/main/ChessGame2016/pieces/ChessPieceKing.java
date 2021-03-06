package main.ChessGame2016.pieces;

import java.awt.Point;
import java.util.ArrayList;

import javafx.scene.image.ImageView;
import main.ChessGame2016.data.Board;
import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.data.Constants;

public class ChessPieceKing extends ChessPiece {
	
	public ChessPieceKing() { }
	
	public ChessPieceKing(int col, int value, ImageView imgV, String id) { super(col, value, imgV, id); }

	@Override
	public boolean isMoveValid(Point p1, Point p2, Integer player) {
		boolean result = true;
		
		int xDifference = Math.abs(p2.x - p1.x);
		int yDifference = Math.abs(p2.y - p1.y);
		
		if(xDifference > 1 || yDifference > 2)
			result = false;
		
		if(!generatePossibleMoves(p1, p2).contains(p2) && Board.gameBoard[p2.x][p2.y].isEmpty())
			result = false;
		
		// EVEN IF P2 EXISTS IN POSSIBLE MOVES,
		// CHECK IF THE KING SHOULD BE ALLOWED TO MOVE
		// WHAT IF THE MOVE WOULD PUT THE KING IN CHECK? OR CHECK MATE?
		// SO CHECK THE Ls FOR KNIGHT ATTACKS, DIAGONAL QUEEN/BISHOP/PAWN/KING ATTACKS,
		// DIRECT ATTACKS FROM QUEEN//ROOK/KING
		
		return result;
	}

	@Override
	public ArrayList<Point> generatePossibleMoves(Point p1, Point p2) {
		ArrayList<Point> possibleMoves = new ArrayList<>();
		
		// MOVE FORWARD/BACKWARD BY 1  
		// IF THERE IS A PIECE AT P2, THEN IT SHOULD NOT BELONG TO THE PLAYER
		// OR
		// IF THERE ISN'T A PIECE AT P2, THEN JUST CHECK THE BOUNDARIES
		if((Board.gameBoard[p2.x][p2.y].getPiece() != null 
				&& !Board.gameBoard[p2.x][p2.y].getPiece().getPrefixOfID().equals(this.getPrefixOfID()))
				|| (Board.gameBoard[p2.x][p2.y].getPiece() == null && p1.x+1 < Constants.MAX_ROWS))
			possibleMoves.add(new Point(p1.x+1, p1.y));
		
		if((p1.x-1) > 0)
			possibleMoves.add(new Point(p1.x-1, p1.y));
		
		// MOVE LEFT/RIGHT BY 1
		if((p1.y+1) < Constants.MAX_COLS) 
			possibleMoves.add(new Point(p1.x, p1.y+1));
		
		if((p1.y-1) > 0)
			possibleMoves.add(new Point(p1.x, p1.y-1));
		
		// MOVE 1 UP 1 RIGHT
		if(p1.x+1 < Constants.MAX_ROWS && (p1.y+1) < Constants.MAX_COLS)
			possibleMoves.add(new Point(p1.x+1, p1.y+1));
		
		// MOVE 1 BACK 1 RIGHT
		if((p1.x-1) >= 0 && (p1.y+1) < Constants.MAX_COLS)
			possibleMoves.add(new Point(p1.x-1, p1.y+1));
		
		// MOVE 1 LEFT 1 UP
		if((p1.y-1) >= 0 && (p1.x+1) <= Constants.MAX_ROWS)
			possibleMoves.add(new Point(p1.x+1, p1.y-1));
		
		// MOVE 1 LEFT 1 BACK
		if((p1.y-1) >= 0 && (p1.x-1) >= 0)
			possibleMoves.add(new Point(p1.x-1, p1.y-1));
		
		//System.out.println(possibleMoves);
		//System.out.println(possibleMoves.size());
		return possibleMoves;
	}

}
