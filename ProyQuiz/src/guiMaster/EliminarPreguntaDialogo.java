/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMaster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ALEW
 */
public class EliminarPreguntaDialogo extends JDialog {
    private  EliminarPreguntaListener listener;
    private JTextField txtNoPregunta;
    private JLabel lblNoPregunta;
    private JButton btnEliminar;
    private JButton btnCancelar;

    public EliminarPreguntaDialogo(JFrame parent){
        super(parent, "Eliminar Pregunta", true);
        super.setSize(346, 99);
        super.setLocationRelativeTo(parent);
        super.setLayout(new FlowLayout());
        super.getContentPane().setBackground(Color.PINK);

        lblNoPregunta = new JLabel("No pregunta");
        txtNoPregunta = new JTextField(15);
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String numero = txtNoPregunta.getText();
                if (!numero.isEmpty()){
                    if (validar(numero) == true){
                        listener.eliminarButtonClick(numero);
                    }else{
                        JOptionPane.showMessageDialog(parent,"Asegúrate que sea un número válido", "ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(parent,"Casilla vacía bro", "ERROR",JOptionPane.ERROR_MESSAGE);
                }

                clean();

            }
        });

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.cancelarButtonClick();
            }
        });

        super.add(lblNoPregunta);
        super.add(txtNoPregunta);
        super.add(btnEliminar);

    }

    private void clean() {
        txtNoPregunta.setText("");
    }

    public void setListener(EliminarPreguntaListener listener) {
        this.listener = listener;
    }

    private Boolean validar(String numero){
        Boolean resultado;

        try {
            Integer.parseInt(numero);
            resultado = true;
        }catch (NumberFormatException ex){
            resultado = false;
        }
        return resultado;
    }
}
