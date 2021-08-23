package game;


public class Square {
	Square curPiece;
	private int xPos, yPos;
	private Boolean col;
	
	public Square(int xStart, int yStart, Boolean color) {
		col = color;
		setxPos(xStart);
		setyPos(yStart);
	}
	
	public int[] getXY() {
		return new int[]{getxPos(),getyPos()};
	}
	
	public boolean getColor() {
		return col;
	}
	
	public void draw() {
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	

}
