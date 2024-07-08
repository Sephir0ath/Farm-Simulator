package Interface;

import Logic.*;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa un JPanel con información sobre cierta estadistica de un jugador
 */
public class PanelStatsText extends JPanel {
    private String statDescription;
    private double statValue;
    private int statIndex;

    /**
     * Constructor de la clase, inicializa las variables necesarias para ser mostrado en el texto
     * @param statDescription parametro tipo String que será el texto que se mostrará en pantalla
     * @param playerInfo parametro tipo PlayerInfo el cual representa las estadisticas del jugador
     * @param index parametro Int el cual representa el index del array de estadisticas del jugador
     */
    public PanelStatsText(String statDescription, PlayerInfo playerInfo, int index){
        super();
        this.statDescription = statDescription;
        this.statValue = playerInfo.getStats(index);
        this.statIndex = index;
    }

    /**
     * Metodo que lee los valores de una instancia de PlayerInfo y actualiza los valores de la clase
     * @param playerInfo parametro tipo PlayerInfo el cual representa las estadisticas del jugador
     */
    public void updateStatsPanel(PlayerInfo playerInfo){
        statValue = playerInfo.getStats(statIndex);
        this.repaint();
    }

    /**
     * Metodo que se encarga de pintar en pantalla las estadiscticas del jugador
     * @param g Parametro tipo Graphics usado para dibujar los componentes
     */
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        String stat = Integer.toString((int)statValue);
        ImageIcon imageIcon = null;
        if (statDescription == "dinero") {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("statsDinero.png")).getImage(), 0, 0, null);
            for (int i = 0; i < stat.length(); i++) {
                char numero = stat.charAt(i);
                if (numero == '0') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum0.png"));
                }
                else if (numero == '1') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum1.png"));
                }
                else if (numero == '2') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum2.png"));
                }
                else if (numero == '3') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum3.png"));
                }
                else if (numero == '4') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum4.png"));
                }
                else if (numero == '5') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum5.png"));
                }
                else if (numero == '6') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum6.png"));
                }
                else if (numero == '7') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum7.png"));
                }
                else if (numero == '8') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum8.png"));
                }
                else if (numero == '9'){
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum9.png"));
                }
                g.drawImage(imageIcon.getImage(),70+(i*22), 12,null);
            }
        }
        else if (statDescription == "animales") {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("statsAnimales.png")).getImage(), 0, 0, null);
            for (int i = 0; i < stat.length(); i++) {
                char numero = stat.charAt(i);
                if (numero == '0') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum0.png"));
                } else if (numero == '1') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum1.png"));
                } else if (numero == '2') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum2.png"));
                } else if (numero == '3') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum3.png"));
                } else if (numero == '4') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum4.png"));
                } else if (numero == '5') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum5.png"));
                } else if (numero == '6') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum6.png"));
                } else if (numero == '7') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum7.png"));
                } else if (numero == '8') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum8.png"));
                } else if (numero == '9') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum9.png"));
                }
                g.drawImage(imageIcon.getImage(), 55 + (i * 22), 12, null);
            }
        }
        else if (statDescription == "comida") {
            g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("statsComida.png")).getImage(), 0, 0, null);
            for (int i = 0; i < stat.length(); i++) {
                char numero = stat.charAt(i);
                if (numero == '0') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum0.png"));
                } else if (numero == '1') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum1.png"));
                } else if (numero == '2') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum2.png"));
                } else if (numero == '3') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum3.png"));
                } else if (numero == '4') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum4.png"));
                } else if (numero == '5') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum5.png"));
                } else if (numero == '6') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum6.png"));
                } else if (numero == '7') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum7.png"));
                } else if (numero == '8') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum8.png"));
                } else if (numero == '9') {
                    imageIcon = new ImageIcon(getClass().getClassLoader().getResource("statsNum9.png"));
                }
                g.drawImage(imageIcon.getImage(), 50 + (i * 22), 12, null);
            }
        }
    }
}
