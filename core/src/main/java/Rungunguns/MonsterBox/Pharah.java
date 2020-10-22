package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;

public class Pharah extends Monster {


    public Pharah(){
        nyouronTexture= new Texture("Monsters/Pharah/Pharah.png");
        NYOURON_SPEED = 3f;
        hitpoint = 5;
        monsterSpriteSheet = new SpriteSheet(nyouronTexture,67,70);
        monstersAnimation = new Animation();
        for (int i = 0;i < 15;i++) {
            if (i < 10 || i > 12) {
                monstersAnimation.addFrame(monsterSpriteSheet.getSprite(i), frameDuration);
            }
        }
        //monstersAnimation.addFrame(monsterSpriteSheet.getSprite(7),0.2f);
        monstersAnimation.setLooping(true);
        nyouronHeight = monsterSpriteSheet.getSprite(0).getHeight();
        nyouronWidth = monsterSpriteSheet.getSprite(0).getWidth();
        nyouroncollisionBox = generateCollisionRectAt(point.x,point.y);
        collisionRectHeight = nyouronHeight;
        collisionRectWidth = nyouronWidth;
    }

}
