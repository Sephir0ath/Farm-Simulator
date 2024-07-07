package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que permite crear instancias de ventanas emergentes.
 */
public class MessageWindow extends JFrame {

    /**
     * Constructor la clase, inicializa y coloca todos los componentes de la ventana.
     * @param Message String el cual será el mensaje de error o indicación según el contexto de la instanciación.
     */
    public MessageWindow(String Message){
        this.setSize(new Dimension(500, 200));
        this.setLayout(new GridLayout(2, 3));
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JLabel textLabel = new JLabel();
        textLabel.setText(Message);
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setVerticalAlignment(SwingConstants.CENTER);

        this.add(textLabel);

        JButton okButton = new JButton("Ok");
        okButton.setBounds(90, 80,90, 45);

        okButton.addActionListener(new ActionListener() {
            /**
             * Evento que se lanza al presionar el Botón en la ventana.
             * @param e evento a ser procesado.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                MessageWindow.this.dispose();
            }
        });

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new GridLayout(1, 3));

        panelButton.add(new JLabel());
        panelButton.add(okButton);
        panelButton.add(new JLabel());
        this.add(panelButton);

        this.setVisible(true);
    }
}