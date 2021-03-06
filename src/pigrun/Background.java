package pigrun;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Background {
	  
	  
	  private Image background;
	  private float x;
	  private float y;
	  private double vx;
	  
	  
	  static public final int WIDTH = 1400; 
	  static public final int IMAGE_HEIGHT = 600;
	 
	public Background(float x, float y, double vx) throws SlickException {
		this.x = x;
		this.y = y;
		this.vx = vx;
		background = new Image("res/background.png");
				
	}

	public void render() {
		background.draw(x,y);
	}
	public void update() {
	    updatemovement();
	    updatewraparound();
	  }

	private void updatewraparound() {
		if(x < - (WIDTH/8)){
			x = -10; 
		}
	}

	private void updatemovement() {
		x += vx;
	}
}
