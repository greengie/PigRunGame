package pigrun;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;





public class BottomObstacle {
	  public static final float WIDTH = 100;
	  static public final int IMAGE_HEIGHT = 150;
	  static public final int Error = 10;
	  
	  private Image bottomObstacle;
	  protected float x;
	  protected float y;
	  protected float vx;
	  
	  protected int pattern = 0;
	  protected int number;
	  
	  public BottomObstacle(float x, float y , float vx) throws SlickException {
		this.x = x;
		this.y = y;
		this.vx = vx;
		bottomObstacle = new Image("res/bottomobstacle.png");
	}

	  public void render() {
		bottomObstacle.draw(x-WIDTH,y-IMAGE_HEIGHT/2+Error);
	  }
	  public void update() {
		    updatemovement();  
		    updateWrapAround();
		  }

	 private void updateWrapAround() {
		 if(x < - PigRunGame.Game_Width/2 && pattern == 0 && number == 0 ){
			 x = PigRunGame.Game_Width+PigRunGame.Game_Width/2;
		 }
	}
	 
	 public void getnumber(int i){
		  number = i;
		  System.out.println(number);
	 }
	 public void getsizepattern(){
		 
	 }

	public void updatemovement() {
		  x += vx;
	}
	
	public float getX() { 
		return x; }
	public float getY() { 
		return y; }
}
