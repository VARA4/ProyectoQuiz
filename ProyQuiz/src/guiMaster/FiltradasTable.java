/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMaster;

import control.Controller;
import model.Pregunta;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ALEW
 */
public class FiltradasTable extends AbstractTableModel {

    public Controller oControl;

    public FiltradasTable(Controller a){
        oControl = a;
    }

    @Override
    public int getRowCount() {
        return this.oControl.noPreguntas();
        //return  1;
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pregunta a = oControl.getPregunta(rowIndex);

        switch (columnIndex){
            case 0:
                //System.out.println("entre");

                return rowIndex+1;
            case 1:
                return a.getPregunta();
            case 2:
                return a.respuesta(0);
            case 3:
                return a.respuesta(1);
            case 4:
                return a.respuesta(2);
            case 5:
                return a.respuesta(3);
            case 6:
                return a.getCorrecta();
            case 7:
                return a.getMateria();
            default:
                throw new AssertionError();
        }

    }

    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:

                return "No. pregunta";
            case 1:
                return "Pregunta";
            case 2:
                return "Respuesta 1";
            case 3:
                return "Respuesta 2";
            case 4:
                return "Respuesta 3";
            case 5:
                return "Respuesta 4";
            case 6:
                return "Respuesta Correcta bro";
            case 7:
                return "MATERIA";
            default:
                throw new AssertionError();
        }
    }
}
