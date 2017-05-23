package main.ChessGame2016.data;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import util.ChessGame2016Properties;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.ChessGame2016.handlers.BishopHandler;
import main.ChessGame2016.handlers.KingHandler;
import main.ChessGame2016.handlers.KnightHandler;
import main.ChessGame2016.handlers.PawnHandler;
import main.ChessGame2016.handlers.QueenHandler;
import main.ChessGame2016.handlers.RookHandler;
import main.ChessGame2016.myChessGame2016.ChessGame2016;
import main.ChessGame2016.pieces.ChessPieceBishop;
import main.ChessGame2016.pieces.ChessPieceFactory;
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
		
		readPlayerFiles(player1, ChessGame2016Properties.getProperty("player1StartingPos"), Constants.CHESSPIECE_PLAYER_1_PREFIX);
		readPlayerFiles(player2, ChessGame2016Properties.getProperty("player2StartingPos"), Constants.CHESSPIECE_PLAYER_2_PREFIX);
		
		System.out.println("guibuttons: ");
		//ChessGame2016.chessManager.getGuiButtons().forEach((k, v)->System.out.println("key " + k));
	}
	
	private void readPlayerFiles(Player player, String playerFile, String playerKey) {
		BufferedReader reader;
		List<String> playerFileLines = null;
		try {	
			reader = new BufferedReader(new FileReader(playerFile));
			
			playerFileLines = new ArrayList<String>();
			String line = "";
			while((line = reader.readLine()) != null) {
				playerFileLines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		addPlayerPieces(player, playerFileLines, playerKey);
	}

	private void addPlayerPieces(Player player, List<String> playerData, String playerKey) {
		for(String pieceData : playerData) {
			ChessPiece newPiece = null;
			String[] data = pieceData.split(";");		// INDEX 0 PROVIDES THE COORDINATE ON THE BOARD, 1 PROVIDES THE VALUE OF THE PIECE 
			
			int x = Integer.parseInt(data[0].split(",")[0]);
			int y = Integer.parseInt(data[0].split(",")[1]);
			int value = Integer.parseInt(data[1]);
			Point point = new Point(x, y);			// USE THIS TO INSERT THE PIECE ON THE BOARD AND INIT THE BOARD
			String pieceKey = "";
			ImageView imgV = null;
			switch(value) {
				case Constants.ROOK:
					pieceKey = playerKey + Constants.CHESSPIECE_ROOK + Constants.CHESSPIECE_SUFFIX_1;
					imgV = loadImageViewForPlayer(point, ChessGame2016Properties.getProperty(playerKey + Constants.CHESSPIECE_ROOK));
					while(player.getPlayerPieces().containsKey(pieceKey)) {
						ChessPiece piece = player.getPlayerPieces().get(pieceKey);
						pieceKey = playerKey + Constants.CHESSPIECE_ROOK + Constants.CHESSPIECE_DIVIDER + ((Integer.parseInt(piece.getSuffixOfID()) + 1) );
					}
					newPiece = new ChessPieceRook(player.getColor(), value,
							imgV, pieceKey);
					RookHandler rHandler = new RookHandler(newPiece);
					imgV.addEventHandler(MouseEvent.ANY, rHandler);
					break;
				case Constants.KNIGHT:
					pieceKey = playerKey + Constants.CHESSPIECE_KNIGHT + Constants.CHESSPIECE_SUFFIX_1;
					imgV = loadImageViewForPlayer(point, ChessGame2016Properties.getProperty(playerKey + Constants.CHESSPIECE_KNIGHT));
					while(player.getPlayerPieces().containsKey(pieceKey)) {
						ChessPiece piece = player.getPlayerPieces().get(pieceKey);
						pieceKey = playerKey + Constants.CHESSPIECE_KNIGHT + Constants.CHESSPIECE_DIVIDER + ((Integer.parseInt(piece.getSuffixOfID()) + 1) );
					}
					newPiece = new ChessPieceKnight(player.getColor(), value,
									imgV, pieceKey);
					KnightHandler kHandler = new KnightHandler(newPiece);
					imgV.addEventHandler(MouseEvent.ANY, kHandler);
					break;
				case Constants.BISHOP:
					pieceKey = playerKey + Constants.CHESSPIECE_BISHOP + Constants.CHESSPIECE_SUFFIX_1;
					imgV = loadImageViewForPlayer(point, ChessGame2016Properties.getProperty(playerKey + Constants.CHESSPIECE_BISHOP));
					while(player.getPlayerPieces().containsKey(pieceKey)) {
						ChessPiece piece = player.getPlayerPieces().get(pieceKey);
						pieceKey = playerKey + Constants.CHESSPIECE_BISHOP + Constants.CHESSPIECE_DIVIDER + ((Integer.parseInt(piece.getSuffixOfID()) + 1) );
					}
					newPiece = new ChessPieceBishop(player.getColor(), value,
									imgV, pieceKey);
					BishopHandler bHandler = new BishopHandler(newPiece);
					imgV.addEventHandler(MouseEvent.ANY, bHandler);
					break;
				case Constants.QUEEN:
					pieceKey = playerKey + Constants.CHESSPIECE_QUEEN + Constants.CHESSPIECE_SUFFIX_1;
					imgV = loadImageViewForPlayer(point, ChessGame2016Properties.getProperty(playerKey + Constants.CHESSPIECE_QUEEN));
					newPiece = new ChessPieceQueen(player.getColor(), value,
									imgV, pieceKey);
					QueenHandler qHandler = new QueenHandler(newPiece);
					imgV.addEventHandler(MouseEvent.ANY, qHandler);
					break;
				case Constants.KING:
					pieceKey = playerKey + Constants.CHESSPIECE_KING + Constants.CHESSPIECE_SUFFIX_1;
					imgV = loadImageViewForPlayer(point, ChessGame2016Properties.getProperty(playerKey + Constants.CHESSPIECE_KING));
					newPiece = new ChessPieceKing(player.getColor(), value,
									imgV, pieceKey);
					KingHandler kiHandler = new KingHandler(newPiece);
					imgV.addEventHandler(MouseEvent.ANY, kiHandler);
					break;
				case Constants.PAWN:
					pieceKey = playerKey + Constants.CHESSPIECE_PAWN + Constants.CHESSPIECE_SUFFIX_1;
					imgV = loadImageViewForPlayer(point, ChessGame2016Properties.getProperty(playerKey + Constants.CHESSPIECE_PAWN));
					while(player.getPlayerPieces().containsKey(pieceKey)) {
						ChessPiece piece = player.getPlayerPieces().get(pieceKey);
						pieceKey = playerKey + Constants.CHESSPIECE_PAWN + Constants.CHESSPIECE_DIVIDER + ((Integer.parseInt(piece.getSuffixOfID()) + 1) );
					}
					newPiece = new ChessPiecePawn(player.getColor(), value,
									imgV, pieceKey);
					PawnHandler pHandler = new PawnHandler(newPiece);
					imgV.addEventHandler(MouseEvent.ANY, pHandler);
					break;
			}
			player.getPlayerPieces().put(pieceKey, newPiece);
			ChessGame2016.chessManager.getBoard().setPieceOnBoard(point, newPiece);	// LOAD THE PIECE ON THE GAME BOARD
			ChessGame2016.chessManager.addGuiButton(pieceKey, imgV);
		}
		
		if(player.getColor() == 1)
			player1 = player;
		else
			player2 = player;
	}
	
	public ImageView loadImageViewForPlayer(Point point, String path) {
		Image img = new Image(path); 
		ImageView imgV = new ImageView(img);
		imgV.setX(point.getY() * 100);
		imgV.setY(point.getX() * 100);
		imgV.setFitHeight(Constants.CHESSPIECE_HEIGHT);
		imgV.setFitWidth(Constants.CHESSPIECE_WIDTH);
		imgV.setPreserveRatio(true);
		
		return imgV;
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
		BoardSquare square = Board.gameBoard[p1.x][p1.y];
		// UPGRADE PAWN TO QUEEN -- ROUGHLY COMPLETE
		if(piece.getValue() == Constants.PAWN && p2.x == Constants.MAX_COLS-1) {
			
			// GET THE KEYS FOR THE PIECE TO BE REMOVED FROM THE OTHER PLAYER
			// AND GENERATE THE UNIQUE ID FOR THE NEW QUEEN FOR THE CURRENT PLAYER
			String pieceToRemove = piece.getID();
			String pieceKey = "1_queen_1";
			piece = getCurrentPlayer().getPlayerPieces().get("1_queen_1");
			if(piece != null) {
				while(getCurrentPlayer().getPlayerPieces().containsKey(pieceKey)) {
					piece = getCurrentPlayer().getPlayerPieces().get(piece.getID());
					pieceKey = getCurrentPlayer().getPlayerPieces().get(piece.getID()).getPrefixOfID() + Constants.CHESSPIECE_DIVIDER
							+ Constants.CHESSPIECE_QUEEN + Constants.CHESSPIECE_DIVIDER + ((Integer.parseInt(piece.getSuffixOfID()) + 1) );
				}
			}
			
			ImageView imgV = loadImageViewForPlayer(p2, ChessGame2016Properties.getProperty(piece.getPrefixOfID() + Constants.CHESSPIECE_DIVIDER + Constants.CHESSPIECE_QUEEN));
			piece = new ChessPieceQueen(getCurrentPlayer().getColor(), Constants.QUEEN, imgV, pieceKey);
			QueenHandler handler = new QueenHandler(piece);
			piece.getImageView().addEventFilter(MouseEvent.ANY, handler);
			System.out.println("UPGRADE PAWN TO QUEEN with new ID " + pieceKey);

			// UPDATE PLAYER PIECES
			getCurrentPlayer().getPlayerPieces().remove(pieceToRemove);
			getCurrentPlayer().getPlayerPieces().put(piece.getID(), piece);
			
			// REMOVE PAWN FROM VIEW, ADD QUEEN TO VIEW
			ChessGame2016View.keysOfIDsToBeRemoved.push(square.getPiece().getImageView());
			ChessGame2016View.keysOfIDsToBeAdded.push(piece.getImageView());
			
			ChessGame2016.chessManager.getGuiButtons().put(pieceKey, piece.getImageView());
		}
		
		// IF THE MOVE IS AN ATTACK
		if(!getCurrentPlayer().getPlayerPieces().containsKey(p1) && !Board.gameBoard[p2.x][p2.y].isEmpty()) {

			// MOVE THE PIECE THAT IS BEING ATTACKED FROM THE OPPOSTING PLAYERS' PIECES
			BoardSquare toBeRemoved = Board.gameBoard[p2.x][p2.y];
			ChessGame2016.chessManager.getNextPlayer().addToRemovedPieces(toBeRemoved.getPiece());
			ChessGame2016.chessManager.getNextPlayer().getPlayerPieces().remove(toBeRemoved.getPiece().getID());
		}
		
		// MOVE THE PIECE ON THE BOARD
		Board.gameBoard[p1.x][p1.y].setEmpty(true);
		Board.gameBoard[p1.x][p1.y].setPiece(null);

		Board.gameBoard[p2.x][p2.y].setEmpty(false);
		Board.gameBoard[p2.x][p2.y].setPiece(piece);

		checkForCheck();
		
		// SWITCH TURNS
		ChessGame2016.chessManager.setNextTurn();
		
		// TESTING
		printChessBoard();
	}
	
	// HAS THE NEWLY MADE MOVE PUT THE OTHER PLAYERS' KING IN DANGER? 
	public void checkForCheck() {
		String key = "";
		if(turn == 1) key = "2_king_1";
		else key = "1_king_1";
		
		Player nextPlayer = ChessGame2016.chessManager.getNextPlayer();
		ChessPiece king = nextPlayer.getPlayerPieces().get(key);
		BoardSquare square = board.getBoardSquareWithKey(king.getID());
		Point point = square.getPosition();		// POINT WILL BE REQUIRED LATER TO GENERATE POSSIBLE MOVES
		System.out.println("GENERATING MOVES FOR KING: ");
		king.generatePossibleMoves(point, new Point(point.x, point.y+1));
		
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
		HashMap<String, ChessPiece> playerPieces = player.getPlayerPieces();
		ChessPiece piece_1 = Board.gameBoard[p1.x][p1.y].getPiece();
		ChessPiece piece_2 = Board.gameBoard[p2.x][p2.y].getPiece();
		
		// SQUARE CONTAINING PIECE 1 HAS TO BE OCCUPIED
		// PIECE 1 MUST BELONG TO THE CURRENT PLAYER
		// SQUARE CONTAINING PIECE 2 CANNOT BELONG TO CURRENT PLAYER
		if(piece_1 != null && playerPieces.containsKey(piece_1.getID()) 
				&& (piece_2 == null || !playerPieces.containsKey(piece_2.getID()))) {
			result = processMove(p1, p2, piece_1);
		} else {
			result = false;
			System.out.println("Invalid move. Please try again.");
		}
		return result;
	}
	
	// TESTING
	public void printChessBoard() {
		for (int i = 0; i < Constants.MAX_ROWS; i++) {
			for (int j = 0; j < Constants.MAX_COLS; j++) {
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
