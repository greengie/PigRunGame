package pigrun;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;



public class BottomObstacle {
	  public static final float WIDTH = 100;
	  static public final int IMAGE_HEIGHT = 150;
	  static public final int Error = 10;
	  
	  private Image bottomObstacle;
	  private float x;
	  private float y;
	  private float vx;
	  
	  public BottomObstacle(float x, float y , float vx) throws SlickException {
		this.x = x;
		this.y = y;
		this.vx = vx;
		bottomObstacle = new Image("res/bottomobstacle.png");
	}

	  public void render() {
		bottomObstacle.draw(x+WIDTH,y-IMAGE_HEIGHT/2+Error);
	  }
	  public void update() {
		    updatemovement();  
		    updateWrapAround();
		  }

	 private void updateWrapAround() {
		 if(x < -WIDTH/2){
			 x = PigRunGame.Game_Width+WIDTH/2;
		 }
	}

	public void updatemovement() {
		  x += vx;
	}
}
