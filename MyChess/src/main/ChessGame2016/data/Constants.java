package main.ChessGame2016.data;

public class Constants {

	public static final int piecesForEachPlayer = 8;
	
	/* PIECES AND THEIR VALUES IN CHESS (SOURCE - WIKI? IDK ANYMORE...) */
	public static final int PAWN = 1;
	public static final int KNIGHT = 2;
	public static final int BISHOP = 3;
	public static final int ROOK = 4;
	public static final int KING = 5;
	public static final int QUEEN = 6;
	
	public static final String baseImgDiretory = "img/";
	public static final String piecesParentDirectory = "img/pieces/";
	public static final String playerOneDirectory = "img/pieces/white/";
	public static final String playerTwoDirectory = "img/pieces/black/";
	
	public static String CHESSPIECE_PLAYER_1_PREFIX = "1_";
	public static String CHESSPIECE_PLAYER_2_PREFIX = "2_";
	
	public static String CHESSPIECE_SUFFIX_1 = "_1";
	public static String CHESSPIECE_SUFFIX_2 = "_2";
	
	
	public static String CHESSPIECE_PAWN = "pawn";
	public static String CHESSPIECE_KNIGHT = "knight";
	public static String CHESSPIECE_BISHOP = "bishop";
	public static String CHESSPIECE_ROOK = "rook";
	public static String CHESSPIECE_KING = "king";
	public static String CHESSPIECE_QUEEN = "queen";
	public static String GAMEBOARD = "GameBoard";
	
	public static final int CHESSPIECE_HEIGHT = 100;
	public static final int CHESSPIECE_WIDTH = 100;
	
	public static final int REMOVED_PIECES_HEIGHT = 50;
	public static final int REMOVED_PIECES_WIDTH = 50;
	public static final int NUM_PIECES_IN_REMOVED_PIECES_ROW = 8;
	
	public static final int PLAYER_1_REMOVED_PIECES_ROW_1_Y = 100;
	public static final int PLAYER_1_REMOVED_PIECES_ROW_2_Y = 200;
	public static final int PLAYER_2_REMOVED_PIECES_ROW_1_Y = 600;
	public static final int PLAYER_2_REMOVED_PIECES_ROW_2_Y = 700;
	
	public static final String IMAGE_EXT_PNG = ".png";
	
	public static final String SPLASH_SCREEN = "SPLASH_SCREEN";
	public static final String SETTINGS_SCREEN = "SETTINGS_SCREEN";
	public static final String GAME_SCREEN = "GAME_SCREEN";
}