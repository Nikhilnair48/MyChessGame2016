package main.ChessGame2016.handlers;

import java.awt.Point;
import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.data.Constants;
import main.ChessGame2016.view.ChessGame2016View;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class KingHandler implements EventHandler<MouseEvent>{
	private ChessPiece king;
	private Point firstPosition;
	
	public KingHandler(ChessPiece piece) {
		king = piece;
	}

	@Override
	public void handle(MouseEvent event) {
		
		if(ChessGame2016View.point1 == null && event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			firstPosition = new Point((int) event.getX() / 100, (int) event.getY() / 100);
			ChessGame2016View.point1 = firstPosition;
			if(king.getColor() == 1)	// PLAYER 1's KING
				ChessGame2016View.keyOfClickedPiece =  king.getPrefixOfID() + "_" + Constants.CHESSPIECE_KING + "_" + king.getSuffixOfID();
			else	// ELSE, PLAYER 2'S KING
				ChessGame2016View.keyOfClickedPiece =  Constants.CHESSPIECE_PLAYER_1_PREFIX + Constants.CHESSPIECE_KING + Constants.CHESSPIECE_SUFFIX_1;
			System.out.println("Clicked King at " + firstPosition + " key " + ChessGame2016View.keyOfClickedPiece);
		}
	}
}
