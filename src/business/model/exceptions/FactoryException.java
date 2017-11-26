/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.exceptions;

/**
 *
 * @author Joao
 */
public class FactoryException extends RuntimeException{
    
    public FactoryException(){
        super("Erro: não foi possível criar o produto");
    }
    
    public FactoryException(String s){
        super(s);
    }
    
}
