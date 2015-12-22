package chess;

public class Board {

	//fields:
	Field[][] gameBoard = new Field[10][10];
	
	
	
	
	//constructor - creates a board with numbers and letters as indexes on the sides and black and white squares in the middle:
	public Board() {
		//put the numbers on the desk:
		int indexNumbers = 49;
		for (int i = 8; i >= 1; i--) {
			gameBoard[i][0] = new Index((char) indexNumbers);
			gameBoard[i][9] = new Index((char) indexNumbers);
			indexNumbers++;
		}
		//put the letters on the desk:
		int indexLetters = 97;
		for (int j = 1; j <= 8; j++) {
			gameBoard[0][j] = new Index((char) indexLetters);
			gameBoard[9][j] = new Index((char) indexLetters);
			indexLetters++;
		}
		
		//put the black and white boxes:
		for (int i = 1; i<= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				if ((i+j)%2 == 0) {
					gameBoard[i][j] = new Field("white");
				} else {
					gameBoard[i][j] = new Field("black");
				}
			}
		}
		
		//but 'black' fields in the 4 corners:
		gameBoard[0][0] = new Field("black");
		gameBoard[0][9] = new Field("black");
		gameBoard[9][0] = new Field("black");
		gameBoard[9][9] = new Field("black");
				
	}
	
	//getters:
	public Field[][] getGameBoard() {
		return this.gameBoard;
	}
	
	
	
	//methods:
	public void displayBoard() {
		for (int i = 0; i < this.gameBoard.length;  ) {
			int j = 0;
			for (int m = 0; m < this.gameBoard[i][j].getImage().length; ) {
				for (  ; j < this.gameBoard[i].length; ) {
					for (int n = 0; n < this.gameBoard[i][j].getImage()[m].length; n++) {
						if (j < this.gameBoard[i].length-1) {
							System.out.print(this.gameBoard[i][j].getImage()[m][n]);
							
						} else {
							System.out.print(this.gameBoard[i][j].getImage()[m][n]);
							
						}
						
					}
					j++;
				}
				System.out.println();
				m++;
				j = 0;
			}
			i++;
		}
	}
	
	
	public void putFigures() {
		
		//pawns:
		for (int j = 1; j < gameBoard[2].length-1; j++) {
			if(j%2 != 0) {
				gameBoard[2][j] = new Pawn("black");
				gameBoard[2][j].setImage(((Pawn) gameBoard[2][j]).getImageOnBlack());
				((Pawn) gameBoard[2][j]).setIsOnBlack(true);
				
				gameBoard[7][j] = new Pawn("white");
				gameBoard[7][j].setImage(((Pawn) gameBoard[7][j]).getImageOnWhite());
				((Pawn) gameBoard[7][j]).setIsOnBlack(false);
			} else {
				gameBoard[2][j] = new Pawn("black");
				gameBoard[2][j].setImage(((Pawn) gameBoard[2][j]).getImageOnWhite());
				((Pawn) gameBoard[2][j]).setIsOnBlack(false);
				gameBoard[7][j] = new Pawn("white");
				gameBoard[7][j].setImage(((Pawn) gameBoard[7][j]).getImageOnBlack());
				((Pawn) gameBoard[7][j]).setIsOnBlack(true);
			}
		}
		
		
		
		
		
		
		
		//knights:
				gameBoard[1][2] = new Knight("black");
				((Knight) gameBoard[1][2]).setImage(((Knight) gameBoard[1][2]).getImageOnBlack());
				((Knight) gameBoard[1][2]).setIsOnBlack(true);
				gameBoard[1][7] = new Knight("black");
				((Knight) gameBoard[1][7]).setImage(((Knight) gameBoard[1][7]).getImageOnWhite());
				((Knight) gameBoard[1][7]).setIsOnBlack(false);
		
				gameBoard[8][2] = new Knight("white");
				((Knight) gameBoard[8][2]).setImage(((Knight) gameBoard[8][2]).getImageOnWhite());
				((Knight) gameBoard[8][2]).setIsOnBlack(false);
				gameBoard[8][7] = new Knight("white");
				((Knight) gameBoard[8][7]).setImage(((Knight) gameBoard[8][7]).getImageOnBlack());
				((Knight) gameBoard[8][7]).setIsOnBlack(true);
		
		
				//bishops:
				gameBoard[1][3] = new Bishop("black");
				((Bishop) gameBoard[1][3]).setImage(((Bishop) gameBoard[1][3]).getImageOnWhite());
				((Bishop) gameBoard[1][3]).setIsOnBlack(false);
				gameBoard[1][6] = new Bishop("black");
				((Bishop) gameBoard[1][6]).setImage(((Bishop) gameBoard[1][6]).getImageOnBlack());
				((Bishop) gameBoard[1][6]).setIsOnBlack(true);
		
				gameBoard[8][3] = new Bishop("white");
				((Bishop) gameBoard[8][3]).setImage(((Bishop) gameBoard[8][3]).getImageOnBlack());
				((Bishop) gameBoard[8][3]).setIsOnBlack(true);
				gameBoard[8][6] = new Bishop("white");
				((Bishop) gameBoard[8][6]).setImage(((Bishop) gameBoard[8][6]).getImageOnWhite());
				((Bishop) gameBoard[8][6]).setIsOnBlack(false);
		
				
				//rooks:
				gameBoard[1][1] = new Rook("black");
				((Rook) gameBoard[1][1]).setImage(((Rook) gameBoard[1][1]).getImageOnWhite());
				((Rook) gameBoard[1][1]).setIsOnBlack(false);
				gameBoard[1][8] = new Rook("black");
				((Rook) gameBoard[1][8]).setImage(((Rook) gameBoard[1][8]).getImageOnBlack());
				((Rook) gameBoard[1][8]).setIsOnBlack(true);
		
				gameBoard[8][1] = new Rook("white");
				((Rook) gameBoard[8][1]).setImage(((Rook) gameBoard[8][1]).getImageOnBlack());
				((Rook) gameBoard[8][1]).setIsOnBlack(true);
				gameBoard[8][8] = new Rook("white");
				((Rook) gameBoard[8][8]).setImage(((Rook) gameBoard[8][8]).getImageOnWhite());
				((Rook) gameBoard[8][8]).setIsOnBlack(false);
		
				
				//queens:
				gameBoard[8][4] = new Queen("white");
				((Queen) gameBoard[8][4]).setImage(((Queen) gameBoard[8][4]).getImageOnWhite());
				((Queen) gameBoard[8][4]).setIsOnBlack(false);
				gameBoard[1][4] = new Queen("black");
				((Queen) gameBoard[1][4]).setImage(((Queen) gameBoard[1][4]).getImageOnBlack());
				((Queen) gameBoard[1][4]).setIsOnBlack(true);
		
				//kings:
				gameBoard[8][5] = new King("white");
				((King) gameBoard[8][5]).setImage(((King) gameBoard[8][5]).getImageOnBlack());
				((King) gameBoard[8][5]).setIsOnBlack(true);
				gameBoard[1][5] = new King("black");
				((King) gameBoard[1][5]).setImage(((King) gameBoard[1][5]).getImageOnWhite());
				((King) gameBoard[1][5]).setIsOnBlack(false);
		
	}
	
	
	public boolean isAFigure(Field[][] gameBoard, int letterStart, int numberStart) {
		
		if (gameBoard[letterStart][numberStart] instanceof Figure) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
