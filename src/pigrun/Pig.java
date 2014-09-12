package pigrun;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Pig {
	
	private float x;
	private float y;
	private Image image;
	
	public Pig (float x, float y) throws SlickException{
		this.x = x;
	    this.y = y;
	    image = new Image("res/pig.png");
	}
	
	public void render() {
		 image.draw(x - 20, 480 - (y - 35));
	}
}
