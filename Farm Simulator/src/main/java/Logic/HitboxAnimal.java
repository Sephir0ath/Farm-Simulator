package Logic;

import Interface.*;

import java.awt.*;

/**
 * Clase HitboxAnimal, esta destinada a la asignacion en tiempo real de las hitbox para los Animales de cada habitat
 */
public class HitboxAnimal {
    private Rectangle hitbox;
    private boolean isVisible;
    private static PanelAnimalStats panelanimalstats = null;

    /**
     * Metodo constructor, crea Rectangle que es la hitbox
     * @param ubicacion tipo Point, contiene la posicion del animal correspondiente en su habitat
     */
    public HitboxAnimal(Point ubicacion) {
        this.hitbox = new Rectangle((int) ubicacion.getX(), (int) ubicacion.getY(), 40, 30);
        this.isVisible = true;
    }

    /**
     * Metodo encargado de actualizar en tiempo real la hitbox del animal
     * @param ubicacion tipo Point, contiene la posicion del animal correspondiente al tiempo en su habitat
     */
    public void updateHitbox(Point ubicacion) {
        this.hitbox.setLocation((int) ubicacion.getX(), (int) ubicacion.getY());
    }

    /**
     * Metodo que sirve para identificar si nuestra hitbox es visible o esta oculta
     * @return isVisible de tipo boolean, indica si nuestra hitbox es visible
     */
    public boolean hitboxIsVisible(){
        return isVisible;
    }


    /**
     * Metodo encargado de activar la hitbox
     */
    public void showHitbox() {
        isVisible = true;
    }

    /**
     * Metodo encargado de desactivar la hitbox
     */
    public void hideHitbox() {
        isVisible = false;
    }

    /**
     * Metodo de tipo getter, nos entrega la hitbox
     * @return hitbox de tipo Rectangle, esta es la hitbox
     */
    public Rectangle getHitbox(){
        return this.hitbox;
    }
}
