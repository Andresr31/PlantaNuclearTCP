/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operario.elements;

import operario.red.RedOperario;

/**
 *
 * @author andres
 */
public class Operario {
    
    private String userName;
    private RedOperario red;

    public Operario(String userName, String ipPlanta, int puertoPlanta) {
        this.userName = userName;
        red = new RedOperario(ipPlanta, puertoPlanta);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    
    ///////////////////////////////////////////////////////////////////////////
    
    public String encender(int idReactor) {
        return red.encender(idReactor);
    }

    public String apagar(int idReactor) {
        return red.apagar(idReactor);
    }

    public String reparar(int idReactor) {
        return red.reparar(idReactor);
    }

    ////////////////////////////////////////////////////////////////////////////
    public String aumentarCarga(float carga, int idReactor) {
        return red.aumentarCarga(idReactor,carga);
    }

    public String disminuirCarga(float carga, int idReactor) {
        return red.disminuirCarga(idReactor,carga);
    }
    
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    
}
