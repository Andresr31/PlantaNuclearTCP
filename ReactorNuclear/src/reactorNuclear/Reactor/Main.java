package reactorNuclear.Reactor;


import reactorNuclear.elements.Reactor;
import reactorNuclear.red.RedReactor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andres
 */
public class Main {
    
    public static void main(String[] args) {
        Reactor reactor = new Reactor(1);
        System.out.println("Reactor: "+reactor.getId()+" APAGADO");
        RedReactor red = new RedReactor(reactor, 2201);
        
        
            
    }
    
}
