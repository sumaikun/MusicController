/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerteclado;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Jesus
 */
public class Reproducir  extends Observable implements Command{
    String ruta;
    private AudioStream iMusic;
    //Silenciar silence ;
    public Reproducir (String ruta){
        this.ruta = ruta;
        //this.silence = silence;
    }
    @Override
    public void execute() {
        try {
            FileInputStream iAudio = new FileInputStream(new File(ruta));
           if(iMusic == null){
            iMusic = new AudioStream(iAudio);
            AudioPlayer.player.start(iMusic);
           }
            setChanged();
            notifyObservers();//silence.Adicionar(iMusic);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reproducir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reproducir.class.getName()).log(Level.SEVERE, null, ex);
        }          
         catch (Exception x) {
            System.out.println("not found" + x);
        }    
    }

    /**
     * @return the iMusic
     */
    public AudioStream getiMusic() {
        return iMusic;
    }

    @Override
    public void stop() {
        System.out.println("llego");
        AudioPlayer.player.stop(iMusic);
        try {
            iMusic.close();
        } catch (IOException ex) {
            Logger.getLogger(Reproducir.class.getName()).log(Level.SEVERE, null, ex);
        }
        iMusic =null;
    }
    
}
