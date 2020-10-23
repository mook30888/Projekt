package Rungunguns;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.SpriteSheet;

import java.util.ArrayList;
import java.util.List;

import static Rungunguns.Maingame.GAME_HEIGHT;
import static Rungunguns.Maingame.GRAVITY;

public class Monster extends Hazards{
    protected boolean isRotating;
    protected Texture nyouronTexture;
    protected  float frameDuration = 0.12f;

    protected SpriteSheet monsterSpriteSheet;
    protected Animation monstersAnimation;

    protected static float NYOURON_X = 100;
    protected static float JUMP_ACCEL = -12.0f;
    protected float nyouronY, nyouronX;
    protected float nyouronYAccel = 0.0f;

    protected static float NYOURON_SPEED;
    protected float nyouronHeight;
    protected float nyouronWidth;
    protected int hitpoint;

    protected float collisionRectHeight;
    protected float collisionRectWidth;

    private float[] nyouronCollisionVertices;
    protected CollisionBox nyouroncollisionBox;

    protected CollisionBox generateCollisionRectAt(float xPos, float yPos) {
        int tempX = (int) xPos;
        int tempY = (int) yPos;
        return new CollisionBox(tempX, tempY, nyouronWidth, nyouronHeight);
    }

    protected void update(TopBottomEdge ground1,float delta) {
        point.preUpdate();
        monstersAnimation.update(delta);

        if(nyouronY + nyouronHeight <= GAME_HEIGHT - ground1.getGroundTextureHeight() )
            nyouronYAccel += GRAVITY;
        else nyouronYAccel = 0;

        calcMonsterYPos();
        point.set(point.getX() - NYOURON_SPEED, point.getY());
    }

    public void render(Graphics g){
        //g.drawTexture(nyouronTexture, point.getX(),point.getY());
        DrawPlayerCollisionBox(g); //กรอบแดงแบบwallhack
        monstersAnimation.draw(g,nyouronX,nyouronY);
        //g.drawTexture(monstersAnimation.getFrame(5).getTexture(),nyouronX,nyouronY);
    }

   public boolean mongotshot(List<Bullet> bullets, List<Bullet> toDelete){
        for (Bullet bullet : bullets) {

            if(nyouroncollisionBox.intersects(bullet.collisionBox)) {
                hitpoint-=1;
                toDelete.add(bullet);
                return true;
            }
        }
        return nyouroncollisionBox.getX()  <= 0;
    }

    void calcMonsterYPos() {
        nyouronX = point.x;
        nyouronY += nyouronYAccel;
        point.y = nyouronY;
        nyouroncollisionBox.set(nyouronX,nyouronY);
       // nyouroncollisionBox.setY(nyouronY);
    }
    void DrawPlayerCollisionBox(Graphics g) {
        g.setColor(Color.RED);
        nyouronCollisionVertices = nyouroncollisionBox.getVertices();

        for(int i=0; i<7; i=i+2){
            g.drawLineSegment(nyouronCollisionVertices[i],nyouronCollisionVertices[i+1],
                    nyouronCollisionVertices[(i+2) % 8],nyouronCollisionVertices[(i+3) % 8]);
        }
    }







}
