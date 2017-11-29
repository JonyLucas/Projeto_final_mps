/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.facade;

import business.control.UserControl;
import business.control.commands.*;
import business.model.exceptions.InvalidLoginException;
import business.model.exceptions.InvalidTypeException;
import business.model.exceptions.UserNotExistException;
import business.model.memento.Caretaker;
import business.model.products.Product;
import business.model.users.User;
import business.model.wishlist.*;

/**
 *
 * Este Facade corresponde ao Facade da questão 02 do laboratorio 05
 * Este Facade será o Invoker do command
 * Este Facade será responsavel por salvar os Mementos
 * 
 **/

public class WishListFacade {
    
    static private Command command;
    static private WishListComponent wlc;
    static private Caretaker caretaker = Caretaker.get_instance();
    
    static public void add_product(String login, Object object) throws UserNotExistException{
        User user = UserControl.get_user(login);
        command = new LoginUserCommand(user, login);
        
        try{
            command.execute();
            
            caretaker.add_memento(user.store_wishlist_in_memento());
            
            command = new AddToWishListCommand(user.get_wishlist(), object);
            command.execute();
        }catch(InvalidLoginException ile){
            System.out.println(ile.getMessage());
        }catch(InvalidTypeException ite){
            System.out.println(ite.getMessage());
        }
    }
    
    static public void remove_product(String login, Object object) throws UserNotExistException{
        
        User user = UserControl.get_user(login);
        command = new LoginUserCommand(user, login);
        
        try{
            command.execute();
            
            caretaker.add_memento(user.store_wishlist_in_memento());
            
            command = new RemoveFromWishListCommand(user.get_wishlist(), object);
            command.execute();
        }catch(InvalidLoginException ile){
            System.out.println(ile.getMessage());
        }catch(InvalidTypeException ite){
            System.out.println(ite.getMessage());
        }
        
    }
    
    static public void show_wishlist(String login) throws UserNotExistException{
        
        User user = UserControl.get_user(login);
        command = new LoginUserCommand(user, login);
        
        try{
            command.execute();
            command = new ShowWishListCommand(user.get_wishlist());
            command.execute();
        }catch(InvalidLoginException ile){
            System.out.println(ile.getMessage());
        }catch(InvalidTypeException ite){
            System.out.println(ite.getMessage());
        }
        
    }
    
    static public void undo_last_command(String login) throws UserNotExistException{
                
        try{
            command = new UndoCommand();
            command.execute();
        }catch(Exception e){
            System.out.println("Can't execute the undo command");
        }
        
    }
    
}
