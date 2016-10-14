package main.ChessGame2016.handlers;

import java.awt.Point;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.data.Constants;
import main.ChessGame2016.view.ChessGame2016View;

public class PawnHandler implements EventHandler<MouseEvent>{
	private ChessPiece pawn;
	private Point firstPosition;
	
	public PawnHandler(ChessPiece piece) {
		pawn = piece;
	}

	@Override
	public void handle(MouseEvent event) {
		if(ChessGame2016View.point1 == null && event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			firstPosition = new Point((int) event.getX() / 100, (int) event.getY() / 100);
			ChessGame2016View.point1 = firstPosition;
			
			if(pawn.getColor() == 1)	// PLAYER 1's PAWN
				ChessGame2016View.keyOfClickedPiece =  pawn.getPrefixOfID() + "_" + Constants.CHESSPIECE_PAWN + "_" + pawn.getSuffixOfID();
			else	// ELSE, PLAYER 2'S PAWN
				ChessGame2016View.keyOfClickedPiece =  Constants.CHESSPIECE_PLAYER_2_PREFIX + Constants.CHESSPIECE_PAWN + Constants.CHESSPIECE_SUFFIX_1;
			System.out.println("Clicked pawn at " + firstPosition + " key " + ChessGame2016View.keyOfClickedPiece);
		}
	}
}
