package main.ChessGame2016.data;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
	BOARD.JAVA
	THE BOARD CLASS WILL MAINTAIN THE STATE OF THE BOARD, I.E,
	THE STATE OF EACH SQUARE, THE PIECES AND THEIR POSITIONS.
	WHEN THE PLAYER MAKES A MOVE, IT HAS TO BE VALIDATED ACCORDING
	TO THE STATE OF THE BOARD BEFORE THE MOVE CAN BE DEEMED VALID.
 */

public class Board {

	// BOARD SIZE AND MAX NUMBER OF PIECES
	public static int MAX_COLS = 8;
	public static int MAX_ROWS = 8;
	public static int TOTAL_PIECES = 32;

	public static BoardSquare[][] gameBoard = new BoardSquare[MAX_ROWS][MAX_COLS];

	HashMap<Integer, Integer> pieceVals = new HashMap<>();
	List<Integer> list = new ArrayList<>();

	public Board() {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				gameBoard[i][j] = new BoardSquare();
			}
		}
	}

	public void initBoard() {
		for (int i = 0; i < MAX_ROWS; i++) {
			BoardSquare boardPiece = null;
			for (int j = 0; j < MAX_COLS; j++) {
				boardPiece = new BoardSquare(new Point(i, j), true, null);
				gameBoard[i][j] = boardPiece;
			}
		}
	}

	/*// ONCE THE MOVE HAS BEEN VALIDATED
	// SET THE FIRST POSITION TO EMPTY, AND MOVE THE
	// PIECE FROM THE FIRST TO THE SECOND POSITION
	public void movePiece(Point p1, Point p2, ChessPiece piece) {
		
		// UPDATE THE BOARD
		gameBoard[p2.x][p2.y] = gameBoard[p1.x][p1.y];
		//gameBoard[p2.x][p2.y].setPosition(p2);
		gameBoard[p1.x][p1.y] = new BoardSquare(new Point(p1.x, p1.y), true, null);;
		
		// UPDATE THE POSITION FOR THE PLAYER
		HashMap<Point, BoardSquare> map = ChessGame2016.chessManager.getCurrentPlayer().getPlayerPieces();
		// SOMETHING IS WRONG HERE
		//BoardSquare square = map.get(p1)
		map.put(p2, gameBoard[p2.x][p2.y]);
		map.remove(p1);
		ChessGame2016.chessManager.getCurrentPlayer().setPlayerPieces(map);
		System.out.println(ChessGame2016.chessManager.getCurrentPlayer().getPlayerPieces().get(p2));
		
		// MOVE THE PIECE ON THE BOARD
		gameBoard[p1.x][p1.y].setEmpty(true);
		gameBoard[p1.x][p1.y].setPiece(null);

		gameBoard[p2.x][p2.y].setEmpty(false);
		gameBoard[p2.x][p2.y].setPiece(piece);
		
		// SWITCH TURNS
		ChessGame2016.chessManager.setNextTurn();
		
		// TESTING
		printChessBoard();
		
	}
	
	// LOGIC FOR PROCESS MOVE - COMING SOON!
	public boolean processMove(Point p1, Point p2, ChessPiece piece) {
		boolean result = false;
		// ENSURE IT'S PLAYER(1||2)'S TURN, ENSURE THAT THE MOVE IS NOT ILLEGAL
		if(!isMoveLegal(p1, p2, piece)) {
			result = false;
			//System.out.println("Your move cannot be made. Please try again.\nPlayer "  + GameManager.turn + "'s turn: ");
		} else {
			movePiece(p1, p2, gameBoard[p1.x][p1.y].getPiece());
			result = true;
			//System.out.println("Player " + GameManager.turn + "'s turn: ");
		}
		return result;
	}

	public boolean isMoveLegal(Point p1, Point p2, ChessPiece piece)  {
		return piece.isMoveValid(p1, p2, new Integer(GameManager.turn));
	}*/

	public boolean isSquareEmpty(Point p) {
		return gameBoard[p.x][p.y].isEmpty();
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
}