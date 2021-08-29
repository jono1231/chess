package game;

import java.util.List;

public class Queen extends Piece {
	private int color;
	
	
	public Queen(int color) {
		this.color = color;
	}
	
	@Override
	public boolean move(Square s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getColor() {
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
