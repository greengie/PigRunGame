package pigrun;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Background {
	  
	  
	  private Image image;
	  private float x;
	  private float y;
	 
	public Background(float x, float y) throws SlickException {
		this.x = x;
		this.y = y;
		image = new Image("res/background.png");
				
	}

	public void render() {
		image.draw(x,y);
	}

}
