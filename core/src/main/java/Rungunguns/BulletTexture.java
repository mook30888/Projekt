package Rungunguns;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BulletTexture {
    private static final String BULLET_TEXTURE_LOCATION = "cute bullet.png";

    Texture bullet = new Texture(Gdx.files.internal(BULLET_TEXTURE_LOCATION));

    public Texture getBullet() {
        return bullet;
    }
}