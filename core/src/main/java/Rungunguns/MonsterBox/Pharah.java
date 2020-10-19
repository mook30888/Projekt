package Rungunguns.MonsterBox;

import Rungunguns.Monster;
import com.badlogic.gdx.graphics.Texture;

public class Pharah extends Monster {


    public Pharah(){
        nyouronTexture= new Texture("Monsters/Pharah/Pharah.png");
        nyouronHeight = nyouronTexture.getHeight();
        nyouronWidth = nyouronTexture.getWidth();
        nyouroncollisionBox = generateCollisionRectAt(nyouronX,nyouronY);
        collisionRectHeight = nyouronHeight;
        collisionRectWidth = nyouronWidth;
        NYOURON_SPEED = 3f;
        hitpoint = 1;
    }

}
