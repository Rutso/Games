package battleships2;

import java.util.Scanner;

public class Human extends Player {

	public Human(String name) {
		super(name);
		super.getFleet()[0] = new Ship("'Swan'", "aircraft carrier", 5);
		super.getFleet()[1] = new Ship("'Eagle'", "battleship", 4);
		super.getFleet()[2] = new Ship("'Seagull'", "cruiser", 3);
		super.getFleet()[3] = new Ship("'Grebe'", "submarine", 3);
		super.getFleet()[4] = new Ship("'Sparrow'", "destroyer", 2);
	}

	@Override
	public char fire(Player opponent) {
		Scanner sc = new Scanner(System.in);
		char vert;
		do {
			System.out.print(this.getName() + ", enter the letter coordinate of the shot: ");
			vert = sc.next().charAt(0);
		} while (!(vert <= 106 && vert >= 97));
		int vertical = vert-96;
		
		int hori;
		do {
			System.out.print(this.getName() + ", enter the number coordinate of the shot: ");
			hori = sc.nextInt();
		} while (!(hori <= 9 && hori >= 0));
		int horizontal = hori+1;
		
		this.putTheAnswerOnTheEnemyMap(vertical, horizontal, opponent.answerToTheOponentsShot(vertical, horizontal));
		
		return opponent.answerToTheOponentsShot(vertical, horizontal);
		
		
		
		
		
	}

	
	@Override
	public void placeShipsInAquatory() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
}
