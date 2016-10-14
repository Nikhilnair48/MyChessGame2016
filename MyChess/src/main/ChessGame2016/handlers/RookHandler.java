package main.ChessGame2016.handlers;

import java.awt.Point;

import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.data.Constants;
import main.ChessGame2016.view.ChessGame2016View;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class RookHandler implements EventHandler<MouseEvent> {
	
	private ChessPiece rook;
	private Point firstPosition;
	
	public RookHandler(ChessPiece piece) {
		rook = piece;
	}

	@Override
	public void handle(MouseEvent event) {
		if(ChessGame2016View.point1 == null && event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			firstPosition = new Point((int) event.getX() / 100, (int) event.getY() / 100);
			ChessGame2016View.point1 = firstPosition;
			if(rook.getColor() == 1)	// PLAYER 1's ROOK
				//previously - ChessGame2016View.keyOfClickedPiece =  Constants.CHESSPIECE_PLAYER_1_PREFIX + Constants.CHESSPIECE_ROOK + Constants.CHESSPIECE_SUFFIX_1;
				ChessGame2016View.keyOfClickedPiece =  rook.getPrefixOfID() + "_" + Constants.CHESSPIECE_ROOK + "_" + rook.getSuffixOfID();
			else	// ELSE, PLAYER 2'S ROOK
				ChessGame2016View.keyOfClickedPiece =  Constants.CHESSPIECE_PLAYER_2_PREFIX + Constants.CHESSPIECE_ROOK + Constants.CHESSPIECE_SUFFIX_1;
			System.out.println("Clicked Rook at " + firstPosition + " key " + ChessGame2016View.keyOfClickedPiece);
		}
	}

}
