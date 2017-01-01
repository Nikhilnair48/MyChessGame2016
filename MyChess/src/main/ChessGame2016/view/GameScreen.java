package main.ChessGame2016.view;

import java.awt.Point;
import java.util.Set;

import main.ChessGame2016.myChessGame2016.ChessGame2016;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GameScreen {
	
	public GameScreen(Stage stage) {	//, Canvas canvas
		Group group = new Group();
		Scene scene = new Scene(group);
		
		group.getChildren().add(ChessGame2016View.canvas);
		
		Set<String> keyset = ChessGame2016.chessManager.getGuiButtons().keySet();
		Object[] imageView = keyset.toArray();
		GraphicsContext gc = ChessGame2016View.canvas.getGraphicsContext2D();
		
		if(ChessGame2016View.buttonsToMove.containsKey("1")) {
			System.out.println("point 2 "+ ChessGame2016View.point2 + " point 1 " + ChessGame2016View.point1);
			
			ChessGame2016View.point1 = flipPointToFitMatrix(ChessGame2016View.point1);
			ChessGame2016View.point2 = flipPointToFitMatrix(ChessGame2016View.point2);
			
			if(ChessGame2016.chessManager.makeAMove(ChessGame2016View.point1, ChessGame2016View.point2)) {
				ChessGame2016View.point1 = flipPointToFitMatrix(ChessGame2016View.point1);
				ChessGame2016View.point2 = flipPointToFitMatrix(ChessGame2016View.point2);
				
				ImageView imgV = (ImageView) ChessGame2016.chessManager.getGuiButtons().get(ChessGame2016View.keyOfClickedPiece);
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
			ImageView imgV = (ImageView) ChessGame2016.chessManager.getGuiButtons().get(imageView[i]);
			gc.drawImage(imgV.getImage(), imgV.getX(), imgV.getY());
			//System.out.println("imgv with key " + imageView[i] + " is " + imgV.isVisible());
		}
		
		stage.setScene(scene);
		stage.show();
		
	}
	
	public Point flipPointToFitMatrix(Point p) {
		Point temp = new Point(p.x, p.y);
		p.x = p.y;
		p.y = temp.x;
		
		return p;
	}

}
