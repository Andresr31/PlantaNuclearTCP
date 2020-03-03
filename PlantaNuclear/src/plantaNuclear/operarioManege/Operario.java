package plantaNuclear.operarioManege;

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
public class Operario implements Runnable {

    private Socket conexion;
    private DataInputStream in;
    private DataOutputStream out;
    
    private OperarioManage supervisor;

    public Operario(Socket conexion, OperarioManage s) {
        this.conexion = conexion;
        try {

            in = new DataInputStream(this.conexion.getInputStream());
            out = new DataOutputStream(this.conexion.getOutputStream());
            this.supervisor = s;
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    public String enviarEvento(String evento) {
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

    @Override
    public void run() {

        while (true) {
            try {
                String data = in.readUTF();

                System.out.println("REQUEST: " + data);
                
            } catch (IOException e) {
                System.out.println("Connection:" + e.getMessage());
            }
        }
    }

}
