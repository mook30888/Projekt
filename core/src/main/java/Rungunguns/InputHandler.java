package Rungunguns;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;


public class InputHandler {

    boolean spacePressed() {return Gdx.input.isKeyJustPressed(Input.Keys.SPACE);}
    boolean zPressed(){return  Gdx.input.isKeyJustPressed(Input.Keys.Z);}
    boolean xPressed(){return  Gdx.input.isKeyJustPressed(Input.Keys.X);}
    boolean cPressed(){return  Gdx.input.isKeyJustPressed(Input.Keys.C);}
}
