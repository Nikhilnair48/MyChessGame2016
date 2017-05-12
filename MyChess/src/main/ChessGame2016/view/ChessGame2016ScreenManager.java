package main.ChessGame2016.view;

import java.awt.Point;
import java.util.Set;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import main.ChessGame2016.data.Constants;
import main.ChessGame2016.myChessGame2016.ChessGame2016;

public class ChessGame2016ScreenManager {
	
	private String currentScreen;
	
	public ChessGame2016ScreenManager() {
		currentScreen = Constants.GAME_SCREEN;
	}
	
	public void renderCurrentScreen() {
		if(currentScreen.equals(Constants.SPLASH_SCREEN))
			renderSplashScreen();
		else if(currentScreen.equals(Constants.SETTINGS_SCREEN))
			renderSettingsScreen();
		else if(currentScreen.equals(Constants.GAME_SCREEN))
			renderGameScreen();
	}
	
	public void renderSplashScreen() {	}
	
	public void renderSettingsScreen() {
		
	}
	
	public void renderGameScreen() {
		
		GraphicsContext gc = ChessGame2016View.canvas.getGraphicsContext2D();
		
		if(ChessGame2016View.buttonsToMove.containsKey("1")) {
			System.out.println("point 2 "+ ChessGame2016View.point2 + " point 1 " + ChessGame2016View.point1);
			
			ChessGame2016View.point1 = flipPointToFitMatrix(ChessGame2016View.point1);
			ChessGame2016View.point2 = flipPointToFitMatrix(ChessGame2016View.point2);
			
			if(ChessGame2016.chessManager.makeAMove(ChessGame2016View.point1, ChessGame2016View.point2)) {
				ChessGame2016View.point1 = flipPointToFitMatrix(ChessGame2016View.point1);
				ChessGame2016View.point2 = flipPointToFitMatrix(ChessGame2016View.point2);
				
				ImageView imgV = (ImageView) ChessGame2016.chessManager.getGuiButtons().get(ChessGame2016View.keyOfClickedPiece);
				if(imgV != null) {
					double x = ChessGame2016View.point2.getX();
					double y = ChessGame2016View.point2.getY();
				
					imgV.setX(x * 100);
					imgV.setY(y * 100);
				}
			}
			
			ChessGame2016View.buttonsToMove.remove("1");
			ChessGame2016View.point1 = null;
			ChessGame2016View.point2 = null;
		}
		
		gc.clearRect(0, 0, ChessGame2016View.canvas.getWidth(), ChessGame2016View.canvas.getHeight());
		
		if(ChessGame2016View.keysOfIDsToBeRemoved.size() > 0) {
			((Group)ChessGame2016View.scene.getRoot()).getChildren().remove(ChessGame2016View.keysOfIDsToBeRemoved.pop());
		}
		
		if(ChessGame2016View.keysOfIDsToBeAdded.size() > 0) {
			System.out.println("adding new shieeeet");
			((Group)ChessGame2016View.scene.getRoot()).getChildren().add(ChessGame2016View.keysOfIDsToBeAdded.remove(0));
		}
		
		Set<String> keyset = ChessGame2016.chessManager.getGuiButtons().keySet();
		Object[] imageView = keyset.toArray();

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
