package Rungunguns;

import com.badlogic.gdx.graphics.Color;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Graphics;



public class Bullet extends Hazards {
    BulletTexture bulletTexture;
    private static float BULLET_SPEED = 20f;
    protected float bulletY, bulletX;

    float bulletHeight;
    float bulletWidth;

    private float[] bulletCollisionVertices;
    private float collisionRectHeight;
    private float collisionRectWidth = 10f;

    CollisionBox collisionBox;


    public Bullet() {
        this.bulletTexture = new BulletTexture();
        bulletHeight = bulletTexture.bullet.getHeight();
        bulletWidth = bulletTexture.bullet.getWidth();
        collisionRectHeight = bulletHeight;
        collisionBox = generateCollisionRectAt(bulletX,bulletY);
    }


    protected CollisionBox generateCollisionRectAt(float xPos, float yPos) {
        int tempX = (int) xPos;
        int tempY = (int) yPos;
        return new CollisionBox(tempX, tempY, bulletWidth, bulletHeight);
    }


    @Override
    public void update(){
        point.preUpdate();
        point.set(point.getX() + BULLET_SPEED, point.getY());
        calcbulletPos();
    }

    public void render(Graphics g){
        g.drawTexture(bulletTexture.getBullet(), point.getX(),point.getY());
        DrawPlayerCollisionBox(g);
    }




    void DrawPlayerCollisionBox(Graphics g) {
        g.setColor(Color.RED);
        bulletCollisionVertices = collisionBox.getVertices();

        for(int i=0; i<7; i=i+2){
            g.drawLineSegment(bulletCollisionVertices[i],bulletCollisionVertices[i+1],
                    bulletCollisionVertices[(i+2) % 8],bulletCollisionVertices[(i+3) % 8]);
        }
    }

    void calcbulletPos() {
        //bulletX = point.x;
        //point.y = bulletY;
        collisionBox.set(point.x,point.y);
    }



}
