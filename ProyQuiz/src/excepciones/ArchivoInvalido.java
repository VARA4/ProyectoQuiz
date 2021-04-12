/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author ALEW
 */
public class ArchivoInvalido extends Exception {
    public ArchivoInvalido() {
    }

    public ArchivoInvalido(String msg) {
        super(msg);
    }
}
