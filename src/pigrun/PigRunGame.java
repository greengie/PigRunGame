package pigrun;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;



public class PigRunGame extends BasicGame {

	private static final int Game_Width = 800;
	private static final int Game_Height = 600;
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
		background = new Background(0,0);
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
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
