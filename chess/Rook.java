package chess;

public class Rook extends Figure {

	//fields:
		protected final char[][] imageOnBlack;
		protected final char[][] imageOnWhite;
		
		
		
		
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

		
		
		
}
