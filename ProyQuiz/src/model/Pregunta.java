/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ALEW
 */
public class Pregunta implements Serializable {
    private String pregunta;
    private Respuesta[] respuestas;
    private Integer contador;

    private String materia;



    public Pregunta(String pregunta, String materia) {
        this.pregunta = pregunta;
        this.respuestas = new Respuesta[4];
        this.contador = 0;
        this.materia = materia;
    }

    public String getMateria(){
        return this.materia;
    }

    public void setRespuesta(Respuesta x){
        if (contador < 4) {
            this.respuestas[contador] = x;
        }
        this.contador++;
    }

    public String getPregunta() {
        return pregunta;
    }
    
    public Boolean valor(int x){
        return this.respuestas[x].getCalificacion();        
    }

    @Override
    public String toString() {
        return String.format("%s      "
            + " [0]%s, [1] %s, [2] %s, [3]%s",getPregunta(),this.respuestas[0].getRespuesta(),this.respuestas[1].getRespuesta(),this.respuestas[2].getRespuesta(),this.respuestas[3].getRespuesta());
    }

    
    public String respuesta(int x){
        return respuestas[x].getRespuesta();
    }

    public Respuesta[] answers(){
        return this.respuestas;
    }

    public String getCorrecta(){
        String correcta = "";
        for (int i = 0; i < respuestas.length; i++) {

            if (respuestas[i].getCalificacion() == true){
                correcta = respuestas[i].getRespuesta();
            }
        }
        return correcta;
    } 
}
