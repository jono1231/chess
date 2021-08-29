package game;

public class Square {
	private Board b;
	private int x;
	private int y;
	private Piece occPiece;
	
	public Square(int xPos, int yPos, Piece curPiece, Board bPointer) {
		x = xPos;
		y = yPos;
		occPiece = curPiece;
		b = bPointer;
	}
	public Square(Piece curPiece, Board bPointer) {
		occPiece = curPiece;
		b = bPointer;
	}
	public Square(Board bPointer) {
		b = bPointer;
	}
	
	//Getter methods
	public boolean isOccupied() {
		return(occPiece != null);
	}
	public Piece getPiece() {
		return occPiece;
	}
	public int getX() {
		return x;
	}
	private int getY() {
		return y;
	}
	
	//Piece capture method - will return true of piece set is success
	//returns false if isn't
	//IMPORTANT: This method assumes that piece can legally move to the square
	public boolean setPiece(Piece p) {
		if(occPiece == null) {
			occPiece = p;
			return true;
		}
		
		//Check if opposite colors
		if(occPiece.getColor() != p.getColor()) {
			occPiece.isCaptured();
			occPiece = p;
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		if(occPiece == null) {
			return " ";
		}
		else {
			return occPiece.toString();
		}
	}
}
