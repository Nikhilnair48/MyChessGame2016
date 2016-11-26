package main.ChessGame2016.handlers;

import java.awt.Point;

import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.data.Constants;
import main.ChessGame2016.myChessGame2016.ChessGame2016;
import main.ChessGame2016.view.ChessGame2016View;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class RookHandler implements EventHandler<MouseEvent> {
	
	private ChessPiece rook;
	private Point firstPosition;
	
	public RookHandler(ChessPiece piece) {
		rook = piece;
	}

	@Override
	public void handle(MouseEvent event) {
		// IF THE PIECE IS ONLY MOVING
		if(ChessGame2016View.point1 == null && event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			firstPosition = new Point((int) event.getX() / 100, (int) event.getY() / 100);
			ChessGame2016View.point1 = firstPosition;
			ChessGame2016View.keyOfClickedPiece =  rook.getPrefixOfID() + "_" + Constants.CHESSPIECE_ROOK + "_" + rook.getSuffixOfID();
			System.out.println("Clicked Rook at " + firstPosition + " key " + ChessGame2016View.keyOfClickedPiece);
		}
		
		// IF THE PIECE IS ATTACKING SOMEONE
		if(ChessGame2016View.point1 != null && event.getEventType().equals(MouseEvent.MOUSE_CLICKED)
				&& !rook.getID().equals(ChessGame2016View.keyOfClickedPiece)) {
			ChessGame2016View.point2 = new Point((int) event.getX() / 100, (int) event.getY() / 100);
			ChessGame2016View.buttonsToMove.put("1", (ImageView) ChessGame2016.chessManager.getGuiButtons().get(ChessGame2016View.keyOfClickedPiece));
		}
		
	}

}
