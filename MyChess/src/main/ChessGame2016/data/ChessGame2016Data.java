package main.ChessGame2016.data;

import java.awt.Point;
import java.util.HashMap;

import main.ChessGame2016.myChessGame2016.ChessGame2016;
import main.ChessGame2016.myChessGame2016.GameManager;

public class ChessGame2016Data {
	
	private Player player1, player2;
	private Board board;
	public static int turn;
	
	public ChessGame2016Data() {
		player1 = new Player(1);
		player2 = new Player(2);
		board = new Board();
	}
	
	public ChessGame2016Data(Player p1, Player p2, Board b) {
		player1 = p1;
		player2 = p2;
		board = b;
	}
	
	public void initData() {
		board.initBoard();
		player1.initPlayer();
		player2.initPlayer();
	}
	
	// ONCE THE MOVE HAS BEEN VALIDATED
	// SET THE FIRST POSITION TO EMPTY, AND MOVE THE
	// PIECE FROM THE FIRST TO THE SECOND POSITION
		public void movePiece(Point p1, Point p2, ChessPiece piece) {
			
			// UPDATE THE BOARD
			Board.gameBoard[p2.x][p2.y] = Board.gameBoard[p1.x][p1.y];
			//board.gameBoard[p2.x][p2.y].setPosition(p2);
			Board.gameBoard[p1.x][p1.y] = new BoardSquare(new Point(p1.x, p1.y), true, null);;
			
			// UPDATE THE POSITION FOR THE PLAYER
			HashMap<Point, BoardSquare> map = ChessGame2016.chessManager.getCurrentPlayer().getPlayerPieces();
			map.put(p2, Board.gameBoard[p2.x][p2.y]);
			map.remove(p1);
			ChessGame2016.chessManager.getCurrentPlayer().setPlayerPieces(map);
			System.out.println(ChessGame2016.chessManager.getCurrentPlayer().getPlayerPieces().get(p2));
			
			// MOVE THE PIECE ON THE BOARD
			Board.gameBoard[p1.x][p1.y].setEmpty(true);
			Board.gameBoard[p1.x][p1.y].setPiece(null);

			Board.gameBoard[p2.x][p2.y].setEmpty(false);
			Board.gameBoard[p2.x][p2.y].setPiece(piece);
			
			// SWITCH TURNS
			ChessGame2016.chessManager.setNextTurn();
			
			// TESTING
			printChessBoard();
		}
	
	public boolean processMove(Point p1, Point p2, ChessPiece piece) {
		boolean result = false;
		if(!isMoveLegal(p1, p2, piece)) {
			System.out.println("Your move cannot be made. Please try again.\nPlayer "  + GameManager.turn + "'s turn: ");
		} else {
			movePiece(p1, p2, Board.gameBoard[p1.x][p1.y].getPiece());
			System.out.println("Player " + GameManager.turn + "'s turn: ");
			result = true;
		}
		
		return result;
	}
	
	public boolean isMoveLegal(Point p1, Point p2, ChessPiece piece)  {
		return piece.isMoveValid(p1, p2, new Integer(GameManager.turn));
	}
	
	// TESTING
		public void printChessBoard() {
			for (int i = 0; i < Board.MAX_ROWS; i++) {
				for (int j = 0; j < Board.MAX_COLS; j++) {
					ChessPiece piece = Board.gameBoard[i][j].getPiece();
					if (piece == null)
						System.out.print("0");
					else
						System.out.print(piece.getValue());
				}
				System.out.println();
			}
		}

}
