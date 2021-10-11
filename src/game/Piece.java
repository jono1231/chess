package game;

import java.util.List;


public class Piece{
	private int color;
	private Square curSquare;
	
	public Piece(int col, Square sqr) {
		color = col;
		curSquare = sqr;
	}
	
	public boolean move(Square s) {
		return false;
	}
	public int getColor() {
		return color;
	}
	public void draw() {
		
	}
	public void isCaptured() {
		
	}
	
	public int getType() {
		return -1;
	}
	
	public Square getCurSquare() {
		return curSquare;
	}
	
	//In theory this returns for all places a piece can move
	//Null if the square is empty, and a piece if it isn't
	public List<Square> getLegalMoves(Board b){
		return null;
	}
	
	protected int[] getLinearOccupations(Square[][] board, int x, int y) {
		int lastYabove = 0;
		int lastXright = 7;
		int lastYbelow = 7;
		int lastXleft = 0;
		        
		for (int i = 0; i < y; i++) {
			if (board[i][x].isOccupied()) {
				if (board[i][x].getPiece().getColor() != this.color) {
					lastYabove = i;
		        } 
				else {lastYabove = i + 1;}
		   }
		}
		for (int i = 7; i > y; i--) {
			if (board[i][x].isOccupied()) {
				if (board[i][x].getPiece().getColor() != this.color) {
					lastYbelow = i;
				} else lastYbelow = i - 1;
		    }
		}

		for (int i = 0; i < x; i++) {
	       if (board[y][i].isOccupied()) {
	           if (board[y][i].getPiece().getColor() != this.color) {
	        	   lastXleft = i;
		       } else lastXleft = i + 1;
		   }
		}
		for (int i = 7; i > x; i--) {
			if (board[y][i].isOccupied()) {
				if (board[y][i].getPiece().getColor() != this.color) {
					lastXright = i;
				} else lastXright = i - 1;
			}
		}
		int[] occups = {lastYabove, lastYbelow, lastXleft, lastXright};
		return occups;
	}
	
	//TODO: Make it actually diagonal (rn its not)
	protected int[] getDiagonalOccupations(Square[][] board, int x, int y) {
		int lastYabove = 0;
		int lastXright = 7;
		int lastYbelow = 7;
		int lastXleft = 0;
				
		for (int i = 0; i < y; i++) {
			   if (board[i][x].isOccupied()) {
		          	if (board[i][x].getPiece().getColor() != this.color) {
		          		lastYabove = i;
		            } 
		          	else {lastYabove = i + 1;}
		        }
		   }

		   for (int i = 7; i > y; i--) {
		       if (board[i][x].isOccupied()) {
		           if (board[i][x].getPiece().getColor() != this.color) {
		                lastYbelow = i;
		           	} 
		           else {lastYbelow = i - 1;}
		       }
		   }

		   for (int i = 0; i < x; i++) {
		       if (board[y][i].isOccupied()) {
		           if (board[y][i].getPiece().getColor() != this.color) {
		              lastXleft = i;
		           } else lastXleft = i + 1;
		       }
		   }

		   for (int i = 7; i > x; i--) {
			   if (board[y][i].isOccupied()) {
				   if (board[y][i].getPiece().getColor() != this.color) {
					   lastXright = i;
				   } else lastXright = i - 1;
			   }
		   }
		
		int[] occups = {lastYabove, lastYbelow, lastXleft, lastXright};
		return occups;	
	}
	
	public String toString() {
		if(color == 1) {return "white ";}
		if(color == 0) {return "black ";}
		return "";
	}
}
