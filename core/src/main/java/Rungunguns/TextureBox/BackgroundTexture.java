package Rungunguns.TextureBox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.IllegalFormatWidthException;


public class BackgroundTexture {
    private static final String BACKGROUND_TEXTURE_LOCATION = "Scene/metropolislight.png";

    Texture background = new Texture(Gdx.files.internal(BACKGROUND_TEXTURE_LOCATION));

    public Texture background() {
        return background;
    }


}
