package wargame;

public class Card {

	//fields:
	private final String color;
	private final String value;
	private int strength;
	
	//Constructor:
	public Card(String value, String color, int strength) {
		//set the color:
		if (color != null) {
			this.color = color;
		} else {
			System.out.println("Invalid card color.");
			this.color = null;
		}
		//set the value:
		if (value != null) {
			this.value = value;
		} else {
			System.out.println("Invalid card value.");
			this.value = null;
		}
		//set the strength:
		this.setStrength(strength);
	}
		
	//Setter:
	private void setStrength(int strength) {
		if (strength > 1) {
			this.strength = strength;
		} else {
			System.out.println("Invalid card strength.");
			this.strength = 0;
		}
	}
	
	
	//Getters:
	public String getColor() {
		return this.color;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public int getStrength() {
		return this.strength;
	}
	
	//Methods:
	
	//compare a card with other card:
	public boolean compareCards(Card c2) {
		return (this.strength > c2.strength);
	}
	
	//check if a card has equal strength to another card:
	public boolean checkIfEqual(Card c2) {
		return (this.strength == c2.strength);
	}
	
	
	//displays a 'picture' of the card:
	public void printCard() {
		String[][] card = {{this.value.toUpperCase(), "-", "|"}, {"|", this.color.substring(0,1).toUpperCase(), "|"}, {"|", "_", this.value.toUpperCase()}};
		for (int i = 0; i < card.length; i++){
			for (int j = 0; j < card[i].length; j++) {
				if (j < card[i].length-1) {
					System.out.print(card[i][j]);
				} else {
					System.out.println(card[i][j]);
				}
			}
		}
	}
	
	
	
}
