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
	

	public SplashScreen() {
		
	}
	
	public List<ImageView> getButtons() {
		ArrayList<ImageView> list = new ArrayList<ImageView>();
		
		/*Button playButton = new Button("PLAY");
		PlayGameButtonHandler playGameButtonHandler = new PlayGameButtonHandler(playButton);
		playButton.addEventHandler(MouseEvent.ANY, playGameButtonHandler);
		
		VBox playButtonBox = new VBox();
		playButtonBox.setMinSize(100, 100);
		playButtonBox.setLayoutX(400);
		playButtonBox.setLayoutY(400);
		playButtonBox.getChildren().add(playButton);
		
		Button exitButton = new Button("EXIT");
		CloseGameHandler exitGameButtonHandler = new CloseGameHandler(exitButton);
		exitButton.addEventHandler(MouseEvent.ANY, exitGameButtonHandler);
		
		VBox exitButtonBox  = new VBox();
		exitButtonBox.setMinSize(100, 100);
		exitButtonBox.setLayoutX(450);
		exitButtonBox.setLayoutY(400);
		exitButtonBox.getChildren().add(exitButton);
		
		list.add(playButtonBox);
		list.add(exitButtonBox);*/
		
		Image playImg = new Image(ChessGame2016Properties.getProperty("playGame"));
		playImgV = new ImageView(playImg);
		
		PlayGameButtonHandler playHandler = new PlayGameButtonHandler(playImgV);
		playImgV.addEventHandler(MouseEvent.ANY, playHandler);
		
		list.add(playImgV);
		
		return list;
		
	}
	
	public List<ImageView> readSplashScreenBackground() {
		
		ArrayList<ImageView> list = new ArrayList<ImageView>();
		Image image = new Image(ChessGame2016Properties.getProperty("background"));
		ImageView imgV = new ImageView(image);
		imgV.setFitWidth(800);
		imgV.setFitHeight(800);
		imgV.setX(0);
		imgV.setY(0);
		list.add(imgV);
		
		return list;
	}
	
	/*public ImageView addGuiButton() {
		System.out.println("called addGUIButtons");
		Image closeButton = new Image(Constants.baseImgDirectory + "/End_Game.png");
		ImageView imgV = new ImageView();
		imgV.setImage(closeButton);
		imgV.setFitWidth(160);
		imgV.setFitHeight(80);
		imgV.setX(400);
		imgV.setY(800);
		CloseGameHandler handler = new CloseGameHandler(imgV);
		imgV.addEventHandler(MouseEvent.ANY, handler);
		
		return imgV;
		
		//ChessGame2016.chessManager.getGuiButtons().put("GameScreen_End_Game", imgV);
	}*/
	
}
