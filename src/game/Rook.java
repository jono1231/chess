package game;

import java.util.LinkedList;
import java.util.List;

public class Rook implements Piece {
	
	private boolean color;
	public Rook(boolean isWhite) {
		color = isWhite;
	}
	
	@Override
	public boolean move(Square s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public void isCaptured() {
		
	}

	@Override
	public List<Square> getLegalMoves(Board b) {
		LinkedList<Square> possMoves = new LinkedList<Square>();
		
		
		return possMoves;
	}
	
	public String toString() {
		return "R";
	}

}
