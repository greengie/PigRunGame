package pigrun;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;





public class Pig {

	private Image pig;
	float x;
	float y;
	private float vjump;
	private float vy;
	
	public Pig(float x, float y, float vjump) throws SlickException {
		this.x = x;
		this.y = y;
		this.vy = vjump;
		this.vjump = vjump;
		pig = new Image("res/pig.png");		
	}

	public void render() {
		pig.draw(x,y);
	}
	public void update() {
			y -= vy;
		    vy += PigRunGame.G;
		    if(y == PigRunGame.Game_Height - PigRunGame.Game_Height/2 + 65  ){
		    	vy = 0;
		    }
	}
	public void setVy(float vy) {
	    this.vy = vy;
	  }
	public void jump() {
		vy = vjump;
	  }
	 public boolean isCollideGround() {
		 	if(y == PigRunGame.Game_Height - PigRunGame.Game_Height/2 + 65 ){
		 		
		 		return true;
		 		}
		 	return false;
		 
	  }

	
	

}
