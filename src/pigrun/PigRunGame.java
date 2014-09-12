package pigrun;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;



public class PigRunGame extends BasicGame {

	public PigRunGame(String title) {
		super(title);
		
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		
		
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		
		
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		
		
	}
	public static void main(String[] args) {
	    try {
	      PigRunGame game = new PigRunGame("Pig Run Game");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(640,480, false);
	      appgc.setMinimumLogicUpdateInterval(1000 / 50);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }

}
