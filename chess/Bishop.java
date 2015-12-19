package chess;

public class Bishop extends Figure {

	//fields:
		protected final char[][] imageOnBlack;
		protected final char[][] imageOnWhite;
		
		
		
		
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
	
	
	
}
