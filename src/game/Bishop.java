package game;

import java.util.List;

public class Bishop extends Piece {

	public Bishop(int isWhite, Square pieces) {
		super(isWhite,pieces);
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
		return super.toString() +  "B";
	}
	
	public int getType() {
		return 4;
	}
}
