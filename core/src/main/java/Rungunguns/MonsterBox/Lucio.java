package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;

public class Lucio extends Monster {


    public Lucio(){
        nyouronTexture = new Texture("Monsters/Lucio/Lucio.png");
        NYOURON_SPEED = 4f;
        hitpoint = 0;
        monsterSpriteSheet = new SpriteSheet(nyouronTexture,116,75);
        monstersAnimation = new Animation();

        for(int i = 0;i < 6;i++ ) {
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(i), frameDuration / 5f);
        }


        monstersAnimation.setLooping(true);
        nyouronHeight = monsterSpriteSheet.getSprite(0).getHeight();
        nyouronWidth = monsterSpriteSheet.getSprite(0).getWidth();
        nyouroncollisionBox = generateCollisionRectAt(point.x,point.y);
        collisionRectHeight = nyouronHeight;
        collisionRectWidth = nyouronWidth;
    }


}
