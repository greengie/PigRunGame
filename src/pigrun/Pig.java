package pigrun;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Pig {

	private Image pig;
	float x;
	float y;
	
	public Pig(int x, int y) throws SlickException {
		this.x = x;
		this.y = y;		
		pig = new Image("res/pig.png");		
	}

	public void render() {
		pig.draw(x,y);
	}

}
