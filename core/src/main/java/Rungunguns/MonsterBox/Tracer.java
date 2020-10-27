package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;

public class Tracer extends Monster {


    public Tracer(){
        nyouronTexture = new Texture("Monsters/Tracer/Tracer.png");
        NYOURON_SPEED = 8;
        hitpoint = 2;
        monsterSpriteSheet = new SpriteSheet(nyouronTexture,75,75);
        monstersAnimation = new Animation();

        for(int i = 0;i < 8;i++ ) {
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(i), frameDuration/1.5f);
        }

        monstersAnimation.setLooping(true);

        monsterscolor = Color.ORANGE;

        nyouronHeight = monsterSpriteSheet.getSprite(0).getHeight();
        nyouronWidth = monsterSpriteSheet.getSprite(0).getWidth();
        nyouroncollisionBox = generateCollisionRectAt(point.x,point.y);
        collisionRectHeight = nyouronHeight;
        collisionRectWidth = nyouronWidth;
    }

    @Override
    protected CollisionBox generateCollisionRectAt(float xPos, float yPos) {
        int tempX = (int) xPos;
        int tempY = (int) yPos;
        return new CollisionBox(tempX, tempY, nyouronWidth-35, nyouronHeight-20); //ขนาด
    }
    @Override
    protected void calcMonsterYPos() {
        nyouronX = point.x;
        nyouronY += nyouronYAccel;
        point.y = nyouronY;
        nyouroncollisionBox.set(nyouronX+10,nyouronY+15); //ตำแหน่งhitbox
    }

}
