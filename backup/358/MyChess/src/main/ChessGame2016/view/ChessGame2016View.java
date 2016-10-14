package main.ChessGame2016.view;

import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChessGame2016View extends Application {
	
	public static HashMap<String, Object> guiButtons;
	public static HashMap<String, Object> guiDecor;

	public void initView() {
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(new Group());
		stage.setScene(scene);
		
		
	}
}
