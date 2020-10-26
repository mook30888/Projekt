package Rungunguns.TextureBox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BombEffect{

        private static final String BOMBEFFECT_TEXTURE_LOCATION = "Explosion/bomb.png";
        Texture bombEffect = new Texture(Gdx.files.internal(BOMBEFFECT_TEXTURE_LOCATION));

    public Texture getBombEffect() {
        return bombEffect;
    }


}
