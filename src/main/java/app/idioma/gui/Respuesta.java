/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.idioma.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author ariel
 */
public class Respuesta extends JButton {
   
    private Pregunta pregunta;
    private int indicePregunta;

    private Inicio frame;
    private boolean correcta;

    public Respuesta(Pregunta pregunta) {

        this.pregunta = pregunta;
   
    }

    public boolean isCorrecta() {
        return correcta;
    }
    

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public int getIndicePregunta() {
        return indicePregunta;
    }

    public void setIndicePregunta(int indicePregunta) {
        this.indicePregunta = indicePregunta;
    }

    public Inicio getFrame() {
        return frame;
    }

    public void setFrame(Inicio frame) {
        this.frame = frame;
    }

   
    
    
    

    @Override
    public synchronized void addMouseListener(MouseListener l) {
        super.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (correcta) {

                    try {
                        FileInputStream fis = new FileInputStream(new File("audio/success.mp3").getAbsolutePath());
                        Player playMP3 = new Player(fis);
                        playMP3.play();
                        
                        
                        FinTarea ft = new FinTarea(frame);
                        ft.setLocationRelativeTo(null);
                        ft.setVisible(true);
                 
                       
                    } catch (FileNotFoundException | JavaLayerException ex) {
                        Logger.getLogger(Respuesta.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {

                    try {
                        FileInputStream fis = new FileInputStream(new File("audio/error.mp3").getAbsolutePath());
                        Player playMP3 = new Player(fis);
                        playMP3.play();
                        
                        pregunta.setErrores(pregunta.getErrores()+1);
                        
                    } catch (FileNotFoundException | JavaLayerException ex) {
                        Logger.getLogger(Respuesta.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

}
