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
import main.ChessGame2016.pieces.ChessPieceFactory;
import main.ChessGame2016.pieces.ChessPieceKing;
import main.ChessGame2016.pieces.ChessPieceKnight;
import main.ChessGame2016.pieces.ChessPiecePawn;
import main.ChessGame2016.pieces.ChessPieceQueen;
import main.ChessGame2016.pieces.ChessPieceRook;

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
	
	public void initPlayer() {
		ChessPieceFactory factory = new ChessPieceFactory();
		if(color == 1) {
			// READ FROM TXT FILE FOR WHITE
			ChessGame2016.chessManager.addGuiButtons(factory.createPieceForAPlayer(Constants.CHESSPIECE_PLAYER_1_PREFIX, color, Constants.playerOneDirectory));
			addChessPieces(1);
		} else {
			// READ FROM TXT FILE FOR BLACK
			ChessGame2016.chessManager.addGuiButtons(factory.createPieceForAPlayer(Constants.CHESSPIECE_PLAYER_2_PREFIX, color, Constants.playerTwoDirectory));
			addChessPieces(2);
		}
	}
	
	public String getPieceKey(String playerWho, int val) {
		return playerWho + Constants.CHESSPIECE_PAWN + "_" + val;
	}
	
	/* BEFORE THE GAME BEGINS, THE CHESS PIECES ARE ASSIGNED TO THE APPROPRIATE PLAYER ON BOTH SIDES */
	private void addChessPieces(int player) {
		// READ THE INITIAL SETTING FROM THE FILE
		BufferedReader reader;
		String playerWho = "";
		try {
			if (player == 1) {
				reader = new BufferedReader(new FileReader(player1File));
				playerWho = Constants.CHESSPIECE_PLAYER_1_PREFIX;
			}
			else { 
				reader = new BufferedReader(new FileReader(player2File));
				playerWho = Constants.CHESSPIECE_PLAYER_2_PREFIX;
			}
			
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
					int value = 0;
					String key = getPieceKey(playerWho, y);
					Point p = new Point(x, y);
					if(x == 0 || x == 7) {
						value = Integer.parseInt(valuesForPieces[j]);
						switch (value) {
						case Constants.ROOK:
							if(y > 4)
								newPiece = new BoardSquare(p, false, 
									new ChessPieceRook(player, value,
											(ImageView) ChessGame2016.chessManager.getGuiButtons().get(playerWho + Constants.CHESSPIECE_ROOK + Constants.CHESSPIECE_SUFFIX_2), playerWho + Constants.CHESSPIECE_ROOK + Constants.CHESSPIECE_SUFFIX_2));
							else
								newPiece = new BoardSquare(p, false, 
									new ChessPieceRook(player, value,
											(ImageView) ChessGame2016.chessManager.getGuiButtons().get(playerWho + Constants.CHESSPIECE_ROOK + Constants.CHESSPIECE_SUFFIX_1), playerWho + Constants.CHESSPIECE_ROOK + Constants.CHESSPIECE_SUFFIX_1));
							break;
						case Constants.KNIGHT:
							if(y > 4)
								newPiece = new BoardSquare(p, false, 
									new ChessPieceKnight(player, value,
											(ImageView) ChessGame2016.chessManager.getGuiButtons().get(playerWho + Constants.CHESSPIECE_KNIGHT + Constants.CHESSPIECE_SUFFIX_2), playerWho + Constants.CHESSPIECE_KNIGHT + Constants.CHESSPIECE_SUFFIX_2));
							else
								newPiece = new BoardSquare(p, false, 
									new ChessPieceKnight(player, value,
											(ImageView) ChessGame2016.chessManager.getGuiButtons().get(playerWho + Constants.CHESSPIECE_KNIGHT + Constants.CHESSPIECE_SUFFIX_1), playerWho + Constants.CHESSPIECE_KNIGHT + Constants.CHESSPIECE_SUFFIX_1));
							break;
						case Constants.BISHOP:
							if(y > 4)
								newPiece = new BoardSquare(p, false, 
									new ChessPieceBishop(player, value,
											(ImageView) ChessGame2016.chessManager.getGuiButtons().get(playerWho + Constants.CHESSPIECE_BISHOP + Constants.CHESSPIECE_SUFFIX_2), playerWho + Constants.CHESSPIECE_BISHOP + Constants.CHESSPIECE_SUFFIX_2));
							else
								newPiece = new BoardSquare(p, false, 
									new ChessPieceBishop(player, value,
											(ImageView) ChessGame2016.chessManager.getGuiButtons().get(playerWho + Constants.CHESSPIECE_BISHOP + Constants.CHESSPIECE_SUFFIX_1), playerWho + Constants.CHESSPIECE_BISHOP + Constants.CHESSPIECE_SUFFIX_1));
							break;
						case Constants.QUEEN:
							newPiece = new BoardSquare(p, false, 
									new ChessPieceQueen(player, value,
											(ImageView) ChessGame2016.chessManager.getGuiButtons().get(playerWho + Constants.CHESSPIECE_QUEEN + Constants.CHESSPIECE_SUFFIX_1), playerWho + Constants.CHESSPIECE_QUEEN + Constants.CHESSPIECE_SUFFIX_1));
							break;
						case Constants.KING:
							newPiece = new BoardSquare(p, false, 
									new ChessPieceKing(player, value,
											(ImageView) ChessGame2016.chessManager.getGuiButtons().get(playerWho + Constants.CHESSPIECE_KING + Constants.CHESSPIECE_SUFFIX_1), playerWho + Constants.CHESSPIECE_KING + Constants.CHESSPIECE_SUFFIX_1));
							break;
						}
					} else {
						value = Constants.PAWN;
						key = getPieceKey(playerWho, y);
						newPiece = new BoardSquare(p, false, 
							new ChessPiecePawn(player, value, 
									(ImageView) ChessGame2016.chessManager.getGuiButtons().get(key), key));	// PAWNS
					}
					Board.gameBoard[p.x][p.y] = newPiece;
					Board.gameBoard[p.x][p.y].setPiece(newPiece.getPiece());
					Board.gameBoard[p.x][p.y].setEmpty(false);
					playerPieces.put(p, newPiece);
					j++;
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

	public Point getRemovedPlayerPieceCoordinate() {
		Point p = new Point();
		
		if(color == 1) {
			p.x = Constants.piecesForEachPlayer * Constants.CHESSPIECE_WIDTH + (removedPieces.size() * Constants.REMOVED_PIECES_WIDTH);
			p.y = (removedPieces.size() >= 8) ? Constants.PLAYER_1_REMOVED_PIECES_ROW_2_Y : Constants.PLAYER_1_REMOVED_PIECES_ROW_1_Y;
		} else {
			p.x = Constants.piecesForEachPlayer * Constants.CHESSPIECE_WIDTH + (removedPieces.size() * Constants.REMOVED_PIECES_WIDTH);
			p.y = (removedPieces.size() >= 8) ? Constants.PLAYER_2_REMOVED_PIECES_ROW_2_Y : Constants.PLAYER_2_REMOVED_PIECES_ROW_1_Y;
		}
		System.out.println(p);
		return p;
	}
	
	public Point[] player2Pawns() {
		Point[] player2Points = new Point[8];
		
		player2Points[0] = new Point(0, 6);
		player2Points[1] = new Point(1, 6);
		player2Points[2] = new Point(2, 6);
		player2Points[3] = new Point(3, 6);
		player2Points[4] = new Point(4, 6);
		player2Points[5] = new Point(5, 6);
		player2Points[6] = new Point(6, 6);
		player2Points[7] = new Point(7, 6);
		
		return player2Points;
	}
	
	public Point[] player1Pawns() {
		Point[] player1Points = new Point[8];
		
		player1Points[0] = new Point(0, 1);
		player1Points[1] = new Point(1, 1);
		player1Points[2] = new Point(2, 1);
		player1Points[3] = new Point(3, 1);
		player1Points[4] = new Point(4, 1);
		player1Points[5] = new Point(5, 1);
		player1Points[6] = new Point(6, 1);
		player1Points[7] = new Point(7, 1);
		
		return player1Points;
	}

	public Point[] getPlayer1Piece() {
		Point[] player1Points = new Point[8];
		
		player1Points[0] = new Point(0, 0);
		player1Points[1] = new Point(1, 0);
		player1Points[2] = new Point(2, 0);
		player1Points[3] = new Point(3, 0);
		player1Points[4] = new Point(4, 0);
		player1Points[5] = new Point(5, 0);
		player1Points[6] = new Point(6, 0);
		player1Points[7] = new Point(7, 0);
		
		return player1Points;
	}
	
	public Point[] getPlayer2Piece() {
		Point[] player2Points = new Point[8];
		
		player2Points[0] = new Point(0, 7);
		player2Points[1] = new Point(1, 7);;
		player2Points[2] = new Point(2, 7);
		player2Points[3] = new Point(3, 7);
		player2Points[4] = new Point(4, 7);
		player2Points[5] = new Point(5, 7);
		player2Points[6] = new Point(6, 7);
		player2Points[7] = new Point(7, 7);
		
		return player2Points;
	}
	
}