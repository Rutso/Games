package chess;

public class Bishop extends Figure {

	//fields:
		
		
		
		
		
		//constructor:
		protected Bishop(String color) {
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
						 			  		 {'/', '/', '/', 'b', 'b', 'b', 'b', '/', '/', '/'},
						 			  		 {'/', '/', 'b', 'b', 'b', 'b', 'b', 'b', '/', '/'},
						 			  		 {'/', '/', '/', 'b', 'b', 'b', 'b', '/', '/', '/'},
						 			  		 {'/', '/', 'b', 'b', 'b', 'b', 'b', 'b', '/', '/'},
									 		};
				imageOnWhite = tempWhiteOnWhite;
				
				char[][] tempWhiteOnBlack = {{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
											 {' ', ' ', ' ', 'b', 'b', 'b', 'b', ' ', ' ', ' '},
											 {' ', ' ', 'b', 'b', 'b', 'b', 'b', 'b', ' ', ' '},
											 {' ', ' ', ' ', 'b', 'b', 'b', 'b', ' ', ' ', ' '},
											 {' ', ' ', 'b', 'b', 'b', 'b', 'b', 'b', ' ', ' '},
				 							};
				imageOnBlack = tempWhiteOnBlack;
				
			} else {
				char[][] tempBlackOnWhite = {{'/', '/', '/', '/', '/', '/', '/', '/', '/', '/'},
											 {'/', '/', '/', 'b', 'b', 'b', 'b', '/', '/', '/'},
											 {'/', '/', 'b', ' ', ' ', ' ', ' ', 'b', '/', '/'},
											 {'/', '/', '/', 'b', ' ', ' ', 'b', '/', '/', '/'},
											 {'/', '/', 'b', ' ', ' ', ' ', ' ', 'B', '/', '/'},
				 							};
				imageOnWhite = tempBlackOnWhite;

				char[][] tempBlackOnBlack = {{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
						 					 {' ', ' ', ' ', 'b', 'b', 'b', 'b', ' ', ' ', ' '},
						 					 {' ', ' ', 'b', ' ', ' ', ' ', ' ', 'b', ' ', ' '},
						 					 {' ', ' ', ' ', 'b', ' ', ' ', 'b', ' ', ' ', ' '},
						 					 {' ', ' ', 'b', ' ', ' ', ' ', ' ', 'b', ' ', ' '},
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
				if (this.isLegalBishopMovingPattern(letterStart, letterEnd, numberStart, numberEnd)) {
					if (this.isThePathForBishopFree(gameBoard, letterStart, letterEnd, numberStart, numberEnd)) {
						if( (gameBoard[numberEnd][letterEnd] instanceof Figure && ((Figure) gameBoard[numberEnd][letterEnd]).getColor().equalsIgnoreCase("white")) || !(gameBoard[numberEnd][letterEnd] instanceof Figure) ) {
							return true;
						}
					}
				}

			return false;
						
			}
			
			if (gameBoard[numberStart][letterStart].getColor().equalsIgnoreCase("white")) {
				if (this.isLegalBishopMovingPattern(letterStart, letterEnd, numberStart, numberEnd)) {
					if (this.isThePathForBishopFree(gameBoard, letterStart, letterEnd, numberStart, numberEnd)) {
						if( (gameBoard[numberEnd][letterEnd] instanceof Figure && ((Figure) gameBoard[numberEnd][letterEnd]).getColor().equalsIgnoreCase("black")) || !(gameBoard[numberEnd][letterEnd] instanceof Figure) ) {
							return true;
						}
					}
				}

			return false;
						
			}
			
			
			return false;
			
		}

		
		
		
		private boolean isLegalBishopMovingPattern(int letterStart, int letterEnd, int numberStart, int numberEnd) {
			if ((letterStart + numberStart == letterEnd + numberEnd) || (letterStart-letterEnd == numberStart-numberEnd)) {
				return true;
			}
			
			return false;
		}	
	
		private boolean isThePathForBishopFree(Field[][] gameBoard, int letterStart, int letterEnd, int numberStart, int numberEnd) {
			if (letterStart < letterEnd && numberStart < numberEnd) {
				int i = 1;
				while (letterStart+i < letterEnd && numberStart+i < numberEnd) {
					if (gameBoard[numberStart+i][letterStart+i] instanceof Figure) {
						return false;
					}
					i++;
				}
				return true;
			}
			
			if (letterStart > letterEnd && numberStart > numberEnd) {
				int i = 1;
				while (letterStart-i < letterEnd && numberStart-i < numberEnd) {
					if (gameBoard[numberStart-i][letterStart-i] instanceof Figure) {
						return false;
					}
					i++;
				}
				return true;
			}
			
			if (letterStart < letterEnd && numberStart > numberEnd) {
				int i = 1;
				while (letterStart+i < letterEnd && numberStart-i > numberEnd) {
					if (gameBoard[numberStart-i][letterStart+i] instanceof Figure) {
						return false;
					}
					i++;
				}
				return true;
			}
			
			if (letterStart > letterEnd && numberStart < numberEnd) {
				int i = 1;
				while (letterStart-i > letterEnd && numberStart+i < numberEnd) {
					if (gameBoard[numberStart+i][letterStart-i] instanceof Figure) {
						return false;
					}
					i++;
				}
				return true;
			}
			
			return false;
		}
	
		
		
		
		
		
		
		
		
}
