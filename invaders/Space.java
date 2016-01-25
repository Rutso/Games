package invaders;

public class Space {
	
	private static final int SIZE_VERTICAL = 30;
	private static final int SIZE_HORIZONTAL = 100;
	private static Space instance;
	private char[][] area;
	private ISpaceObject[][] flyingObjects;
	
	
	private Space() {
		this.area = new char[Space.SIZE_VERTICAL][Space.SIZE_HORIZONTAL];
		for (int i = 0; i < this.area.length; i++) {
			putBorders();
		}
		
		this.flyingObjects = new ISpaceObject[Space.SIZE_VERTICAL][Space.SIZE_HORIZONTAL];
		for (int i = 0; i < this.flyingObjects.length; i++) {
			for (int j = 0; j < this.flyingObjects[i].length; j++) {
				this.flyingObjects[i][j] = new EmptySpace();
			}
		}
		
	}
	
	private void putBorders() {
		for (int i = 0; i < this.area.length; i++) {
			for (int j = 0; j < this.area[i].length; j++) {
				if (i == 0 || i == this.area.length-1) {
					this.area[i][j] = '*';
				} else {
					if(j == 0 || j == this.area[i].length-1) {
						this.area[i][j] = '*';
					} else {
						this.area[i][j] = ' ';
					}
				}
			}
		}
	}
	
	public void printSpace() {
		for (int i = 0; i < this.area.length; i++) {
			for (int j = 0; j < this.area[i].length; j++) {
				if (j < this.area[i].length-1) {
					System.out.print(this.area[i][j]);
				} else {
					System.out.println(this.area[i][j]);
				}
			}
		}
	}

	
	public static Space getSpace() {
		if (Space.instance == null) {
			Space.instance = new Space();
			return Space.instance;
		} else {
			return Space.instance;
		}
	}
	
	
	public void appearInSpace(int vertical, int horizontal, ISpaceObject newSpaceObject) {
		this.area[vertical][horizontal] = newSpaceObject.getObjectRepresentation();
		this.flyingObjects[vertical][horizontal] = newSpaceObject;
	}
	
	public void setEmptySpace(int vertical, int horizontal) {
		this.area[vertical][horizontal] = ' '; 
	}
	
	public void removeObjectFromSpace(int vertical, int horizontal) {
		this.flyingObjects[vertical][horizontal] = new EmptySpace();
		setEmptySpace(vertical, horizontal);
	}
	
	
	
	public void swapUp(int verticalCoordinate, int horizontalCoordinate, ISpaceObject spaceObject) {
		if (spaceObject instanceof LaserBeam) {
			if (verticalCoordinate == 1) {
				spaceObject = null;
				EmptySpace es = new EmptySpace();
				this.flyingObjects[verticalCoordinate][horizontalCoordinate] = es;
				this.area[verticalCoordinate][horizontalCoordinate] = ' ';
			} else {
				if (this.flyingObjects[verticalCoordinate-1][horizontalCoordinate] instanceof InvaderShip) {
					((InvaderShip) this.flyingObjects[verticalCoordinate-1][horizontalCoordinate]).destroy();
					
					spaceObject = null;
					EmptySpace es = new EmptySpace();
					this.flyingObjects[verticalCoordinate][horizontalCoordinate] = es;
					this.area[verticalCoordinate][horizontalCoordinate] = ' ';
					this.area[verticalCoordinate-1][horizontalCoordinate] = ' ';
				} else {
					this.flyingObjects[verticalCoordinate-1][horizontalCoordinate] = spaceObject;
					((LaserBeam) this.flyingObjects[verticalCoordinate-1][horizontalCoordinate]).setVerticalCoordinate(verticalCoordinate-1);
					this.area[verticalCoordinate-1][horizontalCoordinate] = ((LaserBeam) this.flyingObjects[verticalCoordinate-1][horizontalCoordinate]).getObjectRepresentation();
					EmptySpace es = new EmptySpace();
					this.flyingObjects[verticalCoordinate][horizontalCoordinate] = es;
					this.area[verticalCoordinate][horizontalCoordinate] = ' ';
				}
			}
		}
	}

	protected ISpaceObject[][] getFlyingObjects() {
		return flyingObjects;
	}

	public void swapDown(int verticalCoordinate, int horizontalCoordinate, ISpaceObject spaceObject) {
		if (spaceObject instanceof LaserBeam) {
			if (verticalCoordinate == this.flyingObjects.length-2) {
				spaceObject = null;
				EmptySpace es = new EmptySpace();
				this.flyingObjects[verticalCoordinate][horizontalCoordinate] = es;
				this.area[verticalCoordinate][horizontalCoordinate] = ' ';
			} else {
				if (this.flyingObjects[verticalCoordinate+1][horizontalCoordinate] instanceof HumanShip) {
					((HumanShip) this.flyingObjects[verticalCoordinate+1][horizontalCoordinate]).destroy();
					spaceObject = null;
					EmptySpace es = new EmptySpace();
					this.flyingObjects[verticalCoordinate][horizontalCoordinate] = es;
					this.area[verticalCoordinate][horizontalCoordinate] = ' ';
					this.area[verticalCoordinate+1][horizontalCoordinate] = ' ';
				} else {
					this.flyingObjects[verticalCoordinate+1][horizontalCoordinate] = spaceObject;
					((LaserBeam) this.flyingObjects[verticalCoordinate+1][horizontalCoordinate]).setVerticalCoordinate(verticalCoordinate+1);
					this.area[verticalCoordinate+1][horizontalCoordinate] = ((LaserBeam) this.flyingObjects[verticalCoordinate+1][horizontalCoordinate]).getObjectRepresentation();
					EmptySpace es = new EmptySpace();
					this.flyingObjects[verticalCoordinate][horizontalCoordinate] = es;
					this.area[verticalCoordinate][horizontalCoordinate] = ' ';
				
				}
			}
		}
	}

	public void swapLeft(int verticalCoordinate, int horizontalCoordinate, ISpaceObject spaceObject) {
		
		if (horizontalCoordinate > 1) {
			if (spaceObject instanceof Spaceship) {
			this.flyingObjects[verticalCoordinate][horizontalCoordinate-1] = spaceObject;
			((Spaceship) this.flyingObjects[verticalCoordinate][horizontalCoordinate-1]).setCoordinateHorizontal(horizontalCoordinate-1);
			this.area[verticalCoordinate][horizontalCoordinate-1] = ((Spaceship) spaceObject).getObjectRepresentation();
			EmptySpace es = new EmptySpace();
			this.flyingObjects[verticalCoordinate][horizontalCoordinate] = es;
			this.area[verticalCoordinate][horizontalCoordinate] = ' ';
		}
		}
		
		
	}

	public void swapRight(int verticalCoordinate, int horizontalCoordinate, ISpaceObject spaceObject) {
		if (horizontalCoordinate < this.flyingObjects[verticalCoordinate].length-2) {
			if (spaceObject instanceof Spaceship) {
			this.flyingObjects[verticalCoordinate][horizontalCoordinate+1] = spaceObject;
			((Spaceship) this.flyingObjects[verticalCoordinate][horizontalCoordinate+1]).setCoordinateHorizontal(horizontalCoordinate+1);
			this.area[verticalCoordinate][horizontalCoordinate+1] = ((Spaceship) spaceObject).getObjectRepresentation();
			EmptySpace es = new EmptySpace();
			this.flyingObjects[verticalCoordinate][horizontalCoordinate] = es;
			this.area[verticalCoordinate][horizontalCoordinate] = ' ';
		}
			
			
		}
		
		
		
	}


}
