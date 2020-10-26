package Rungunguns;

import Rungunguns.MonsterBox.Mercy;
import Rungunguns.MonsterBox.Pharah;
import Rungunguns.MonsterBox.Lucio;
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
    private List<Grenade> grenades = new ArrayList<Grenade>();

    Viewport fitViewport;
    InputHandler inputHandler;
    Player player;
    Bullet bullet;
    Grenade grenade;
    PlayerTexture playerTexture;
    TopBottomEdge ground1, ground2;
    TopBottomEdgeTexture topBottomEdgeTexture;
    Background background1, background2;
    BackgroundTexture backgroundTexture;
    List<Monster>  monsters;
    UserInterface userInterface;
    UserInterfaceTexture userInterfaceTexture;


    float spawnrate;



    @Override
    public void initialise() {
        GRAVITY = 0.0f;
        FLYING_SPEED = GAME_FLYING_SPEED;
        inGame = false;
        isDead = false;
        playerScore = 0;
        inputHandler = new InputHandler();
        spawnrate = 10;

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
        grenade = new Grenade();
        player = new Player(playerTexture, IS_TESTING);
        monsters = new ArrayList<Monster>();
        fitViewport = new FitViewport(GAME_WIDTH, GAME_HEIGHT);
        userInterface = new UserInterface(new UserInterfaceTexture());



    }
    
    @Override
    public void update(float delta) {
        if (isDead) {

        } else {
            checkinput();

            Pharah mon2 = new Pharah();
            Mercy mon3= new Mercy();
            Lucio mon1 = new Lucio();

            spawnmonster(mon1,5);
            spawnmonster(mon2,spawnrate);
            spawnmonster(mon3,randomFloatMinMax(spawnrate-50,spawnrate));


            List<Bullet> toDel = new ArrayList<Bullet>();
            List<Monster> toRemove = new ArrayList<Monster>();
            List<Grenade> toDelete = new ArrayList<Grenade>();



            for(Monster monster:monsters){
                monster.update(ground1,delta);
                if(monster.mongotshot(bullets,toDel) || monster.mongotbomb(grenades,toDelete)) {
                    if(monster.hitpoint == 0){
                        toRemove.add(monster);
                        scorethisgame +=1; //mons ตายเพิ่ม 1
                        if(scorethisgame%10==0){
                            spawnrate+=5;
                        }
                    }

                }
                if(player.playerGotHit(monsters)){
                    setDead();
                }
            }



            for (Bullet bul: bullets) {
                bul.BulletisOutOfScreen(bullets,toDel);
                bul.update();
            }

            for (Grenade gre: grenades) {
                gre.update(ground1);
            }

            bullets.removeAll(toDel);
            grenades.removeAll(toDelete);
            monsters.removeAll(toRemove);



            player.update(inputHandler.arrowupPressed(),GAME_HEIGHT - ground1.getGroundTextureHeight(), delta);
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
        for (Grenade gre: grenades) {
            gre.render(g);
        }

        for(Monster monster : monsters){
            monster.render(g);
        }

        userInterface.displayScore(g,scorethisgame);

        if(!inGame){
            //userInterface.displayHighscore(g,highScore);
            userInterface.displayStartMessage(g);
            userInterface.displayZX(g);
            userInterface.displaySpace(g);

        }
        if (isDead){
            userInterface.displayHighscore(g,scorethisgame);
            userInterface.displayResultMessage(g);
            userInterface.displayReturn(g);
        }


    }

    void setDead() {
        isDead = true;   //อมตะ
        FLYING_SPEED = 0f;
        GRAVITY = 0f;
    }

    float randomFloatMinMax(float min, float max) {
        float leftLimit = min;
        float rightLimit = max;
        return leftLimit + new Random().nextFloat() * (rightLimit - leftLimit);
    }

    public static int getScore(){return scorethisgame;}  //เผื่อเรียก

    public void spawnmonster(Monster a,float spawnrate){
        if(randomFloatMinMax(1,1000) < spawnrate ){
            monsters.add(a);
            a.generateHazardAtPos(GAME_WIDTH,GAME_HEIGHT/2);
        }

    }

    private void checkinput() {
        if (inputHandler.arrowupPressed()) {
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

        if (inputHandler.cPressed()){
            player.Thrownade();
            Grenade grenade = new Grenade();
            grenades.add(grenade);
            grenade.generateHazardAtPos(Player.PLAYER_X + player.getPlayerTextureWidth(), randomFloatMinMax(player.getPlayerY()+42,player.getPlayerY()+30));

        }
        if(inputHandler.arrowDownPressed()){
            player.atground(GAME_HEIGHT - ground1.getGroundTextureHeight()-player.getPlayerTextureHeight());
        }
    }








}
