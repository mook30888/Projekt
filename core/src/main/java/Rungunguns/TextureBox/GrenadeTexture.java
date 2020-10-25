package Rungunguns.TextureBox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;
public class GrenadeTexture {
    private static final String GRENADE_TEXTURE_LOCATION = "cutenade.png";

    Texture grenade = new Texture(Gdx.files.internal(GRENADE_TEXTURE_LOCATION));



    public static Texture getGrenade() { return grenade; }

}
