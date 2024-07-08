package Logic;

import Interface.*;

import java.awt.*;

public class HitboxAnimal {
    private Rectangle hitbox;
    private boolean isVisible;
    private static PanelAnimalStats panelanimalstats = null;

    public HitboxAnimal(Point ubicacion) {
        this.hitbox = new Rectangle((int) ubicacion.getX(), (int) ubicacion.getY(), 40, 30);
        this.isVisible = true;
    }

    public void updateHitbox(Point ubicacion) {
        this.hitbox.setLocation((int) ubicacion.getX(), (int) ubicacion.getY());
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
