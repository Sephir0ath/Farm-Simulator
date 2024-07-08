package Logic;

import Interface.*;

import java.awt.*;

public class HitboxAnimal {
    private Rectangle hitbox;
    private Animal animal;
    private static PanelAnimalStats panelanimalstats = null;

    public HitboxAnimal(Point ubicacion, Animal animal) {
        this.animal = animal;
        this.hitbox = new Rectangle((int) ubicacion.getX(), (int) ubicacion.getY(), 40, 30);
    }

    public void updateHitbox(Point ubicacion) {
        this.hitbox.setLocation((int) ubicacion.getX(), (int) ubicacion.getY());
    }

    public void cursorInAnimal() {
        PanelGame.getInstance().cursorIsOnHitbox(this.hitbox, this.animal);
    }
}
