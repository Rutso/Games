package chess;

public class Queen extends Figure {

	//fields:
		
		
		
		
		//constructor:
		protected Queen(String color) {
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
				char[][] tempWhiteOnWhite = {{'/', '/', '/', 'q', 'q', 'q', 'q', '/', '/', '/'},
						 			  		 {'/', '/', '/', 'q', 'q', 'q', 'q', '/', '/', '/'},
						 			  		 {'/', '/', '/', 'q', 'q', 'q', 'q', '/', '/', '/'},
						 			  		 {'/', '/', '/', 'q', 'q', 'q', 'q', '/', '/', '/'},
						 			  		 {'/', '/', 'q', 'q', 'q', 'q', 'q', 'q', '/', '/'},
									 		};
				imageOnWhite = tempWhiteOnWhite;
				
				char[][] tempWhiteOnBlack = {{' ', ' ', ' ', 'q', 'q', 'q', 'q', ' ', ' ', ' '},
											 {' ', ' ', ' ', 'q', 'q', 'q', 'q', ' ', ' ', ' '},
											 {' ', ' ', ' ', 'q', 'q', 'q', 'q', ' ', ' ', ' '},
											 {' ', ' ', ' ', 'q', 'q', 'q', 'q', ' ', ' ', ' '},
											 {' ', ' ', 'q', 'q', 'q', 'q', 'q', 'q', ' ', ' '},
				 							};
				imageOnBlack = tempWhiteOnBlack;
				
			} else {
				char[][] tempBlackOnWhite = {{'/', '/', '/', 'q', 'q', 'q', 'q', '/', '/', '/'},
	 			  		 					 {'/', '/', '/', 'q', ' ', ' ', 'q', '/', '/', '/'},
	 			  		 					 {'/', '/', '/', 'q', ' ', ' ', 'q', '/', '/', '/'},
	 			  		 					 {'/', '/', '/', 'q', ' ', ' ', 'q', '/', '/', '/'},
	 			  		 					 {'/', '/', 'q', ' ', ' ', ' ', ' ', 'q', '/', '/'},
				 							};
				imageOnWhite = tempBlackOnWhite;

				char[][] tempBlackOnBlack = {{' ', ' ', ' ', 'q', 'q', 'q', 'q', ' ', ' ', ' '},
						 					 {' ', ' ', ' ', 'q', ' ', ' ', 'q', ' ', ' ', ' '},
						 					 {' ', ' ', ' ', 'q', ' ', ' ', 'q', ' ', ' ', ' '},
						 					 {' ', ' ', ' ', 'q', ' ', ' ', 'q', ' ', ' ', ' '},
						 					 {' ', ' ', 'q', ' ', ' ', ' ', ' ', 'q', ' ', ' '},
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
