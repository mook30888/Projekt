package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import com.badlogic.gdx.graphics.Texture;

public class NyouronA extends Monster {


    public NyouronA(){
        nyouronTexture = new Texture("Nyouron.png");
        nyouronHeight = nyouronTexture.getHeight();
        nyouronWidth = nyouronTexture.getWidth();
        nyouroncollisionBox = generateCollisionRectAt(nyouronX,nyouronY);
        collisionRectHeight = nyouronHeight;
        collisionRectWidth = nyouronWidth;
        NYOURON_SPEED = 2f;
        hitpoint = 1;
    }





}
