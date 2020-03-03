
package plantaNuclear.operarioManege;

import java.net.Socket;
import java.util.ArrayList;
import plantaNuclear.elements.PlantaNuclear;

/**
 *
 * @author andres
 */
public class OperarioManage {
    
    private ArrayList<Operario> operarios;
    
    private PlantaNuclear planta;

    public OperarioManage() {
        
        operarios = new ArrayList<>();
        this.planta = new PlantaNuclear(this);
    }
    
    //////////////////////////////////////////////////////////////////////////
    public boolean agregarOperario (Socket conexion){
        Operario op = new Operario(conexion, this);
        return operarios.add(op);
    }
    
    public void interpretar(String comando){
        this.planta.interpretar(comando);
    }
    
    public void chat(String mensaje){
        
        for (Operario operario : operarios) {
            String comando = "CHAT;;"+mensaje;
            operario.enviarEvento(comando);
        }
        
    }
    
    
    
    
    
}
