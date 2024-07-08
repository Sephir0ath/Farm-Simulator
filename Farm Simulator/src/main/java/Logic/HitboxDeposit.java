package Logic;

import java.awt.*;

/**
 * Clase HitboxDeposit, esta destinada a la asignacion de una hitbox para los depositos de los habitats
 */
public class HitboxDeposit {
    private Rectangle hitbox;
    private boolean isVisible;
    /**
     * Metodo constructor, crea Rectangle que es la hitbox
     * @param habitat de tipo Point, contiene la posicion del habitat correspondiente
     */
    public HitboxDeposit(Point habitat) {
        this.hitbox = new Rectangle((int) habitat.getX() +3, (int) habitat.getY() +118, 30,30);
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
