package Logic;

import java.awt.*;

public class HitboxDeposit {
    private Rectangle hitbox;
    private boolean isVisible;
    public HitboxDeposit(Point habitat) {
        this.hitbox = new Rectangle((int) habitat.getX() +3, (int) habitat.getY() +118, 30,30);
    }

    public boolean hitboxIsVisible(){
        return isVisible;
    }
    public void showHitbox() {
        isVisible = true;
    }

    public void hideHitbox() {
        isVisible = false;
    }

    public Rectangle getHitbox(){
        return this.hitbox;
    }
}
