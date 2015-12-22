package chess;

public class Knight extends Figure {

	//fields:
		
		
		
		
		
		//constructor:
		protected Knight(String color) {
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
				char[][] tempWhiteOnWhite = {{'/', '/', 'k', 'k', 'k', '/', '/', '/', '/', '/'},
						 			  		 {'/', 'k', 'k', 'k', 'k', 'k', '/', '/', '/', '/'},
						 			  		 {'/', 'k', 'k', 'k', 'k', 'k', 'k', '/', '/', '/'},
						 			  		 {'/', '/', '/', 'k', 'k', 'k', 'k', '/', '/', '/'},
						 			  		 {'/', '/', 'k', 'k', 'k', 'k', 'k', 'k', '/', '/'},
									 		};
				imageOnWhite = tempWhiteOnWhite;
				
				char[][] tempWhiteOnBlack = {{' ', ' ', 'k', 'k', 'k', ' ', ' ', ' ', ' ', ' '},
											 {' ', 'k', 'k', 'k', 'k', 'k', ' ', ' ', ' ', ' '},
											 {' ', 'k', 'k', 'k', 'k', 'k', 'k', ' ', ' ', ' '},
											 {' ', ' ', ' ', 'k', 'k', 'k', 'k', ' ', ' ', ' '},
											 {' ', ' ', 'k', 'k', 'k', 'k', 'k', 'k', ' ', ' '},
				 							};
				imageOnBlack = tempWhiteOnBlack;
				
			} else {
				char[][] tempBlackOnWhite = {{'/', '/', 'k', 'k', 'k', '/', '/', '/', '/', '/'},
	 			  		 					 {'/', 'k', ' ', ' ', ' ', 'k', '/', '/', '/', '/'},
	 			  		 					 {'/', 'k', 'k', 'k', ' ', ' ' ,'k', '/', '/', '/'},
	 			  		 					 {'/', '/', '/', 'k', ' ', ' ', 'k', '/', '/', '/'},
	 			  		 					 {'/', '/', 'k', ' ', ' ', ' ', ' ', 'k', '/', '/'},
				 							};
				imageOnWhite = tempBlackOnWhite;

				char[][] tempBlackOnBlack = {{' ', ' ', 'k', 'k', 'k', ' ', ' ', ' ', ' ', ' '},
						 					 {' ', 'k', ' ', ' ', ' ', 'k', ' ', ' ', ' ', ' '},
						 					 {' ', 'k', 'k', 'k', ' ', ' ', 'k', ' ', ' ', ' '},
						 					 {' ', ' ', ' ', 'k', ' ', ' ', 'k', ' ', ' ', ' '},
						 					 {' ', ' ', 'k', ' ', ' ', ' ', ' ', 'k', ' ', ' '},
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
			
			//check if on the end square there is a figure from the own color and call a method that checks if the movement
			//corresponds to the specific moving patern of the Knight:
			if (gameBoard[numberStart][letterStart].getColor().equalsIgnoreCase("black")) {
				if (((gameBoard[numberEnd][letterEnd] instanceof Figure) && (gameBoard[numberEnd][letterEnd].getColor().equalsIgnoreCase("white"))) || !(gameBoard[numberEnd][letterEnd] instanceof Figure)) {
					if (this.isLegalHoresMove(letterStart, letterEnd, numberStart, numberEnd)) {
						return true;
					}
					
				}
			} 
			if (gameBoard[numberStart][letterStart].getColor().equalsIgnoreCase("white")) {
				if (((gameBoard[numberEnd][letterEnd] instanceof Figure) && (gameBoard[numberEnd][letterEnd].getColor().equalsIgnoreCase("black"))) || !(gameBoard[numberEnd][letterEnd] instanceof Figure) ) {
					if (this.isLegalHoresMove(letterStart, letterEnd, numberStart, numberEnd)) {
						return true;
					}
				}
			} 
						
			return false;
		}

		private boolean isLegalHoresMove(int letterStart, int letterEnd, int numberStart, int numberEnd) {
			if ((letterStart+1 == letterEnd && numberStart-2 == numberEnd) || (letterStart+2 == letterEnd && numberStart-1 == numberEnd) || (letterStart+2 == letterEnd && numberStart+1 == numberEnd) || (letterStart+1 == letterEnd && numberStart+2 == numberEnd) || (letterStart-1 == letterEnd && numberStart+2 == numberEnd) || (letterStart-2 == letterEnd && numberStart+1 == numberEnd) || (letterStart-2 == letterEnd && numberStart-1 == numberEnd) || (letterStart-1 == letterEnd && numberStart-2 == numberEnd)) {
				return true;
			}
			return false;
		}
		
		
		
	
	
}
