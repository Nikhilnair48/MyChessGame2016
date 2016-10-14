package main.ChessGame2016.handlers;

import java.awt.Point;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.data.Constants;
import main.ChessGame2016.view.ChessGame2016View;

public class BishopHandler implements EventHandler<MouseEvent>{
	private ChessPiece bishop;
	private Point firstPosition;
	
	public BishopHandler(ChessPiece piece) {
		bishop = piece;
	}

	@Override
	public void handle(MouseEvent event) {
		
		if(ChessGame2016View.point1 == null && event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			firstPosition = new Point((int) event.getX() / 100, (int) event.getY() / 100);
			ChessGame2016View.point1 = firstPosition;
			if(bishop.getColor() == 1)	// PLAYER 1's BISHOP
				ChessGame2016View.keyOfClickedPiece =  bishop.getPrefixOfID() + "_" + Constants.CHESSPIECE_BISHOP + "_" + bishop.getSuffixOfID();
			else	// ELSE, PLAYER 2'S BISHOP
				ChessGame2016View.keyOfClickedPiece =  Constants.CHESSPIECE_PLAYER_1_PREFIX + Constants.CHESSPIECE_BISHOP + Constants.CHESSPIECE_SUFFIX_1;
			System.out.println("Clicked Bishop at " + firstPosition + " key " + ChessGame2016View.keyOfClickedPiece);
		}
	}
}
