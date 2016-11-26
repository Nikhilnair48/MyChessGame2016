package main.ChessGame2016.handlers;

import java.awt.Point;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.data.Constants;
import main.ChessGame2016.myChessGame2016.ChessGame2016;
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
			ChessGame2016View.keyOfClickedPiece =  bishop.getPrefixOfID() + "_" + Constants.CHESSPIECE_BISHOP + "_" + bishop.getSuffixOfID();
			System.out.println("Clicked Bishop at " + firstPosition + " key " + ChessGame2016View.keyOfClickedPiece);
		}
		// IF THE PIECE IS ATTACKING SOMEONE
		if(ChessGame2016View.point1 != null && event.getEventType().equals(MouseEvent.MOUSE_CLICKED)
				&& !bishop.getID().equals(ChessGame2016View.keyOfClickedPiece)) {
			ChessGame2016View.point2 = new Point((int) event.getX() / 100, (int) event.getY() / 100);
			ChessGame2016View.buttonsToMove.put("1", (ImageView) ChessGame2016.chessManager.getGuiButtons().get(ChessGame2016View.keyOfClickedPiece));
		}
	}
}
