package battleships2;

public class Ship {

	//Inner class:
	private class Segment {
		private int coordinateLetter;
		private int coordinateNumber;
		private boolean isOk = true;
		
		//Setters and Getters of the inner class (do I neet them anyway?)
		public void setCoordinateLetter(int coordinateLetter) {
			this.coordinateLetter = coordinateLetter;
		}
		public void setCoordinateNumber(int coordinateNumber) {
			this.coordinateNumber = coordinateNumber;
		}
		public void hit() {
			this.isOk = false;
		}
		protected int getCoordinateLetter() {
			return coordinateLetter;
		}
		protected int getCoordinateNumber() {
			return coordinateNumber;
		}
		protected boolean isOk() {
			return isOk;
		}
		
		
	}
	
	
	
	//Outer class fields:
	private final String name;
	private final String type;
	private final int numberOfSegments;
	private int numberOfDamagedSegments = 0;
	private Segment[] segments;
	private boolean isAlive = true;
	
	//Outer class Constructor:

	public Ship(String name, String type, int numberOfSegments) {
		this.name = name;
		this.type = type;
		this.numberOfSegments = numberOfSegments;
		this.segments = new Segment[numberOfSegments];
		for (int i = 0; i < this.segments.length; i++) {
			this.segments[i] = new Segment();
		}
	}
	
	public boolean isAlive() {
		return this.isAlive;
	}
	
	

	public char checkIfHit(int vertical, int horizontal) {
		for (int i = 0; i < this.segments.length; i++) {
			if (this.segments[i].getCoordinateLetter() == vertical && this.segments[i].getCoordinateNumber() == horizontal && this.segments[i].isOk()) {
				if ((this.numberOfSegments-this.numberOfDamagedSegments) > 1) {
					this.numberOfDamagedSegments++;
					this.segments[i].hit();
					System.out.println(this.name + " was hit!");
					return 'h';
				} else {
					System.out.println("The " + this.type + " " + this.name + " was sunk!");
					this.isAlive = false;
					return 's';
				}
			}
		}
		return 'm';
	}
	
	
	
	
}
