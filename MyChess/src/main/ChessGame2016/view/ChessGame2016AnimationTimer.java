package main.ChessGame2016.view;

import java.util.Set;

import main.ChessGame2016.data.Board;
import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.myChessGame2016.ChessGame2016;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

public class ChessGame2016AnimationTimer extends AnimationTimer {

	@Override
	public void handle(long currentTime) {
		Set<String> keyset = ChessGame2016View.guiButtons.keySet();
		Object[] imageView = keyset.toArray();
		GraphicsContext gc = ChessGame2016View.canvas.getGraphicsContext2D();
		
		if(ChessGame2016View.buttonsToMove.containsKey("1")) {
			System.out.println(ChessGame2016View.point2);
			ChessPiece piece = Board.gameBoard[(int)ChessGame2016View.point1.getX()][(int)ChessGame2016View.point1.getY()].getPiece();
			
			if(ChessGame2016.chessManager.getGameData().processMove(ChessGame2016View.point1, ChessGame2016View.point2, piece)) {
				ImageView imgV = (ImageView) ChessGame2016View.guiButtons.get(ChessGame2016View.keyOfClickedPiece);
				double x = ChessGame2016View.point2.getX();
				double y = ChessGame2016View.point2.getY();
			
				imgV.setX(x * 100);
				imgV.setY(y * 100);
			}
			
			ChessGame2016View.buttonsToMove.remove("1");
			ChessGame2016View.point1 = null;
			ChessGame2016View.point2 = null;
		}
		
		gc.clearRect(0, 0, ChessGame2016View.canvas.getWidth(), ChessGame2016View.canvas.getHeight());
		
		for(int i = 0; i < imageView.length; i++) {
			ImageView imgV = (ImageView) ChessGame2016View.guiButtons.get(imageView[i]);
			gc.drawImage(imgV.getImage(), imgV.getX(), imgV.getY());
		}
	}

}
