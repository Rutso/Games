package chess;

public class Figure extends Field {

	//fields:
		protected boolean isOnBlack;
		protected boolean isFirstMove = true;
		protected char[][] imageOnBlack;
		protected char[][] imageOnWhite;
	//constructor:
		//it calls the default constructor of the superclas Field
		
		
		
	//setter:
	protected void setIsOnBlack(boolean isOnBlack){
		this.isOnBlack = isOnBlack;
	}
	
	
	//getter:
	protected boolean getIsOnBlack() {
		return this.isOnBlack;
	}
	protected boolean getIsFirstMove() {
		return this.isFirstMove;
	}
	
	//methods:
	protected void firstMooveMade() {
		this.isFirstMove = false;
	}
	
	
	protected void removeFigure(Field[][] gameBoard, int letterEnd, int numberEnd, Field[] removedFigures) {
		String fromColor = new String();
		if(((Figure) gameBoard[numberEnd][letterEnd]).isOnBlack) {
			fromColor = "black";
		} else {
			fromColor = "white";
		}
		
		for (int i = 0; i < removedFigures.length; i++) {
			if (removedFigures[i] == null) {
				removedFigures[i] = gameBoard[numberEnd][letterEnd];
				return;
			}
		}
		
		gameBoard[numberEnd][letterEnd] = new Field(fromColor);
		
	}
	
	
	protected void moveFigure(Field[][] gameBoard, int letterStart, int numberStart, int letterEnd, int numberEnd) {
		String fromColor = new String();
		if(((Figure) gameBoard[numberStart][letterStart]).isOnBlack) {
			fromColor = "black";
		} else {
			fromColor = "white";
		}
		
		String toColor = new String();
		if (gameBoard[numberEnd][letterEnd].getColor().equalsIgnoreCase("black")) {
			((Figure) gameBoard[numberStart][letterStart]).setImage(imageOnBlack);
			toColor = "black";
		} else {
			((Figure) gameBoard[numberStart][letterStart]).setImage(imageOnWhite);
			toColor = "white";
		}
		
		gameBoard[numberEnd][letterEnd] = gameBoard[numberStart][letterStart];
		if (toColor.equalsIgnoreCase("black")) {
			((Figure) gameBoard[numberEnd][letterEnd]).setIsOnBlack(true);
		} else {
			((Figure) gameBoard[numberEnd][letterEnd]).setIsOnBlack(false);
		}
		gameBoard[numberStart][letterStart] = new Field(fromColor);
		
		
		
	}
	
	
	
	
}
