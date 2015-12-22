package chess;

public class Player {
	
	//fields:
	private final String name;
	private Figure[] figures = new Figure[16];
	private Figure[] removedFigures = new Figure[16];
	
	
	//constructor:
	public Player(String name) {
		if (name != null) {
			this.name = name;
		} else {
			System.out.println("Null set for Player's name.");
			this.name = null;
		}
	}
	
	//getter:
	public String getName() {
		return this.name;
	}
	
	public Figure[] getRemovedFigures() {
		 return this.removedFigures;
	 }
	
	
}
