package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;

public class Pharah extends Monster {


    public Pharah(){
        nyouronTexture = new Texture("Monsters/Pharah/Pharah4.png");
        NYOURON_SPEED = 3f;
        hitpoint = 1;
        monsterSpriteSheet = new SpriteSheet(nyouronTexture,73,70);
        monstersAnimation = new Animation();

        for(int i = 0;i < 12;i++ ) {
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(i), frameDuration / 1.5f);
        }

        monstersAnimation.setLooping(true);
        nyouronHeight = monsterSpriteSheet.getSprite(0).getHeight();
        nyouronWidth = monsterSpriteSheet.getSprite(0).getWidth();
        nyouroncollisionBox = generateCollisionRectAt(point.x,point.y);
        collisionRectHeight = nyouronHeight;
        collisionRectWidth = nyouronWidth;
    }

}
