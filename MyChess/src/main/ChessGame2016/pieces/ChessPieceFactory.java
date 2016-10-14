package main.ChessGame2016.pieces;

import java.awt.Point;

import main.ChessGame2016.data.BoardSquare;
import main.ChessGame2016.data.ChessPiece;
import main.ChessGame2016.data.ChessPieceCreationInfo;
import main.ChessGame2016.data.Constants;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChessPieceFactory {
	
	public ChessPieceFactory() { }
	
	// WE NEED - IMAGE PATH, PLAYER PREFIX - 1_ OR 2_, PIECE NAME, PLAYER PIECE SUFFIX - _1 OR _2, 
	// AND IMG EXTENSION.
	public BoardSquare createChessPiece(ChessPieceCreationInfo info, Point xy, int color, int value) {
		Image img;
		ImageView imgV;
		ChessPiece piece;
		BoardSquare square;
		//System.out.println(info + "\nshit " + info.getImagePath());
		/*System.out.println("wrong: " + info.getImagePath() + info.getPieceName() + info.getImageExtension() +
				"\nright: " + Constants.playerOneDirectory + Constants.CHESSPIECE_ROOK + Constants.IMAGE_EXT_PNG);*/
		img = new Image(info.getImagePath() + info.getPieceName() + info.getImageExtension());
		imgV = new ImageView(img);
		imgV.setX(xy.getX() * 100);
		imgV.setY(xy.getY() * 100);
		imgV.setFitHeight(Constants.CHESSPIECE_HEIGHT);
		imgV.setFitWidth(Constants.CHESSPIECE_WIDTH);
		imgV.setPreserveRatio(true);
		piece = new ChessPieceRook(color, value, imgV, info.getPiecePrefix() + info.getPieceName() + info.getPieceSuffix());
		square = new BoardSquare(xy, false, piece);
		
		return square;
	}
	
	

}
