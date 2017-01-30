/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerteclado;

/**
 *
 * @author Jesus
 */
public class Setups {
    
    Storaged storage = new Storaged();
    
    public Storaged Sensorium(){
        storage.setElementA("C:\\Users\\Jesus\\Documents\\NetBeansProjects\\LeerTeclado\\LeerTeclado\\src\\sonidos\\violines1.1.wav");
        storage.setElementS("C:\\Users\\Jesus\\Documents\\NetBeansProjects\\LeerTeclado\\LeerTeclado\\src\\sonidos\\violines1.2.wav");
        storage.setElementD("C:\\Users\\Jesus\\Documents\\NetBeansProjects\\LeerTeclado\\LeerTeclado\\src\\sonidos\\violines1.3.wav");
        return storage;
    }
}
