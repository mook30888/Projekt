package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import Rungunguns.TopBottomEdge;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;

import static Rungunguns.Maingame.GAME_HEIGHT;
import static Rungunguns.Maingame.GRAVITY;

public class Mercy extends Monster {


    public Mercy(){
        nyouronTexture = new Texture("Monsters/Mercy/Mercy.png");
        NYOURON_SPEED = 3;
        hitpoint = 2;
        monsterSpriteSheet = new SpriteSheet(nyouronTexture,86,64);
        monstersAnimation = new Animation();
        for (int i = 0;i < 6;i++) {
                monstersAnimation.addFrame(monsterSpriteSheet.getSprite(i), frameDuration/3.2f);
        }

        monsterscolor = Color.YELLOW;

        monstersAnimation.setLooping(true);

        nyouronHeight = monsterSpriteSheet.getSprite(0).getHeight()-20;
        nyouronWidth = monsterSpriteSheet.getSprite(0).getWidth()-20;
        nyouroncollisionBox = generateCollisionRectAt(point.x,point.y);
        collisionRectHeight = nyouronHeight;
        collisionRectWidth = nyouronWidth;
    }

@Override
    protected void update(TopBottomEdge ground1, float delta) {
        point.preUpdate();
        monstersAnimation.update(delta);
        if(nyouronY + nyouronHeight <= GAME_HEIGHT - ground1.getGroundTextureHeight()-300)
            nyouronYAccel += GRAVITY;
        else nyouronYAccel -= GRAVITY;
        calcMonsterYPos();
        point.set(point.getX() - NYOURON_SPEED, point.getY());

    }

}
