package game;

import java.util.LinkedList;
import java.util.List;

public class Rook extends Piece {
	
	private int color;
	private int x;
	private int y;
	
	public Rook(int col, int xPos, int yPos) {
		color = col;
		x = xPos;
		y = yPos;
	}
	
	//Move method
	public boolean move(Square s) {
		return s.setPiece(this);
	}

	public int getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	public void draw() {
		// TODO Auto-generated method stub

	}

	public void isCaptured() {
		
	}

	public List<Square> getLegalMoves(Board b) {
		LinkedList<Square> possMoves = new LinkedList<Square>();
		Square[][] bState = b.getBoardState();
		
		//Checks to the right
		for(int i = x+1; i < 8; i++) {
			if(bState[i][y].getPiece()== null || bState[i][y].getPiece().getColor() == this.getColor()) {
				break;
			}
			possMoves.add(bState[i][y]);
		}
		
		
		return possMoves;
	}
	

	
	@Override
	public String toString() {
		return "R";
	}

}
