/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import excepciones.ArchivoInvalido;
import excepciones.CargarArchivo;

/**
 *
 * @author ALEW
 */
public interface DialogMenuListener {
    public void addPreguntaButtonClick() throws ArchivoInvalido, CargarArchivo;
    public void answerButtonClick();
}
