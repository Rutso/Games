package chess;

public class Rook extends Figure {

	//fields:
		
		
		
		
		
		//constructor:
		protected Rook(String color) {
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
						 			  		 {'/', '/', 'r', 'r', 'r', 'r', 'r', 'r', '/', '/'},
						 			  		 {'/', '/', 'r', 'r', 'r', 'r', 'r', 'r', '/', '/'},
						 			  		 {'/', '/', 'r', 'r', 'r', 'r', 'r', 'r', '/', '/'},
						 			  		 {'/', '/', 'r', 'r', 'r', 'r', 'r', 'r', '/', '/'},
									 		};
				imageOnWhite = tempWhiteOnWhite;
				
				char[][] tempWhiteOnBlack = {{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
											 {' ', ' ', 'r', 'r', 'r', 'r', 'r', 'r', ' ', ' '},
											 {' ', ' ', 'r', 'r', 'r', 'r', 'r', 'r', ' ', ' '},
											 {' ', ' ', 'r', 'r', 'r', 'r', 'r', 'r', ' ', ' '},
											 {' ', ' ', 'r', 'r', 'r', 'r', 'r', 'r', ' ', ' '},
				 							};
				imageOnBlack = tempWhiteOnBlack;
				
			} else {
				char[][] tempBlackOnWhite = {{'/', '/', '/', '/', '/', '/', '/', '/', '/', '/'},
	 			  		 					 {'/', '/', 'r', 'r', 'r', 'r', 'r', 'r', '/', '/'},
	 			  		 					 {'/', '/', 'r', ' ', ' ', ' ', ' ', 'r', '/', '/'},
	 			  		 					 {'/', '/', 'r', ' ', ' ', ' ', ' ', 'r', '/', '/'},
	 			  		 					 {'/', '/', 'r', ' ', ' ', ' ', ' ', 'r', '/', '/'},
				 							};
				imageOnWhite = tempBlackOnWhite;

				char[][] tempBlackOnBlack = {{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
						 					 {' ', ' ', 'r', 'r', 'r', 'r', 'r', 'r', ' ', ' '},
						 					 {' ', ' ', 'r', ' ', ' ', ' ', ' ', 'r', ' ', ' '},
						 					 {' ', ' ', 'r', ' ', ' ', ' ', ' ', 'r', ' ', ' '},
						 					 {' ', ' ', 'r', ' ', ' ', ' ', ' ', 'r', ' ', ' '},
											};
				imageOnBlack = tempBlackOnBlack;
					
				
			}
			
			
		}
	
		//getters:
		protected char[][] getImageOnBlack() {
			return this.imageOnBlack;
		}
		protected char[][] getImageOnWhite() {
			return this.imageOnWhite;
		}

		@Override
		protected boolean isItALegalMove(Field[][] gameBoard, int letterStart, int letterEnd, int numberStart, int numberEnd) {
			 
			if (gameBoard[numberStart][letterStart].getColor().equalsIgnoreCase("black")) {
				if (this.isLegalRookMovingPattern(letterStart, letterEnd, numberStart, numberEnd)) {
					if (this.isThePathForRookFree(gameBoard, letterStart, letterEnd, numberStart, numberEnd)) {
						if( (gameBoard[numberEnd][letterEnd] instanceof Figure && ((Figure) gameBoard[numberEnd][letterEnd]).getColor().equalsIgnoreCase("white")) || !(gameBoard[numberEnd][letterEnd] instanceof Figure) ) {
							return true;
						}
					}
				}
				return false;
			}
			
			if (gameBoard[numberStart][letterStart].getColor().equalsIgnoreCase("white")) {
				if (this.isLegalRookMovingPattern(letterStart, letterEnd, numberStart, numberEnd)) {
					if (this.isThePathForRookFree(gameBoard, letterStart, letterEnd, numberStart, numberEnd)) {
						if( (gameBoard[numberEnd][letterEnd] instanceof Figure && ((Figure) gameBoard[numberEnd][letterEnd]).getColor().equalsIgnoreCase("black")) || !(gameBoard[numberEnd][letterEnd] instanceof Figure) ) {
							return true;
						}
					}
				}
				return false;
			}
			
			return false;
		}

		
		private boolean isLegalRookMovingPattern(int letterStart, int letterEnd, int numberStart, int numberEnd) {
			if ((letterStart<letterEnd && numberStart==numberEnd) || (letterStart==letterEnd && numberStart<numberEnd) || (letterStart>letterEnd && numberStart==numberEnd) || (letterStart==letterEnd && numberStart>numberEnd)) {
				return true;
			}
			
			return false;
		}	
	
		private boolean isThePathForRookFree(Field[][] gameBoard, int letterStart, int letterEnd, int numberStart, int numberEnd) {
			if (letterStart<letterEnd && numberStart==numberEnd) {
				int i = 1;
				while (letterStart+i < letterEnd) {
					if (gameBoard[numberStart][letterStart+i] instanceof Figure) {
						return false;
					}
					i++;
				}
				return true;
			}
			
			if (letterStart==letterEnd && numberStart<numberEnd) {
				int i = 1;
				while (numberStart+i < numberEnd) {
					if (gameBoard[numberStart+i][letterStart] instanceof Figure) {
						return false;
					}
					i++;
				}
				return true;
			}
			
			if (letterStart>letterEnd && numberStart==numberEnd) {
				int i = 1;
				while (letterStart-i > letterEnd) {
					if (gameBoard[numberStart][letterStart-i] instanceof Figure) {
						return false;
					}
					i++;
				}
				return true;
			}
			
			if (letterStart==letterEnd && numberStart>numberEnd) {
				int i = 1;
				while (numberStart-i < numberEnd) {
					if (gameBoard[numberStart-i][letterStart] instanceof Figure) {
						return false;
					}
					i++;
				}
				return true;
			}
			
			return false;
		}

		
		
		
}
