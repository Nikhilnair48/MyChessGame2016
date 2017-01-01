package main.ChessGame2016.view;

import main.ChessGame2016.handlers.CloseGameHandler;
import main.ChessGame2016.handlers.PlayGameButtonHandler;
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

	public SplashScreen(Stage stage, Canvas canvas) {
		Group group = new Group();
		Scene scene = new Scene(group);
		
		group.getChildren().add(canvas);
		
		((Group)scene.getRoot()).getChildren().add(readSplashScreenBackground());
		
		/*Button closeButton = new Button("EXIT");
		CloseGameHandler handler = new CloseGameHandler(closeButton);
		closeButton.addEventHandler(MouseEvent.ANY, handler);
		
		VBox vbox = new VBox();
		vbox.setMinSize(100, 100);
		vbox.setLayoutX(550);
		vbox.setLayoutY(600);
		
		vbox.getChildren().add(closeButton);*/
		
		Button playButton = new Button("PLAY");
		PlayGameButtonHandler playGameButtonHandler = new PlayGameButtonHandler(playButton);
		playButton.addEventHandler(MouseEvent.ANY, playGameButtonHandler);
		//playButton.setOnAction(eve -> new PlayGameButtonHandler(playButton));
		
		VBox playButtonBox = new VBox();
		playButtonBox.setMinSize(100, 100);
		playButtonBox.setLayoutX(550);
		playButtonBox.setLayoutY(450);
		playButtonBox.getChildren().add(playButton);
		
		Image image = new Image(ChessGame2016Properties.getProperty("trump"));
		ImageView imgV = new ImageView(image);
		
		imgV.setX(0);
		imgV.setY(0);
		//((Group)scene.getRoot()).getChildren().add(vbox);
		((Group)scene.getRoot()).getChildren().add(playButtonBox);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public ImageView readSplashScreenBackground() {
		Image image = new Image(ChessGame2016Properties.getProperty("background"));
		ImageView imgV = new ImageView(image);
		
		imgV.setX(0);
		imgV.setY(0);
		
		return imgV;
	}
	
}
