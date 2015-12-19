package chess;

public class Field {

	//fields:
	protected String color;
	protected char[][] image = new char[5][10];
	
	
	//constructors:
	//this one will be used for the figures:
	public Field() {
		
	}
	
	//this one will create the empty fields for the game board:
	public Field(String color) {
		if (color.equalsIgnoreCase("white")) {
			this.color = color;
		} else {
			if (color.equalsIgnoreCase("black")) {
				this.color = color;
			} else {
				System.out.println("Invalid color!");
			}
		}
		
		
		if (this.color.equalsIgnoreCase("white")) {
			for (int i = 0; i <=4; i++) {
				for (int j = 0; j <= 9; j++) {
					image[i][j] = '/'; //because console has black background the 'white' fields will be filled, and the 'black' will be empty.
				}
			}
		} else {
			for (int i = 0; i <=4; i++) {
				for (int j = 0; j <= 9; j++) {
					image[i][j] = ' ';
				}
			}
		}
		
	}
	
	//setters - will use them for the creation of the different figures:
	protected void setColor(String color) {
		if (color.equalsIgnoreCase("white")) {
			this.color = color;
		} else {
			if (color.equalsIgnoreCase("black")) {
				this.color = color;
			} else {
				System.out.println("Invalid color!");
			}
		}
	}
	
	protected void setImage(char[][] image) {
		this.image = image;
	}
	
	//getters:
	protected String getColor() {
		return this.color;
	}
	
	protected char[][] getImage() {
		return this.image;
	}
	
	//methods:
	protected void printImage() {
		for (int i = 0; i < this.image.length; i++) {
			for (int j = 0; j < this.image[i].length; j++) {
				if (j < this.image[i].length-1) {
					System.out.print(this.image[i][j]);
				} else {
					System.out.println(this.image[i][j]);
				}
			}
		}
	}
	
	
	
	
	
	
	
	
}
