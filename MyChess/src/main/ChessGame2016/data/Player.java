package main.ChessGame2016.data;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.image.ImageView;
import main.ChessGame2016.myChessGame2016.ChessGame2016;
import main.ChessGame2016.pieces.ChessPieceBishop;
import main.ChessGame2016.pieces.ChessPieceKing;
import main.ChessGame2016.pieces.ChessPieceKnight;
import main.ChessGame2016.pieces.ChessPiecePawn;
import main.ChessGame2016.pieces.ChessPieceQueen;
import main.ChessGame2016.pieces.ChessPieceRook;
import main.ChessGame2016.view.ChessGame2016View;

/*
 	PLAYER.JAVA
 	THE PLAYER CLASS IS A WORK IN PROGRESS. CHECK BACK LATER FOR MORE!
 */


/* WHY DOES THE PLAYER NEED THE PIECES?
 IF THE PIECES ARE ON THE BOARD, WE'LL NEED AN ADDITIONAL ATTRIBUTE
 TO INFORM US WHETHER THE PIECE BELONGS TO THE WHITE OR BLACK SIDE;
 BUT THE PLAYER ALREADY BELONGS TO WHITE/BLACK, SO IT'S EASIER TO 
 IDENTIFY THE PIECES
 */
public class Player {
	
	private int color;	// 1 FOR WHITE, 2 FOR BLACK
	
	// THIS SHOULD LIKELY BE A CLASS BY ITSELF
	private int numWins;
	private int numLosses;
	private int totalGames;
	
	private HashMap<Point, BoardSquare> playerPieces;
	private ArrayList<ChessPiece> removedPieces;
	
	private final String player1File = "data/player1StartingPos.txt";
	private final String player2File = "data/player2StartingPos.txt";
	
	public Player() {
		numWins = numLosses = totalGames = 0;
		playerPieces = new HashMap<>();
		removedPieces = new ArrayList<>();
	}
	
	public Player(int nColor, int wins, int losses, int totalG, HashMap<Point, BoardSquare> pPieces) {
		color = nColor;
		numWins = wins;
		numLosses = losses;
		totalGames = totalG;
		if (pPieces != null) {
			playerPieces = pPieces;
		} else {
			playerPieces = new HashMap<>();
		}
		removedPieces = new ArrayList<>();
	}
	
	public Player(int c) {
		color = c;
		numWins = numLosses = totalGames = 0;
		playerPieces = new HashMap<>();
		removedPieces = new ArrayList<>();
	}
	
	public void move(Point p1, Point p2) throws ClassNotFoundException {
		
		// TIP TO IMPROVE -- CHECK IF THE PIECE BELONGS TO THE PLAYER HERE, SO WE DON'T HAVE TO CHECK THAT ON THE BOARD 
		// IN PROCESSMOVE/ISMOVELEGAL
		
		// SQUARE CONTAINING PIECE 1 HAS TO BE OCCUPIED
		// PIECE 1 MUST BELONG TO THE CURRENT PLAYER
		// SQUARE CONTAINING PIECE 2 CANNOT BELONG TO CURRENT PLAYER
		if(Board.gameBoard[p1.x][p1.y].getPiece() != null && playerPieces.containsKey(p1) 
				&& !playerPieces.containsKey(p2)) {
			ChessPiece chessPiece = getPieceClass(Board.gameBoard[p1.x][p1.y].getPiece());
			ChessGame2016.chessManager.getBoard().processMove(p1, p2, chessPiece);
		} else {
			System.out.println("Invalid move. Please try again.");
		}
	}
	
	public ChessPiece getPieceClass(ChessPiece piece) throws ClassNotFoundException {
		
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
	
	public void initPlayer() {
		if(color == 1) {
			// READ FROM TXT FILE FOR WHITE
			addChessPieces(1);
		} else {
			// READ FROM TXT FILE FOR BLACK
			addChessPieces(2);
		}
	}
	
	/* BEFORE THE GAME BEGINS, THE CHESS PIECES ARE ASSIGNED TO THE APPROPRIATE PLAYER ON BOTH SIDES */
	private void addChessPieces(int player) {
		// READ THE INITIAL SETTING FROM THE FILE
		BufferedReader reader;
		
		try {
			if (player == 1)
				reader = new BufferedReader(new FileReader(player1File));
			else 
				reader = new BufferedReader(new FileReader(player2File));
			
			for (int i = 0; i < 1; i++) {
				// READ THE BOARD PIECE ON LINE 1, AND VALUES ON LINE 2
				BoardSquare newPiece = new BoardSquare();
				String pieces = reader.readLine();
				String values = reader.readLine();
				
				String[] coordinatesAsString = pieces.split(";");
				String[] valuesForPieces = values.split(";");
				int j = 0;
				for(String str : coordinatesAsString) {
					int x = str.charAt(1)-48;
					int y = str.charAt(3)-48;
					int value = Integer.parseInt(valuesForPieces[j]);
					
					Point p = new Point(x, y);
					if(x == 0 || x == 7) {
						switch (value) {
						case Constants.PAWN:
							newPiece = new BoardSquare(p, false, 
									new ChessPiecePawn(player, value, 
											(ImageView) ChessGame2016View.guiButtons.get(player+"PAWN"), "test"));
							break;
						case Constants.ROOK:
							newPiece = new BoardSquare(p, false, 
									new ChessPieceRook(player, value,
											(ImageView) ChessGame2016View.guiButtons.get(player+"ROOK"), "test"));
							break;
						case Constants.KNIGHT:
							newPiece = new BoardSquare(p, false, 
									new ChessPieceKnight(player, value,
											(ImageView) ChessGame2016View.guiButtons.get(player+"KNIGHT"), "test"));
							break;
						case Constants.BISHOP:
							newPiece = new BoardSquare(p, false, 
									new ChessPieceBishop(player, value,
											(ImageView) ChessGame2016View.guiButtons.get(player+"BISHOP"), "test"));
							break;
						case Constants.QUEEN:
							newPiece = new BoardSquare(p, false, 
									new ChessPieceQueen(player, value,
											(ImageView) ChessGame2016View.guiButtons.get(player+"QUEEN"), "test"));
							break;
						case Constants.KING:
							newPiece = new BoardSquare(p, false, 
									new ChessPieceKing(player, value,
											(ImageView) ChessGame2016View.guiButtons.get(player+"KING"), "test"));
							break;
						}
					} else
						newPiece = new BoardSquare(p, false, 
								new ChessPiecePawn(player, Constants.PAWN,
										(ImageView) ChessGame2016View.guiButtons.get(player+"PAWNS"), "test"));	// PAWNS
					
					playerPieces.put(p, newPiece);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException: " + e.getMessage());
		}
	}
	
	public int getColor() { return color; }

	public void setColor(int color) { this.color = color; }

	public int getNumWins() { return numWins; }

	public void setNumWins(int numWins) { this.numWins = numWins; }

	public int getNumLosses() { return numLosses; }

	public void setNumLosses(int numLosses) { this.numLosses = numLosses; }

	public int getTotalGames() { return totalGames;	}

	public void setTotalGames(int totalGames) { this.totalGames = totalGames; }

	public HashMap<Point, BoardSquare> getPlayerPieces() { return playerPieces; }

	public void setPlayerPieces(HashMap<Point, BoardSquare> playerPieces) { this.playerPieces = playerPieces; }

	public ArrayList<ChessPiece> getRemovedPieces() { return removedPieces; }

	public void setRemovedPieces(ArrayList<ChessPiece> removedPieces) { this.removedPieces = removedPieces; }
	
	public void addToRemovedPieces(ChessPiece piece) {
		piece.setOnBoard(0);	// UPDATE THE VALUE TO REFLECT THE CURRENT STATE OF THE PIECE
		this.removedPieces.add(piece); 
	}
	
	/* TESTING PURPOSES */
	public void addChessPiece(Point p, BoardSquare sq) {
		playerPieces.put(p, sq);
	}
	
	public void movieAPiece(Point pointFrom, Point pointTo) {
		BoardSquare square = playerPieces.get(pointFrom);
		square.setPosition(pointTo);
		ChessGame2016.chessManager.getBoard().printChessBoard();
	}

}