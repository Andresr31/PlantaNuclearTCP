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
import plantaNuclear.operarioManege.OperarioManage;

/**
 *
 * @author andres
 */
public class Recibe {

    ServerSocket listenSocket;
    OperarioManage operarios;

    public Recibe(Comunicacion c) throws IOException {

        listenSocket = new ServerSocket(4400);
        
        operarios = new OperarioManage();

    }

    public void procesar() {
        try {
            System.out.println("PLANTA: encendida");

            while (true) {
                System.out.println("PLANTA: esperando operario");

                Socket clientSocket = listenSocket.accept();

                System.out.println("PLANTA: operario recibido "+clientSocket.getInetAddress().getHostName());

                operarios.agregarOperario(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Error connecting a client: " + e.getMessage());
        }
    }

}
