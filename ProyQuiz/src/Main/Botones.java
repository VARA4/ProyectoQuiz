/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ALEW
 */
public class Botones extends JPanel {
    private JButton btnLogin;
    private JButton btnCancelar;
    private BotonesListener listener;

    public Botones(){
        btnLogin = new JButton("Login");
        btnCancelar = new JButton("Cancelar");

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.loginButtonClick();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.cancelarButtonClick();
            }
        });

        this.setBorder(new EmptyBorder(30,100,20,100));
        this.setLayout(new BorderLayout());
        this.add(btnLogin, BorderLayout.EAST);
        this.add(btnCancelar, BorderLayout.WEST);

    }

    public void setListener(BotonesListener listener) {
        this.listener = listener;
    }
}
