package Interface;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * Clase que representa la Ventana del juego
 */
public class Window extends JFrame {
    private static Window instance;

    /**
     * Constructor de la clase, inicializa el JPanel principal
     */
    public Window(){
        super("Farm Simulator");
        setSize(new Dimension(1200, 700));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        instance = this;
        setResizable(true);
        setMinimumSize(new Dimension(800, 700));
        add(new PanelPrincipal());
        setLocationRelativeTo(null);
        setVisible(true);
        playMusic();
    }

    /**
     * Clase que retorna la instacia Singleton de la clase, si la clase no ha sido creada, la inicializa antes de retornar.
     * @return la instancia de la clase
     */
    public static synchronized Window frame(){
        if (instance == null) {
            instance = new Window();
        }
        return instance;
    }

    /**
     * Método para reproducir música en un bucle mientras la ventana está activa.
     */
    public void playMusic() {
        try {
            InputStream backgroundMusic = getClass().getResourceAsStream("/music.wav");
            if (backgroundMusic != null) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(backgroundMusic);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                FloatControl volumen = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                volumen.setValue(0);
                clip.start();
            } else {
                System.out.println("El archivo de música que buscas no existe.");
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
