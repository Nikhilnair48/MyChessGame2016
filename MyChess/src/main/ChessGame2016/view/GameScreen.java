package main.ChessGame2016.view;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import main.ChessGame2016.data.Constants;
import main.ChessGame2016.handlers.BoardHandler;
import main.ChessGame2016.handlers.CloseGameHandler;
import main.ChessGame2016.myChessGame2016.ChessGame2016;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GameScreen {
	
	public GameScreen() {
	}
	
	public List<ImageView> getGuiButtons() {
		//addGuiButtons();
		List<ImageView> list = new ArrayList<>();
		HashMap<String, Object> guiButtons = ChessGame2016.chessManager.getGuiButtons();
		Object[] arr = guiButtons.keySet().toArray();
		for(int i = 0; i < arr.length; i++) {
			ImageView imgV = (ImageView) ChessGame2016.chessManager.getGuiButtons().get(arr[i]);
			list.add(imgV);
		}
		list.add(readBoardImage());
		return list;
	}
	
	public Point flipPointToFitMatrix(Point p) {
		Point temp = new Point(p.x, p.y);
		p.x = p.y;
		p.y = temp.x;
		
		return p;
	}
	
	private ImageView readBoardImage() {
		Image image = new Image(Constants.baseImgDirectory + "GameBoardUpdated.png");
		ImageView imgV = new ImageView(image);
		
		imgV.setX(0);
		imgV.setY(0);
		BoardHandler bHandler = new BoardHandler(ChessGame2016.chessManager.getBoard(), imgV);
		imgV.addEventFilter(MouseEvent.MOUSE_CLICKED, bHandler);
		return imgV;
	}
	
	/*private void addGuiButtons() {
		System.out.println("called addGUIButtons");
		Image closeButton = new Image(Constants.baseImgDirectory + "/End_Game.png");
		ImageView imgV = new ImageView();
		imgV.setImage(closeButton);
		imgV.setFitWidth(160);
		imgV.setFitHeight(80);
		CloseGameHandler handler = new CloseGameHandler(imgV);
		imgV.addEventHandler(MouseEvent.ANY, handler);
		imgV.setX(800);
		imgV.setY(305);
		
		ChessGame2016.chessManager.getGuiButtons().put("GameScreen_End_Game", imgV);
	}*/

}
