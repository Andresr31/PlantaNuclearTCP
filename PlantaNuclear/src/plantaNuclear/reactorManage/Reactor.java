/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantaNuclear.reactorManage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andres
 */
public class Reactor {

    private Socket conexion;

    public Reactor(Socket conexion) {
        this.conexion = conexion;
    }

    //////////////////////////////////////////////////////////////////////
    // 300 si ya está encendido
    // 500 si está dañado
    // 400 no funcional
    // 200 está apagado y lo encendió
    public String encender() {

        String comando = "ENCENDER";
        String response = "ERROR";
        try {
            DataInputStream in = new DataInputStream(conexion.getInputStream());
            DataOutputStream out = new DataOutputStream(conexion.getOutputStream());
            out.writeUTF(comando);
            out.flush();

            String output = in.readUTF();

            System.out.println("RESPONSE: " + output);
            response = output;
        } catch (IOException ex) {
            Logger.getLogger(Reactor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;

    }

    // 300 si ya está apagado
    // 500 si está dañado
    // 400 no funcional
    // 200 está encendido y lo apagó
    public String apagar() {
        
        String comando = "APAGAR";
        String response = "ERROR";
        try {
            DataInputStream in = new DataInputStream(conexion.getInputStream());
            DataOutputStream out = new DataOutputStream(conexion.getOutputStream());
            out.writeUTF(comando);
            out.flush();

            String output = in.readUTF();

            System.out.println("RESPONSE: " + output);
            response = output;
        } catch (IOException ex) {
            Logger.getLogger(Reactor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;

    }

    // 300 si ya está apagado
    // 500 si está dañado
    // 400 no funcional
    // 200 está encendido y lo apagó
    public String reparar() {
        String comando = "REPARAR";
        String response = "ERROR";
        try {
            DataInputStream in = new DataInputStream(conexion.getInputStream());
            DataOutputStream out = new DataOutputStream(conexion.getOutputStream());
            out.writeUTF(comando);
            out.flush();

            String output = in.readUTF();

            System.out.println("RESPONSE: " + output);
            response = output;
        } catch (IOException ex) {
            Logger.getLogger(Reactor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;

    }

    ////////////////////////////////////////////////////////////////////////////
    public String aumentarCarga(float carga) {
        String comando = "AUMENTAR;;"+carga;
        String response = "ERROR";
        try {
            DataInputStream in = new DataInputStream(conexion.getInputStream());
            DataOutputStream out = new DataOutputStream(conexion.getOutputStream());
            out.writeUTF(comando);
            out.flush();

            String output = in.readUTF();

            System.out.println("RESPONSE: " + output);
            response = output;
        } catch (IOException ex) {
            Logger.getLogger(Reactor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    public String disminuirCarga(float carga) {
        
        String comando = "DISMINUIR;;"+carga;
        String response = "ERROR";
        try {
            DataInputStream in = new DataInputStream(conexion.getInputStream());
            DataOutputStream out = new DataOutputStream(conexion.getOutputStream());
            out.writeUTF(comando);
            out.flush();

            String output = in.readUTF();

            System.out.println("RESPONSE: " + output);
            response = output;
        } catch (IOException ex) {
            Logger.getLogger(Reactor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;

    }

}
