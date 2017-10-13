package main.ChessGame2016.myChessGame2016;

import java.awt.Point;
import java.util.HashMap;

import javafx.stage.Stage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.ChessGame2016.data.Board;
import main.ChessGame2016.data.ChessGame2016Data;
import main.ChessGame2016.data.Player;
import main.ChessGame2016.view.ChessGame2016View;

/*
	GAMEMANAGER.JAVA
	THE MOTHER OF ALL CLASSES!
	THE GAMEMANAGER CLASS WILL HANDLE ANY AND ALL INTERACTIONS FROM THE
	PLAYER ON THE VIEW, AND DELEGATE IT TO THE DATA LAYER 
 */

public class GameManager {
	private static final Logger logger = LogManager.getLogger("GameManager");
	
	private ChessGame2016View view;
	private ChessGame2016Data data;
	
	private HashMap<String, Object> guiButtons;
	private HashMap<String, Object> guiDecor;
	
	public GameManager() {
		logger.info("GameManager init : starting");
		
		guiButtons = new HashMap<>();
		guiDecor = new HashMap<>();
		data = new ChessGame2016Data();		// INITIALIZES THE DATA -> INCLUDES PLAYER1, PLAYER2 & BOARD 
		view = new ChessGame2016View();
		
		logger.info("GameManager init : complete");
	}
	
	public GameManager(ChessGame2016View gameView, HashMap<String, Object> buttons, HashMap<String, Object> decor) {
		logger.info("GameManager init : starting");
		
		view = gameView;
		guiButtons = buttons;
		guiDecor = decor;
		
		logger.info("GameManager init : complete");
	}

	// STEPS -
	// INITIALIZE THE BOARD - COMPLETE
	// SET THE TURN FOR PLAYER '?' - ENSURE THAT OPPOSITE PLAYER'S PIECES ARE DISABLED
	// SET SCORES, IF NECESSARY
	// LISTEN FOR MOVES
	//public void beginGame(Stage stg) throws Exception {
	public void beginGame() throws Exception {
		logger.info("GameManager beginGame : preparing to init view & data");
		view.initView();
	}
	
	public boolean makeAMove(Point p1, Point p2) {
		boolean result = false;
		// MAKE A MOVE
		if (ChessGame2016Data.turn == 1)
			result = data.move(p1, p2);
		else
			result = data.move(p1, p2);
		
		return result;
	}
	
	public Board getBoard() { return data.getBoard();	}

	public void setBoard(Board board) { data.setBoard(board); }
	
	// RETURN THE APPROPRIATE PLAYER DEPENDING ON THE REQUIREMENT (I.E, INT)
	public Player getCurrentPlayer() { return data.getCurrentPlayer(); }
	
	public Player getNextPlayer() { return data.getNextPlayer(); }
	
	// FLIP THE TURN 
	public void setNextTurn() { data.setNextTurn(); }
	
	public ChessGame2016Data getGameData() { return data; }

	public HashMap<String, Object> getGuiButtons() { return guiButtons; }

	public void setGuiButtons(HashMap<String, Object> guiButtons) { this.guiButtons = guiButtons; }
	
	public Object removeGuiButton(String key) { return guiButtons.remove(key); }
	
	public void addGuiButton(String key, Object button) {
		guiButtons.put(key, button);
	}
	
	public void addGuiButtons(HashMap<String, Object> newButtons) {
		Object[] arr = newButtons.keySet().toArray();
		
		for(int i = 0; i < arr.length; i++) {
			guiButtons.put(String.valueOf(arr[i]), newButtons.get(arr[i]));
		}
	}

	public HashMap<String, Object> getGuiDecor() { return guiDecor; }

	public void setGuiDecor(HashMap<String, Object> guiDecor) { this.guiDecor = guiDecor; }
	
}
