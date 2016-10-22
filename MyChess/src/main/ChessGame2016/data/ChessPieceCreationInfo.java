package main.ChessGame2016.data;

public class ChessPieceCreationInfo {
	
	private String imagePath;
	private String imageExtension;
	private String pieceName;
	private String piecePrefix;
	private String pieceSuffix;
	
	public ChessPieceCreationInfo(String imagePath, String imageExtension, String pieceName, String piecePrefix, String pieceSuffix) {
		super();
		this.imagePath = imagePath;
		this.imageExtension = imageExtension;
		this.pieceName = pieceName;
		this.piecePrefix = piecePrefix;
		this.pieceSuffix = pieceSuffix;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getImageExtension() {
		return imageExtension;
	}
	public void setImageExtension(String imageExtension) {
		this.imageExtension = imageExtension;
	}
	public String getPieceName() {
		return pieceName;
	}
	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}
	public String getPiecePrefix() {
		return piecePrefix;
	}
	public void setPiecePrefix(String piecePrefix) {
		this.piecePrefix = piecePrefix;
	}
	public String getPieceSuffix() {
		return pieceSuffix;
	}
	public void setPieceSuffix(String pieceSuffix) {
		this.pieceSuffix = pieceSuffix;
	}
	
	@Override
	public String toString() {
		return "ChessPieceCreationInfo [imagePath=" + imagePath
				+ ", imageExtension=" + imageExtension + ", pieceName="
				+ pieceName + ", piecePrefix=" + piecePrefix + ", pieceSuffix="
				+ pieceSuffix + "]";
	}

}
