package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionBox;

public class NyouronA extends Monster {



    public NyouronA(){
        nyouronTexture= new Texture(Gdx.files.internal("Nyonron.png"));
        nyouronHeight = nyouronTexture.getHeight();
        nyouronWidth = nyouronTexture.getWidth();
        collisionRectHeight = nyouronHeight;
        collisionRectWidth = nyouronWidth;
        NYOURON_SPEED = 20f;
        hitpoint = 1;
    }





}
