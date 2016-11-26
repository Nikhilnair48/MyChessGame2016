package main.ChessGame2016.pieces;

import java.awt.Point;
import java.util.HashMap;
import main.ChessGame2016.data.BoardSquare;
import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.data.ChessPieceCreationInfo;
import main.ChessGame2016.data.Constants;
import main.ChessGame2016.handlers.BishopHandler;
import main.ChessGame2016.handlers.KingHandler;
import main.ChessGame2016.handlers.KnightHandler;
import main.ChessGame2016.handlers.PawnHandler;
import main.ChessGame2016.handlers.QueenHandler;
import main.ChessGame2016.handlers.RookHandler;
import javafx.scene.image.Image;
//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ChessPieceFactory {
	
	public ChessPieceFactory() { }
	
	// WE NEED - IMAGE PATH, PLAYER PREFIX - 1_ OR 2_, PIECE NAME, PLAYER PIECE SUFFIX - _1 OR _2, 
	// AND IMG EXTENSION.
	public BoardSquare createChessPiece(ChessPieceCreationInfo info, Point xy, int color, int value)  {
		Image img = null;
		ImageView imgV = null;
		ChessPiece piece = null;
		BoardSquare square = null;
		
		try {
			img = new Image(info.getImagePath() + info.getPieceName() + info.getImageExtension());
			imgV = new ImageView(img);
			imgV.setX(xy.getX() * 100);
			imgV.setY(xy.getY() * 100);
			imgV.setFitHeight(Constants.CHESSPIECE_HEIGHT);
			imgV.setFitWidth(Constants.CHESSPIECE_WIDTH);
			imgV.setPreserveRatio(true);
			piece = new ChessPieceRook(color, value, imgV, info.getPiecePrefix() + info.getPieceName() + info.getPieceSuffix());
			square = new BoardSquare(xy, false, piece);
		} catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
		return square;
	}
	
	public HashMap<String, Object> createPieceForAPlayer(String playerWho, int color, String imagesDirectory) {	// color to determine whether the pieces are black or white
		
		HashMap<String, Object> playerImageViews = new HashMap<>();
		Point[] playerPiecePoints = null;
		
		if(playerWho.equals("1_")) {
			playerPiecePoints = getPlayer1Piece();
		} else {
			playerPiecePoints = getPlayer2Piece();
		}
		
		// A ROOK THAT'LL BE WHITE, IS WORTH 4 POINTS - REDUNDANT, IT'S IMAGEVIEW, AND IT'S VALUES 
		//ChessPieceRook rook = new ChessPieceRook(1, 4, new ImageView(new Image(Constants.playerOneDirectory + Constants.CHESSPIECE_ROOK + Constants.IMAGE_EXT_PNG)));

		ChessPieceCreationInfo pieceInfo= new ChessPieceCreationInfo(imagesDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_ROOK,
				playerWho, Constants.CHESSPIECE_SUFFIX_1);
		BoardSquare square = createChessPiece(pieceInfo, playerPiecePoints[0], color, Constants.ROOK);
		RookHandler rookHandler = new RookHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, rookHandler);
		playerImageViews.put(playerWho + Constants.CHESSPIECE_ROOK + Constants.CHESSPIECE_SUFFIX_1, square.getPiece().getImageView());	//square.getPiece().getImageView()
		//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo= new ChessPieceCreationInfo(imagesDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_ROOK,
				playerWho, Constants.CHESSPIECE_SUFFIX_2);
		square = createChessPiece(pieceInfo, playerPiecePoints[7], color, Constants.ROOK);
		rookHandler = new RookHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, rookHandler);
		playerImageViews.put(playerWho + Constants.CHESSPIECE_ROOK + Constants.CHESSPIECE_SUFFIX_2, square.getPiece().getImageView());
		//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo= new ChessPieceCreationInfo(imagesDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_KNIGHT,
				playerWho, Constants.CHESSPIECE_SUFFIX_1);
		square = createChessPiece(pieceInfo, playerPiecePoints[1], color, Constants.KNIGHT);
		KnightHandler knightHandler = new KnightHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, knightHandler);
		playerImageViews.put(playerWho + Constants.CHESSPIECE_KNIGHT + Constants.CHESSPIECE_SUFFIX_1, square.getPiece().getImageView());
		//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo= new ChessPieceCreationInfo(imagesDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_KNIGHT,
				playerWho, Constants.CHESSPIECE_SUFFIX_2);
		square = createChessPiece(pieceInfo, playerPiecePoints[6], color, Constants.KNIGHT);
		knightHandler = new KnightHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, knightHandler);
		playerImageViews.put(playerWho + Constants.CHESSPIECE_KNIGHT + Constants.CHESSPIECE_SUFFIX_2, square.getPiece().getImageView());
		//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo = new ChessPieceCreationInfo(imagesDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_BISHOP,
				playerWho, Constants.CHESSPIECE_SUFFIX_1);
		square = createChessPiece(pieceInfo, playerPiecePoints[2], color, Constants.BISHOP);
		BishopHandler bishopHandler = new BishopHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, bishopHandler);
		playerImageViews.put(playerWho + Constants.CHESSPIECE_BISHOP + Constants.CHESSPIECE_SUFFIX_1, square.getPiece().getImageView());
		//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo = new ChessPieceCreationInfo(imagesDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_BISHOP,
				playerWho, Constants.CHESSPIECE_SUFFIX_2);
		square = createChessPiece(pieceInfo, playerPiecePoints[5], color, Constants.BISHOP);
		bishopHandler = new BishopHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, bishopHandler);
		playerImageViews.put(playerWho + Constants.CHESSPIECE_BISHOP + Constants.CHESSPIECE_SUFFIX_2, square.getPiece().getImageView());
		//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo = new ChessPieceCreationInfo(imagesDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_QUEEN,
				playerWho, Constants.CHESSPIECE_SUFFIX_1);
		square = createChessPiece(pieceInfo, playerPiecePoints[3], color, Constants.QUEEN);
		QueenHandler queenHandler = new QueenHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, queenHandler);
		playerImageViews.put(playerWho + Constants.CHESSPIECE_QUEEN + Constants.CHESSPIECE_SUFFIX_1, square.getPiece().getImageView());
		//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo = new ChessPieceCreationInfo(imagesDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_KING,
				playerWho, Constants.CHESSPIECE_SUFFIX_1);
		square = createChessPiece(pieceInfo, playerPiecePoints[4], color, Constants.KING);
		KingHandler kingHandler = new KingHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, kingHandler);
		playerImageViews.put(playerWho + Constants.CHESSPIECE_KING + Constants.CHESSPIECE_SUFFIX_1, square.getPiece().getImageView());
		//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		PawnHandler pawnHandler = null;
		
		Point[] points = null;
		if(playerWho.equals("1_"))
			points = player1Pawns();
		else
			points = player2Pawns();
		
		for(int i = 0; i < 8; i++) {
			pieceInfo = new ChessPieceCreationInfo(imagesDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_PAWN,
					playerWho, "_" + i);
			square = createChessPiece(pieceInfo, points[i] , color, Constants.PAWN);	//new Point(i, 1)
			pawnHandler = new PawnHandler(square.getPiece());
			square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, pawnHandler);
			playerImageViews.put(playerWho + Constants.CHESSPIECE_PAWN + "_" + i, square.getPiece().getImageView());
			//System.out.println(playerWho + Constants.CHESSPIECE_PAWN + "_" + i);
			//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		}
		
		return playerImageViews;
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
