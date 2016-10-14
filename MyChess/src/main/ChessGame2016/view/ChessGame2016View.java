package main.ChessGame2016.view;

import java.awt.Point;
import java.util.HashMap;

import main.ChessGame2016.data.BoardSquare;
import main.ChessGame2016.data.ChessGame2016Data;
import main.ChessGame2016.data.ChessPieceCreationInfo;
import main.ChessGame2016.data.Constants;
import main.ChessGame2016.handlers.BishopHandler;
import main.ChessGame2016.handlers.BoardHandler;
import main.ChessGame2016.handlers.CloseGameHandler;
import main.ChessGame2016.handlers.KingHandler;
import main.ChessGame2016.handlers.KnightHandler;
import main.ChessGame2016.handlers.PawnHandler;
import main.ChessGame2016.handlers.QueenHandler;
import main.ChessGame2016.handlers.RookHandler;
import main.ChessGame2016.myChessGame2016.ChessGame2016;
import main.ChessGame2016.pieces.ChessPieceFactory;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChessGame2016View extends Application {
	
	public static HashMap<String, Object> guiButtons;
	public static HashMap<String, Object> guiDecor;
	public static HashMap<String, Object> buttonsToMove;

	private ChessPieceFactory factory;
	
	public static String keyOfClickedPiece = null;
	public static Point point1 = null;
	public static Point point2 = null;
	
	public static Canvas canvas = new Canvas(512, 512);
	
	public ChessGame2016View() {
		guiButtons = new HashMap<>();
		guiDecor = new HashMap<>();
		buttonsToMove = new HashMap<>();
		factory = new ChessPieceFactory();
	}

	public void initView() {
		launch();
	}
	
	public void init() throws Exception {
		ChessGame2016.chessManager.getGameData().initData();
		System.out.println("data initialized!");
	}

	@Override
	public void start(Stage stage) throws Exception {
		Group group = new Group();
		Scene scene = new Scene(group);
		stage.setScene(scene);
		
		group.getChildren().add(canvas);
		
		readBoardImage(scene, stage);
		
		readImagePieces(Constants.CHESSPIECE_PLAYER_1_PREFIX, getPlayer1Piece(), scene, stage);
		readImagePieces(Constants.CHESSPIECE_PLAYER_2_PREFIX, getPlayer2Piece(), scene, stage);
		
		Button closeButton = new Button("END IT");
		CloseGameHandler handler = new CloseGameHandler(closeButton);
		closeButton.addEventHandler(MouseEvent.ANY, handler);
		
		VBox vbox = new VBox();
		vbox.setLayoutX(500);
		vbox.setLayoutY(500);
		vbox.getChildren().add(closeButton);
		
		ChessGame2016AnimationTimer timer = new ChessGame2016AnimationTimer();
		timer.start();
		
		((Group)scene.getRoot()).getChildren().add(vbox);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public void readBoardImage(Scene scene, Stage stage) {
		Image image = new Image(Constants.baseImgDiretory + "GameBoard.png");
		ImageView imgV = new ImageView(image);
		
		imgV.setX(0);
		imgV.setY(0);
		BoardHandler bHandler = new BoardHandler(ChessGame2016.chessManager.getBoard(), imgV);
		imgV.addEventFilter(MouseEvent.MOUSE_CLICKED, bHandler);
		((Group)scene.getRoot()).getChildren().add(imgV);
		
	}
	
	public void readImagePieces(String playerWho, Point[] playerPiecePoints, Scene scene, Stage stage) {
		
		// A ROOK THAT'LL BE WHITE, IS WORTH 4 POINTS - REDUNDANT, IT'S IMAGEVIEW, AND IT'S VALUES 
		//ChessPieceRook rook = new ChessPieceRook(1, 4, new ImageView(new Image(Constants.playerOneDirectory + Constants.CHESSPIECE_ROOK + Constants.IMAGE_EXT_PNG)));

		ChessPieceCreationInfo pieceInfo= new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_ROOK,
				playerWho, Constants.CHESSPIECE_SUFFIX_1);
		BoardSquare square = factory.createChessPiece(pieceInfo, playerPiecePoints[0], 1, 3);
		RookHandler rookHandler = new RookHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, rookHandler);
		guiButtons.put(playerWho + Constants.CHESSPIECE_ROOK + Constants.CHESSPIECE_SUFFIX_1, square.getPiece().getImageView());
		((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo= new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_ROOK,
				playerWho, Constants.CHESSPIECE_SUFFIX_2);
		square = factory.createChessPiece(pieceInfo, playerPiecePoints[7], 1, 3);
		rookHandler = new RookHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, rookHandler);
		guiButtons.put(playerWho + Constants.CHESSPIECE_ROOK + Constants.CHESSPIECE_SUFFIX_2, square.getPiece().getImageView());
		((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo= new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_KNIGHT,
				playerWho, Constants.CHESSPIECE_SUFFIX_1);
		square = factory.createChessPiece(pieceInfo, playerPiecePoints[1], 1, 4);
		KnightHandler knightHandler = new KnightHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, knightHandler);
		guiButtons.put(playerWho + Constants.CHESSPIECE_KNIGHT + Constants.CHESSPIECE_SUFFIX_1, square.getPiece().getImageView());
		((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo= new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_KNIGHT,
				playerWho, Constants.CHESSPIECE_SUFFIX_2);
		square = factory.createChessPiece(pieceInfo, playerPiecePoints[6], 1, 4);
		knightHandler = new KnightHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, knightHandler);
		guiButtons.put(playerWho + Constants.CHESSPIECE_KNIGHT + Constants.CHESSPIECE_SUFFIX_2, square.getPiece().getImageView());
		((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo = new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_BISHOP,
				playerWho, Constants.CHESSPIECE_SUFFIX_1);
		square = factory.createChessPiece(pieceInfo, playerPiecePoints[2], 1, 4);
		BishopHandler bishopHandler = new BishopHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, bishopHandler);
		guiButtons.put(playerWho + Constants.CHESSPIECE_BISHOP + Constants.CHESSPIECE_SUFFIX_1, square.getPiece().getImageView());
		((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo = new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_BISHOP,
				playerWho, Constants.CHESSPIECE_SUFFIX_2);
		square = factory.createChessPiece(pieceInfo, playerPiecePoints[5], 1, 4);
		bishopHandler = new BishopHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, bishopHandler);
		guiButtons.put(playerWho + Constants.CHESSPIECE_BISHOP + Constants.CHESSPIECE_SUFFIX_2, square.getPiece().getImageView());
		((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo = new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_QUEEN,
				playerWho, Constants.CHESSPIECE_SUFFIX_1);
		square = factory.createChessPiece(pieceInfo, playerPiecePoints[3], 1, 4);
		QueenHandler queenHandler = new QueenHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, queenHandler);
		guiButtons.put(playerWho + Constants.CHESSPIECE_QUEEN + Constants.CHESSPIECE_SUFFIX_1, square.getPiece().getImageView());
		((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo = new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_KING,
				playerWho, Constants.CHESSPIECE_SUFFIX_1);
		square = factory.createChessPiece(pieceInfo, playerPiecePoints[4], 1, 4);
		KingHandler kingHandler = new KingHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, kingHandler);
		guiButtons.put(playerWho + Constants.CHESSPIECE_KING + Constants.CHESSPIECE_SUFFIX_1, square.getPiece().getImageView());
		((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		PawnHandler pawnHandler = null;
		
		Point[] points = null;
		if(playerWho.equals("1_"))
			points = player1Pawns();
		else
			points = player2Pawns();
		
		for(int i = 0; i < 8; i++) {
			pieceInfo = new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_PAWN,
					playerWho, "_" + i);
			square = factory.createChessPiece(pieceInfo, points[i] , 1, 4);	//new Point(i, 1)
			pawnHandler = new PawnHandler(square.getPiece());
			square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, pawnHandler);
			guiButtons.put(playerWho + Constants.CHESSPIECE_PAWN + "_" + i, square.getPiece().getImageView());
			System.out.println(playerWho + Constants.CHESSPIECE_PAWN + "_" + i);
			((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		}
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
