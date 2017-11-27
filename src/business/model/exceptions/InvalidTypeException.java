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
public class InvalidTypeException extends RuntimeException{
    
    public InvalidTypeException(){
        super("Erro: Tipo de produto inválido");
    }
    
    public InvalidTypeException(String s){
        super(s);
    }
    
}
