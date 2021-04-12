/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiAlumn;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 *
 * @author ALEW
 */
public class PanelContador extends JPanel {
    private JLabel lblContador;

    public PanelContador(){
        lblContador = new JLabel("30:00");
        lblContador.setFont(new Font("Serif",Font.PLAIN,15));
        this.setBackground(Color.WHITE);

        this.setBorder(new EmptyBorder(10,10,10,10));
        this.add(lblContador);
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }
}
