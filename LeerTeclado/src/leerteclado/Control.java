/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerteclado;

import java.util.HashMap;

/**
 *
 * @author Jesus
 */
public class Control {
    HashMap <Character,Command> comandos;
    Silenciar silenciar;
    
    
    public Control () {
        
        comandos = new HashMap();
        silenciar = new Silenciar();
        Setups setup = new Setups();
        Storaged st = new Storaged();
        
        st = setup.Sensorium();
        
       comandos.put('A', new Reproducir(st.getElementA()));
       comandos.put('S', new Reproducir(st.getElementS()));
       comandos.put('D', new Reproducir(st.getElementD()));
       
       /*((Reproducir)comandos.get('A')).addObserver(silenciar);
       ((Reproducir)comandos.get('S')).addObserver(silenciar);
       ((Reproducir)comandos.get('D')).addObserver(silenciar);
       comandos.put('F', silenciar);*/
        
    }
    
    public void ejecutar (char s){
        /*if(s=='1'){
            comandos.put('A', new Reproducir("C:\\Users\\Jesus\\Documents\\NetBeansProjects\\LeerTeclado\\LeerTeclado\\src\\sonidos\\part4.mid"));
            comandos.put('S', new Reproducir("C:\\Users\\Jesus\\Documents\\NetBeansProjects\\LeerTeclado\\LeerTeclado\\src\\sonidos\\violines1.2.wav"));
            comandos.put('D', new Reproducir("C:\\Users\\Jesus\\Documents\\NetBeansProjects\\LeerTeclado\\LeerTeclado\\src\\sonidos\\violines1.3.wav"));
        }*/
        //comandos.get('F').adicionar();
        comandos.get(s).execute();
    }
    
    public void soltar(char s )
    {
        comandos.get(s).stop();
    }
}
