package Rungunguns;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;

public class Maingame extends BasicGame {
	public static final String GAME_IDENTIFIER = "Rungungun";
    PlayerTexture playerTexture;
	private Texture texture;
	
	@Override
    public void initialise() {
    	texture = new Texture("Player/planes.jpg");
        playerTexture = new PlayerTexture();
    }
    
    @Override
    public void update(float delta) {
    
    }
    
    @Override
    public void interpolate(float alpha) {
    
    }
    
    @Override
    public void render(Graphics g) {
		g.drawTexture(texture, 0f, 0f);
    }
}
