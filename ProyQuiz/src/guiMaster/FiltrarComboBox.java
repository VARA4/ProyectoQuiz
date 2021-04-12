/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMaster;

import excepciones.ArchivoInvalido;
import excepciones.CargarArchivo;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ALEW
 */
public class FiltrarComboBox extends JPanel {
    JComboBox preguntasCB;
    JLabel lblFiltrar;
    JButton btnBuscar;

    FiltrarComboBoxListener listener;

    public FiltrarComboBox(String[] respuestas){
        lblFiltrar = new JLabel("Filtrar por materia");

        preguntasCB = new JComboBox(respuestas);
        preguntasCB.setSelectedIndex(-1);


        btnBuscar = new JButton("Filtrar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    listener.btnBuscarButtonClick((String) preguntasCB.getSelectedItem());
                } catch (ArchivoInvalido | CargarArchivo archivoInvalido) {
                    archivoInvalido.printStackTrace();
                }
                preguntasCB.setSelectedIndex(-1);
            }
        });


        this.add(lblFiltrar);
        this.add(preguntasCB);
        this.add(btnBuscar);
    }

    public void setListener(FiltrarComboBoxListener listener) {
        this.listener = listener;
    }
}
