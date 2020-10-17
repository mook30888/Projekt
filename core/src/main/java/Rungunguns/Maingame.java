package Rungunguns;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.viewport.FitViewport;
import org.mini2Dx.core.graphics.viewport.Viewport;

import java.util.Random;

public class Maingame extends BasicGame {
	public static final String GAME_IDENTIFIER = "Rungungun";
	private Texture texture;

    public static float GRAVITY;
    public static float FLYING_SPEED;
    public static final float GAME_WIDTH = 800;
    public static final float GAME_HEIGHT = 500;

    //These variables change how it feels to play the game.
    private static float GAME_GRAVITY = 0.6f;
    private static float GAME_FLYING_SPEED = 8f;
    private static boolean IS_ROTATING = false;
    private static boolean IS_TESTING = false;

    private boolean inGame, isDead;
    private static int playerScore, highScore;


    Viewport fitViewport;
    InputHandler inputHandler;
    Player player;
    PlayerTexture playerTexture;


    CollisionBox[] collisionRectanglesBottom, collisionRectanglesTop;

    int pillarIndexHead, pillarIndexTail;
    int pillarTiming;



    @Override
    public void initialise() {
        GRAVITY = 0.0f;
        FLYING_SPEED = GAME_FLYING_SPEED;
        inGame = false;
        isDead = false;
        playerScore = 0;


        playerTexture = new PlayerTexture();


        player = new Player(playerTexture, IS_ROTATING, IS_TESTING);

        fitViewport = new FitViewport(GAME_WIDTH, GAME_HEIGHT);


        pillarTiming = 60;

    }
    
    @Override
    public void update(float delta) {
        if (isDead) {
            if (inputHandler.spacePressed()) {
                initialise();
            }
        } else {

            if (inputHandler.spacePressed()) {
                GRAVITY = GAME_GRAVITY;
                inGame = true;
            }else{


                if (player.getPlayerY() < 0 || player.getPlayerY() > GAME_HEIGHT - player.getPlayerTextureHeight()) {
                    setDead();
                }
                player.update(inputHandler.spacePressed(), delta);
            }





        }

    }
    
    @Override
    public void interpolate(float alpha) {
    
    }
    
    @Override
    public void render(Graphics g) {
        fitViewport.apply(g);
        player.render(g);
    }

    void setDead() {
        isDead = false;   //อมตะ
        FLYING_SPEED = 0f;
        GRAVITY = 0f;
    }






}
