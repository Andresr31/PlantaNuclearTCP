/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactorNuclear.elements;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import reactorNuclear.red.Envia;
import reactorNuclear.red.Recibe;

/**
 *
 * @author andres
 */
public class Comunicacion {

    private int puerto;
    private Reactor reactor;
    private DataInputStream in;
    private Recibe recibe;
    private Envia envia;

    ///////////////////////////////////////////////////////////////////////
    public Comunicacion(int puerto, Reactor reactor) {
        this.puerto = puerto;
        this.reactor = reactor;
        try {
            this.envia = new Envia();
            this.recibe = new Recibe(this);
            ExecutorService executor = Executors.newCachedThreadPool();
            executor.execute(recibe);
            
        } catch (IOException ex) {
            Logger.getLogger(Comunicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///////////////////////////////////////////////////////////////////////
    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    ///////////////////////////////////////////////////////////////
    public void interpretar(Socket cliente) {

        try {
            this.in = new DataInputStream(cliente.getInputStream());
            String resultado = this.reactor.interpretar(in.readUTF());
            System.out.println(resultado);
            this.envia.enviar(cliente, resultado);

        } catch (IOException ex) {
            Logger.getLogger(Comunicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    ///////////////////////////////////////////////////////////////

}
