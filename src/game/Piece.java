package game;


public class Piece extends Square{
	
	public Piece(int xStart, int yStart, Boolean color) {
		super(xStart, yStart, color);
	}
	
	public void move(int xFinal, int yFinal) {
		if(isLegal(xFinal,yFinal)) {
			setxPos(xFinal);
			setyPos(yFinal);
		}
	}
	
	private boolean isLegal(int xFinal, int yFinal) {
		return true;
	}
}
