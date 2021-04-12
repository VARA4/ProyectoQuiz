/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiAlumn;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ALEW
 */
public class CalificacionDialog extends JDialog {
    private JButton btnCerrar;
    private JLabel lblCalif;
    private JLabel lblRespCorrect;
    private guiAlumnoListener listener;

    public CalificacionDialog(JFrame parent, double calificacion, int respuestasCorrectas){
        super(parent, "Nueva pregunta", true);
        super.setSize(348, 114);
        super.setLocationRelativeTo(parent);
        super.setLayout(new FlowLayout());
        super.getContentPane().setBackground(Color.WHITE);

        lblRespCorrect = new JLabel("Tuviste un total de " + respuestasCorrectas + " respuestas correctas bro c:");
        lblCalif = new JLabel(String.format("Tu calificación es de %.2f.",calificacion));
        btnCerrar = new JButton("Cerrar");

        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.cerrarButtonCLick();
            }
        });


        this.add(lblRespCorrect);
        this.add(lblCalif);
        this.add(btnCerrar, BorderLayout.SOUTH);
    }

    public void setListener(guiAlumnoListener listener) {
        this.listener = listener;
    }
}
