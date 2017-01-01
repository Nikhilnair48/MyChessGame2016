package main.ChessGame2016.data;

import java.awt.Point;
import java.util.HashMap;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.ChessGame2016.handlers.CloseGameHandler;
import main.ChessGame2016.myChessGame2016.ChessGame2016;
import main.ChessGame2016.pieces.ChessPieceBishop;
import main.ChessGame2016.pieces.ChessPieceKing;
import main.ChessGame2016.pieces.ChessPieceKnight;
import main.ChessGame2016.pieces.ChessPiecePawn;
import main.ChessGame2016.pieces.ChessPieceQueen;
import main.ChessGame2016.pieces.ChessPieceRook;
import main.ChessGame2016.view.ChessGame2016View;

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
		addGuiButtons();
		
		/*if (turn == 1)
			System.out.println("Player 1's turn: ");
		else
			System.out.println("Player 2's turn: ");*/
	}
	
	public void addGuiButtons() {
		
		Image closeButton = new Image(Constants.baseImgDirectory + "/End_Game.png");
		ImageView imgV = new ImageView();
		imgV.setImage(closeButton);
		imgV.setFitWidth(160);
		imgV.setFitHeight(40);
		CloseGameHandler handler = new CloseGameHandler(imgV);
		imgV.addEventHandler(MouseEvent.ANY, handler);
		imgV.setX(800);
		imgV.setY(300);

		ChessGame2016.chessManager.getGuiButtons().put("GameScreen_End_Game", imgV);
	}
	
	// ONCE THE MOVE HAS BEEN VALIDATED
	// SET THE FIRST POSITION TO EMPTY, AND MOVE THE
	// PIECE FROM THE FIRST TO THE SECOND POSITION
	public void movePiece(Point p1, Point p2, ChessPiece piece) {
		
		// IF THE MOVE WAS INDEED AN ATTACK, MOVE THE VICTIM TO JAIL.
		if (!Board.gameBoard[p2.x][p2.y].isEmpty()) {
			System.out.println("DETECTED ATTACK IN THE DATA LAYER - 1");
			// POOR APPROACH, BUT THIS WILL RETRIEVE THE ID OF THE IMAGE VIEW OF THE PIECE TO BE ATTACKED
			String ID = Board.gameBoard[p2.x][p2.y].getPiece().getID();
			ImageView imgV = (ImageView) ChessGame2016.chessManager.getGuiButtons().get(ID);

			Point p = ChessGame2016.chessManager.getNextPlayer().getRemovedPlayerPieceCoordinate();
			System.out.println("point " + p + " piece ID " + ID);
			imgV.setX(p.x);
			imgV.setY(p.y);
			imgV.setFitWidth(imgV.getImage().getWidth()/2);
			
			ChessGame2016.chessManager.getGuiButtons().put(ID, imgV);
		}
		
		// UPDATE THE POSITION FOR THE PLAYER
		HashMap<Point, BoardSquare> map = getCurrentPlayer().getPlayerPieces();
		BoardSquare square = Board.gameBoard[p1.x][p1.y];
		square.setPosition(p2);
		map.put(p2, square);
		map.remove(p1);
		getCurrentPlayer().setPlayerPieces(map);
		
		// IF THE MOVE IS AN ATTACK
		if(!getCurrentPlayer().getPlayerPieces().containsKey(p1) && !Board.gameBoard[p2.x][p2.y].isEmpty()) {

			// MOVE THE PIECE THAT IS BEING ATTACKED FROM THE OPPOSTING PLAYERS' PIECES
			BoardSquare toBeRemoved = Board.gameBoard[p2.x][p2.y];
			ChessGame2016.chessManager.getNextPlayer().addToRemovedPieces(toBeRemoved.getPiece());
			ChessGame2016.chessManager.getNextPlayer().getPlayerPieces().remove(p2);
		}
		
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
