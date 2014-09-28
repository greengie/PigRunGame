package pigrun;

import org.newdawn.slick.SlickException;

public class SlidingTopObstacleDownward extends TopObstacle {

	public SlidingTopObstacleDownward(float x, float y, float vx)throws SlickException {
		super(x, y, vx);
		
	}
	@Override
	 public void updatemovement() {
		    super.updatemovement();
			if(y >= Pig.ground_height - 100){	
					y -= 0.4 ;
		    	}
			}
	@Override
	public void updateWrapAround() {
		super.updateWrapAround();
		if(x < -100){
			
			 if(number == 0){
				 zerocollide = true;
			 }
			 if(lastpattern == 0 && pattern == 0){
				 x = 1900;
			 }
			 else if(lastpattern == 0 && pattern == 1){
				 if(number%2 == 0)
				    x = 1900;
				 else
					x = 1500;
			 }
			 else if(lastpattern == 1 && pattern == 0){
				 if(number%2 == 0)
				    x = 1900;
				 else
					x = 2300;
			 }
			 else if(lastpattern == 1 && pattern == 1){
				x = 1900;
			 }
			 
		}
	}
	
}
