package main.ChessGame2016.view;

import java.awt.Point;
import java.util.Set;

import javafx.animation.PathTransition;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import main.ChessGame2016.data.Constants;
import main.ChessGame2016.myChessGame2016.ChessGame2016;

public class ChessGame2016ScreenManager {
	
	private String currentScreen;
	
	public ChessGame2016ScreenManager() {
		currentScreen = Constants.SPLASH_SCREEN;
	}
	
	public void renderCurrentScreen() {
		if(currentScreen.equals(Constants.SPLASH_SCREEN))
			renderSplashScreen();
		else if(currentScreen.equals(Constants.SETTINGS_SCREEN))
			renderSettingsScreen();
		else if(currentScreen.equals(Constants.GAME_SCREEN))
			renderGameScreen();
	}
	
	public void renderSplashScreen() {
		
		/*PathTransition transition = new PathTransition();
		transition.setDuration(Duration.millis(1000));
		transition.setPath(new Path(new MoveTo(400, 0)));
		transition.setNode(imgV);	
		transition.setCycleCount(1);
		transition.play();*/
	}
	
	public void renderSettingsScreen() {
		
	}
	
	public void renderGameScreen() {
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
	}
	
	public Point flipPointToFitMatrix(Point p) {
		Point temp = new Point(p.x, p.y);
		p.x = p.y;
		p.y = temp.x;
		
		return p;
	}

}
