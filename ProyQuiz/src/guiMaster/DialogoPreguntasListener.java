/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMaster;

import model.Pregunta;
import model.Respuesta;

/**
 *
 * @author ALEW
 */
public interface DialogoPreguntasListener {
    public void aceptarButtonClick(Pregunta pregunta, Respuesta uno, Respuesta dos, Respuesta tres, Respuesta cuatro);
    public void cancelarButtonClick();
}
