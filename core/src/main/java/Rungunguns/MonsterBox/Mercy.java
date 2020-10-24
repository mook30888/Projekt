package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import Rungunguns.TopBottomEdge;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;

import static Rungunguns.Maingame.GAME_HEIGHT;
import static Rungunguns.Maingame.GRAVITY;

public class Mercy extends Monster {


    public Mercy(){
        nyouronTexture= new Texture("Monsters/Pharah/Pharah1.png");
        NYOURON_SPEED = 1.5f;
        hitpoint = 1;
        monsterSpriteSheet = new SpriteSheet(nyouronTexture,60,60);
        monstersAnimation = new Animation(); //test commit 2
        for (int i = 0;i < 15;i++) {
            if (i < 10 || i > 12) {
                monstersAnimation.addFrame(monsterSpriteSheet.getSprite(i), frameDuration);
            }
        }
        monstersAnimation.addFrame(monsterSpriteSheet.getSprite(7),0.2f);
        monstersAnimation.setLooping(true);
        nyouronHeight = monsterSpriteSheet.getSprite(0).getHeight();
        nyouronWidth = monsterSpriteSheet.getSprite(0).getWidth();
        nyouroncollisionBox = generateCollisionRectAt(point.x,point.y);
        collisionRectHeight = nyouronHeight;
        collisionRectWidth = nyouronWidth;
    }

@Override
    protected void update(TopBottomEdge ground1, float delta) {
        point.preUpdate();
        monstersAnimation.update(delta);
        if(nyouronY + nyouronHeight <= GAME_HEIGHT - ground1.getGroundTextureHeight()-200)
            nyouronYAccel += GRAVITY;
        else nyouronYAccel -= GRAVITY;
        calcMonsterYPos();
        point.set(point.getX() - NYOURON_SPEED, point.getY());

    }


}
