package game;

import java.util.LinkedList;
import java.util.List;

public class Rook extends Piece {
	
	public Rook(int col, Square square) {
		super(col,square);
	}
	
	//Move method
	public boolean move(Square s) {
		return s.setPiece(this);
	}

	public List<Square> getLegalMoves(Board b) {
        LinkedList<Square> legalMoves = new LinkedList<Square>();
        Square[][] board = b.getBoardState();
        
        int x = getCurSquare().getX();
        int y = getCurSquare().getY();
        
        int[] occups = getLinearOccupations(board, x, y);
        
        for (int i = occups[0]; i <= occups[1]; i++) {
            if (i != y) legalMoves.add(board[i][x]);
        }
        
        for (int i = occups[2]; i <= occups[3]; i++) {
            if (i != x) legalMoves.add(board[y][i]);
        }
        
        return legalMoves;
    }
	
	@Override
	public String toString() {
		return "R";
	}
	
	public int getType() {
		return 2;
	}

}
