package pigrun;

import org.newdawn.slick.SlickException;

public class SlidingTopObstacleUpWard extends TopObstacle {

	

	public SlidingTopObstacleUpWard(float x, float y1, float vx) throws SlickException {
		super(x, y1, vx);
	
	}
	@Override
	 public void updatemovement() {
		    super.updatemovement();
		    if( y1 <= Pig.ground_height + 50){
		    	y1 += 0.1 ;
		    }
		   
	}
	public void updateWrapAround(){
		 if(x < -100){
				
				if(number == 0){
					 zerocollide = true;
				 }
				 if(lastpattern == 0 && pattern == 0){
					 x = 2500;
					 
				 }
				 else if(lastpattern == 0 && pattern == 1){
					 if(number%2 == 0)
						    x = 2500;
						 else
							x = 2100;
					 
				 }
				 else if(lastpattern == 1 && pattern == 0){
					 if(number%2 == 0)
						    x = 2500;
						 else
							x = 2900;
					 
				 }
				 else if(lastpattern == 1 && pattern == 1){
					 	x = 2500;
					 	
				 }	
				 randomY1(); 
			}
	 	}
	
	
	
	
}

