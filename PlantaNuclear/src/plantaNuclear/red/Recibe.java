/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantaNuclear.red;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import plantaNuclear.elements.Comunicacion;

/**
 *
 * @author andres
 */
public class Recibe implements Runnable {

    ServerSocket listenSocket;
    Comunicacion comunicacion;
    

    public Recibe(Comunicacion c) throws IOException {

        this.comunicacion = c;
        listenSocket = new ServerSocket(c.getPuerto());
        

    }

    @Override
    public void run() {

        while (true) {
            System.out.println("SERVER: esperando un operario");

            Socket clientSocket = null;
            try {
                clientSocket = listenSocket.accept();
            } catch (IOException ex) {
                Logger.getLogger(Recibe.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("SERVER: operario: "+clientSocket.getInetAddress().getHostName());

            this.comunicacion.interpretar(clientSocket);

            //hasher.process();
        }

    }

}
