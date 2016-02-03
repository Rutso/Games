package invaders;

import java.util.Scanner;

public class Experiments {

	
	
	public static void main(String[] arg) {
			
		LaserBeam lb = new LaserBeam();
		lb.setHorizontalCoordinate(48);
		lb.setVerticalCoordinate(27);
	
		Space s = Space.getSpace();
		//s.appearInSpace(27, 48, lb);
		InvaderShip is = new InvaderShip();
		HumanShip hs = new HumanShip();
				
		
		Thread a = new Thread( new Runnable() {

			@Override
			public void run() {
				
				while (hs.isAlive() && is.isAlive()) {

					s.printSpace();
					
					try {
						Thread.sleep(18);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
				
				
			}
			
		});
		
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				Scanner sc = new Scanner(System.in);
				while (hs.isAlive() && is.isAlive()) {
				//System.out.println("Make a move");
		
				hs.setMove(sc.nextInt());
				}
				sc.close();
				
			}
			
		});

		t.start();
		a.start();
		hs.moveInSpace();
		//lb.moveUpInSpace();
		is.moveInSpace();
		
		is.fire();
		
			
	}
	
	
}
