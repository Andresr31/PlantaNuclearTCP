/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactorNuclear.elements;

/**
 *
 * @author andres
 */
public class Reactor {
    private String estado;
    private float carga;
    private boolean funcional;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getCarga() {
        return carga;
    }

    public void setCarga(float carga) {
        this.carga = carga;
    }
    
    public String encender(){
        setEstado("ENCENDIDO");
        return "200";
    }
    
    public String apagar(){
        setEstado("APAGADO");
        return "200";
    }
    
    public String reparar(){
        setCarga(0);
        setEstado("REPARADO");
        return "200";
    }
    
    public String dañar(float cargaDaño){
        if(cargaDaño > 100){
            setCarga(cargaDaño);
            setEstado("DAÑADO");
            return "200";
        } else{
            return "500";
        }
    }
    
    public void verificarFuncionalidad(){}
       
}
