package Rungunguns;

import Rungunguns.TextureBox.GrenadeTexture;
import com.badlogic.gdx.graphics.Color;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Graphics;

import java.util.List;

import static Rungunguns.Maingame.GAME_HEIGHT;
import static Rungunguns.Maingame.GRAVITY;

public class Grenade extends Hazards {
    GrenadeTexture grenadeTexture;
    private static float GRENADE_SPEED = 3f;

    float GrenadeHeight;
    float GrenadetWidth;

    protected float grenadeYAccel = 0.0f;
    protected float grenadeY;

    private float[] GrenadeCollisionVertices;
    private float collisionRectHeight;
    private float collisionRectWidth = 10f;

    CollisionBox collisionBox;


    public Grenade() {
        this.grenadeTexture = new GrenadeTexture();
        GrenadeHeight = GrenadeTexture.getGrenade().getHeight();
        GrenadetWidth = GrenadeTexture.getGrenade().getWidth();
        collisionRectHeight = GrenadeHeight;
        collisionBox = generateCollisionRectAt(point.x,point.y);
    }


    protected CollisionBox generateCollisionRectAt(float xPos, float yPos) {
        int tempX = (int) xPos;
        int tempY = (int) yPos;
        return new CollisionBox(tempX, tempY, GrenadetWidth, GrenadeHeight);
    }

    public boolean isOutOfScreen(List<Bullet> bullets, List<Bullet> toDelete) {
        for (Bullet bullet : bullets) {

            if (collisionBox.getX() > 800) {
                toDelete.add(bullet);
                return true;
            }

        }
        return false;
    }


    public void update(TopBottomEdge ground1,float delta){
        point.preUpdate();
        point.set(point.getX() + GRENADE_SPEED, point.getY());

        if(grenadeY + GrenadeHeight <= GAME_HEIGHT - ground1.getGroundTextureHeight() )
            grenadeYAccel += GRAVITY;
        else grenadeYAccel = 0;

        calcbulletPos();
    }

    public void render(Graphics g){
        g.drawTexture(grenadeTexture.getGrenade(), point.getX(),point.getY());
        // DrawPlayerCollisionBox(g); กรอบแดง
    }




    void DrawPlayerCollisionBox(Graphics g) {
        g.setColor(Color.RED);
        GrenadeCollisionVertices = collisionBox.getVertices();

        for(int i=0; i<7; i=i+2){
            g.drawLineSegment(GrenadeCollisionVertices[i],GrenadeCollisionVertices[i+1],
                    GrenadeCollisionVertices[(i+2) % 8],GrenadeCollisionVertices[(i+3) % 8]);
        }
    }

    void calcbulletPos() {
        collisionBox.set(point.x,point.y);
    }
}
