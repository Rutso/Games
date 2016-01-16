package battleships2;

public class Ship {

	//Inner class:
	private class Segment {
		private int coordinateLetter;
		private int coordinateNumber;
		private boolean isHit = false;
		
		//Setters and Getters of the inner class (do I neet them anyway?)
		public void setCoordinateLetter(int coordinateLetter) {
			this.coordinateLetter = coordinateLetter;
		}
		public void setCoordinateNumber(int coordinateNumber) {
			this.coordinateNumber = coordinateNumber;
		}
		public void hit() {
			this.isHit = true;
		}
		protected int getCoordinateLetter() {
			return coordinateLetter;
		}
		protected int getCoordinateNumber() {
			return coordinateNumber;
		}
		protected boolean isHit() {
			return isHit;
		}
		
		
	}
	
	
	
	//Outer class fields:
	private final String name;
	private final String type;
	private final int numberOfSegments;
	private int numberOfDamagedSegments = 0;
	private Segment[] segments;
	
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
	
	
	
	
	
}
