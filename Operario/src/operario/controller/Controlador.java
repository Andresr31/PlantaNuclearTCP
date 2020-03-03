/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operario.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import operario.elements.Operario;
import operario.views.PlantaView;

/**
 *
 * @author andres
 */
public class Controlador implements Runnable {

    private ServerSocket listenSocket;
    private PlantaView planta;
    

    public Controlador(PlantaView p) throws IOException {

        listenSocket = new ServerSocket(5555);
        this.planta = p;
        

    }

    @Override
    public void run() {

        while (true) {
            System.out.println("ESPERANDO: planta");

            Socket clientSocket = null;
            try {
                clientSocket = listenSocket.accept();
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("SERVER: cliente recibido");

            this.interpretar(clientSocket);

            //hasher.process();
        }

    }
    
    public void interpretar(Socket planta){
        
        //INTERPRETA Y MODIFICA LA VISTA
        
    }

}
