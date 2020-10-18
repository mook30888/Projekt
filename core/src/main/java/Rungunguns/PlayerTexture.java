package Rungunguns;



import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;


public class PlayerTexture {
    private static final String PLAYER_SPRITE_SHEET_LOCATION = "Mccree Running Sheet.png";

    private float frameDuration = 0.12f;

    Texture spriteTexture = new Texture(PLAYER_SPRITE_SHEET_LOCATION);
    SpriteSheet playerSpriteSheet = new SpriteSheet(spriteTexture,67,70);
    Animation playerAnimation = new Animation();


    public PlayerTexture(){
        playerAnimation.addFrame(playerSpriteSheet.getSprite(0),frameDuration);
        playerAnimation.addFrame(playerSpriteSheet.getSprite(1),frameDuration);
        playerAnimation.addFrame(playerSpriteSheet.getSprite(2),frameDuration);
        playerAnimation.addFrame(playerSpriteSheet.getSprite(3),frameDuration);
        playerAnimation.addFrame(playerSpriteSheet.getSprite(4),frameDuration);
        playerAnimation.addFrame(playerSpriteSheet.getSprite(5),frameDuration);
        playerAnimation.addFrame(playerSpriteSheet.getSprite(6),frameDuration);
        playerAnimation.addFrame(playerSpriteSheet.getSprite(7),frameDuration);
    }

}
