package myChessGame2016;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import data.Board;
import data.Player;

/*
	GAMEMANAGER.JAVA
	THE MOTHER OF ALL CLASSES!
	THE GAMEMANAGER CLASS WILL HANDLE ANY AND ALL INTERACTIONS FROM THE
	PLAYER, AND FORWARD THE REQUEST (EX: MOVE A PIECE) TO THE APPROPRIATE
	OBJECT.
 */

public class GameManager {
	private Player player1, player2;
	private Board board;
	
	public GameManager() {
		player1 = new Player(1);
		player2 = new Player(2);
		board = new Board();
	}
	
	public GameManager(Player p1, Player p2, Board b) {
		player1 = p1;
		player2 = p2;
		board = b;
	}

	// STEPS -
	// INITIALIZE THE BOARD - COMPLETE
	// SET THE TURN FOR PLAYER '?' - ENSURE THAT OPPOSITE PLAYER'S PIECES ARE DISABLED
	// SET SCORES, IF NECESSARY
	// LISTEN FOR MOVES
	public void beginGame() {
		
		board.initBoard();
		
		// WAIT FOR USER INPUT
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the from & to position (Ex: '01 02'): ");
		String input = "";
		
		
		// AS OF NOW USER INPUT WILL BE EITHER "QUIT" OR
		// START POSITION FOLLOWED BY A SPACE AND THEN END POSITION
		// Ex: "11 21" MOVES THE PIECE FROM INDEX (1,1) to (2,1)
		try {
			System.out.println("PLAYER 1's TURN: ");
			while (!(input = reader.readLine()).equals("quit")) {
				
				Point p1 = new Point();
				p1.x = Integer.parseInt(input.substring(0, 1));
				p1.y = Integer.parseInt(input.substring(1, 2));
				Point p2 = new Point();
				p2.x = Integer.parseInt(input.substring(3, 4));
				p2.y = Integer.parseInt(input.substring(4));
				
				// MAKE A MOVE
				board.processMove(p1, p2);
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("Game cannot be started: " + e.getMessage());
		}
		System.out.println("Goodbye");
	}

	public Player getPlayer1() { return player1; }

	public void setPlayer1(Player player1) { this.player1 = player1; }

	public Player getPlayer2() { return player2; }

	public void setPlayer2(Player player2) { this.player2 = player2; }

	public Board getBoard() { return board;	}

	public void setBoard(Board board) { this.board = board; }
}
