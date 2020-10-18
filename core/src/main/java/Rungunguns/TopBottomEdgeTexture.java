package Rungunguns;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TopBottomEdgeTexture {

    private static final String GROUND_TEXTURE_LOCATION = "groundDirt.png";
    private static final String CEILING_TEXTURE_LOCATION = "ceilingDirt.png";

    Texture groundTexture = new Texture(Gdx.files.internal(GROUND_TEXTURE_LOCATION));
    Texture ceilingTexture = new Texture(Gdx.files.internal(CEILING_TEXTURE_LOCATION));
}
