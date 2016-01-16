package battleships2;

public class Bot extends Player {

	public Bot(String name) {
		super(name);
		super.getFleet()[0] = new Ship("'Titan'", "aircraft carrier", 5);
		super.getFleet()[1] = new Ship("'Mars'", "battleship", 4);
		super.getFleet()[2] = new Ship("'Saturn'", "cruiser", 3);
		super.getFleet()[3] = new Ship("'Neptun'", "submarine", 3);
		super.getFleet()[4] = new Ship("'Mercurius'", "destroyer", 2);
	}

	@Override
	public char fire(Player opponent) {
		// TODO Auto-generated method stub
		return 'm';
	}

	@Override
	public void placeShipsInAquatory() {
		// TODO Auto-generated method stub
		
	}
	

}
