package Rungunguns;

import Rungunguns.TextureBox.BombEffect;
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


    BombEffect bombEffect;
    CollisionBox collisionBox;


    public Grenade() {
        this.grenadeTexture = new GrenadeTexture();
        bombEffect = new BombEffect();
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



    public void update(TopBottomEdge ground1){
        point.preUpdate();
        point.set(point.getX() + GRENADE_SPEED, point.getY());

        if(grenadeY + GrenadeHeight <= GAME_HEIGHT - ground1.getGroundTextureHeight() ) {
            grenadeYAccel += GRAVITY*2;

        }
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
        point.y += grenadeYAccel;
        collisionBox.set(point.x,point.y);
    }

    public boolean GrenadeisOutOfScreen(List<Grenade> grenades, List<Grenade> toDelete,float y) {
        for (Grenade grenade : grenades) {

            if (collisionBox.getY() > y) {
                toDelete.add(grenade);
                return true;
            }

        }
        return false;
    }

}
