package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;

//หลบลูกปืนได้ ปืนXจะยิงไม่โดน

public class Genji extends Monster {


    public Genji(){
        nyouronTexture = new Texture("Monsters/Genji/Genji.png");
        NYOURON_SPEED = 45;
        hitpoint = 2;
        monsterSpriteSheet = new SpriteSheet(nyouronTexture,129,129);
        monstersAnimation = new Animation();

        for(int i = 0;i < 10;i++ ) {
            monstersAnimation.addFrame(monsterSpriteSheet.getSprite(i), frameDuration/3);
        }

        monstersAnimation.setLooping(true);

        //monsterscolor = Color.OLIVE;

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
        return new CollisionBox(tempX, tempY, nyouronWidth-59, nyouronHeight-85); //ขนาดhitbox
    }
    @Override
    protected void calcMonsterYPos() {
        nyouronX = point.x;
        nyouronY += nyouronYAccel;
        point.y = nyouronY;
        nyouroncollisionBox.set(nyouronX+30,nyouronY+45); //ตำแหน่งhitbox
    }

}