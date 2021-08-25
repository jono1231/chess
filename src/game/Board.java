package game;

import java.util.LinkedList;
import java.util.List;

public class Board {
	
	private LinkedList<Piece> bPieces;
    private LinkedList<Piece> wPieces;
    
    private boolean whiteTurn = true;
    private Square[][] pieces;
    
    //Initialize board
    public Board() {
    	pieces = new Square[8][8];
    	for(int i = 0; i < 8; i++) {
    		for(int j = 0; j < 8; j++) {
    			pieces[i][j] = new Square(this);
    		}
    	}
    	populateBoard();
    	addPiecesToList();
    }
 

	public void printBoard() {
		for(int i = 0; i < pieces.length; i++) {
			for(int j = 0; j < pieces[i].length; j++) {
				System.out.print(pieces[i][j]);
			}
			System.out.println();
		}
	}
	
	//Helper method that resets the board, slow and clunky but works
	//Super dumb code
	//TODO: add coords later
	private void populateBoard() {
		//Pawns
    	for(int i = 0; i < pieces.length; i++) {
    		Square wPawn = new Square(new Pawn(false),this);
    		Square bPawn = new Square(new Pawn(true),this);
    		
    		pieces[1][i] = wPawn;
    		pieces[6][i] = bPawn;
    	}
    	
    	//Kings
    	Square wKing = new Square(new King(true), this);
    	Square bKing = new Square(new King(false), this);
    	pieces[0][4] = wKing;
    	pieces[7][4] = bKing;
    	
    	//Queens
    	Square wQueen = new Square(new Queen(true), this);
    	Square bQueen = new Square(new Queen(false), this);
    	pieces[0][3] = wQueen;
    	pieces[7][3] = bQueen;
    	
    	//Knights
    	Square wKnight1 = new Square(new Knight(true), this);
    	Square bKnight1 = new Square(new Knight(false), this);
    	Square wKnight2 = new Square(new Knight(true), this);
    	Square bKnight2 = new Square(new Knight(false), this);
    	pieces[0][1] = wKnight1;
    	pieces[7][1] = bKnight1;
    	pieces[0][6] = wKnight2;
    	pieces[7][6] = bKnight2;
    	
    	//Rooks
    	Square wRook1 = new Square(new Rook(true), this);
    	Square bRook1 = new Square(new Rook(false), this);
    	Square wRook2 = new Square(new Rook(true), this);
    	Square bRook2 = new Square(new Rook(false), this);
    	pieces[0][0] = wRook1;
    	pieces[7][0] = bRook1;
    	pieces[0][7] = wRook2;
    	pieces[7][7] = bRook2;

    	
    	//Bishops
    	Square wBish1 = new Square(new Bishop(true), this);
    	Square bBish1 = new Square(new Bishop(false), this);
    	Square wBish2 = new Square(new Bishop(true), this);
    	Square bBish2 = new Square(new Bishop(false), this);
    	pieces[0][2] = wBish1;
    	pieces[7][2] = bBish1;
    	pieces[0][5] = wBish2;
    	pieces[7][5] = bBish2;
	}
	
	private void addPiecesToList() {
		wPieces = new LinkedList<Piece>();
		bPieces = new LinkedList<Piece>();
		for(int i = 0; i < 7; i++) {
			wPieces.add(pieces[0][i].getPiece());
			wPieces.add(pieces[1][i].getPiece());
			bPieces.add(pieces[6][i].getPiece());
			bPieces.add(pieces[7][i].getPiece());
		}
	}

	
	public static void main(String[] args) {
		Board b = new Board();
		b.printBoard();
	}
}


