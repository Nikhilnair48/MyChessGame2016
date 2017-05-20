package main.ChessGame2016.data;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import main.ChessGame2016.myChessGame2016.ChessGame2016;

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
	
	//private HashMap<Point, BoardSquare> playerPieces;
	private HashMap<String, ChessPiece> playerPieces;
	private ArrayList<ChessPiece> removedPieces;
	
	public Player() {
		numWins = numLosses = totalGames = 0;
		playerPieces = new HashMap<>();
		removedPieces = new ArrayList<>();
	}
	
	public Player(int nColor, int wins, int losses, int totalG, HashMap<String, ChessPiece> pPieces) {
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

	/*private String getPieceKey(String playerWho, int val) {
		return playerWho + Constants.CHESSPIECE_PAWN + "_" + val;
	}*/
	
	public int getColor() { return color; }

	public void setColor(int color) { this.color = color; }

	public int getNumWins() { return numWins; }

	public void setNumWins(int numWins) { this.numWins = numWins; }

	public int getNumLosses() { return numLosses; }

	public void setNumLosses(int numLosses) { this.numLosses = numLosses; }

	public int getTotalGames() { return totalGames;	}

	public void setTotalGames(int totalGames) { this.totalGames = totalGames; }

	public HashMap<String, ChessPiece> getPlayerPieces() { return playerPieces; }

	public void setPlayerPieces(HashMap<String, ChessPiece> playerPieces) { this.playerPieces = playerPieces; }

	public ArrayList<ChessPiece> getRemovedPieces() { return removedPieces; }

	public void setRemovedPieces(ArrayList<ChessPiece> removedPieces) { this.removedPieces = removedPieces; }
	
	public void addToRemovedPieces(ChessPiece piece) {
		piece.setOnBoard(0);	// UPDATE THE VALUE TO REFLECT THE CURRENT STATE OF THE PIECE
		this.removedPieces.add(piece);
	}
	
	/* TESTING PURPOSES */
	public void addChessPiece(String p, ChessPiece sq) {
		playerPieces.put(p, sq);
	}
	
	public void movieAPiece(Point pointFrom, Point pointTo) {
		ChessPiece square = playerPieces.get("CHAAANGE");
		//square.setPosition(pointTo);
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
	
}