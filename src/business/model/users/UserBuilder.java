/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.users;

import business.control.Validator;
import business.model.exceptions.LoginValidationException;
import business.model.exceptions.PasswordValidationException;

/**
 *
 * @author Dell
 */
public abstract class UserBuilder {
    
        
    protected String login, password,tipo;
    
    public UserBuilder(String login, String password){
        this.login = login;
        this.password = password;
             
    }
    
    public abstract void buildLogin();
    public abstract void buildPassword();
    public abstract void buildTipo();
    
      
    public String get_login(){
        return this.login;
    }
    
    public String get_password(){
        return this.password;
    }
    
    public String get_tipo(){
        return this.tipo;
    }
    
    public void set_login(String login){
        try{
            Validator.validate_login(login);
            this.login = login;
        }catch(LoginValidationException uve){
            System.out.println(uve.getMessage());
        }
    }
    
    public void set_password(String password){
        try{
            Validator.validate_password(password);
            this.password = password;
        }catch(PasswordValidationException uve){
            System.out.println(uve.getMessage());
        }
    }
    
    public void set_tipo(String tipo){
         try{
            Validator.validate_password(password);
            this.tipo = tipo;
        }catch(PasswordValidationException uve){
            System.out.println(uve.getMessage());
        }
    }
   
}
