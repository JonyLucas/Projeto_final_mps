/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.commands;

import business.model.exceptions.InvalidTypeException;
import business.model.memento.Memento;

/**
 *
 * @author Joao
 */
public class UndoCommand implements Command {

    private Memento memento;
    
    
    
    @Override
    public void execute() throws InvalidTypeException {
        
    }
    
}
