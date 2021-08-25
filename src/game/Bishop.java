package game;

import java.util.List;

public class Bishop implements Piece {

	private boolean color;
	
	public Bishop(boolean isWhite) {
		color = isWhite;
	}
	
	@Override
	public boolean move(int x1, int y1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getColor() {
		// TODO Auto-generated method stub
		return false;
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
		return "B";
	}

}
