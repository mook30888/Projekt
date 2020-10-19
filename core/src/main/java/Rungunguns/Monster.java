package Rungunguns;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Graphics;

public abstract class Monster extends Hazards{
    protected boolean isRotating;
    protected Texture nyouronTexture;

    protected static float NYOURON_SPEED;
    protected float nyouronHeight;
    protected float nyouronWidth;
    protected int hitpoint;

    protected float collisionRectHeight;
    protected float collisionRectWidth;

    protected CollisionBox collisionBox;

@Override
    void update() {
        point.preUpdate();
        point.set(point.getX() - NYOURON_SPEED, point.getY());
    }

    public void render(Graphics g){
        g.drawTexture(nyouronTexture, point.getX(),point.getY());
    }







}
