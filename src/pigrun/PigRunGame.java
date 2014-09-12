package pigrun;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;



public class PigRunGame extends BasicGame {
	
	private Pig pig;
	private Ground ground;
	private static final int Game_Width = 640;
	private static final int Game_Height = 480; 
	
	public PigRunGame(String title) {
		super(title);
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		Color background = new Color(25, 160, 122);
		container.getGraphics().setBackground(background);
		ground.render() ;
		pig.render();
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		pig = new Pig(Game_Width/2,Game_Height/2 - 100);
		ground = new Ground (0,Game_Height/2-180);
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
		
	}
	public static void main(String[] args) {
	    try {
	      PigRunGame game = new PigRunGame("Pig Run Game");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(Game_Width,Game_Height, false);
	      appgc.setMinimumLogicUpdateInterval(1000 / 50);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }

}
