package game;

import java.util.LinkedList;
import java.util.List;

public class Board {
	
	private LinkedList<Piece> bPieces;
    private LinkedList<Piece> wPieces;
        
    private boolean wTurn = true;
    private Square[][] pieces;
    
    //Initialize board
    public Board() {
    	pieces = new Square[8][8];
    	for(int i = 0; i < 8; i++) {
    		for(int j = 0; j < 8; j++) {
    			pieces[i][j] = new Square(i,j,null,this);
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
	
	//boardState getter method
	public Square[][] getBoardState() {
		return pieces;
	}
	
	
	//Helper method that resets the board, slow and clunky but works
	//Super dumb code
	//TODO: add coords later
	private void populateBoard() {
		//Pawns
    	for(int i = 0; i < pieces.length; i++) {
    		Square wPawn = new Square(1,i,new Pawn(false),this);
    		Square bPawn = new Square(6,i,new Pawn(true),this);
    		
    		pieces[1][i] = wPawn;
    		pieces[6][i] = bPawn;
    	}
    	
    	//Kings
    	Square wKing = new Square(0,4,new King(true), this);
    	Square bKing = new Square(7,4,new King(false), this);
    	pieces[0][4] = wKing;
    	pieces[7][4] = bKing;
    	
    	//Queens
    	Square wQueen = new Square(0,3,new Queen(true), this);
    	Square bQueen = new Square(7,3,new Queen(false), this);
    	pieces[0][3] = wQueen;
    	pieces[7][3] = bQueen;
    	
    	//Knights
    	Square wKnight1 = new Square(0,1,new Knight(true), this);
    	Square bKnight1 = new Square(7,1,new Knight(false), this);
    	Square wKnight2 = new Square(0,6,new Knight(true), this);
    	Square bKnight2 = new Square(7,6,new Knight(false), this);
    	pieces[0][1] = wKnight1;
    	pieces[7][1] = bKnight1;
    	pieces[0][6] = wKnight2;
    	pieces[7][6] = bKnight2;
    	
    	//Rooks
    	Square wRook1 = new Square(0,0,new Rook(true), this);
    	Square bRook1 = new Square(7,0,new Rook(false), this);
    	Square wRook2 = new Square(0,7,new Rook(true), this);
    	Square bRook2 = new Square(7,7,new Rook(false), this);
    	pieces[0][0] = wRook1;
    	pieces[7][0] = bRook1;
    	pieces[0][7] = wRook2;
    	pieces[7][7] = bRook2;

    	
    	//Bishops
    	Square wBish1 = new Square(0,2,new Bishop(true), this);
    	Square bBish1 = new Square(7,2,new Bishop(false), this);
    	Square wBish2 = new Square(0,5,new Bishop(true), this);
    	Square bBish2 = new Square(7,5,new Bishop(false), this);
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
	
	//Gets all legal moves for the turn
	public List<Square> getLegalMoves(){
		LinkedList<Square> moves = new LinkedList<Square>();
		if(wTurn) {
			for(Piece p : wPieces) {
				for(Square move : p.getLegalMoves(this)) {
					moves.add(move);
				}
			}
		}
		else {
			for(Piece p : bPieces) {
				for(Square move : p.getLegalMoves(this)) {
					moves.add(move);
				}
			}
		}
		return moves;
	}
	
	//returns true if move was possible, returns false if it isnt.
	//Note this code doesn't do checks/checkmates yet, 
	//Im planning to have separate detection for that
	public boolean move(Piece p, Square s) {
		if(p.getColor()!=wTurn||!p.getLegalMoves(this).contains(s)) {
			return false;
		}
		p.move(s);
		wTurn = !wTurn;
		
		return true;
	}
	
	public static void main(String[] args) {
		Board b = new Board();
		b.printBoard();
	}
}


