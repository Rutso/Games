package chess;

public class King extends Figure {

	
	
	
	
	//fields:
			protected final char[][] imageOnBlack;
			protected final char[][] imageOnWhite;
			
			
			
			
			//constructor:
			protected King(String color) {
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
					char[][] tempWhiteOnWhite = {{'/', '/', 'K', '/', 'K', 'K', '/', 'K', '/', '/'},
							 			  		 {'/', '/', 'K', 'K', 'K', 'K', 'K', 'K', '/', '/'},
							 			  		 {'/', '/', '/', 'K', 'K', 'K', 'K', '/', '/', '/'},
							 			  		 {'/', '/', '/', 'K', 'K', 'K', 'K', '/', '/', '/'},
							 			  		 {'/', '/', 'K', 'K', 'K', 'K', 'K', 'K', '/', '/'},
										 		};
					imageOnWhite = tempWhiteOnWhite;
					
					char[][] tempWhiteOnBlack = {{' ', ' ', 'K', ' ', 'K', 'K', ' ', 'K', ' ', ' '},
												 {' ', ' ', 'K', 'K', 'K', 'K', 'K', 'K', ' ', ' '},
												 {' ', ' ', ' ', 'K', 'K', 'K', 'K', ' ', ' ', ' '},
												 {' ', ' ', ' ', 'K', 'K', 'K', 'K', ' ', ' ', ' '},
												 {' ', ' ', 'K', 'K', 'K', 'K', 'K', 'K', ' ', ' '},
					 							};
					imageOnBlack = tempWhiteOnBlack;
					
				} else {
					char[][] tempBlackOnWhite = {{'/', '/', 'K', '/', 'K', 'K', '/', 'K', '/', '/'},
		 			  		 					 {'/', '/', 'K', 'K', ' ', ' ', 'K', 'K', '/', '/'},
		 			  		 					 {'/', '/', '/', 'K', ' ', ' ', 'K', '/', '/', '/'},
		 			  		 					 {'/', '/', '/', 'K', ' ', ' ', 'K', '/', '/', '/'},
		 			  		 					 {'/', '/', 'K', ' ', ' ', ' ', ' ', 'K', '/', '/'},
					 							};
					imageOnWhite = tempBlackOnWhite;

					char[][] tempBlackOnBlack = {{' ', ' ', 'K', ' ', 'K', 'K', ' ', 'K', ' ', ' '},
												 {' ', ' ', 'K', 'K', ' ', ' ', 'K', 'K', ' ', ' '},
												 {' ', ' ', ' ', 'K', ' ', ' ', 'K', ' ', ' ', ' '},
												 {' ', ' ', ' ', 'K', ' ', ' ', 'K', ' ', ' ', ' '},
												 {' ', ' ', 'K', ' ', ' ', ' ', ' ', 'K', ' ', ' '},
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
