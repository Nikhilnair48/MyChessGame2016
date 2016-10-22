package main.ChessGame2016.myChessGame2016;

import java.awt.Point;
import java.util.HashMap;

import main.ChessGame2016.data.Board;
import main.ChessGame2016.data.ChessGame2016Data;
import main.ChessGame2016.data.Player;
import main.ChessGame2016.view.ChessGame2016View;

/*
	GAMEMANAGER.JAVA
	THE MOTHER OF ALL CLASSES!
	THE GAMEMANAGER CLASS WILL HANDLE ANY AND ALL INTERACTIONS FROM THE
	PLAYER, AND FORWARD THE REQUEST (EX: MOVE A PIECE) TO THE APPROPRIATE
	OBJECT.
 */

public class GameManager {
	private ChessGame2016View view;
	//public static int turn; 				// WHICH PLAYER WILL MAKE THE NEXT MOVE?
	private ChessGame2016Data data;
	
	private HashMap<String, Object> guiButtons;
	private HashMap<String, Object> guiDecor;
	
	public GameManager() {
		guiButtons = new HashMap<>();
		guiDecor = new HashMap<>();
		data = new ChessGame2016Data();		// INITIALIZES THE DATA -> INCLUDES PLAYER1, PLAYER2 & BOARD 
		view = new ChessGame2016View();
		//turn = 1;	// PLAYER 1 GETS THE FIRST TURN BY DEFAULT
	}
	
	public GameManager(ChessGame2016View gameView, HashMap<String, Object> buttons, HashMap<String, Object> decor) {
		//turn = 1;
		view = gameView;
		guiButtons = buttons;
		guiDecor = decor;
	}

	// STEPS -
	// INITIALIZE THE BOARD - COMPLETE
	// SET THE TURN FOR PLAYER '?' - ENSURE THAT OPPOSITE PLAYER'S PIECES ARE DISABLED
	// SET SCORES, IF NECESSARY
	// LISTEN FOR MOVES
	public void beginGame() throws ClassNotFoundException {
		System.out.println("Load images");
		view.initView();
		System.out.println("Init data");
		
		System.out.println("Init view");
		//view.initView();
		
		//BoardSquare testSq = new BoardSquare(new Point(5,4), false, new ChessPieceRook(1, 4));
		//Board.gameBoard[5][4] = testSq;
		//player1.addChessPiece(new Point(5,4), testSq);
		
		//waitForInput();
		
		System.out.println("Goodbye");
	}
	
	/*public void waitForInput() throws ClassNotFoundException {
		// WAIT FOR USER INPUT
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		if (turn == 1)
			System.out.println("Player 1's turn: ");
		else
			System.out.println("Player 2's turn: ");

		board.printChessBoard();

		// AS OF NOW USER INPUT WILL BE EITHER "QUIT" OR
		// START POSITION FOLLOWED BY A SPACE AND THEN END POSITION
		// Ex: "11 21" MOVES THE PIECE FROM INDEX (1,1) to (2,1)
		try {
			while (!(input = reader.readLine()).equals("quit")) {

				Point p1 = new Point();
				p1.x = Integer.parseInt(input.substring(0, 1));
				p1.y = Integer.parseInt(input.substring(1, 2));
				Point p2 = new Point();
				p2.x = Integer.parseInt(input.substring(3, 4));
				p2.y = Integer.parseInt(input.substring(4));
				
				makeAMove(p1, p2);
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("Game cannot be started: " + e.getMessage());
		}
	}*/
	
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
	
	public void addGuiButtons(HashMap<String, Object> newButtons) {
		Object[] arr = newButtons.keySet().toArray();
		
		for(int i = 0; i < arr.length; i++) {
			guiButtons.put(String.valueOf(arr[i]), newButtons.get(arr[i]));
		}
	}

	public HashMap<String, Object> getGuiDecor() { return guiDecor; }

	public void setGuiDecor(HashMap<String, Object> guiDecor) { this.guiDecor = guiDecor; }
	
}
