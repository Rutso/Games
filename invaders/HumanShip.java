package invaders;

import java.util.Scanner;

public class HumanShip extends Spaceship {

	private static final int SPOWN_COORDINATE_VERTICAL = 28;
	private static final int SPOWN_COORDINATE_HORIZONTAL = 48;
	private volatile int move = 0;
	
	public HumanShip() {
		super();
		super.setObjectRepresentation('O');
		ISpaceObject.SPACE.appearInSpace(HumanShip.SPOWN_COORDINATE_VERTICAL, HumanShip.SPOWN_COORDINATE_HORIZONTAL, this);
		super.setCoordinateVertical(HumanShip.SPOWN_COORDINATE_VERTICAL);
		super.setCoordinateHorizontal(HumanShip.SPOWN_COORDINATE_HORIZONTAL);
		
	}

	@Override
	public void moveInSpace() {
		HumanShip hs = this;
		Scanner sc = new Scanner(System.in);
		
		Thread t = new Thread (new Runnable() {
			
			@Override
			public void run() {
				
				
				
				//int move = 0;
				while (hs.isAlive()) {
					//do {
					//	System.out.println("Make a move: 1 - left, 2 - right, 2 -fire");
					//		move = sc.nextInt();
					//} while (move == 0);
					
					
					
					
				
					switch (move) {
					case 1: 
						Space.getSpace().swapLeft(hs.getCoordinateVertical(), hs.getCoordinateHorizontal(), hs);
						move = 0;
						break;
					case 3:
						Space.getSpace().swapRight(hs.getCoordinateVertical(), hs.getCoordinateHorizontal(), hs);
						move = 0;
						break;
					case 2:
						fire();
						move = 0;
						break;
					}
				}
				
				
			
			}
			
			
		});
		
		
		t.start();
		
		
		
		
	}

	@Override
	public void fire() {
		LaserBeam lb = getLaserCannon().shot();
		ISpaceObject.SPACE.appearInSpace(super.getCoordinateVertical()-1, super.getCoordinateHorizontal(), lb);
		lb.setVerticalCoordinate(super.getCoordinateVertical()-1);
		lb.setHorizontalCoordinate(super.getCoordinateHorizontal());
		lb.moveUpInSpace();
	}

	protected int getMove() {
		return move;
	}

	protected void setMove(int move) {
		this.move = move;
	}
	
	
	
}
