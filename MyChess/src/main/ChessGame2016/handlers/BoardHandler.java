package main.ChessGame2016.handlers;

import java.awt.Point;

import main.ChessGame2016.data.Board;
import main.ChessGame2016.view.ChessGame2016View;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class BoardHandler implements EventHandler<MouseEvent> {
	
	private ImageView imgV;
	private Board board;
	
	public BoardHandler(Board gameBoard, ImageView gameImgV) {
		imgV = gameImgV;
		board = gameBoard;
	}

	@Override
	public void handle(MouseEvent event) {
		System.out.println("Clicked on board at " + event.getX() + " " + event.getY());
		if(ChessGame2016View.point1 != null) {
			
			ChessGame2016View.point2 = new Point((int) event.getX() / 100, (int) event.getY() / 100);
			//ChessGame2016View.guiButtons.get("1_rook.png")
			ChessGame2016View.buttonsToMove.put("1", ChessGame2016View.guiButtons.get(ChessGame2016View.keyOfClickedPiece));
			
			System.out.println("Key of the piece " + ChessGame2016View.keyOfClickedPiece);
		}
	}

}
