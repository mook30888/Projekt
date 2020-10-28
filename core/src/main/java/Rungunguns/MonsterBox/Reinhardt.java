package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;

public class Reinhardt extends Monster {


    public Reinhardt(){
        nyouronTexture = new Texture("Monsters/Reinh/Reinhardt.png");
        NYOURON_SPEED = 3.8f;
        hitpoint = 20;
        monsterSpriteSheet = new SpriteSheet(nyouronTexture,146,103);
        monstersAnimation = new Animation();

        for(int i = 0;i < 12;i++ ) {
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(i), frameDuration/1.4f);
        }

        //monsterscolor = Color.GRAY;

        monstersAnimation.setLooping(true);

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
        return new CollisionBox(tempX, tempY, nyouronWidth-60, nyouronHeight-30); //ขนาดhitbox
    }
    @Override
    protected void calcMonsterYPos() {
        nyouronX = point.x;
        nyouronY += nyouronYAccel;
        point.y = nyouronY;
        nyouroncollisionBox.set(nyouronX+30,nyouronY+20); //ตำแหน่งhitbox
    }

}