package chess;

public class Knight extends Figure {

	//fields:
		protected final char[][] imageOnBlack;
		protected final char[][] imageOnWhite;
		
		
		
		
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
	
	
}
