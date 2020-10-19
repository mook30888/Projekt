package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.graphics.Graphics;

public class NyouronA extends Monster {


    public NyouronA(){
        nyouronTexture= new Texture("Nyouron.png");
        nyouronHeight = nyouronTexture.getHeight();
        nyouronWidth = nyouronTexture.getWidth();
        nyouroncollisionBox = generateCollisionRectAt(nyouronX,nyouronY);
        collisionRectHeight = nyouronHeight;
        collisionRectWidth = nyouronWidth;
        NYOURON_SPEED = 2f;
        hitpoint = 1;
    }





}
