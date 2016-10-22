package main.ChessGame2016.data;

import java.awt.Point;
import java.util.HashMap;

import main.ChessGame2016.myChessGame2016.ChessGame2016;
import main.ChessGame2016.pieces.ChessPieceBishop;
import main.ChessGame2016.pieces.ChessPieceKing;
import main.ChessGame2016.pieces.ChessPieceKnight;
import main.ChessGame2016.pieces.ChessPiecePawn;
import main.ChessGame2016.pieces.ChessPieceQueen;
import main.ChessGame2016.pieces.ChessPieceRook;

public class ChessGame2016Data {
	
	private Player player1, player2;
	private Board board;
	public static int turn;
	
	public ChessGame2016Data() {
		player1 = new Player(1);
		player2 = new Player(2);
		board = new Board();
		turn = 1;
	}
	
	public ChessGame2016Data(Player p1, Player p2, Board b) {
		player1 = p1;
		player2 = p2;
		board = b;
		turn = 1;
	}
	
	public void initData() {
		board.initBoard();
		player1.initPlayer();
		player2.initPlayer();
		
		/*if (turn == 1)
			System.out.println("Player 1's turn: ");
		else
			System.out.println("Player 2's turn: ");*/
	}
	
	// ONCE THE MOVE HAS BEEN VALIDATED
	// SET THE FIRST POSITION TO EMPTY, AND MOVE THE
	// PIECE FROM THE FIRST TO THE SECOND POSITION
	public void movePiece(Point p1, Point p2, ChessPiece piece) {
		
		// UPDATE THE BOARD
		/*Board.gameBoard[p2.x][p2.y] = Board.gameBoard[p1.x][p1.y];
		//board.gameBoard[p2.x][p2.y].setPosition(p2);
		Board.gameBoard[p1.x][p1.y].setPiece(null);
		//Board.gameBoard[p1.x][p1.y] = new BoardSquare(new Point(p1.x, p1.y), true, null);
		*/
		// UPDATE THE POSITION FOR THE PLAYER
		Player player = this.getCurrentPlayer();
		HashMap<Point, BoardSquare> map = player.getPlayerPieces();
		BoardSquare square = Board.gameBoard[p1.x][p1.y];
		square.setPosition(p2);
		map.put(p2, square);
		map.remove(p1);
		player.setPlayerPieces(map);
		//System.out.println(player.getPlayerPieces().get(p2));
		
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
			System.out.println("Your move cannot be made. Please try again.\nPlayer "  + turn + "'s turn: ");
		} else {
			movePiece(new Point(p1.x, p1.y), new Point(p2.x, p2.y), Board.gameBoard[p1.x][p1.y].getPiece());
			System.out.println("Player " + turn + "'s turn: ");
			result = true;
		}
		
		return result;
	}
	
	public boolean isMoveLegal(Point p1, Point p2, ChessPiece piece)  {
		return piece.isMoveValid(p1, p2, new Integer(turn));
	}
	
	public boolean move(Point p1, Point p2) {
		
		boolean result = false;
		
		// TIP TO IMPROVE -- CHECK IF THE PIECE BELONGS TO THE PLAYER HERE, SO WE DON'T HAVE TO CHECK THAT ON THE BOARD 
		// IN PROCESSMOVE/ISMOVELEGAL
		Player player = this.getCurrentPlayer();
		HashMap<Point, BoardSquare> playerPieces = player.getPlayerPieces();
		
		// SQUARE CONTAINING PIECE 1 HAS TO BE OCCUPIED
		// PIECE 1 MUST BELONG TO THE CURRENT PLAYER
		// SQUARE CONTAINING PIECE 2 CANNOT BELONG TO CURRENT PLAYER
		if(Board.gameBoard[p1.x][p1.y].getPiece() != null && playerPieces.containsKey(p1) 
				&& !playerPieces.containsKey(p2)) {
			ChessPiece chessPiece = getPieceClass(Board.gameBoard[p1.x][p1.y].getPiece());
			result = processMove(p1, p2, chessPiece);
		} else {
			result = false;
			System.out.println("Invalid move. Please try again.");
		}
		return result;
	}
	
	public ChessPiece getPieceClass(ChessPiece piece) {
		
		int value = piece.getValue();
		ChessPiece pieceClass = null;
		switch (value) {
		case 1:
			pieceClass = (ChessPiecePawn)piece;
			break;
		case 2:
			//KNIGHT
			pieceClass = (ChessPieceKnight)piece;
			break;
		case 3:
			//BISHOP
			pieceClass = (ChessPieceBishop)piece;
			break;
		case 4:
			//ROOK
			pieceClass = (ChessPieceRook)piece;
			break;
		case 5:
			//KING
			pieceClass = (ChessPieceKing)piece;
			break;
		case 6:
			//QUEEN
			pieceClass = (ChessPieceQueen)piece;
			break;
		}
		return pieceClass;
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
	
	public Player getPlayer1() { return player1; }

	public void setPlayer1(Player player1) { this.player1 = player1; }

	public Player getPlayer2() { return player2; }

	public void setPlayer2(Player player2) { this.player2 = player2; }

	public Board getBoard() { return board;	}

	public void setBoard(Board board) { this.board = board; }
	
	// RETURN THE APPROPRIATE PLAYER DEPENDING ON THE REQUIREMENT (I.E, INT)
	public Player getCurrentPlayer() { return (turn == 1) ? player1 : player2; }
	
	public Player getNextPlayer() { return (turn == 1) ? player2 : player1; }
	
	public void setNextTurn() { if(turn == 1) turn = 2; else turn = 1; }

}
