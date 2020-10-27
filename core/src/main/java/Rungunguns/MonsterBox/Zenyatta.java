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
        NYOURON_SPEED = 5.5f;
        hitpoint = 3;

        monsterSpriteSheet = new SpriteSheet(nyouronTexture,133,133);
        monstersAnimation = new Animation();
//        for(int i = 0;i < 13;i++ ) {
        monstersAnimation.addFrame(monsterSpriteSheet.getSprite(0), frameDuration/2);
        monstersAnimation.addFrame(monsterSpriteSheet.getSprite(1), frameDuration/2);
        monstersAnimation.addFrame(monsterSpriteSheet.getSprite(2), frameDuration/2);
        monstersAnimation.addFrame(monsterSpriteSheet.getSprite(3), frameDuration/2);
        monstersAnimation.addFrame(monsterSpriteSheet.getSprite(4), frameDuration/2);
        monstersAnimation.addFrame(monsterSpriteSheet.getSprite(5), frameDuration/2);
        monstersAnimation.addFrame(monsterSpriteSheet.getSprite(6), frameDuration/2);
        monstersAnimation.addFrame(monsterSpriteSheet.getSprite(7), frameDuration/2);
        monstersAnimation.addFrame(monsterSpriteSheet.getSprite(8), frameDuration/2);
        monstersAnimation.addFrame(monsterSpriteSheet.getSprite(9), frameDuration/2);
        monstersAnimation.addFrame(monsterSpriteSheet.getSprite(10), frameDuration/2);
        monstersAnimation.addFrame(monsterSpriteSheet.getSprite(11), frameDuration/2);
        monstersAnimation.addFrame(monsterSpriteSheet.getSprite(12), frameDuration/2);
//        }
        monstersAnimation.setLooping(true);
        monsterscolor = Color.GOLD;

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
        return new CollisionBox(tempX, tempY, nyouronWidth-60, nyouronHeight-69); //ขนาด
    }
    @Override
    protected void calcMonsterYPos() {
        nyouronX = point.x;
        nyouronY += nyouronYAccel;
        point.y = nyouronY;
        nyouroncollisionBox.set(nyouronX+30,nyouronY+30); //ตำแหน่งhitbox
    }
    @Override
    protected void update(TopBottomEdge ground1, float delta) {
        point.preUpdate();
        monstersAnimation.update(delta);
        if(nyouronY + nyouronHeight <= GAME_HEIGHT - ground1.getGroundTextureHeight()-150)
            nyouronYAccel += GRAVITY;
        else nyouronYAccel -= 2f;
        calcMonsterYPos();
        point.set(point.getX() - NYOURON_SPEED, point.getY());
    }
}
