/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.memento;

import java.util.LinkedList;

/**
 *
 * @author Joao
 */
public class Caretaker {
    
    static private LinkedList<Memento> saved_states = null;
    static private Caretaker caretaker = null;
    
    private Caretaker(){
        saved_states = new LinkedList<Memento>();
    }
    
    /**Padrão singleton**/
    public static synchronized Caretaker get_instance(){
        if(caretaker == null){ //Indica que o caretaker não foi inicializado
            caretaker = new Caretaker();
        }
        return caretaker;
    }
    
    public void add_memento(Memento m){ saved_states.add(m); }
    public Memento get_lastest_memento() { return saved_states.pollLast(); }
    
}
