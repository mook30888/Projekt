package Rungunguns;

import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.engine.geom.CollisionPoint;


public class Bullet extends Hazards {
    BulletTexture bulletTexture;
    private static float BULLET_SPEED = 0.3f;

    float bulletHeight;
    float bulletWidth;
    float halfbulletWidth;

    private float collisionRectHeight;
    private float collisionRectWidth = 10f;

    CollisionBox collisionRectTop, collisionRectBottom;

    public Bullet(BulletTexture bulletTexture) {
        this.bulletTexture = bulletTexture;
        bulletHeight = bulletTexture.bullet.getHeight();
        bulletWidth = bulletTexture.bullet.getWidth();
        collisionRectHeight = bulletHeight;
        halfbulletWidth = bulletWidth / 2.0f;
    }


    void generateHazardAtPos(float xPos, float yPos) {
        super.generateHazardAtPos(xPos, yPos);

    }




}
