/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerteclado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Jesus
 */
public class Silenciar implements Command , Observer{

    ArrayList<AudioStream> rutas;
    

    public Silenciar() {
        this.rutas = new ArrayList();
    }
    
    public void Adicionar(AudioStream ast) {
        
        rutas.add(ast);
    }
    
    
    
    @Override
    public void execute() {
      
            for(AudioStream ap:rutas)
            {
               AudioPlayer.player.stop(ap);
                try {
                    ap.close();
                } catch (IOException ex) {
                    Logger.getLogger(Silenciar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            rutas.removeAll(rutas);
            

        //iMusic = null;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("ingreso al observer");
        Reproducir r =(Reproducir) o;
        rutas.add(r.getiMusic());
    }

    @Override
    public void stop() {
        //no hace nada
    }
    
}
