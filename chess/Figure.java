package chess;

public abstract class Figure extends Field {

	//fields:
		protected boolean isOnBlack;
		protected boolean isFirstMove = true;
		protected char[][] imageOnBlack;
		protected char[][] imageOnWhite;
	
		
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
	protected void firstMoveMade() {
		this.isFirstMove = false;
	}
	
	
	protected abstract boolean isItALegalMove(Field[][] gameBoard, int letterStart, int letterEnd, int numberStart, int numberEnd);
	
		
	protected abstract boolean doesItThreatensTheKing(Field[][] gameBoard, int letterStart, int letterEnd);
	
	
	protected void removeFigure(Field[][] gameBoard, int letterEnd, int numberEnd, Player oponent) {
		String fromColor = new String();
		if(((Figure) gameBoard[numberEnd][letterEnd]).isOnBlack) {
			fromColor = "black";
		} else {
			fromColor = "white";
		}
		
		for (int i = 0; i < oponent.getRemovedFigures().length; i++) {
			if (oponent.getRemovedFigures()[i] == null) {
				oponent.getRemovedFigures()[i] = ((Figure) gameBoard[numberEnd][letterEnd]);
				return;
			}
		}
		
		gameBoard[numberEnd][letterEnd] = new Field(fromColor);
		
	}
	
	
	protected void moveFigure(Field[][] gameBoard, int letterStart, int numberStart, int letterEnd, int numberEnd) {
		String fromColor = new String();
		if(gameBoard[numberStart][letterStart] instanceof Pawn && ((Pawn) gameBoard[numberStart][letterStart]).isFirstMove) {
			((Pawn) gameBoard[numberStart][letterStart]).firstMoveMade();
		} 
		
		if(((Figure) gameBoard[numberStart][letterStart]).isOnBlack) {
			fromColor = "black";
		} else {
			fromColor = "white";
		}
		
		String toColor = new String();
		if (gameBoard[numberEnd][letterEnd].getColor().equalsIgnoreCase("black")) {
			((Figure) gameBoard[numberStart][letterStart]).setImage(this.imageOnBlack);
			toColor = "black";
		} else {
			((Figure) gameBoard[numberStart][letterStart]).setImage(this.imageOnWhite);
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
