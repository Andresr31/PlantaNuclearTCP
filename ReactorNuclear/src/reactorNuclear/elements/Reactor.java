
package reactorNuclear.elements;

/**
 *
 * @author Carlos Andres Rojas Parra
 * @author David Salgado Ospina
 */
public class Reactor {
    private final int ENCENDIDO = 1;
    private final int APAGADO = 2;
    private final int DAÑADO = 3;
 
    private int estado;
    private float carga;
    private boolean funcional;

    /////////////////////////////////////////////////////////////////////
    public Reactor() {
        
        this.estado = APAGADO;
        this.carga = 0;
        this.funcional = true;
        
    }

    public int getEstado() {
        return estado;
    }

    public float getCarga() {
        return carga;
    }

    public boolean isFuncional() {
        return funcional;
    }
    
    private void setEstado(int e){
        this.estado=e;
    }
    
    private void setCarga(float c){
        this.carga=c;
    }
    
    /////////////////////////////////////////////////////////////////////////

    // 300 si ya está encendido
    // 500 si está dañado
    // 400 no funcional
    // 200 está apagado y lo encendió
    public String encender(){
        
        switch (this.estado) {
            case ENCENDIDO:
                return "300";
            case DAÑADO:
                return "500";
            case APAGADO:
                setEstado(ENCENDIDO);
                setCarga(0);
                return "200";
            default:
                break;
        }
        
        return "404";
        
    }
    
    // 300 si ya está apagado
    // 500 si está dañado
    // 400 no funcional
    // 200 está encendido y lo apagó
    public String apagar(){
        
        switch (this.estado) {
            case APAGADO:
                return "300";
            case DAÑADO:
                return "500";
            case ENCENDIDO:
                setEstado(APAGADO);
                setCarga(0);
                return "200";
            default:
                return "404";
        }
        
    }
    
    // 300 si ya está apagado
    // 500 si está dañado
    // 400 no funcional
    // 200 está encendido y lo apagó
    public String reparar(){
        
        if(this.estado == DAÑADO)
        {
            apagar();
            this.funcional = true;
            return "200";
        }else{
            return "500";
        }
        
    }
    
    ////////////////////////////////////////////////////////////////////////////
    public String aumentarCarga(float carga){
        float temp = this.carga + carga;
        
        if(temp > 100)
            return dañar();
        if(this.estado == ENCENDIDO)
        {
            this.carga = temp;
            return "200";
        }else{
            if (this.estado == DAÑADO){
                return "300";
            }else if(this.estado == APAGADO)
            {
                return "400";
            }      
        }
        
        return "404";
        
    }
    
    public String disminuirCarga(float carga){
        float temp = this.carga - carga;
        
        if(temp <= 0)
            return apagar();
        if(this.estado == ENCENDIDO)
        {
            this.carga = temp;
            return "200";
        }else{
            if (this.estado == DAÑADO){
                return "300";
            }else if(this.estado == APAGADO)
            {
                return "400";
            }      
        }
        
        return "404";
        
    }
    
    public String dañar(){
        this.setEstado(DAÑADO);
        this.funcional = false;
        return "600";
    }  
}
