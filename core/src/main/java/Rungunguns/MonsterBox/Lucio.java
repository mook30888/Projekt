package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;

public class Lucio extends Monster {


    public Lucio(){
        nyouronTexture = new Texture("Monsters/Lucio/Webp.net-resizeimage.png");
        NYOURON_SPEED = 8f;
        hitpoint = 0;
        monsterSpriteSheet = new SpriteSheet(nyouronTexture,60,70);
        monstersAnimation = new Animation();

                monstersAnimation.addFrame(monsterSpriteSheet.getSprite(0), frameDuration);
                monstersAnimation.addFrame(monsterSpriteSheet.getSprite(1), frameDuration);
                monstersAnimation.addFrame(monsterSpriteSheet.getSprite(2), frameDuration);
                monstersAnimation.addFrame(monsterSpriteSheet.getSprite(3), frameDuration);
                monstersAnimation.addFrame(monsterSpriteSheet.getSprite(4), frameDuration);
                monstersAnimation.addFrame(monsterSpriteSheet.getSprite(5), frameDuration);
                monstersAnimation.addFrame(monsterSpriteSheet.getSprite(6), frameDuration);
                monstersAnimation.addFrame(monsterSpriteSheet.getSprite(7), frameDuration);


        //monstersAnimation.addFrame(monsterSpriteSheet.getSprite(7),0.2f);
        monstersAnimation.setLooping(true);
        nyouronHeight = monsterSpriteSheet.getSprite(0).getHeight();
        nyouronWidth = monsterSpriteSheet.getSprite(0).getWidth();
        nyouroncollisionBox = generateCollisionRectAt(point.x,point.y);
        collisionRectHeight = nyouronHeight;
        collisionRectWidth = nyouronWidth;
    }

}
