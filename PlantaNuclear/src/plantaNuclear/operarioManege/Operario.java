
package plantaNuclear.operarioManege;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author andres
 */
public class Operario {
    
    private Socket conexion;

    public Operario(Socket conexion) {
        this.conexion = conexion;
    }
    
    public String enviarEvento(String evento)
    {
         String response = "ERROR";
        try {
            DataInputStream in = new DataInputStream(conexion.getInputStream());
            DataOutputStream out = new DataOutputStream(conexion.getOutputStream());
            out.writeUTF(evento);
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
