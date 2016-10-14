package main.ChessGame2016.myChessGame2016;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.ChessGame2016.data.Board;
import main.ChessGame2016.data.BoardSquare;
import main.ChessGame2016.data.ChessGame2016Data;
import main.ChessGame2016.data.Player;
import main.ChessGame2016.pieces.ChessPieceBishop;
import main.ChessGame2016.pieces.ChessPieceKing;
import main.ChessGame2016.pieces.ChessPieceKnight;
import main.ChessGame2016.pieces.ChessPieceRook;
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
	private Player player1, player2;
	private Board board;
	public static int turn; 				// WHICH PLAYER WILL MAKE THE NEXT MOVE?
	private ChessGame2016Data data;
	
	public GameManager() {
		player1 = new Player(1);
		player2 = new Player(2);
		board = new Board();
		turn = 1;	// PLAYER 1 GETS THE FIRST TURN BY DEFAULT
		view = new ChessGame2016View();
		data = new ChessGame2016Data();
	}
	
	public GameManager(Player p1, Player p2, Board b, ChessGame2016View gameView) {
		player1 = p1;
		player2 = p2;
		board = b;
		turn = 1;
		view = gameView;
	}

	// STEPS -
	// INITIALIZE THE BOARD - COMPLETE
	// SET THE TURN FOR PLAYER '?' - ENSURE THAT OPPOSITE PLAYER'S PIECES ARE DISABLED
	// SET SCORES, IF NECESSARY
	// LISTEN FOR MOVES
	public void beginGame() throws ClassNotFoundException {
		
		view.initView();
		
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
	
	public void makeAMove(Point p1, Point p2) throws ClassNotFoundException {
		// MAKE A MOVE
		if (turn == 1)
			player1.move(p1, p2);
		else
			player2.move(p1, p2);
	}
	
	// RETURN THE APPROPRIATE PLAYER DEPENDING ON THE REQUIREMENT (I.E, INT)
	public Player getCurrentPlayer() { return (turn == 1) ? player1 : player2; }
	
	public Player getNextPlayer() { return (turn == 1) ? player2 : player1; }
	
	// FLIP THE TURN 
	public void setNextTurn() { if(turn == 1) turn = 2; else turn = 1; }
	
	public Player getPlayer1() { return player1; }

	public void setPlayer1(Player player1) { this.player1 = player1; }

	public Player getPlayer2() { return player2; }

	public void setPlayer2(Player player2) { this.player2 = player2; }

	public Board getBoard() { return board;	}

	public void setBoard(Board board) { this.board = board; }
	
	public ChessGame2016Data getGameData() { return data; }
}
