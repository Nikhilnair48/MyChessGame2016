package data;

import java.awt.Point;

public class ChessPieceRook extends ChessPiece {
	
	public ChessPieceRook(int col, int value) { super(col, value); }
	
	public boolean isMoveValid(Point p1, Point p2, Integer player) {
		boolean result = true;
		
		int xDiff = Math.abs(p1.x - p2.x);
		int yDiff = Math.abs(p1.y - p2.x);
		
		
		// THE MOVE IS INVALID IF THE ROOK HAVE MOVED HORIZONTALLY AND VERTICALLY
		/*if(xDiff == 0 && yDiff == 0)
			result = false;
		else {
			int verticalOrHorizontal= (xDiff ==  0) ? 0 : 1;	// 0 FOR HORIZONTAL, 1 FOR VERTICAL
			
			if(verticalOrHorizontal == 0) {*/
				for(int i = p1.x; i < p2.x; i++) {
					if(!Board.gameBoard[p1.x][p1.y].isEmpty())
						result = false;
				}
			//}
			
		//}
		
		return result;
	}

}
