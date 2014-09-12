package pigrun;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ground {
	private Image image;
	private int y;
	private int x;
	
	public Ground(int x, int y) throws SlickException {
		this.x = x;
	    this.y = y;
	    image = new Image("res/ground.png");
	}

	public void render() {
		 image.draw(x , 480 - (y + 20));
	}
}
