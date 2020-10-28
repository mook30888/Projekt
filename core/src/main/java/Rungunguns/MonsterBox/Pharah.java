package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;

public class Pharah extends Monster {


    public Pharah(){
        nyouronTexture = new Texture("Monsters/Pharah/Pharah.png");
        NYOURON_SPEED = 5;
        hitpoint = 4;
        monsterSpriteSheet = new SpriteSheet(nyouronTexture,135,110);
        monstersAnimation = new Animation();

        for(int i = 0;i < 12;i++ ) {
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(i), frameDuration);
        }

        //monsterscolor = Color.ROYAL;

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
        return new CollisionBox(tempX, tempY, nyouronWidth-70, nyouronHeight-50); //ขนาด
    }
    @Override
    protected void calcMonsterYPos() {
        nyouronX = point.x;
        nyouronY += nyouronYAccel;
        point.y = nyouronY;
        nyouroncollisionBox.set(nyouronX+30,nyouronY+40); //ตำแหน่งhitbox
    }

}
