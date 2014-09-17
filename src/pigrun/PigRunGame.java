package pigrun;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;



public class PigRunGame extends BasicGame {

	public static final int Game_Width = 1200;
	public static final int Game_Height = 600;
	public static final float Background_VX = -5;
	public static final float Pig_Jump_Vy = 12;
	public static final float G = (float) -0.4;
	
	private boolean isStarted;
	
	
	private Background background;
	private Pig pig;
	

	public PigRunGame(String title) {
		super(title);
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		background.render();
		pig.render();
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		background = new Background(-Game_Width/8,0,Background_VX);
		pig = new Pig(Game_Width/5,Game_Height - Game_Height/2+65,Pig_Jump_Vy);
		isStarted = false;
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if(isStarted == true){
			background.update();
			pig.update();
			}
		}
	
	@Override
	  public void keyPressed(int key, char c) {
		if(Pig.check_jump < 2){
			if (key == Input.KEY_SPACE) {
				pig.jump();
				isStarted = true;
				Pig.check_jump ++ ;
			}
		}
	}
	
	public static void main(String[] args) {
	    try {
	      PigRunGame game = new PigRunGame("PigRun Game");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(Game_Width, Game_Height, false);
	      appgc.setMinimumLogicUpdateInterval(1000 / 60);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }

}
