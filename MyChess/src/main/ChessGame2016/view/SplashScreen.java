package main.ChessGame2016.view;

import java.util.ArrayList;
import java.util.List;
import main.ChessGame2016.handlers.CloseGameHandler;
import main.ChessGame2016.handlers.PlayGameButtonHandler;
import util.ChessGame2016Properties;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SplashScreen {
	
	private ImageView backgroundImage;
	private ImageView playImgV;
	private ImageView recordImgV;
	private ImageView exitImgV;

	public SplashScreen() { }
	
	// READ THE NECESSARY IMAGES, CREATE IMAGEVIEWS AND ADD TO THE LIST TO BE RETURNED
	public List<ImageView> getButtons() {
		ArrayList<ImageView> list = new ArrayList<ImageView>();
		
		Image backgroundImg = new Image(ChessGame2016Properties.getProperty("background"));
		backgroundImage = new ImageView(backgroundImg);
		backgroundImage.setX(0);
		backgroundImage.setY(0);
		backgroundImage.setFitWidth(1200);
		backgroundImage.setFitHeight(800);

		Image playImg = new Image(ChessGame2016Properties.getProperty("playGame"));
		playImgV = new ImageView(playImg);
		PlayGameButtonHandler playHandler = new PlayGameButtonHandler(playImgV);
		playImgV.addEventHandler(MouseEvent.ANY, playHandler);
		playImgV.setX(0);
		playImgV.setY(0);
		playImgV.setId("PLAY");
		
		/*Image exitImg = new Image(ChessGame2016Properties.getProperty("records"));
		exitImgV = new ImageView(exitImg);
		exitImgV.setX(250);
		exitImgV.setY(0);
		CloseGameHandler exitHandler = new CloseGameHandler(exitImgV);
		exitImgV.addEventHandler(MouseEvent.ANY, exitHandler);*/
		
		Image recordImg = new Image(ChessGame2016Properties.getProperty("exit"));
		recordImgV = new ImageView(recordImg);
		recordImgV.setX(250);
		recordImgV.setY(0);
		CloseGameHandler recordHandler = new CloseGameHandler(recordImgV);
		recordImgV.addEventHandler(MouseEvent.ANY, recordHandler);
		
		list.add(backgroundImage);
		list.add(playImgV);
		//list.add(exitImgV);
		list.add(recordImgV);
		
		return list;
	}
	
	/*public List<ImageView> readSplashScreenBackground() {
		
		ArrayList<ImageView> list = new ArrayList<ImageView>();
		backgroundImage = new Image(ChessGame2016Properties.getProperty("background"));
		ImageView imgV = new ImageView(backgroundImage);
		imgV.setFitWidth(800);
		imgV.setFitHeight(800);
		imgV.setX(0);
		imgV.setY(0);
		list.add(imgV);
		
		return list;
	}*/
}
