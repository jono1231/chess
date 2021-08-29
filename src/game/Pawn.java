package game;

import java.util.List;

public class Pawn extends Piece{
	
	//Constructor method
	public Pawn(int color, Square sqr) {
		super(color, sqr);
	}


	//Move method - returns true if attempted move is possible
	//returns false if attempted move isn't possible
	public boolean move(Square s) {
		
		return false;
	}
	
	//Gets the piece on the squares that a pawn can move to
	//In this case, a pawn needs to get pieces in front and on the left or right
	public List<Square> getLegalMoves(Board b) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		return "p";
	}

}
