package Rungunguns;


import com.badlogic.gdx.assets.AssetManager;

public class Sounds{
    public static AssetManager manager;

    public void getSound(){
        manager = new AssetManager();
        manager.load("Sounds/mariojump.mp3",Sounds.class);
        manager.load("Sounds/gunshot.mp3",Sounds.class);
        manager.finishLoading();
    }

    public void pew(){
        manager.load("Sounds/pew.mp3",Sounds.class);
    }


}
