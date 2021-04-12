/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiAlumn;

import model.Pregunta;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 *
 * @author ALEW
 */
public class PanelPreguntas extends JPanel {
    private JLabel lblPregunta;
    private JRadioButton rbRespuesta1;
    private JRadioButton rbRespuesta2;
    private JRadioButton rbRespuesta3;
    private JRadioButton rbRespuesta4;
    private ButtonGroup bgIncisos;
    private JLabel lblMateria;
    private PanelPreguntasActionListener listener;

    public PanelPreguntas(){
        this.setBackground(Color.WHITE);
        lblPregunta = new JLabel("Comenzarás tu examen, que la suerte esté de tu lado o que Dios se apiade de ti xD");

        GridLayout gridLayout = new GridLayout(1,1);
        gridLayout.setHgap(10);
        gridLayout.setVgap(40);
        this.setLayout(gridLayout);

        this.setBorder(new EmptyBorder(10,30,20,10));
        super.add(lblPregunta);

        System.out.println("Comenzar Examen");
    }

    public PanelPreguntas(Pregunta pregunta){

        if (pregunta != null){
            this.setBackground(Color.WHITE);
            //System.out.println("la respuesta es "+pregunta.getCorrecta());

            lblPregunta = new JLabel(pregunta.getPregunta());
            lblMateria = new JLabel(pregunta.getMateria());
            lblMateria.setFont(new Font("Serif",Font.PLAIN,15));
            rbRespuesta1 = new JRadioButton("a)"+ pregunta.respuesta(0));
            rbRespuesta2 = new JRadioButton("b) "+ pregunta.respuesta(1));
            rbRespuesta3 = new JRadioButton("c) "+ pregunta.respuesta(2));
            rbRespuesta4 = new JRadioButton("d) "+ pregunta.respuesta(3));

            rbRespuesta1.setBackground(Color.WHITE);
            rbRespuesta2.setBackground(Color.WHITE);
            rbRespuesta3.setBackground(Color.WHITE);
            rbRespuesta4.setBackground(Color.WHITE);

            rbRespuesta1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    listener.rbRespuesta1Click();
                }
            });

            rbRespuesta2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    listener.rbRespuesta2Click();
                }
            });

            rbRespuesta3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    listener.rbRespuesta3Click();
                }
            });

            rbRespuesta4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    listener.rbRespuesta4Click();
                }
            });


            bgIncisos = new ButtonGroup();

            bgIncisos.add(rbRespuesta1);
            bgIncisos.add(rbRespuesta2);
            bgIncisos.add(rbRespuesta3);
            bgIncisos.add(rbRespuesta4);

            //Matriz
            GridLayout gridLayout = new GridLayout(6,1);
            gridLayout.setHgap(10);
            gridLayout.setVgap(40);
            this.setLayout(gridLayout);

            this.setBorder(new EmptyBorder(10,30,20,10));

            this.add(lblPregunta);
            this.add(lblMateria);
            this.add(rbRespuesta1);
            this.add(rbRespuesta2);
            this.add(rbRespuesta3);
            this.add(rbRespuesta4);
        }

    }

    public void clean(){
        if (lblMateria== null){

        }else{
            this.lblPregunta.setText("");
            this.rbRespuesta1.setText("");
            this.rbRespuesta2.setText("");
            this.rbRespuesta3.setText("");
            this.rbRespuesta4.setText("");
        }
    }

    public void setListener(PanelPreguntasActionListener listener) {
        this.listener = listener;
    }
}