/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operario.red;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andres
 */
public class RedOperario {

    private Socket conexion;
    private InetAddress ipPlanta;
    private int puertoPlanta;
    
    private Envia envia;

    public RedOperario(String ipPlanta, int puertoPlanta) {
        try {
            this.ipPlanta = InetAddress.getByName(ipPlanta);
        } catch (UnknownHostException ex) {
            Logger.getLogger(RedOperario.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.puertoPlanta = puertoPlanta;
        this.envia = new Envia();
    }

    public void conectar() {

        try {
            this.conexion = new Socket(ipPlanta, puertoPlanta);
            System.out.println("Operario conectado con la planta: " + conexion.getInetAddress().getHostName());

        } catch (IOException ex) {
            System.out.println("Error al conectar con la planta");
        }
    }

    public String encender(int id) {

        String comando = id+";;ENCENDER";
        return this.envia.enviar(conexion,comando);

    }
    
    public String apagar(int id) {

        String comando = id+";;APAGAR";
        return this.envia.enviar(conexion,comando);

    }

    public String reparar(int id) {
        String comando = id+";;REPARAR";
        return this.envia.enviar(conexion,comando);
    }

    ////////////////////////////////////////////////////////////////////////////
    public String aumentarCarga(int id,float carga) {
        String comando = id+";;AUMENTAR;;"+carga;
        return this.envia.enviar(conexion,comando);
    }

    public String disminuirCarga(int id,float carga) {

        String comando = id+";;DISMINUIR;;"+carga;
        return this.envia.enviar(conexion,comando);

    }
    
    public String chat(String mensaje){
        
        String comando = "0;;CHAT;;"+mensaje;
        return this.envia.enviar(conexion, comando);
    }
   

}
