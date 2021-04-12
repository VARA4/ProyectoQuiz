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
public class CargarArchivo extends Exception {
    public CargarArchivo() {
    }

    public CargarArchivo(String msg) {
        super(msg);
    }
}
