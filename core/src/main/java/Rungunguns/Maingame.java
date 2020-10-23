package Rungunguns;

import Rungunguns.MonsterBox.Pharah;
import Rungunguns.TextureBox.BackgroundTexture;
import Rungunguns.TextureBox.PlayerTexture;
import Rungunguns.TextureBox.TopBottomEdgeTexture;
import Rungunguns.TextureBox.UserInterfaceTexture;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.viewport.FitViewport;
import org.mini2Dx.core.graphics.viewport.Viewport;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maingame extends BasicGame {
	public static final String GAME_IDENTIFIER = "Rungungun";


    public static float GRAVITY;
    public static float FLYING_SPEED;
    public static final float GAME_WIDTH = 800;
    public static final float GAME_HEIGHT = 500;

    //These variables change how it feels to play the game.
    private static float GAME_GRAVITY = 0.6f;
    private static int scorethisgame = 0;
    private static float GAME_FLYING_SPEED = 8f;
    private static boolean IS_ROTATING = false;
    private static boolean IS_TESTING = false;

    private boolean inGame, isDead;
    private static int playerScore, highScore;

    private List<Bullet> bullets = new ArrayList<Bullet>();

    Viewport fitViewport;
    InputHandler inputHandler;
    Player player;
    Bullet bullet;
    PlayerTexture playerTexture;
    TopBottomEdge ground1, ground2;
    TopBottomEdgeTexture topBottomEdgeTexture;
    Background background1, background2;
    BackgroundTexture backgroundTexture;
    List<Monster>  monsters;
    UserInterface userInterface;
    UserInterfaceTexture userInterfaceTexture;


    int pillarTiming;



    @Override
    public void initialise() {
        GRAVITY = 0.0f;
        FLYING_SPEED = GAME_FLYING_SPEED;
        inGame = false;
        isDead = false;
        playerScore = 0;
        inputHandler = new InputHandler();

        playerTexture = new PlayerTexture();
        backgroundTexture = new BackgroundTexture();

        topBottomEdgeTexture = new TopBottomEdgeTexture();
        ground1 = new TopBottomEdge(topBottomEdgeTexture);
        ground2 = new TopBottomEdge(topBottomEdgeTexture);
        ground2.generateHazardAtPos(GAME_WIDTH,GAME_HEIGHT - ground1.getGroundTextureHeight());
        background1 = new Background(backgroundTexture);
        background1.generateHazardAtPos(0,0);
        background2 = new Background(backgroundTexture);
        background2.generateHazardAtPos(background1.width()-5, 0.0f);
        bullet = new Bullet();
        player = new Player(playerTexture, IS_TESTING);
        monsters = new ArrayList<Monster>();
        fitViewport = new FitViewport(GAME_WIDTH, GAME_HEIGHT);
        userInterface = new UserInterface(new UserInterfaceTexture());



        pillarTiming = 60;

    }
    
    @Override
    public void update(float delta) {
        if (isDead) {

        } else {
            if (inputHandler.spacePressed()) {
                GRAVITY = GAME_GRAVITY;
                inGame = true;
            }
            if (inputHandler.zPressed()){
                player.shooting();
                Bullet bullet = new Bullet();
                bullets.add(bullet);
                bullet.generateHazardAtPos(Player.PLAYER_X + player.getPlayerTextureWidth(), randomFloatMinMax(player.getPlayerY()+30,player.getPlayerY()+15));

            }
            if (inputHandler.xPressed()){
                player.shooting();
                Bullet bullet = new Bullet();
                bullets.add(bullet);
                bullet.generateHazardAtPos(Player.PLAYER_X + player.getPlayerTextureWidth(), randomFloatMinMax(player.getPlayerY()+42,player.getPlayerY()+30));

            }

            if(randomFloatMinMax(1,100) < 5 ){
                //NyouronA mon1 = new NyouronA();
                Pharah mon2 = new Pharah();
                //monsters.add(mon1);
                monsters.add(mon2);
                //mon1.generateHazardAtPos(GAME_WIDTH,GAME_HEIGHT/2);
                mon2.generateHazardAtPos(GAME_WIDTH,GAME_HEIGHT/2);
            }

            List<Bullet> toDel = new ArrayList<Bullet>();
            List<Monster> toRemove = new ArrayList<Monster>();
            for(Monster monster:monsters){
                monster.update(ground1,delta);
                if(monster.mongotshot(bullets,toDel)) {
                    if(monster.hitpoint == 0){
                        toRemove.add(monster);
                        scorethisgame +=1; //mons ตายเพิ่ม 1
                    }

                }
                if(player.playerGotHit(monsters)){
                    setDead();

                }
            }
            for (Bullet bul: bullets) {
                bul.isOutOfScreen(bullets,toDel);
                bul.update();
            }
            bullets.removeAll(toDel);
            monsters.removeAll(toRemove);



            player.update(inputHandler.spacePressed(),GAME_HEIGHT - ground1.getGroundTextureHeight(), delta);
            ground1.update();
            ground2.update();
            background1.update();
            background2.update();


        }

    }
    
    @Override
    public void interpolate(float alpha) {
    
    }
    
    @Override
    public void render(Graphics g) {


        fitViewport.apply(g);
        background1.render(g);
        background2.render(g);
        player.render(g);
        //ground1.render(g);
       // ground2.render(g);
        for (Bullet bul: bullets) {
            bul.render(g);
        }
        for(Monster monster : monsters){
            monster.render(g);
        }

        userInterface.displayScore(g,scorethisgame);

        if(!inGame){
            //userInterface.displayHighscore(g,highScore);
            userInterface.displayStartMessage(g);
            userInterface.displayZX(g);

        }
        if (isDead){
            userInterface.displayResultMessage(g);
            userInterface.displayScore(g,scorethisgame);
        }


    }

    void setDead() {
        isDead = false;   //อมตะ
        FLYING_SPEED = 0f;
        GRAVITY = 0f;
    }

    float randomFloatMinMax(float min, float max) {
        float leftLimit = min;
        float rightLimit = max;
        return leftLimit + new Random().nextFloat() * (rightLimit - leftLimit);
    }

    public static int getScore(){return scorethisgame;}  //เผื่อเรียก







}
