package pigrun;

import org.newdawn.slick.SlickException;

public class SlidingTopObstacleDownward extends TopObstacle {

	
	public SlidingTopObstacleDownward(float x, float y1, float vx)throws SlickException {
		super(x, y1, vx);
		
	}
	
	@Override
	 public void updatemovement() {
		    super.updatemovement();
			if(y1 >= Pig.ground_height - 200){	
					y1 -= 0.4 ;
		    	}
	}	
}
