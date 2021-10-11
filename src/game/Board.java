package game;

import java.util.LinkedList;
import java.util.List;

public class Board {
	
	private LinkedList<Piece> bPieces;
    private LinkedList<Piece> wPieces;
        
    private int curTurn = 1;
    private Square[][] pieces;
    
    //Initialize board
    public Board() {
    	pieces = new Square[8][8];
    	for(int i = 0; i < 8; i++) {
    		for(int j = 0; j < 8; j++) {
    			pieces[i][j] = new Square(i,j,null,this);
    			pieces[i][j].setPiece(new Piece(0, pieces[i][j]));
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
        for (int x = 0; x < 8; x++) {
            pieces[6][x].setPiece(new Pawn(0, pieces[6][x]));
            pieces[1][x].setPiece(new Pawn(1, pieces[1][x]));
        }
        
        //Queens
        pieces[0][3].setPiece(new Queen(1, pieces[0][3]));
        pieces[7][3].setPiece(new Queen(0, pieces[7][3]));
        
        //Kings (need special treatment)
        King bk = new King(0, pieces[7][4]);
        King wk = new King(1, pieces[0][4]);
        pieces[7][4].setPiece(bk);
        pieces[0][4].setPiece(wk);

        //Rooks
        pieces[7][0].setPiece(new Rook(0, pieces[7][0]));
        pieces[7][7].setPiece(new Rook(0, pieces[7][7]));
        pieces[0][0].setPiece(new Rook(1, pieces[0][0]));
        pieces[0][7].setPiece(new Rook(1, pieces[0][7]));

        //Knights
        pieces[7][1].setPiece(new Knight(0, pieces[7][1]));
        pieces[7][6].setPiece(new Knight(0, pieces[7][6]));
        pieces[0][1].setPiece(new Knight(1, pieces[0][1]));
        pieces[0][6].setPiece(new Knight(1, pieces[0][6]));

        //Bishops
        pieces[7][2].setPiece(new Bishop(0, pieces[7][2]));
        pieces[7][5].setPiece(new Bishop(0, pieces[7][5]));
        pieces[0][2].setPiece(new Bishop(1, pieces[0][2]));
        pieces[0][5].setPiece(new Bishop(1, pieces[0][5]));
	}
	
	private void addPiecesToList() {
		wPieces = new LinkedList<Piece>();
		bPieces = new LinkedList<Piece>();
		for(int i = 0; i < 7; i++) {
			bPieces.add(pieces[0][i].getPiece());
			bPieces.add(pieces[1][i].getPiece());
			wPieces.add(pieces[6][i].getPiece());
			wPieces.add(pieces[7][i].getPiece());
		}
	}
	
	//Gets all legal moves for the turn
	public List<Square> getLegalMoves(){
		LinkedList<Square> moves = new LinkedList<Square>();
		if(curTurn%2 == 1) {
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
	
	public Square getSquare(int y, int x) {
		return pieces[x][y];
	}
	
	//returns true if move was possible, returns false if it isnt.
	//Note this code doesn't do checks/checkmates yet, 
	//Im planning to have separate detection for that
	public boolean move(Piece p, Square s) {
		if(p.getColor()%2!=curTurn%2||!p.getLegalMoves(this).contains(s)) {
			return false;
		}
		p.move(s);
		curTurn = 1+curTurn;	
		
		return true;
	}
	
	//returns true if move was possible, returns false if it isnt.
	//Note this code doesn't do checks/checkmates yet, 
	//Im planning to have separate detection for that
	public boolean move(Piece p, int x, int y) {
		if(p.getColor()%2!=curTurn%2||!p.getLegalMoves(this).contains(pieces[x][y])) {
			return false;
		}
		p.move(pieces[x][y]);
		curTurn = 1+curTurn;	
		return true;
	}
		
	public static void main(String[] args) {
		Board b = new Board();
		System.out.print(b.getSquare(0, 0).getPiece().getLegalMoves(b).size());
		b.printBoard();
	}
}


