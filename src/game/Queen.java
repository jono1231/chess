package game;

import java.util.List;

public class Queen extends Piece {
	
	
	public Queen(int color, Square sqr) {
		super(color,sqr);
	}
	
	@Override
	public boolean move(Square s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Square> getLegalMoves(Board b) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		return "Q";
	}
	
	public int getType() {
		return 5;
	}

}
