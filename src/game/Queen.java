package game;

import java.util.List;

public class Queen implements Piece {
	private boolean color;
	
	
	public Queen(boolean isWhite) {
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
		// TODO Auto-generated method stub

	}

	@Override
	public List<Square> getLegalMoves(Board b) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		return "Q";
	}

}
