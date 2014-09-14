package pigrun;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;



public class PigRunGame extends BasicGame {

	public static final int Game_Width = 800;
	public static final int Game_Height = 600;
	public static final float Background_VX = -5;
	
	private Background background;

	public PigRunGame(String title) {
		super(title);
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		background.render();
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		background = new Background(-Game_Width/8,0,Background_VX);
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		background.update();
	}
	
	public static void main(String[] args) {
	    try {
	      PigRunGame game = new PigRunGame("PigRun Game");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(Game_Width, Game_Height, false);
	      appgc.setMinimumLogicUpdateInterval(1000 / 50);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }

}
