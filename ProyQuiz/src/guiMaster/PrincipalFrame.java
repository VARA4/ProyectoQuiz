/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMaster;

import control.Controller;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import excepciones.ArchivoInvalido;
import excepciones.CargarArchivo;
import model.Pregunta;
import model.Respuesta;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ALEW
 */
public class PrincipalFrame extends JFrame {
    private MenuBar baresito;
    private DialogoPreguntas dlgPreguntas;
    private JTable tblPreguntas;
    private Controller control;
    private PreguntasTableModel modelPreguntas;
    private FiltrarComboBox answer;
    private EliminarPreguntaDialogo eliminarPreguntaDialogo;

    public PrincipalFrame() throws CargarArchivo, ArchivoInvalido {
        super("E X A M E N");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(1200, 300);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);
        String[] res = {
                "ESPAÑOL", "MATEMATICAS", "GEOGRAFIA", "HISTORIA", "PROGRAMACIÓN"
        };

        try {
            control = new Controller();
        } catch (ArchivoInvalido ex) {
            JOptionPane.showMessageDialog(PrincipalFrame.this,
                    ex.getMessage(),
                    "Archivo corrompido",
                    JOptionPane.ERROR_MESSAGE);
        } catch (CargarArchivo ex) {
            JOptionPane.showMessageDialog(PrincipalFrame.this,
                    ex.getMessage(),
                    "Archivo corrompido",
                    JOptionPane.ERROR_MESSAGE);
        }

        modelPreguntas = new PreguntasTableModel(control);
        tblPreguntas = new JTable(modelPreguntas);
        /*resizeColumnWidth(tblPreguntas);
        tblPreguntas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);*/
        answer = new FiltrarComboBox(res);
        answer.setListener(new FiltrarComboBoxListener() {
            @Override
            public void btnBuscarButtonClick(String indice) throws ArchivoInvalido, CargarArchivo {
                if (indice == null) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, "Selecciona una materia", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    FiltradasDialogo filtrar = new FiltradasDialogo(PrincipalFrame.this, control.filtrar(indice));

                    filtrar.setVisible(true);
                }
            }
        });

        eliminarPreguntaDialogo = new EliminarPreguntaDialogo(this);
        eliminarPreguntaDialogo.setListener(new EliminarPreguntaListener() {
            @Override
            public void eliminarButtonClick(String noControl) {
                JOptionPane.showMessageDialog(PrincipalFrame.this, control.eliminarPregunta(noControl), "Eliminar", JOptionPane.INFORMATION_MESSAGE);
                modelPreguntas.fireTableDataChanged();
                eliminarPreguntaDialogo.setVisible(false);
            }

            @Override
            public void cancelarButtonClick() {

            }
        });

        baresito = new MenuBar();
        baresito.setListener(new MenuListener() {
            @Override
            public void nuevaPreguntaButtonClick() {
                System.out.println("Nueva pregunta");
                dlgPreguntas.setVisible(true);
            }

            @Override
            public void guardarButtonClick() throws ArchivoInvalido, CargarArchivo {
                control.guardar();
            }

            @Override
            public void eliminarButtonClick() {
                eliminarPreguntaDialogo.setVisible(true);
            }

            @Override
            public void salirButtonClick() {
                System.exit(0);
                System.out.println("Saliendo ...");
            }

            @Override
            public void acercaDeButtonClick() {
                AcercaDeDialog a = new AcercaDeDialog(PrincipalFrame.this);
                a.setVisible(true);
                System.out.println(a.getSize());
            }
        });

        dlgPreguntas = new DialogoPreguntas(this, res);
        dlgPreguntas.setListener(new DialogoPreguntasListener() {
            @Override
            public void aceptarButtonClick(Pregunta pregunta, Respuesta uno, Respuesta dos, Respuesta tres, Respuesta cuatro) {
                control.addPregunta(pregunta);
                control.inciso(control.getPreguntas().size() - 1, uno);
                control.inciso(control.getPreguntas().size() - 1, dos);
                control.inciso(control.getPreguntas().size() - 1, tres);
                control.inciso(control.getPreguntas().size() - 1, cuatro);
                modelPreguntas.fireTableDataChanged();
                dlgPreguntas.setVisible(false);
                dlgPreguntas.clean();
            }

            @Override
            public void cancelarButtonClick() {
                dlgPreguntas.clean();
                dlgPreguntas.setVisible(false);
            }
        });

        super.add(baresito, BorderLayout.NORTH);
        super.add(new JScrollPane(tblPreguntas), BorderLayout.CENTER);

        super.add(answer, BorderLayout.SOUTH);
        super.setVisible(true);
    }

    public static void main(String args[]) throws ArchivoInvalido, CargarArchivo {
        new PrincipalFrame();
    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300)
                width = 300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
}