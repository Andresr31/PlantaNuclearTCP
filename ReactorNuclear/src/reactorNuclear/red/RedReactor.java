
package reactorNuclear.red;

import reactorNuclear.elements.Comunicacion;
import reactorNuclear.elements.Reactor;

/**
 *
 * @author Carlos Andres Rojas Parra
 * @author David Salgado Ospina
 */
public class RedReactor {
    
    private Comunicacion comunicacion;
    private Reactor reactor;
    private int puerto;

    public RedReactor(Reactor reactor, int puerto) {
        this.reactor = reactor;
        this.puerto = puerto;
        
        this.comunicacion = new Comunicacion(puerto, reactor);
    }

    public Comunicacion getComunicacion() {
        return comunicacion;
    }

    public void setComunicacion(Comunicacion comunicacion) {
        this.comunicacion = comunicacion;
    }

    public Reactor getReactor() {
        return reactor;
    }

    public void setReactor(Reactor reactor) {
        this.reactor = reactor;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
    
    
    
    
    
    
    
    
}
