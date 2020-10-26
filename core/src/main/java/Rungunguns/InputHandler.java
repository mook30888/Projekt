package Rungunguns;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;


public class InputHandler {

    boolean arrowupPressed() {return Gdx.input.isKeyJustPressed(Input.Keys.UP);}
    boolean arrowDownPressed() {return Gdx.input.isKeyJustPressed(Input.Keys.DOWN);}
    boolean zPressed(){return  Gdx.input.isKeyJustPressed(Input.Keys.Z);}
    boolean xPressed(){return  Gdx.input.isKeyJustPressed(Input.Keys.X);}
    boolean cPressed(){return  Gdx.input.isKeyJustPressed(Input.Keys.C);}
}
