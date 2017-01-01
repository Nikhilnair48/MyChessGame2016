package main.ChessGame2016.view;

import java.awt.Point;
import java.util.HashMap;
import util.ChessGame2016Properties;
import main.ChessGame2016.data.Constants;
import main.ChessGame2016.handlers.BoardHandler;
import main.ChessGame2016.handlers.CloseGameHandler;
import main.ChessGame2016.myChessGame2016.ChessGame2016;
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
	
	public static HashMap<String, Object> buttonsToMove;

	public static String keyOfClickedPiece = null;
	public static Point point1 = null;
	public static Point point2 = null;
	
	public static Canvas canvas = new Canvas(1200, 800);
	Group group = new Group();
	public static Scene scene;
	public static Stage stage;
	
	public ChessGame2016View() {
		buttonsToMove = new HashMap<>();
	}

	public void initView() {
		launch();
	}
	
	public Stage getStage() { return stage;	}
	
	@Override
	public void start(Stage stage) throws Exception {
		scene = new Scene(group);
		stage.setScene(scene);
		
		group.getChildren().add(canvas);
		//ChessGame2016View.stage = stage;
		ChessGame2016.chessManager.getGameData().initData();
		
		//((Group)scene.getRoot()).getChildren().add(readSplashScreenBackground());
		readBoardImage(scene);
		
		HashMap<String, Object> guiButtons = ChessGame2016.chessManager.getGuiButtons();
		Object[] arr = guiButtons.keySet().toArray();
		for(int i = 0; i < arr.length; i++) {
			ImageView imgV = (ImageView) ChessGame2016.chessManager.getGuiButtons().get(arr[i]);
			((Group)scene.getRoot()).getChildren().add(imgV);
		}
		
		/*Button closeButton = new Button("END IT");
		CloseGameHandler handler = new CloseGameHandler(closeButton);
		closeButton.addEventHandler(MouseEvent.ANY, handler);
		
		VBox vbox = new VBox();
		vbox.setLayoutX(500);
		vbox.setLayoutY(500);
		vbox.getChildren().add(closeButton);*/
		
		Image image = new Image(ChessGame2016Properties.getProperty("trump"));
		ImageView imgV = new ImageView(image);
		
		imgV.setX(0);
		imgV.setY(0);
		
		//SplashScreen splash = new SplashScreen(this.stage, canvas);
		
		ChessGame2016AnimationTimer timer = new ChessGame2016AnimationTimer();
		timer.start();
		
		//((Group)scene.getRoot()).getChildren().add(vbox);
		//System.out.println(((Group)scene.getRoot()).getChildren().size());
		stage.setScene(scene);
		stage.show();
	}
	
	public ImageView readSplashScreenBackground() {
		Image image = new Image(ChessGame2016Properties.getProperty("background"));
		ImageView imgV = new ImageView(image);
		
		imgV.setX(0);
		imgV.setY(0);
		
		return imgV;
	}
	
	public void readBoardImage(Scene scene) {
		Image image = new Image(Constants.baseImgDirectory + "GameBoardUpdated.png");
		ImageView imgV = new ImageView(image);
		
		imgV.setX(0);
		imgV.setY(0);
		BoardHandler bHandler = new BoardHandler(ChessGame2016.chessManager.getBoard(), imgV);
		imgV.addEventFilter(MouseEvent.MOUSE_CLICKED, bHandler);
		((Group)scene.getRoot()).getChildren().add(imgV);
		
	}
	
	public Scene getScene() { return scene; }
	
	/*public void readImagePieces(String playerWho, Point[] playerPiecePoints, Scene scene, Stage stage) {
		
		// A ROOK THAT'LL BE WHITE, IS WORTH 4 POINTS - REDUNDANT, IT'S IMAGEVIEW, AND IT'S VALUES 
		//ChessPieceRook rook = new ChessPieceRook(1, 4, new ImageView(new Image(Constants.playerOneDirectory + Constants.CHESSPIECE_ROOK + Constants.IMAGE_EXT_PNG)));

		ChessPieceCreationInfo pieceInfo= new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_ROOK,
				playerWho, Constants.CHESSPIECE_SUFFIX_1);
		BoardSquare square = factory.createChessPiece(pieceInfo, playerPiecePoints[0], 1, 3);
		RookHandler rookHandler = new RookHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, rookHandler);
		guiButtons.put(playerWho + Constants.CHESSPIECE_ROOK + Constants.CHESSPIECE_SUFFIX_1, square.getPiece().getImageView());
		//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo= new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_ROOK,
				playerWho, Constants.CHESSPIECE_SUFFIX_2);
		square = factory.createChessPiece(pieceInfo, playerPiecePoints[7], 1, 3);
		rookHandler = new RookHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, rookHandler);
		guiButtons.put(playerWho + Constants.CHESSPIECE_ROOK + Constants.CHESSPIECE_SUFFIX_2, square.getPiece().getImageView());
		//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo= new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_KNIGHT,
				playerWho, Constants.CHESSPIECE_SUFFIX_1);
		square = factory.createChessPiece(pieceInfo, playerPiecePoints[1], 1, 4);
		KnightHandler knightHandler = new KnightHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, knightHandler);
		guiButtons.put(playerWho + Constants.CHESSPIECE_KNIGHT + Constants.CHESSPIECE_SUFFIX_1, square.getPiece().getImageView());
		//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo= new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_KNIGHT,
				playerWho, Constants.CHESSPIECE_SUFFIX_2);
		square = factory.createChessPiece(pieceInfo, playerPiecePoints[6], 1, 4);
		knightHandler = new KnightHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, knightHandler);
		guiButtons.put(playerWho + Constants.CHESSPIECE_KNIGHT + Constants.CHESSPIECE_SUFFIX_2, square.getPiece().getImageView());
		//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo = new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_BISHOP,
				playerWho, Constants.CHESSPIECE_SUFFIX_1);
		square = factory.createChessPiece(pieceInfo, playerPiecePoints[2], 1, 4);
		BishopHandler bishopHandler = new BishopHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, bishopHandler);
		guiButtons.put(playerWho + Constants.CHESSPIECE_BISHOP + Constants.CHESSPIECE_SUFFIX_1, square.getPiece().getImageView());
		//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo = new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_BISHOP,
				playerWho, Constants.CHESSPIECE_SUFFIX_2);
		square = factory.createChessPiece(pieceInfo, playerPiecePoints[5], 1, 4);
		bishopHandler = new BishopHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, bishopHandler);
		guiButtons.put(playerWho + Constants.CHESSPIECE_BISHOP + Constants.CHESSPIECE_SUFFIX_2, square.getPiece().getImageView());
		//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo = new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_QUEEN,
				playerWho, Constants.CHESSPIECE_SUFFIX_1);
		square = factory.createChessPiece(pieceInfo, playerPiecePoints[3], 1, 4);
		QueenHandler queenHandler = new QueenHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, queenHandler);
		guiButtons.put(playerWho + Constants.CHESSPIECE_QUEEN + Constants.CHESSPIECE_SUFFIX_1, square.getPiece().getImageView());
		//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
		pieceInfo = new ChessPieceCreationInfo(Constants.playerOneDirectory, Constants.IMAGE_EXT_PNG, Constants.CHESSPIECE_KING,
				playerWho, Constants.CHESSPIECE_SUFFIX_1);
		square = factory.createChessPiece(pieceInfo, playerPiecePoints[4], 1, 4);
		KingHandler kingHandler = new KingHandler(square.getPiece());
		square.getPiece().getImageView().addEventFilter(MouseEvent.ANY, kingHandler);
		guiButtons.put(playerWho + Constants.CHESSPIECE_KING + Constants.CHESSPIECE_SUFFIX_1, square.getPiece().getImageView());
		//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		
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
			//((Group)scene.getRoot()).getChildren().add(square.getPiece().getImageView());
		}
	}*/
	
}
