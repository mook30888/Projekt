package Rungunguns;

import org.mini2Dx.core.engine.geom.CollisionPoint;
import static Rungunguns.Maingame.FLYING_SPEED;

public class Hazards {

    CollisionPoint point = new CollisionPoint();

    void generateHazardAtPos(float xPos, float yPos) {
        point.set(xPos, yPos);
    }

    void update() {
        point.preUpdate();
        point.set(point.getX() - FLYING_SPEED, point.getY());
    }

    public float getHazardXPos() {
        return point.getX();
    }



}
