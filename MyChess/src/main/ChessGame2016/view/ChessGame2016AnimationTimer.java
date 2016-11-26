package main.ChessGame2016.view;

import javafx.animation.AnimationTimer;

public class ChessGame2016AnimationTimer extends AnimationTimer {

	ChessGame2016ScreenManager viewManager = new ChessGame2016ScreenManager();
	
	@Override
	public void handle(long currentTime) {
		viewManager.renderCurrentScreen();
	}
	
}
