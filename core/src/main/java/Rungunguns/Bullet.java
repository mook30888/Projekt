package Rungunguns;

import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Graphics;



public class Bullet extends Hazards {
    BulletTexture bulletTexture;
    private static float BULLET_SPEED = 20f;


    float bulletHeight;
    float bulletWidth;

    private float collisionRectHeight;
    private float collisionRectWidth = 10f;

    CollisionBox collisionBox;


    public Bullet() {
        this.bulletTexture = new BulletTexture();
        bulletHeight = bulletTexture.bullet.getHeight();
        bulletWidth = bulletTexture.bullet.getWidth();
        collisionRectHeight = bulletHeight;
    }
    @Override
    public void update(){
        point.preUpdate();
        point.set(point.getX() + BULLET_SPEED, point.getY());
    }

    public void render(Graphics g){
        g.drawTexture(bulletTexture.getBullet(), point.getX(),point.getY());
    }



}
