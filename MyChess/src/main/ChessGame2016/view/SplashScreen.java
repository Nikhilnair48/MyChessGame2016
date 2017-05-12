package main.ChessGame2016.view;

import java.util.ArrayList;
import java.util.List;
import main.ChessGame2016.data.Constants;
import main.ChessGame2016.handlers.CloseGameHandler;
import main.ChessGame2016.handlers.PlayGameButtonHandler;
import main.ChessGame2016.myChessGame2016.ChessGame2016;
import util.ChessGame2016Properties;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SplashScreen {
	
	private Image backgroundImage;
	private ImageView playImgV;
	private ImageView recordImgV;
	private ImageView exitImgV;

	public SplashScreen() { }
	
	// READ THE NECESSARY IMAGES, CREATE IMAGEVIEWS AND ADD TO THE LIST TO BE RETURNED
	public List<ImageView> getButtons() {
		ArrayList<ImageView> list = new ArrayList<ImageView>();

		Image playImg = new Image(ChessGame2016Properties.getProperty("playGame"));
		playImgV = new ImageView(playImg);
		PlayGameButtonHandler playHandler = new PlayGameButtonHandler(playImgV);
		playImgV.addEventHandler(MouseEvent.ANY, playHandler);
		playImgV.setX(0);
		playImgV.setY(0);
		
		Image exitImg = new Image(ChessGame2016Properties.getProperty("records"));
		exitImgV = new ImageView(exitImg);
		exitImgV.setX(250);
		exitImgV.setY(0);
		CloseGameHandler exitHandler = new CloseGameHandler(exitImgV);
		exitImgV.addEventHandler(MouseEvent.ANY, exitHandler);
		
		Image recordImg = new Image(ChessGame2016Properties.getProperty("exit"));
		recordImgV = new ImageView(recordImg);
		recordImgV.setX(500);
		recordImgV.setY(0);
		CloseGameHandler recordHandler = new CloseGameHandler(recordImgV);
		recordImgV.addEventHandler(MouseEvent.ANY, recordHandler);
		
		list.add(playImgV);
		list.add(exitImgV);
		list.add(recordImgV);
		
		return list;
	}
	
	public List<ImageView> readSplashScreenBackground() {
		
		ArrayList<ImageView> list = new ArrayList<ImageView>();
		backgroundImage = new Image(ChessGame2016Properties.getProperty("background"));
		ImageView imgV = new ImageView(backgroundImage);
		imgV.setFitWidth(800);
		imgV.setFitHeight(800);
		imgV.setX(0);
		imgV.setY(0);
		list.add(imgV);
		
		return list;
	}
}
