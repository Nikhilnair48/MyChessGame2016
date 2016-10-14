package main.ChessGame2016.handlers;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CloseGameHandler implements EventHandler<MouseEvent>{

	private Button button;
	
	public CloseGameHandler(Button nButton) {
		button = nButton;
	}
	
	@Override
	public void handle(MouseEvent event) {
		if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			Stage stage = (Stage) button.getScene().getWindow();
			stage.close();
		}
	}

}
