

package invaders;

//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;

public class LaserBeam implements ISpaceObject{

	
	private char representation = '!';
	private int verticalCoordinate;
	private int horizontalCoordinate;

	public char getObjectRepresentation() {
		return representation;
	}

	
	public void moveUpInSpace() {
		// MediaPlayer mediaPlayer = new MediaPlayer(new Media("file://C/Users/Mecho/Downloads/laserg.mp3"));
	    // mediaPlayer.play();
		LaserBeam lb = this;
		
		Thread t = new Thread (new Runnable() {

			@Override
			public void run() {
				
			    
				
				while (lb.verticalCoordinate > 0) {
					Space.getSpace().swapUp(lb.verticalCoordinate, lb.horizontalCoordinate, lb);
				
			    
			        
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			
			}
			
			
		});
		
		
		t.start();
		
	}

	public void moveDownInSpace() {
		LaserBeam lb = this;
		
		Thread t = new Thread (new Runnable() {

			@Override
			public void run() {
				
			    
				
				while (lb.verticalCoordinate < Space.getSpace().getFlyingObjects().length-1) {
					Space.getSpace().swapDown(lb.verticalCoordinate, lb.horizontalCoordinate, lb);
				
			    
			        
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			
			}
			
			
		});
		
		
		t.start();
		
	}


	protected void setVerticalCoordinate(int verticalCoordinate) {
		this.verticalCoordinate = verticalCoordinate;
	}


	protected void setHorizontalCoordinate(int horizontalCoordinate) {
		this.horizontalCoordinate = horizontalCoordinate;
	}
	
	
	
	
	
}
