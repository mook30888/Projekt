package Rungunguns.MonsterBox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.engine.geom.CollisionBox;

public class NyouronA {

    private static final String NYOURON_TEXTURE_LOCATION = "Nyouron.png";
    Texture nyouronTexture = new Texture(Gdx.files.internal(NYOURON_TEXTURE_LOCATION));

    private static float NYOURON_SPEED = 20f;

    float nyouronHeight;
    float nyouronWidth;

    private float collisionRectHeight;
    private float collisionRectWidth = 10f;

    CollisionBox collisionBox;







}
