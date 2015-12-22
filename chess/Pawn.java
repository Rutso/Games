package chess;

public class Pawn extends Figure {

	//fields:
	
	
	
	
	
	//constructor:
	protected Pawn(String color) {
		if (color.equalsIgnoreCase("white")) {
			this.color = color;
		} else {
			if (color.equalsIgnoreCase("black")) {
				this.color = color;
			} else {
				System.out.println("Invalid color!");
			}
		}
		
		if (color.equalsIgnoreCase("white")) {
			char[][] tempWhiteOnWhite = {{'/', '/', '/', '/', '/', '/', '/', '/', '/', '/'},
					 			  		 {'/', '/', '/', '/', '/', '/', '/', '/', '/', '/'},
					 			  		 {'/', '/', '/', 'p', 'p', 'p', 'p', '/', '/', '/'},
					 			  		 {'/', '/', '/', 'p', 'p', 'p', 'p', '/', '/', '/'},
					 			  		 {'/', '/', 'p', 'p', 'p', 'p', 'p', 'p', '/', '/'},
								 		};
			this.imageOnWhite = tempWhiteOnWhite;
			
			char[][] tempWhiteOnBlack = {{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
										 {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
										 {' ', ' ', ' ', 'p', 'p', 'p', 'p', ' ', ' ', ' '},
										 {' ', ' ', ' ', 'p', 'p', 'p', 'p', ' ', ' ', ' '},
										 {' ', ' ', 'p', 'p', 'p', 'p', 'p', 'p', ' ', ' '},
			 							};
			this.imageOnBlack = tempWhiteOnBlack;
			
		} else {
			char[][] tempBlackOnWhite = {{'/', '/', '/', '/', '/', '/', '/', '/', '/', '/'},
			  		 					 {'/', '/', '/', '/', '/', '/', '/', '/', '/', '/'},
			  		 					 {'/', '/', '/', 'p', 'p', 'p', 'p', '/', '/', '/'},
			  		 					 {'/', '/', '/', 'p', ' ', ' ', 'p', '/', '/', '/'},
			  		 					 {'/', '/', 'p', ' ', ' ', ' ', ' ', 'p', '/', '/'},
			 							};
			this.imageOnWhite = tempBlackOnWhite;

			char[][] tempBlackOnBlack = {{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
					 					 {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
					 					 {' ', ' ', ' ', 'p', 'p', 'p', 'p', ' ', ' ', ' '},
					 					 {' ', ' ', ' ', 'p', ' ', ' ', 'p', ' ', ' ', ' '},
					 					 {' ', ' ', 'p', ' ', ' ', ' ', ' ', 'p', ' ', ' '},
										};
			this.imageOnBlack = tempBlackOnBlack;
				
			
		}
		
		
	}
	
	
	//getters:
	protected char[][] getImageOnBlack() {
		return this.imageOnBlack;
	}
	protected char[][] getImageOnWhite() {
		return this.imageOnWhite;
	}
	
	//methods:
	@Override
	protected boolean isItALegalMove(Field[][] gameBoard, int letterStart, int letterEnd, int numberStart, int numberEnd) {
		
		if (((Pawn)gameBoard[numberStart][letterStart]).getColor().equalsIgnoreCase("black")) {
			if (letterStart == letterEnd && numberStart+1 == numberEnd && !(gameBoard[numberEnd][letterEnd] instanceof Figure)) {
				return true;
			}
			if (((Pawn)gameBoard[numberStart][letterStart]).isFirstMove && letterStart == letterEnd && numberStart+2 == numberEnd && !(gameBoard[numberStart+1][letterEnd] instanceof Figure) && !(gameBoard[numberEnd][letterEnd] instanceof Figure)) {
				return true;
			}
			
			if (letterStart+1 == letterEnd && numberStart+1 == numberEnd && (gameBoard[numberEnd][letterEnd] instanceof Figure)) {
				if (((Figure)gameBoard[numberEnd][letterEnd]).getColor().equalsIgnoreCase("white") ) {
					return true;
				}
				
			}
			if (letterStart-1 == letterEnd && numberStart+1 == numberEnd && (gameBoard[numberEnd][letterEnd] instanceof Figure)) {
				if (((Figure)gameBoard[numberEnd][letterEnd]).getColor().equalsIgnoreCase("white") ) {
					return true;
				}
				
			}
			
			
		} 
		
		if (((Pawn)gameBoard[numberStart][letterStart]).getColor().equalsIgnoreCase("white")) {
				if (letterStart == letterEnd && numberStart-1 == numberEnd && !(gameBoard[numberEnd][letterEnd] instanceof Figure)) {
					return true;
				}
				if (((Pawn)gameBoard[numberStart][letterStart]).isFirstMove && letterStart == letterEnd && numberStart-2 == numberEnd && !(gameBoard[numberStart-1][letterEnd] instanceof Figure) && !(gameBoard[numberEnd][letterEnd] instanceof Figure)) {
					return true;
				}
				
				if (letterStart+1 == letterEnd && numberStart-1 == numberEnd && (gameBoard[numberEnd][letterEnd] instanceof Figure)) {
					if (((Figure)gameBoard[numberEnd][letterEnd]).getColor().equalsIgnoreCase("black") ) {
						return true;
					}
					
				}
				if (letterStart-1 == letterEnd && numberStart-1 == numberEnd && (gameBoard[numberEnd][letterEnd] instanceof Figure)) {
					if (((Figure)gameBoard[numberEnd][letterEnd]).getColor().equalsIgnoreCase("black") ) {
						return true;
					}
					
				}
			
						
			
		}
		
		
		return false;
		
		
		
		
	}
	
	
	
	
	
}
