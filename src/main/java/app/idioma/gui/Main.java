/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.idioma.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author ariel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static Inicio inicio;
    private static List<PreguntaAudio> preguntas;

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        comenzar();

    }

    public static void comenzar() {

        crearPreguntas();

        
        if (inicio != null) {
            
            inicio.dispose();

            inicio = null;
       
        }


        inicio = new Inicio(preguntas);
        inicio.setVisible(true);
        inicio.setExtendedState(JFrame.MAXIMIZED_BOTH);

       

        try {
            Thread hilo2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        preguntas.get(0).reproducir();

                    } catch (FileNotFoundException | JavaLayerException ex) {
                        Logger.getLogger(Respuesta.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });

            hilo2.sleep(1300);
            hilo2.run();

        } catch (InterruptedException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    private static void crearPreguntas() {

        preguntas = new ArrayList<>();

        PreguntaAudio pregunta = new PreguntaAudio();
        File audioMan = new File("audio/aMan.mp3");
        pregunta.setArchivo(audioMan);

        Respuesta r = new Respuesta(pregunta);
        r.setIcon(new ImageIcon("img/ninno.jpg"));
        r.setCorrecta(false);

        Respuesta r1 = new Respuesta(pregunta);
        r1.setIcon(new ImageIcon("img/mujer.jpg"));
        r1.setCorrecta(false);

        Respuesta r2 = new Respuesta(pregunta);
        r2.setIcon(new ImageIcon("img/hombre.jpg"));
        r2.setCorrecta(true);

        Respuesta r3 = new Respuesta(pregunta);
        r3.setIcon(new ImageIcon("img/ninna.jpg"));
        r3.setCorrecta(false);

        pregunta.getRespuestas().add(r);
        pregunta.getRespuestas().add(r1);
        pregunta.getRespuestas().add(r2);
        pregunta.getRespuestas().add(r3);

        PreguntaAudio pregunta2 = new PreguntaAudio();
        File audioBoy = new File("audio/aBoy.mp3");
        pregunta2.setArchivo(audioBoy);

        Respuesta r4 = new Respuesta(pregunta2);
        r4.setIcon(new ImageIcon("img/ninno2.jpg"));
        r4.setCorrecta(true);

        Respuesta r5 = new Respuesta(pregunta2);
        r5.setIcon(new ImageIcon("img/mujer2.jpg"));
        r5.setCorrecta(false);

        Respuesta r6 = new Respuesta(pregunta2);
        r6.setIcon(new ImageIcon("img/hombre2.jpg"));
        r6.setCorrecta(false);

        Respuesta r7 = new Respuesta(pregunta2);
        r7.setIcon(new ImageIcon("img/ninna2.jpg"));
        r7.setCorrecta(false);

        pregunta2.getRespuestas().add(r7);
        pregunta2.getRespuestas().add(r5);
        pregunta2.getRespuestas().add(r6);
        pregunta2.getRespuestas().add(r4);

        PreguntaAudio pregunta3 = new PreguntaAudio();
        File audioGirl = new File("audio/aGirl.mp3");
        pregunta3.setArchivo(audioGirl);

        Respuesta r8 = new Respuesta(pregunta3);
        r8.setIcon(new ImageIcon("img/mujer.jpg"));
        r8.setCorrecta(false);

        Respuesta r9 = new Respuesta(pregunta3);
        r9.setIcon(new ImageIcon("img/ninna.jpg"));
        r9.setCorrecta(true);

        Respuesta r10 = new Respuesta(pregunta3);
        r10.setIcon(new ImageIcon("img/ninno2.jpg"));
        r10.setCorrecta(false);

        Respuesta r11 = new Respuesta(pregunta3);
        r11.setIcon(new ImageIcon("img/hombre.jpg"));
        r11.setCorrecta(false);

        pregunta3.getRespuestas().add(r8);
        pregunta3.getRespuestas().add(r9);
        pregunta3.getRespuestas().add(r10);
        pregunta3.getRespuestas().add(r11);

        PreguntaAudio pregunta4 = new PreguntaAudio();
        File audioWoman = new File("audio/aWoman.mp3");
        pregunta4.setArchivo(audioWoman);

        Respuesta r12 = new Respuesta(pregunta4);
        r12.setIcon(new ImageIcon("img/hombre2.jpg"));
        r12.setCorrecta(false);

        Respuesta r13 = new Respuesta(pregunta4);
        r13.setIcon(new ImageIcon("img/ninna2.jpg"));
        r13.setCorrecta(false);

        Respuesta r14 = new Respuesta(pregunta4);
        r14.setIcon(new ImageIcon("img/mujer2.jpg"));
        r14.setCorrecta(true);

        Respuesta r15 = new Respuesta(pregunta4);
        r15.setIcon(new ImageIcon("img/hombre.jpg"));
        r15.setCorrecta(false);

        pregunta4.getRespuestas().add(r12);
        pregunta4.getRespuestas().add(r13);
        pregunta4.getRespuestas().add(r14);
        pregunta4.getRespuestas().add(r15);

        PreguntaAudio pregunta5 = new PreguntaAudio();
        File audioGirlDrinking = new File("audio/girlAction1.mp3");
        pregunta5.setArchivo(audioGirlDrinking);

        Respuesta r16 = new Respuesta(pregunta5);
        r16.setIcon(new ImageIcon("img/mujerBebe.jpg"));
        r16.setCorrecta(false);

        Respuesta r17 = new Respuesta(pregunta5);
        r17.setIcon(new ImageIcon("img/ninnaCome.jpg"));
        r17.setCorrecta(false);

        Respuesta r18 = new Respuesta(pregunta5);
        r18.setIcon(new ImageIcon("img/ninnoCome.jpg"));
        r18.setCorrecta(false);

        Respuesta r19 = new Respuesta(pregunta5);
        r19.setIcon(new ImageIcon("img/ninnaBebe.jpg"));
        r19.setCorrecta(true);

        pregunta5.getRespuestas().add(r16);
        pregunta5.getRespuestas().add(r17);
        pregunta5.getRespuestas().add(r18);
        pregunta5.getRespuestas().add(r19);

        preguntas.add(pregunta);
        preguntas.add(pregunta2);
        preguntas.add(pregunta3);
        preguntas.add(pregunta4);
        preguntas.add(pregunta5);
    }

}
