package invaders;

		class LaserCannon {
	
			protected LaserBeam shot() {
				return new LaserBeam();
				
			}
		}


	public abstract class Spaceship implements ISpaceObject, Moovable {

		private static final int MAX_LIFE = 1;
		private int life;
		private LaserCannon laserCannon;
		private int coordinateVertical;
		private int coordinateHorizontal;
		private volatile boolean isAlive;
		private char objectRepresentation;
		
		public Spaceship() {
			this.life = Spaceship.MAX_LIFE;
			this.laserCannon = new LaserCannon();
			this.isAlive = true;
			
		}
	
	
	
	
	public abstract void fire();


	protected void setCoordinateVertical(int coordinateVertical) {
		this.coordinateVertical = coordinateVertical;
	}

	protected void setCoordinateHorizontal(int coordinateHorizontal) {
		this.coordinateHorizontal = coordinateHorizontal;
	}

	protected int getCoordinateVertical() {
		return coordinateVertical;
	}

	protected int getCoordinateHorizontal() {
		return coordinateHorizontal;
	}
	
	protected void destroy() {
		this.isAlive = false;
	}
	
	protected boolean isAlive() {
		return this.isAlive;
	}




	public char getObjectRepresentation() {
		return objectRepresentation;
	}

	protected void setObjectRepresentation(char objectRepresentation) {
		this.objectRepresentation = objectRepresentation;
	}




	protected LaserCannon getLaserCannon() {
		return laserCannon;
	}
	
	
	
	
	
}
