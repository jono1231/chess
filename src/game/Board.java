package game;

import java.util.LinkedList;
import java.util.List;

public class Board {
	
	private LinkedList<Piece> Bpieces;
    private LinkedList<Piece> Wpieces;
    
    private boolean whiteTurn = true;
    private Square[][] pieces;
    
    //Initialize board
    public Board() {
    	pieces = new Square[8][8];
    	//Populate boardstate
    	for(int i = 0; i < pieces.length; i++) {
    		pieces[1][i] = new Square(new Pawn(true),this);
    		pieces[7][i] = new Square(new Pawn(true),this);
    	}
    }
 
	public void printBoard() {
		for(int i = 0; i < pieces.length; i++) {
			for(int j = 0; j < pieces[i].length; j++) {
				System.out.print(pieces[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Board b = new Board();
		b.printBoard();
	}
}


