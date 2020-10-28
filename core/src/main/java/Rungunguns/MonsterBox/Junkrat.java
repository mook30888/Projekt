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

public class Junkrat extends Monster {


    public Junkrat(){
        nyouronTexture = new Texture("Monsters/Junkrat/Junkrat.png");
        NYOURON_SPEED = 3;
        hitpoint = 2;
        monsterSpriteSheet = new SpriteSheet(nyouronTexture,105,105);
        monstersAnimation = new Animation();

        for(int i = 0;i < 6;i++ ) {
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(i), frameDuration/2.5f);
        }

        monstersAnimation.setLooping(true);

       // monsterscolor = Color.GOLDENROD;

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
        return new CollisionBox(tempX, tempY, nyouronWidth-45, nyouronHeight-30); //ขนาด
    }
    @Override
    protected void calcMonsterYPos() {
        nyouronX = point.x;
        nyouronY += nyouronYAccel;
        point.y = nyouronY;
        nyouroncollisionBox.set(nyouronX+20,nyouronY+15); //ตำแหน่งhitbox

    }

    @Override
    protected void update(TopBottomEdge ground1, float delta) {
        point.preUpdate();
        monstersAnimation.update(delta);
        if(nyouronY + nyouronHeight <= GAME_HEIGHT - ground1.getGroundTextureHeight()-150)
            nyouronYAccel += GRAVITY;
        else nyouronYAccel -= GRAVITY;
        calcMonsterYPos();
        point.set(point.getX() - NYOURON_SPEED, point.getY());

    }

}
