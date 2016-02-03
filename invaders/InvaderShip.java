package invaders;

//import java.util.Scanner;

public class InvaderShip extends Spaceship {

	public InvaderShip() {
		super();
		super.setObjectRepresentation('X');
		ISpaceObject.SPACE.appearInSpace(1, 48, this);
		super.setCoordinateVertical(1);
		super.setCoordinateHorizontal(48);
		
	}

	@Override
	public void moveInSpace() {
		
		
		InvaderShip is = this;
		
		Thread t = new Thread (new Runnable() {
			
			@Override
			public void run() {
				
				
				
			
				while (is.isAlive()) {
					
					if (is.getCoordinateHorizontal() == 2) {
						while (is.getCoordinateHorizontal() < Space.getSpace().getFlyingObjects()[is.getCoordinateVertical()].length-2) {
							//	is.fire();
								Space.getSpace().swapRight(is.getCoordinateVertical(), is.getCoordinateHorizontal(), is);
								
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
							
							}				
					}
					
					
					
					
					Space.getSpace().swapLeft(is.getCoordinateVertical(), is.getCoordinateHorizontal(), is);
					//is.fire();
					if (is.getCoordinateHorizontal() == 1) {
						
						while (is.getCoordinateHorizontal() < Space.getSpace().getFlyingObjects()[is.getCoordinateVertical()].length-2) {
						//	is.fire();
							Space.getSpace().swapRight(is.getCoordinateVertical(), is.getCoordinateHorizontal(), is);
							
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						
						}				
						
						
						
					}
					
					
					if (is.getCoordinateHorizontal() == Space.getSpace().getFlyingObjects()[is.getCoordinateVertical()].length-3) {
						
						while (is.getCoordinateHorizontal() > 1) {
							//is.fire();
							Space.getSpace().swapLeft(is.getCoordinateVertical(), is.getCoordinateHorizontal(), is);
							
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
						
						
					}
					
				try {
						Thread.sleep(1000);
				} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					e.printStackTrace();
					}
					
					
				}
				
				
				
				
			
			}
			
			
		});
		
		
		t.start();
		
		
		
	}

	@Override
	public void fire() {
		
			while (this.isAlive()) {
				LaserBeam lb = getLaserCannon().shot();
			ISpaceObject.SPACE.appearInSpace(this.getCoordinateVertical()+1, this.getCoordinateHorizontal(), lb);
			lb.setVerticalCoordinate(this.getCoordinateVertical()+1);
			lb.setHorizontalCoordinate(this.getCoordinateHorizontal());
			lb.moveDownInSpace();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			}
			
			
			
			
		
		
	}

}
