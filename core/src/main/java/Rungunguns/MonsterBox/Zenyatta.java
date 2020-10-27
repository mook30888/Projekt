package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import Rungunguns.TopBottomEdge;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;

import java.util.Random;

import static Rungunguns.Maingame.GAME_HEIGHT;
import static Rungunguns.Maingame.GRAVITY;

public class Zenyatta extends Monster {


    public Zenyatta(){
        nyouronTexture = new Texture("Monsters/Zenyatta/Zenyatta.png");
        NYOURON_SPEED = 12f;
        hitpoint = 3;

        monsterSpriteSheet = new SpriteSheet(nyouronTexture,133,133);
        monstersAnimation = new Animation();

        for(int i = 0;i < 13;i++ ) {
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(i), frameDuration / 4);
        }

        monsterscolor = Color.GOLD;

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

        if (nyouronY + nyouronHeight <= randomFloatMinMax(randomFloatMinMax(0, 30), GAME_HEIGHT - ground1.getGroundTextureHeight() - 50))
            nyouronYAccel += GRAVITY;
        else nyouronYAccel = 2;
        calcMonsterYPos();
        point.set(point.getX() - NYOURON_SPEED, point.getY());
    }
        @Override
    protected CollisionBox generateCollisionRectAt(float xPos, float yPos) {
        int tempX = (int) xPos;
        int tempY = (int) yPos;
        return new CollisionBox(tempX, tempY, nyouronWidth-60, nyouronHeight-69); //ขนาด
    }
    @Override
    protected void calcMonsterYPos() {
        nyouronX = point.x;
        nyouronY += nyouronYAccel;
        point.y = nyouronY;
        nyouroncollisionBox.set(nyouronX+30,nyouronY+30); //ตำแหน่งhitbox
    }

        float randomFloatMinMax(float min, float max) {
            float leftLimit = min;
            float rightLimit = max;
            return leftLimit + new Random().nextFloat() * (rightLimit - leftLimit);
        }
}
