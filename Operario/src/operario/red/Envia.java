/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operario.red;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andres
 */
public class Envia {

    private DataOutputStream out;

    public Envia() {
    }
    
    public String enviar(Socket cliSocket, String mensaje){
        String response = "ERROR";
        try {
            DataInputStream in = new DataInputStream(cliSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(cliSocket.getOutputStream());
            out.writeUTF(mensaje);
            out.flush();

            String output = in.readUTF();

            System.out.println("RESPONSE: " + output);
            response = output;
        } catch (IOException ex) {
            System.out.println("error al enviar");
        }
        return response;
        
    }

}
