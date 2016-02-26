package data;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
	BOARD.JAVA
	THE BOARD CLASS WILL MAINTAIN THE STATE OF THE BOARD, I.E,
	THE STATE OF EACH SQUARE, THE PIECES AND THEIR POSITIONS.
	WHEN THE PLAYER MAKES A MOVE, IT HAS TO BE VALIDATED ACCORDING
	TO THE STATE OF THE BOARD BEFORE THE MOVE CAN BE DEEMED MADE.
 */

public class Board {

	// SIZE OF THE BOARD, AND THE GAME BOARD
	public static int MAX_COLS = 8;
	public static int MAX_ROWS = 8;
	public static int TOTAL_PIECES = 32;

	public static BoardSquare[][] gameBoard = new BoardSquare[MAX_ROWS][MAX_COLS];
	private int whoseMove; // WHO WILL MOVE NEXT? BLACK OR WHITE? 1 FOR WHITE, 2 FOR BLACK

	HashMap<Integer, Integer> pieceVals = new HashMap<>();
	List<Integer> list = new ArrayList<>();

	public Board() {
		whoseMove = 1;

		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				gameBoard[i][j] = new BoardSquare();
			}
		}
	}

	public void initBoard() {
		// READ THE INITIAL SETTING FROM THE FILE
		BufferedReader reader;
		int blackOrWhite = 1; // READ IN THE WHITE PIECES FIRST
		try {
			reader = new BufferedReader(new FileReader(
					"data/InitialGameBoard.txt"));
			for (int i = 0; i < MAX_ROWS; i++) {
				int pieceVal;
				BoardSquare newPiece = new BoardSquare();
				for (int j = 0; j < MAX_COLS; j++) {
					pieceVal = reader.read();

					if (i == 6 || i == 7)
						blackOrWhite = 2;
					else if (i == 0 || i == 1)
						blackOrWhite = 1;
					else
						blackOrWhite = 0;

					// IF THE SQUARE IS NOT EMPTY, THEN WE HAVE
					if (blackOrWhite == 1)
						newPiece = new BoardSquare(new Point(i, j), true,
								new ChessPiece(1, pieceVal - 48));
					else if (blackOrWhite == 2)
						newPiece = new BoardSquare(new Point(i, j), true,
								new ChessPiece(2, pieceVal - 48));
					else
						newPiece = new BoardSquare(new Point(i, j), false, null);

					gameBoard[i][j] = newPiece;
				}
				reader.read();
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException: " + e.getMessage());
		}
	}

	// ONCE THE MOVE HAS BEEN VALIDATED
	// SET THE FIRST POSITION TO EMPTY, AND MOIVE TO PIECE TO THE SECONT
	// POSITION
	public void movePiece(Point p1, Point p2, ChessPiece piece) {
		gameBoard[p1.x][p1.y].setEmpty(true);
		gameBoard[p1.x][p1.y].setPiece(null);

		gameBoard[p2.x][p2.y].setEmpty(false);
		gameBoard[p2.x][p2.y].setPiece(piece);

		printChessBoard();
	}

	// TESTING
	public void printChessBoard() {
		for (int i = 0; i < MAX_ROWS; i++) {
			for (int j = 0; j < MAX_COLS; j++) {
				ChessPiece piece = gameBoard[i][j].getPiece();
				if (piece == null)
					System.out.print("0");
				else
					System.out.print(piece.getValue());
			}
			System.out.println();
		}
	}

	// LOGIC FOR PROCESS MOVE - COMING SOON!
	public void processMove(Point p1, Point p2) {
		movePiece(p1, p2, gameBoard[p1.x][p1.y].getPiece());
		if (whoseMove == 1) {
			whoseMove = 2;
			System.out.println("PLAYER 2's TURN: ");
		} else {
			whoseMove = 1;
			System.out.println("PLAYER 1's TURN: ");
		}
		// } else {
		// System.out.println("That move cannot be processed");
		// }
	}
}