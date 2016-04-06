package data;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import myChessGame2016.ChessGame2016;

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
	private HashMap<Point, BoardSquare> removedPieces;
	
	private final String player1File = "data/player1StartingPos.txt";
	private final String player2File = "data/player2StartingPos.txt";
	
	public Player() {
		numWins = numLosses = totalGames = 0;
		playerPieces = new HashMap<>();
		removedPieces = new HashMap<>();
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
		removedPieces = new HashMap<>();
	}
	
	public Player(int c) {
		color = c;
		numWins = numLosses = totalGames = 0;
		playerPieces = new HashMap<>();
		removedPieces = new HashMap<>();
	}
	
	public void move(Point p1, Point p2) throws ClassNotFoundException {
		//System.out.println("here "+playerPieces.get(new Point(p1.x, p1.y)));
		
		// TIP TO IMPROVE -- CHECK IF THE PIECE BELONGS TO THE PLAYER HERE, SO WE DON'T HAVE TO CHECK THAT ON THE BOARD 
		// IN PROCESSMOVE/ISMOVELEGAL
		if(Board.gameBoard[p1.x][p1.y].getPiece() != null) {
			Class<?> className = getPieceClass(Board.gameBoard[p1.x][p1.y].getPiece().getValue());
			ChessGame2016.chessManager.getBoard().processMove(p1, p2, className);
		} else {
			System.out.println("Invalid move. Please try again.");
		}
	}
	
	public Class<?> getPieceClass(int value) throws ClassNotFoundException {

		Class<?> pieceClass = null;
		switch (value) {
		case 1:
			pieceClass = Class.forName("data.ChessPiecePawn");
			break;
		case 2:
			//KNIGHT
			break;
		case 3:
			//BISHOP
			break;
		case 4:
			//ROOK
			break;
		case 5:
			//KING
			break;
		case 6:
			//QUEEN
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
	public void addChessPieces(int player) {
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
						switch(value) {
							case PiecesAndValues.ROOK:
								newPiece = new BoardSquare(p, false, new ChessPieceRook(player, value));
								break;
							case PiecesAndValues.KNIGHT:
								newPiece = new BoardSquare(p, false, new ChessPieceKnight(player, value));
								break;
							case PiecesAndValues.BISHOP:
								newPiece = new BoardSquare(p, false, new ChessPieceBishop(player, value));
								break;
							case PiecesAndValues.QUEEN:
								newPiece = new BoardSquare(p, false, new ChessPieceQueen(player, value));
								break;
							case PiecesAndValues.KING:
								newPiece = new BoardSquare(p, false, new ChessPieceKing(player, value));
								break;								
						}
					} else
						newPiece = new BoardSquare(p, false, new ChessPiecePawn(player, PiecesAndValues.PAWN));	// PAWNS
					
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

	public HashMap<Point, BoardSquare> getRemovedPieces() { return removedPieces; }

	public void setRemovedPieces(HashMap<Point, BoardSquare> removedPieces) { this.removedPieces = removedPieces; }

}