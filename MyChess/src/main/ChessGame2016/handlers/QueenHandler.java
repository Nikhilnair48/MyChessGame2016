package main.ChessGame2016.handlers;

import java.awt.Point;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.data.Constants;
import main.ChessGame2016.view.ChessGame2016View;

public class QueenHandler implements EventHandler<MouseEvent>{
	
	private ChessPiece queen;
	private Point firstPosition;
	
	public QueenHandler(ChessPiece piece) {
		queen = piece;
	}

	@Override
	public void handle(MouseEvent event) {
		if(ChessGame2016View.point1 == null && event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			firstPosition = new Point((int) event.getX() / 100, (int) event.getY() / 100);
			ChessGame2016View.point1 = firstPosition;
			if(queen.getColor() == 1)	// PLAYER 1's QUEEN
				ChessGame2016View.keyOfClickedPiece =  queen.getPrefixOfID() + "_" + Constants.CHESSPIECE_QUEEN + "_" + queen.getSuffixOfID();
			else	// ELSE, PLAYER 2'S QUEEN
				ChessGame2016View.keyOfClickedPiece =  Constants.CHESSPIECE_PLAYER_2_PREFIX + Constants.CHESSPIECE_QUEEN + Constants.CHESSPIECE_SUFFIX_1;
			System.out.println("Clicked Queen at " + firstPosition);
		}
	}

}
