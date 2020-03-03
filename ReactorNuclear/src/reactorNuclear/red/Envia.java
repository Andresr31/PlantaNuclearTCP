/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactorNuclear.red;

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
    
    public void enviar(Socket cliSocket, String mensaje){
        
        System.out.println("RESPONSE: " + mensaje);
        
        try {
            this.out= new DataOutputStream(cliSocket.getOutputStream());
            out.writeUTF(mensaje);
            out.flush();
        } catch (IOException ex) {
            System.out.println("Error en envia de reactor");
            //Logger.getLogger(Envia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

}
