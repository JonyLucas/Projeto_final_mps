/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.commands;

import business.model.exceptions.InvalidTypeException;

/**
 *
 * @author Joao
 */

public interface Command {
    public void execute() throws InvalidTypeException;
}
