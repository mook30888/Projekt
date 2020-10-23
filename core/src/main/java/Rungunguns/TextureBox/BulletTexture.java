package Rungunguns.TextureBox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class BulletTexture {
    private static final String BULLET_TEXTURE_LOCATION = "cute bullet.png";

    Texture bullet = new Texture(Gdx.files.internal(BULLET_TEXTURE_LOCATION));

    public Texture getBullet() {
        return bullet;
    }

    public Texture bullet() {
        return bullet;
    }
}
