package game;

import java.util.List;

public class King extends Piece {
	
	public King(int isWhite, Square sqr) {
		super(isWhite,sqr);
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
		return "K";
	}

	public int getType() {
		return 6;
	}
}
