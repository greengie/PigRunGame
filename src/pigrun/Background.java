package pigrun;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Background {
	  
	  
	  private Image image;
	  private float x;
	  private float y;
	  private float vx;
	  
	  static public final int WIDTH = 1400; 
	  static public final int IMAGE_HEIGHT = 600;
	 
	public Background(float x, float y, float vx) throws SlickException {
		this.x = x;
		this.y = y;
		this.vx = vx;
		image = new Image("res/background.png");
				
	}

	public void render() {
		image.draw(x,y);
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
