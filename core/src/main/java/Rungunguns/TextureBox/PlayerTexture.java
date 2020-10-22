package Rungunguns.TextureBox;



import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;

import java.awt.*;


public class PlayerTexture {
    private static final String PLAYER_SPRITE_SHEET_LOCATION = "Mccree Running Sheet.png";
    private static final String SHOOTING_SPRITE_SHEET_LOCATION = "Mccree Shooting Sheet.png";

    private float frameDuration = 0.12f;

    protected Texture spriteTexture = new Texture(PLAYER_SPRITE_SHEET_LOCATION);
    protected Texture shootingTexture = new Texture(SHOOTING_SPRITE_SHEET_LOCATION);
    protected SpriteSheet playerSpriteSheet = new SpriteSheet(spriteTexture,67,70);
    protected SpriteSheet ShootingSpriteSheet = new SpriteSheet(shootingTexture,67,70);
    protected Animation playerAnimation = new Animation();
    protected Animation playershooting = new Animation();

    public PlayerTexture(){
        playerAnimation.addFrame(playerSpriteSheet.getSprite(0),frameDuration);
        playerAnimation.addFrame(playerSpriteSheet.getSprite(1),frameDuration);
        playerAnimation.addFrame(playerSpriteSheet.getSprite(2),frameDuration);
        playerAnimation.addFrame(playerSpriteSheet.getSprite(3),frameDuration);
        playerAnimation.addFrame(playerSpriteSheet.getSprite(4),frameDuration);
        playerAnimation.addFrame(playerSpriteSheet.getSprite(5),frameDuration);
        playerAnimation.addFrame(playerSpriteSheet.getSprite(6),frameDuration);
        playerAnimation.addFrame(playerSpriteSheet.getSprite(7),frameDuration);

        playershooting.addFrame(ShootingSpriteSheet.getSprite(0),frameDuration/3);
        playershooting.addFrame(ShootingSpriteSheet.getSprite(1),frameDuration/3);
        playershooting.addFrame(ShootingSpriteSheet.getSprite(2),frameDuration/3);
        playershooting.addFrame(ShootingSpriteSheet.getSprite(3),frameDuration/3);
        playershooting.addFrame(ShootingSpriteSheet.getSprite(4),frameDuration/3);

    }

    public SpriteSheet playerSpriteSheet() {
        return playerSpriteSheet;
    }

    public Animation playerAnimation() {
        return playerAnimation;
    }

    public Animation playershooting() {
        return playershooting;
    }
}

