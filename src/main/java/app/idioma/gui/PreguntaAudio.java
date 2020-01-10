/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.idioma.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author ariel
 */
public class PreguntaAudio extends Pregunta {

    private File archivo;

    public PreguntaAudio() {
    }

  
    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void reproducir() throws FileNotFoundException, JavaLayerException {

       
        FileInputStream fis = new FileInputStream(archivo.getAbsolutePath());
        Player playMP3 = new Player(fis);
        playMP3.play();
    }

   

}
