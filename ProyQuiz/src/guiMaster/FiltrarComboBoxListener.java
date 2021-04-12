/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMaster;

import excepciones.ArchivoInvalido;
import excepciones.CargarArchivo;

/**
 *
 * @author ALEW
 */
public interface FiltrarComboBoxListener {
    public void btnBuscarButtonClick(String materia) throws ArchivoInvalido, CargarArchivo;
}
