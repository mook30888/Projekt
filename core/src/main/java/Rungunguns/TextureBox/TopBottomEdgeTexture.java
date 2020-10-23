package Rungunguns.TextureBox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class TopBottomEdgeTexture {

    private static final String GROUND_TEXTURE_LOCATION = "Test Map.png";

    Texture groundTexture = new Texture(Gdx.files.internal(GROUND_TEXTURE_LOCATION));

    public Texture groundTexture() {
        return groundTexture;
    }
}
