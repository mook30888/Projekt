package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;

public class Tracer extends Monster {


    public Tracer(){
        nyouronTexture = new Texture("Monsters/Tracer/Tracer.png");
        NYOURON_SPEED = 6f;
        hitpoint = 1;
        monsterSpriteSheet = new SpriteSheet(nyouronTexture,75,75);
        monstersAnimation = new Animation();

        for(int i = 0;i < 8;i++ ) {
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(i), frameDuration);
        }

        monstersAnimation.setLooping(true);
        nyouronHeight = monsterSpriteSheet.getSprite(0).getHeight();
        nyouronWidth = monsterSpriteSheet.getSprite(0).getWidth();
        nyouroncollisionBox = generateCollisionRectAt(point.x,point.y);
        collisionRectHeight = nyouronHeight;
        collisionRectWidth = nyouronWidth;
    }

}
