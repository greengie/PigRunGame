package pigrun;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MediumObstacle {
	public static final float WIDTH = 100;
	static public final int IMAGE_HEIGHT = 150;
	static public final int Error = 50;
	
	private Image mediumObstacle;
	private float x;
	private float y;
	private float vx;

	public MediumObstacle(float x, float y, float vx) throws SlickException {
		this.x = x;
		this.y = y;
		this.vx = vx;
		mediumObstacle = new Image("res/bottomobstacles-medium.png");
	}

	public void render() {
	mediumObstacle.draw(x-WIDTH,y-IMAGE_HEIGHT/2-Error);
	}
	public void update() {
	    updatemovement();  
	    updateWrapAround();
	  }

	private void updateWrapAround() {
	 if(x < -PigRunGame.Game_Width/2){
		 x = PigRunGame.Game_Width+PigRunGame.Game_Width/4;
	 }
	}

	public void updatemovement() {
	  x += vx;
	}
}
