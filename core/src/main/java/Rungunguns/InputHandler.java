package Rungunguns;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;


public class InputHandler {

    boolean spacePressed() {
        return Gdx.input.isKeyJustPressed(Input.Keys.SPACE);
    }
}
