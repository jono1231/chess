package game;

import java.util.List;

public interface Piece{
	boolean move(int x1, int y1);
	boolean getColor();
	void draw();
	void isCaptured();
	
	//In theory this returns for all places a piece can move
	//Null if the square is empty, and a piece if it isn't
	List<Square> getLegalMoves(Board b);
}
