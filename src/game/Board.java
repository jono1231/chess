package game;



public class Board{
	private Square[][] boardState;
	private static int YMAX = 800;
	private static int XMAX = 800;

	
	public Board() {
		boardState = new Square[7][7];
		for(int i = 0; i < boardState.length; i++) {
			for(int j = 0; j < boardState[i].length; j++) {
				boardState[i][j] = new Square(i*50+50,j*50+50,null);
				boardState[i][j].draw();
			}
		}
		
	}
	
	
    public static void main(String[] args) 
    { 

    } 
}
