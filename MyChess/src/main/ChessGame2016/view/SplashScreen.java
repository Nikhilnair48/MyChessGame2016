package main.ChessGame2016.view;

import main.ChessGame2016.handlers.CloseGameHandler;
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
		stage.setScene(scene);
		
		group.getChildren().add(canvas);
		
		Button closeButton = new Button("END IT");
		CloseGameHandler handler = new CloseGameHandler(closeButton);
		closeButton.addEventHandler(MouseEvent.ANY, handler);
		
		VBox vbox = new VBox();
		vbox.setLayoutX(1180);
		vbox.setLayoutY(0);
		vbox.getChildren().add(closeButton);
		
		Image image = new Image(ChessGame2016Properties.getProperty("trump"));
		ImageView imgV = new ImageView(image);
		
		imgV.setX(0);
		imgV.setY(0);
		((Group)scene.getRoot()).getChildren().add(vbox);
	}
}
