package data;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import myChessGame2016.ChessGame2016;
import myChessGame2016.GameManager;

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

	HashMap<Integer, Integer> pieceVals = new HashMap<>();
	List<Integer> list = new ArrayList<>();

	public Board() {

		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				gameBoard[i][j] = new BoardSquare();
			}
		}
	}

	public BoardSquare initializePiece(Point p, boolean isEmpty, int player, int value) {
		BoardSquare newPiece = new BoardSquare();;
		switch (value) {
		case PiecesAndValues.PAWN:
			newPiece = new BoardSquare(p, isEmpty, new ChessPiecePawn(player, value));
			break;
		case PiecesAndValues.ROOK:
			newPiece = new BoardSquare(p, isEmpty, new ChessPieceRook(player, value));
			break;
		case PiecesAndValues.KNIGHT:
			newPiece = new BoardSquare(p, isEmpty, new ChessPieceKnight(player, value));
			break;
		case PiecesAndValues.BISHOP:
			newPiece = new BoardSquare(p, isEmpty, new ChessPieceBishop(player, value));
			break;
		case PiecesAndValues.QUEEN:
			newPiece = new BoardSquare(p, isEmpty, new ChessPieceQueen(player, value));
			break;
		case PiecesAndValues.KING:
			newPiece = new BoardSquare(p, isEmpty, new ChessPieceKing(player, value));
			break;
		}
		
		return newPiece;
	}

	public void initBoard() {
		// READ THE INITIAL SETTING FROM THE FILE
		BufferedReader reader;

		Player player1 = ChessGame2016.chessManager.getPlayer1();
		Player player2 = ChessGame2016.chessManager.getPlayer2();

		HashMap<Point, BoardSquare> player1Pieces = new HashMap<>();
		HashMap<Point, BoardSquare> player2Pieces = new HashMap<>();

		try {
			reader = new BufferedReader(new FileReader("data/InitialGameBoard.txt"));
			for (int i = 0; i < MAX_ROWS; i++) {
				int pieceVal;
				BoardSquare newPiece = new BoardSquare();
				for (int j = 0; j < MAX_COLS; j++) {
					pieceVal = reader.read();

					if (i == 6 || i == 7) { // BLACK PIECES ARE AT ROWS 6 & 7
						//newPiece = new BoardSquare(new Point(i, j), false, new ChessPiece(2, pieceVal - 48));
						newPiece = initializePiece(new Point(i,j), false, 21, pieceVal - 48);
						player2Pieces.put(new Point(i, j), newPiece);
					} else if (i == 0 || i == 1) { // WHITE PIECES ARE AT ROWS 1 & 2
						//newPiece = new BoardSquare(new Point(i, j), false, new ChessPiece(1, pieceVal - 48));
						newPiece = initializePiece(new Point(i,j), false, 1, pieceVal - 48);
						player1Pieces.put(new Point(i, j), newPiece);
					} else { // ALL OTHER SQUARES ARE EMPTY
						newPiece = new BoardSquare(new Point(i, j), true, null);
					}
					gameBoard[i][j] = newPiece;
				}
				reader.read();
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException: " + e.getMessage());
		}

		player1.setPlayerPieces(player1Pieces);
		player2.setPlayerPieces(player2Pieces);

		ChessGame2016.chessManager.setPlayer1(player1);
		ChessGame2016.chessManager.setPlayer2(player2);
	}

	// ONCE THE MOVE HAS BEEN VALIDATED
	// SET THE FIRST POSITION TO EMPTY, AND MOIVE TO PIECE TO THE SECOND
	// POSITION
	public void movePiece(Point p1, Point p2, ChessPiece piece) {

		HashMap<Point, BoardSquare> map = ChessGame2016.chessManager.getCurrentPlayer().getPlayerPieces();
		map.put(p2, gameBoard[p1.x][p1.y]);
		map.put(p1, null);
		
		gameBoard[p1.x][p1.y].setEmpty(true);
		gameBoard[p1.x][p1.y].setPiece(null);

		gameBoard[p2.x][p2.y].setEmpty(false);
		gameBoard[p2.x][p2.y].setPiece(piece);
		
		ChessGame2016.chessManager.setNextTurn();

		printChessBoard();
	}

	// LOGIC FOR PROCESS MOVE - COMING SOON!
	public void processMove(Point p1, Point p2, Class<?> className) {
		// ENSURE IT'S PLAYER(1||2)'S TURN, ENSURE THAT THE MOVE IS NOT ILLEGAL
		
		if(!isMoveLegal(p1, p2, className)) 
			System.out.println("Your move cannot be made. Please try again.\n PLAYER + "  + GameManager.turn + "'s TURN: ");
		else {
			movePiece(p1, p2, gameBoard[p1.x][p1.y].getPiece());
			System.out.println("PLAYER " + GameManager.turn + "'s TURN: ");
		}
		
		/*if (GameManager.turn == 1) {
			if (!isMoveLegal(p1, p2, className))
				System.out.println("Your move cannot be made. Please try again.\n" + "PLAYER 1's TURN: ");
			else {
				GameManager.turn = 2;
				movePiece(p1, p2, gameBoard[p1.x][p1.y].getPiece());
				System.out.println("PLAYER 2's TURN: ");
			}
		} else {
			if (!isMoveLegal(p1, p2, className))
				System.out.println("Your move cannot be made. Please try again.\n" + "PLAYER 2's TURN: ");
			else {
				GameManager.turn = 1;
				movePiece(p1, p2, gameBoard[p1.x][p1.y].getPiece());
				System.out.println("PLAYER 1's TURN: ");
			}
		}*/
	}

	public boolean isMoveLegal(Point p1, Point p2, Class<?> className)  {
		boolean result = true;

		// ILLEGAL MOVE CASE 1 - IT'S THE THE GIVEN PLAYERS' PIECE; CASE 2 - THE
		// BOARDSQUARE IS OCCUPIED BY ANOTHER PIECE;
		// CASE 3 - ATTEMPT TO MOVE FROM AN EMPTY SQUARE (!)
		if (!ChessGame2016.chessManager.getCurrentPlayer().getPlayerPieces().containsKey(p1)
				|| gameBoard[p2.x][p2.y].getPiece() != null || gameBoard[p1.x][p1.y].isEmpty()) {
			result = false;
		} else {

			//BoardSquare sq = gameBoard[p1.x][p1.y];
	
			try {
				// CALL THE 'isMoveValid' METHOD ON THE APPROPRIATE CHESS PIECE THAT IS TO BE MOVED
				Method method = className.getMethod("isMoveValid", Point.class, Point.class, Integer.class);
				
				try {
					
					// WE NEED A NEW INSTANCE OF CLASSNAME, ELSE WE CANNOT ACCESS THE METHODS (STATIC ONES MAY STILL BE ACCESSED) 
					method.invoke(className.newInstance(), p1,  p2, new Integer(GameManager.turn));
					
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				}
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
		
		return result;
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