package Rungunguns;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public class BackgroundTexture {
    private static final String BACKGROUND_TEXTURE_LOCATION = "Scene/0.5.png";

    Texture background = new Texture(Gdx.files.internal(BACKGROUND_TEXTURE_LOCATION));
}
