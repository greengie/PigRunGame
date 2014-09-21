package pigrun;

import org.newdawn.slick.SlickException;

public class SlidingTopObstacleUpWard extends TopObstacle {

	public SlidingTopObstacleUpWard(float x, float y, float vx) throws SlickException {
		super(x, y, vx);
		
	}
	@Override
	 public void updatemovement() {
		    super.updatemovement();
		    y += 0.8 ;
		  }
	
}
