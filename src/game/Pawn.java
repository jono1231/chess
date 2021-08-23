package game;

import java.util.List;

public class Pawn implements Piece{
	private int xPos;
	private int yPos;
	private boolean color;
	
	//Constructor method
	public Pawn(int xStart, int yStart, boolean pColor) {
		xPos = xStart;
		yPos = yStart;
		color = pColor;
	}

	//Move method - returns true if attempted move is possible
	//returns false if attempted move isn't possible
	public boolean move(int x1, int y1) {
		
		return false;
	}

	//Hurr Durr
	public boolean getColor() {
		return color;
	}
	
	//Draws piece on the board, I rely on hoggy for this one
	public void draw() {
		
	}
	
	//Gets the piece on the squares that a pawn can move to
	//In this case, a pawn needs to get pieces in front and on the left or right
	public List<Square> getLegalMoves(Board b) {
		// TODO Auto-generated method stub
		return null;
	}

}
