/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantaNuclear.reactorManage;

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
public class ReactorManage {
    
    private Reactor[] reactores;

    public ReactorManage() {
        this.reactores = new Reactor[3];
        conectar();
    }
    
    //////////////////////////////////////////////////////////////////////////
    
    public void conectar()
    {
        try {
            Socket reactorA = new Socket(InetAddress.getByName("127.0.0.1"), 2201);
            Socket reactorB = new Socket(InetAddress.getByName("127.0.0.1"), 2202);
            Socket reactorC = new Socket(InetAddress.getByName("127.0.0.1"), 2203);
            
            this.reactores[0] = new Reactor(reactorA);
            this.reactores[1] = new Reactor(reactorB);
            this.reactores[2] = new Reactor(reactorC);
            
        } catch (UnknownHostException ex) {
            System.out.println("Error conectando reactores");
        } catch (IOException ex) {
            System.out.println("Error conectando reactores");
        }
        
    }
    
    ////////////////////////////////////////////////////////////////////////////
    public String encender(int idReactor) {
        return reactores[idReactor-1].encender();
    }

    public String apagar(int idReactor) {
        return reactores[idReactor-1].apagar();
    }

    public String reparar(int idReactor) {
        return reactores[idReactor-1].reparar();
    }

    ////////////////////////////////////////////////////////////////////////////
    public String aumentarCarga(float carga, int idReactor) {
        return reactores[idReactor-1].aumentarCarga(carga);
    }

    public String disminuirCarga(float carga, int idReactor) {
        return reactores[idReactor-1].disminuirCarga(carga);
    }

    
    
}
