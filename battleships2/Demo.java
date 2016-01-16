package battleships2;

public class Demo {

	public static void main(String[] args) {
		
		//1. Create players:
		Player player1 = new Human("Mecho");
		Player player2 = new Bot("Pachinko");
		
		
		playBattleships(player1, player2);
		
		
		
		

	}

	public static void playBattleships(Player player1, Player player2) {
		//Fire at each other until one of the fleets is sunk:
		while (player1.isFleetAlive() && player2.isFleetAlive()) {
			
			player1.displayMaps();
			player1.fire(player2);
			
			
			if (!(player2.isFleetAlive())) {
				break;
			}
						
			player2.fire(player1);
			
		}
				
		//Determine the winner:
		if (player1.isFleetAlive()) {
			System.out.println(player1.getName() + " wins!");
		} 
				
		if (player2.isFleetAlive()) {
			System.out.println(player2.getName() + " wins!");
		} 
	}
	
	
		
}
