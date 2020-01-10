/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.idioma.gui;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ariel
 */
public abstract class Pregunta {
    
    private List<Respuesta> respuestas;
    private int errores;
    

    public Pregunta() {
        respuestas = new ArrayList<>();
        errores = 0;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

  
    
    

  
    
    
    
    
    
    

    
   
}
