/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantaNuclear.elements;

import plantaNuclear.operarioManege.OperarioManage;
import plantaNuclear.reactorManage.ReactorManage;

/**
 *
 * @author andres
 */
public class PlantaNuclear {
    
    private ReactorManage reactor;
    private OperarioManage operario;

    public PlantaNuclear(OperarioManage o) {
        reactor = new ReactorManage();
        operario = o;
    }
    
    public String interpretar(String comando)
    {
        String[] mensaje = comando.split(";;");
        String respuesta = "";
        switch(mensaje[1]){
            case "APAGAR":
                
                int idApagar = Integer.parseInt(mensaje[0]);
                respuesta = reactor.apagar(idApagar);
                return respuesta;
            
            case "ENCENDER":
                int idEncender = Integer.parseInt(mensaje[0]);
                respuesta = reactor.encender(idEncender);
                return respuesta;
                
            case "DISMINUIR":
                int idDisminuir = Integer.parseInt(mensaje[0]);
                float disminucion = Float.parseFloat(mensaje[2]);
                
                respuesta = reactor.disminuirCarga(disminucion,idDisminuir);

                return respuesta;
                
            case "AUMENTAR":
                int idAumentar = Integer.parseInt(mensaje[0]);
                float aumento = Float.parseFloat(mensaje[2]);
                
                respuesta = reactor.aumentarCarga(aumento,idAumentar);

                return respuesta;
                
            case "REPARAR":
                int idReparar = Integer.parseInt(mensaje[0]);
                
                respuesta = reactor.reparar(idReparar);
                
                return respuesta;
                
            case "CHAT":
                operario.chat(mensaje[2]);
                return respuesta;
                
        }
        return "500";
    }
    
    
    
}
