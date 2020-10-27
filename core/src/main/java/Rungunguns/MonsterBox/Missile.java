package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import Rungunguns.TopBottomEdge;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.SpriteSheet;

import java.util.Random;

import static Rungunguns.Maingame.GAME_HEIGHT;
import static Rungunguns.Maingame.GRAVITY;

public class Missile extends Monster {


    public Missile(){
        nyouronTexture = new Texture("Monsters/Rocket/Rocket.png");
        NYOURON_SPEED = 5f;
        hitpoint = 0;
        nyouronHeight = nyouronTexture.getHeight();
        nyouronWidth = nyouronTexture.getWidth();
        nyouroncollisionBox = generateCollisionRectAt(point.x,point.y);
        collisionRectHeight = nyouronHeight;
        collisionRectWidth = nyouronWidth;
    }

    @Override
    protected void update(TopBottomEdge ground1, float delta) {
        point.preUpdate();

        if(nyouronY + nyouronHeight <= randomFloatMinMax(randomFloatMinMax(0,150),GAME_HEIGHT - ground1.getGroundTextureHeight()-300))
            nyouronYAccel += GRAVITY;
        else nyouronYAccel =0;
        calcMonsterYPos();
        point.set(point.getX() - NYOURON_SPEED, point.getY());

    }
    @Override
    public void render(Graphics g){
        DrawPlayerCollisionBox(g); //กรอบแดงแบบwallhack
        g.drawTexture(nyouronTexture,nyouronX,nyouronY);
    }


    float randomFloatMinMax(float min, float max) {
        float leftLimit = min;
        float rightLimit = max;
        return leftLimit + new Random().nextFloat() * (rightLimit - leftLimit);
    }


}
