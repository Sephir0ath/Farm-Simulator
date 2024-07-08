package Logic;

import Interface.*;
import Interface.Window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point mouseLocationRelativeToPanel = PanelGame.getInstance().getMousePosition();

                if (mouseLocationRelativeToPanel != null) {
                    // Aparecer panel
                    if (hitbox.contains(mouseLocationRelativeToPanel) && PanelGame.getInstance().contains(mouseLocationRelativeToPanel)) {
                        if (panelanimalstats == null) {
                            panelanimalstats = new PanelAnimalStats(hitbox, mouseLocationRelativeToPanel, animal);
                            panelanimalstats.CreateInterfazAnimal();
                        }
                    }
                }
                // Remover panel solo si el cursor no está sobre el hitbox o el panel
                else {
                    if (panelanimalstats != null) {
                        Rectangle panelBounds = panelanimalstats.getBounds();
                        panelBounds.translate(0, -47);  //6, 29
                        Point panelLocation = panelBounds.getLocation();
                        panelBounds.setLocation(panelLocation);

                        if (!hitbox.contains(mouseLocationRelativeToPanel) && !panelBounds.contains(mouseLocationRelativeToPanel)) {
                            panelanimalstats.removeInterfazAnimal();
                            panelanimalstats = null;
                        }
                    }
                }
            }
        });
        timer.start();
    }
}
