package Rungunguns;


import com.badlogic.gdx.graphics.Color;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Graphics;
import static Rungunguns.Maingame.GRAVITY;



public class Player {
    public static float PLAYER_X = 100;
    private static float JUMP_ACCEL = -12.0f;

    private float playerTextureHeight, playerTextureWidth;
    private boolean isRotating, isTesting;

    private float playerY;
    private float playerYAccel = 0.0f;
    private float[] playerCollisionVertices;

    CollisionBox playerCollisionBox;

    private PlayerTexture playerTexture;

    public Player(PlayerTexture playerTexture, boolean isRotating, boolean isTesting) {
        this.playerTexture = playerTexture;
        playerTextureHeight = playerTexture.playerSpriteSheet.getSprite(0).getHeight();
        playerTextureWidth = playerTexture.playerSpriteSheet.getSprite(0).getWidth();
        playerCollisionBox = generateCollisionRectAt(PLAYER_X, playerY);
        playerY = 300-playerTextureHeight/2;
        this.isRotating = isRotating;
        this.isTesting = isTesting;
        playerTexture.playerAnimation.setLooping(true);
    }

    void settingPlayerJumping() {
        playerYAccel = JUMP_ACCEL;
    }

    CollisionBox generateCollisionRectAt(float xPos, float yPos) {
        int tempX = (int) xPos;
        int tempY = (int) yPos;
        return new CollisionBox(tempX, tempY, playerTextureWidth, playerTextureHeight);
    }


    void DrawPlayerCollisionBox(Graphics g) {
        g.setColor(Color.RED);
        playerCollisionVertices = playerCollisionBox.getVertices();

        for(int i=0; i<7; i=i+2){
            g.drawLineSegment(playerCollisionVertices[i],playerCollisionVertices[i+1],
                    playerCollisionVertices[(i+2) % 8],playerCollisionVertices[(i+3) % 8]);
        }
    }


    void update(boolean isJumping, TopBottomEdge ground2,TopBottomEdge ground1, float delta) {

        playerCollisionBox.preUpdate();

        playerTexture.playerAnimation.update(delta);


        if (isJumping) {
            settingPlayerJumping();
        } else {
            if(playerY <= ground2.getGroundTextureHeight() ||playerY <= ground1.getGroundTextureHeight() )
                playerYAccel += GRAVITY;
            else playerYAccel = 0;
        }


        calcPlayerYPos();
    }


    void render(Graphics g) {
        //TODO Give plane tilt when flying up or down.
        if (getPlayerYAccel() > 0) {

        } else if (getPlayerYAccel() > 0) {

        }

        playerTexture.playerAnimation.draw(g,PLAYER_X,getPlayerY());

        if(isTesting){
            DrawPlayerCollisionBox(g);
        }

    }

    void calcPlayerYPos() {
        playerY += playerYAccel;
        playerCollisionBox.setY(playerY);
    }

    float getPlayerY() {
        return playerY;
    }

    float getPlayerYAccel() {
        return playerYAccel;
    }

    float getPlayerTextureHeight() {
        return playerTextureHeight;
    }



















}
