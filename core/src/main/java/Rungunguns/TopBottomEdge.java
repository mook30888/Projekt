package Rungunguns;

import Rungunguns.TextureBox.TopBottomEdgeTexture;
import org.mini2Dx.core.graphics.Graphics;

import static Rungunguns.Maingame.GAME_WIDTH;
import static Rungunguns.Maingame.GAME_HEIGHT;


public class TopBottomEdge extends Hazards  {

    TopBottomEdgeTexture topBottomEdgeTexture;
    private float groundTextureHeight;

    public TopBottomEdge(TopBottomEdgeTexture topBottomEdgeModel) {
        this.topBottomEdgeTexture = topBottomEdgeModel;
        groundTextureHeight = topBottomEdgeModel.groundTexture().getHeight();
    }

    @Override
    void update() {
        super.update();
        if (point.getX() < -GAME_WIDTH-1) {
            point.setX(GAME_WIDTH-1);
        }
    }

    void render(Graphics g) {
        g.drawTexture(topBottomEdgeTexture.groundTexture(), point.getX(),
                GAME_HEIGHT - topBottomEdgeTexture.groundTexture().getHeight());
    }


    public float getGroundTextureHeight() {
        return groundTextureHeight;
    }



}
