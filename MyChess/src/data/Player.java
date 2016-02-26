package data;

import java.awt.Point;
import java.util.ArrayList;

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
	
	private ArrayList<Integer> playerPieces;
	private ArrayList<Integer> removedPieces;
	
	public Player() {
		numWins = numLosses = totalGames = 0;
		playerPieces = new ArrayList<>();
		removedPieces = new ArrayList<>();
	}
	
	public Player(int nColor, int wins, int losses, int totalG, ArrayList<Integer> pPieces) {
		color = nColor;
		numWins = wins;
		numLosses = losses;
		totalGames = totalG;
		playerPieces = pPieces;
	}
	
	public Player(int c) {
		color = c;
	}
	
	public void move(Point p1, Point p2) {
		// TO BE COMPLETED
	}
	
	public int getColor() { return color; }

	public void setColor(int color) { this.color = color; }

	public int getNumWins() { return numWins; }

	public void setNumWins(int numWins) { this.numWins = numWins; }

	public int getNumLosses() { return numLosses; }

	public void setNumLosses(int numLosses) { this.numLosses = numLosses; }

	public int getTotalGames() { return totalGames;	}

	public void setTotalGames(int totalGames) { this.totalGames = totalGames; }

	public ArrayList<Integer> getPlayerPieces() { return playerPieces; }

	public void setPlayerPieces(ArrayList<Integer> playerPieces) { this.playerPieces = playerPieces; }

	public ArrayList<Integer> getRemovedPieces() { return removedPieces; }

	public void setRemovedPieces(ArrayList<Integer> removedPieces) { this.removedPieces = removedPieces; }

}