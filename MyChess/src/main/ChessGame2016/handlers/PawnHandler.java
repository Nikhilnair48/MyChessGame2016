package main.ChessGame2016.handlers;

import java.awt.Point;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.data.Constants;
import main.ChessGame2016.myChessGame2016.ChessGame2016;
import main.ChessGame2016.view.ChessGame2016View;

public class PawnHandler implements EventHandler<MouseEvent>{
	private ChessPiece pawn;
	private Point firstPosition;
	
	public PawnHandler(ChessPiece piece) {
		pawn = piece;
	}

	@Override
	public void handle(MouseEvent event) {
		// ONLY MOVING THE PIECE
		if(ChessGame2016View.point1 == null && event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			firstPosition = new Point((int) event.getX() / 100, (int) event.getY() / 100);
			ChessGame2016View.point1 = firstPosition;
			ChessGame2016View.keyOfClickedPiece =  pawn.getPrefixOfID() + "_" + Constants.CHESSPIECE_PAWN + "_" + pawn.getSuffixOfID();
			System.out.println("Clicked pawn at " + firstPosition + " key " + ChessGame2016View.keyOfClickedPiece);
		}
		
		// ATTEMPT TO ATTACK
		if(ChessGame2016View.point1 != null && event.getEventType().equals(MouseEvent.MOUSE_CLICKED)
				&& !pawn.getID().equals(ChessGame2016View.keyOfClickedPiece)) {
			System.out.println("ATTACK DETECTED");
			ChessGame2016View.point2 = new Point((int) event.getX() / 100, (int) event.getY() / 100);
			ChessGame2016View.buttonsToMove.put("1", (ImageView) ChessGame2016.chessManager.getGuiButtons().get(ChessGame2016View.keyOfClickedPiece));
		}
	}
}
