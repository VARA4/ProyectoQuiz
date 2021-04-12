/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMaster;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 *
 * @author ALEW
 */
public class AcercaDeDialog extends JDialog {
    private JPanel jPanel;
    private JLabel lblImage;
    private ImageIcon imageIcon;
    private JLabel lbltxt;

    public AcercaDeDialog(JFrame parent) {

        super(parent, "About..", true);
        super.setLocationRelativeTo(parent);
        super.setSize(845, 251);
        super.setLayout(new FlowLayout());

        jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(30, 100, 20, 100));
        lbltxt = new JLabel("No es posible ponerlo here xd ");

        imageIcon = new ImageIcon("src/Imagenes/Red_Hat_logo_RedHat.png");
        lblImage = new JLabel();
        lblImage.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(500, 150, Image.SCALE_SMOOTH)));
        jPanel.setBounds(50,50,50,50);

        jPanel.add(lblImage, BorderLayout.NORTH);
        jPanel.add(lbltxt, BorderLayout.CENTER);
        this.add(jPanel);
    }
}
