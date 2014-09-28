package pigrun;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MediumObstacle extends BottomObstacle {

	static public final int IMAGE_HEIGHT = 210;
	static public final int Error = 10;
	
	protected Image mediumObstacle;

	public MediumObstacle(float x, float y, float vx) throws SlickException {
		super(x, y, vx);
		mediumObstacle = new Image("res/mediumobstacles.png");
	}
	@Override
	 public void render() {
		mediumObstacle.draw(x-WIDTH,y-IMAGE_HEIGHT/2-Error);
	  }
	
}
	