package main.ChessGame2016.handlers;

import main.ChessGame2016.view.ChessGame2016View;
import main.ChessGame2016.view.GameScreen;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PlayGameButtonHandler implements EventHandler<MouseEvent> {
	
	private ImageView playButton;

	public PlayGameButtonHandler(ImageView button) {
		playButton = button;
	}
	
	@Override
	public void handle(MouseEvent event) {
		if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			System.out.println("TRIGGERED PLAY GAME!");
			ChessGame2016View.stage.setScene(ChessGame2016View.gameScene);
		}
		
	}
	

}
