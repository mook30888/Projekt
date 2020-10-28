package Rungunguns;

import Rungunguns.MonsterBox.*;
import Rungunguns.TextureBox.BackgroundTexture;
import Rungunguns.TextureBox.PlayerTexture;
import Rungunguns.TextureBox.TopBottomEdgeTexture;
import Rungunguns.TextureBox.UserInterfaceTexture;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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
    public static AssetManager manager;

    private static float GAME_GRAVITY = 0.6f;
    private static int scorethisgame = 0;
    private static float GAME_FLYING_SPEED = 8f;
    private static boolean IS_ROTATING = false;
    private static boolean IS_TESTING = false;

    private boolean inGame, isDead,Zshoot=true,Xshoot=false;
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


    float spawnrate , startgame ;
    int stagenow=0;



    @Override
    public void initialise() {
        GRAVITY = 0.0f;
        FLYING_SPEED = GAME_FLYING_SPEED;
        inGame = false;
        isDead = false;
        playerScore = 0;
        inputHandler = new InputHandler();
        spawnrate = 10;
        startgame =0;
        scorethisgame =0;

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

        manager = new AssetManager();
        manager.load("Sounds/gunshot.mp3", Sound.class);
        manager.load("Sounds/Pekora.wav", Music.class);
        manager.load("Sounds/Star Fox.wav",Music.class);
        manager.load("Sounds/flash.mp3",Sound.class);
        manager.load("Sounds/enthu.wav",Sound.class);
        manager.finishLoading();


    }
    
    @Override
    public void update(float delta) {
        if (isDead) {
            if (inputHandler.SpacePressed()) {
                initialise();
            }

        } else {
            checkinput();
            if(inGame) {



                checkStage();
                switch (stagenow){
                    case 0:
                        spawnmonster(new Pharah(), 10);
                        spawnmonster(new Lucio(), 3);
                        spawnmonster(new Tracer(), 4);
                        spawnmonster(new Reinhardt(), 2);
                        spawnmonster(new Zenyatta(),3);
                        spawnmonster(new Junkrat(),2);
                        spawnmonster(new Genji(),2);break;
                    case 1:
                        spawnmonster(new Pharah(), 15);
                        spawnmonster(new Lucio(), 5);
                        spawnmonster(new Tracer(), 6);
                        spawnmonster(new Reinhardt(), 6);
                        spawnmonster(new Mercy(), 5);
                        spawnmonster(new Zenyatta(),5);
                        spawnmonster(new Junkrat(),4);
                        spawnmonster(new Genji(),4);break;
                    case 2:
                        spawnmonster(new Pharah(), 11);
                        spawnmonster(new Lucio(), 10);
                        spawnmonster(new Tracer(), 11);
                        spawnmonster(new Reinhardt(), 10);
                        spawnmonster(new Mercy(), 5);
                        spawnmonster(new Zenyatta(),5);
                        spawnmonster(new Missile(),10);
                        spawnmonster(new Junkrat(),10);
                        spawnmonster(new Genji(),10);break;
                    case 3:
                        spawnmonster(new Pharah(), 35);
                        spawnmonster(new Lucio(), 8);
                        spawnmonster(new Tracer(), 30);
                        spawnmonster(new Reinhardt(), 14);
                        spawnmonster(new Mercy(), 5);
                        spawnmonster(new Missile(),10);
                        spawnmonster(new Missile(),15);
                        spawnmonster(new Zenyatta(),5);
                        spawnmonster(new Junkrat(),3);
                        break;
                    case 4:
                        spawnmonster(new Pharah(), 40);
                        spawnmonster(new Lucio(), 10);
                        spawnmonster(new Tracer(), 37);
                        spawnmonster(new Reinhardt(), 18);
                        spawnmonster(new Mercy(), 20);
                        spawnmonster(new Missile(),15);
                        spawnmonster(new Zenyatta(),8);
                        spawnmonster(new Junkrat(),4);break;
                }



                List<Bullet> toDel = new ArrayList<Bullet>();
                List<Monster> toRemove = new ArrayList<Monster>();
                List<Grenade> toDelete = new ArrayList<Grenade>();

                manager.get("Sounds/Pekora.wav", Music.class).stop();
                manager.get("Sounds/Star Fox.wav",Music.class).play();


                for (Monster monster : monsters) {
                    monster.update(ground1, delta);
                    if (monster.mongotshot(bullets, toDel) || monster.mongotbomb(grenades, toDelete)) {
                        if (monster.hitpoint <= 0) {
                            toRemove.add(monster);
                            scorethisgame += 1; //mons ตายเพิ่ม 1
                            if (scorethisgame % 10 == 0) {
                                spawnrate += 5;
                            }
                        }
                    }

                    if (player.playerGotHit(monster)&&inGame) {
                            setDead();
                    }
                }


                for (Bullet bul : bullets) {
                    bul.BulletisOutOfScreen(bullets, toDel);
                    bul.update();

                }


                for (Grenade gre : grenades) {
                    gre.GrenadeisOutOfScreen(grenades, toDelete, GAME_HEIGHT - ground1.getGroundTextureHeight() - player.getPlayerTextureHeight());
                    gre.update(ground1);
                }

                bullets.removeAll(toDel);
                grenades.removeAll(toDelete);
                monsters.removeAll(toRemove);


                player.update(inputHandler.arrowupPressed(), GAME_HEIGHT - ground1.getGroundTextureHeight(), delta);
                ground1.update();
                ground2.update();
                background1.update();
                background2.update();
            }


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
            userInterface.displayUp(g);
            userInterface.displayDown(g);
            userInterface.displayBomb(g);
            manager.get("Sounds/Pekora.wav", Music.class).play();
        }
        if (isDead){
            userInterface.displayHighscore(g,scorethisgame);
            userInterface.displayResultMessage(g);
            userInterface.displayReturn(g);
            manager.get("Sounds/Star Fox.wav",Music.class).stop();



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
            a.generateHazardAtPos(GAME_WIDTH,GAME_HEIGHT);
        }

    }

    private void checkinput() {
        if (inputHandler.arrowupPressed()) {
            GRAVITY = GAME_GRAVITY;

            inGame = true;
        }
        if (inputHandler.zPressed() && Zshoot){

            player.shooting();
            Bullet bullet = new Bullet();
            bullets.add(bullet);
            bullet.generateHazardAtPos(Player.PLAYER_X + player.getPlayerTextureWidth(), randomFloatMinMax(player.getPlayerY()+30,player.getPlayerY()+15));
            Zshoot = false;
            Xshoot = true;
            manager.get("Sounds/gunshot.mp3", Sound.class).play();

        }
        if (inputHandler.xPressed() && Xshoot){
            player.shooting();
            Bullet bullet = new Bullet();
            bullets.add(bullet);
            bullet.generateHazardAtPos(Player.PLAYER_X + player.getPlayerTextureWidth(), randomFloatMinMax(player.getPlayerY()+42,player.getPlayerY()+30));
            Zshoot=true;
            Xshoot=false;
            manager.get("Sounds/gunshot.mp3", Sound.class).play();
        }

        if (inputHandler.SpacePressed()){
            player.Thrownade();
            Grenade grenade = new Grenade();
            grenades.add(grenade);
            grenade.generateHazardAtPos(Player.PLAYER_X + player.getPlayerTextureWidth(), randomFloatMinMax(player.getPlayerY()+42,player.getPlayerY()+30));
            manager.get("Sounds/flash.mp3",Sound.class).play();

        }
        if(inputHandler.arrowDownPressed()){
            player.atground(GAME_HEIGHT - ground1.getGroundTextureHeight()-player.getPlayerTextureHeight());
        }
    }


    private void checkStage(){
        if(scorethisgame==0)stagenow=0;
        if(15 <scorethisgame && scorethisgame <=50)stagenow=1;
        if(50 <scorethisgame && scorethisgame <=200)stagenow=2;
        if(200 <scorethisgame && scorethisgame <=500)stagenow=3;
        if(500 < scorethisgame)stagenow=4;

    }

}
