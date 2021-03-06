package main.ChessGame2016.view;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import main.ChessGame2016.data.Constants;
import main.ChessGame2016.handlers.BoardHandler;
import main.ChessGame2016.myChessGame2016.ChessGame2016;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// THIS CLASS WILL NEED TO BE REFACTORED. VIEW AS A WHOLE WILL NEED IT.
public class ChessGame2016View extends Application {
	
	public static HashMap<String, Object> buttonsToMove;

	public static String keyOfClickedPiece = null;
	public static Point point1 = null;
	public static Point point2 = null;
	
	public static Canvas canvas = new Canvas(750, 750);
	Group group = new Group();
	public static Scene scene;
	public static Stage stage;
	
	public static Stack<ImageView> keysOfIDsToBeRemoved = new Stack<ImageView>();
	public static Stack<ImageView> keysOfIDsToBeAdded = new Stack<ImageView>();
	
	private StackPane splashPane;
	private Group gameGroup;
	
	public static Scene splashScene;
	public static Scene gameScene;
	
	public ChessGame2016View() {
		buttonsToMove = new HashMap<>();
		splashPane = new StackPane();
		gameGroup = new Group();
	}

	// COMMENTED OUT CODE TO TEST
	//public void initView(Stage stg) throws Exception {
	public void initView() throws Exception {
		launch();
		//startGame(stg);
	}
	
	public Stage getStage() { return stage;	}
	
	//public void startGame(Stage stage) throws Exception {		FOR TESTING
	public void start(Stage stage) throws Exception {
		// DATA HAS TO BE INITIALIZED HERE SINCE JAVA 8
		// DOESN'T ALLOW THE APP TO LOAD JAVAFX IMAGE UNTIL THE start()
		// METHOD IS CALLED. CURRENTLY, THE DATA LAYER WILL LOAD
		// CHESSPIECE IMAGES WHEN INIT IS INVOKED
		ChessGame2016.chessManager.getGameData().initData();
		
		ChessGame2016View.stage = stage;
		group.getChildren().add(canvas);
		
		SplashScreen splash = new SplashScreen();
		/*List<ImageView> imgViews = splash.readSplashScreenBackground();
		for(ImageView imgView : imgViews) {
			splashPane.getChildren().add(imgView);
		}*/
		
		List<ImageView> splashButtons = splash.getButtons();
		for(ImageView imgV : splashButtons) {
			StackPane.setMargin(imgV, new Insets(imgV.getX(), 0, 0, imgV.getY()));
			splashPane.getChildren().add(imgV);
		}
		
		splashScene = new Scene(splashPane, 1200, 800);
		
		GameScreen gameScreen = new GameScreen();
		List<ImageView> imgViews = gameScreen.getGuiButtons();
		for(ImageView imgView : imgViews) {
			gameGroup.getChildren().add(imgView);
		}
		gameScene = new Scene(gameGroup, 1200, 800);
		
		ChessGame2016AnimationTimer timer = new ChessGame2016AnimationTimer();
		timer.start();
		
		stage.setScene(splashScene);
		stage.show();
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
}
