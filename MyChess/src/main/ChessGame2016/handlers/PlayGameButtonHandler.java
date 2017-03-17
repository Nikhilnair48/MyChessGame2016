package main.ChessGame2016.handlers;

import main.ChessGame2016.view.ChessGame2016View;
import main.ChessGame2016.view.GameScreen;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PlayGameButtonHandler implements EventHandler<MouseEvent> {
	
	private Button playButton;

	public PlayGameButtonHandler(Button button) {
		playButton = button;
	}
	
	public PlayGameButtonHandler(Button button, Stage stage) {
		playButton = button;
	}
	
	@Override
	public void handle(MouseEvent event) {
		if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			System.out.println("TRIGGERED!");
			GameScreen gameScreen = new GameScreen(ChessGame2016View.stage);
		}
		
	}
	

}
