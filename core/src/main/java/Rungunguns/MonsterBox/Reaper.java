package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import Rungunguns.TopBottomEdge;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;

import static Rungunguns.Maingame.GAME_HEIGHT;
import static Rungunguns.Maingame.GRAVITY;

public class Reaper extends Monster {


    public Reaper(){
        nyouronTexture = new Texture("Monsters/Reaper/Reaper.png");
        NYOURON_SPEED = 4f;
        hitpoint = 1;
        monsterSpriteSheet = new SpriteSheet(nyouronTexture,50,50);
        monstersAnimation = new Animation();
//        for (int i = 0;i < 9;i++) {
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(0), frameDuration/8);
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(1), frameDuration/8f);
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(2), frameDuration/8f);
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(3), frameDuration/6f);
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(4), frameDuration/2f);
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(5), frameDuration);
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(6), frameDuration);
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(7), frameDuration);
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(8), frameDuration);
//        }
        monstersAnimation.setLooping(true);

        nyouronHeight = monsterSpriteSheet.getSprite(0).getHeight();
        nyouronWidth = monsterSpriteSheet.getSprite(0).getWidth();
        nyouroncollisionBox = generateCollisionRectAt(point.x,point.y);
        collisionRectHeight = nyouronHeight;
        collisionRectWidth = nyouronWidth;
    }


}
