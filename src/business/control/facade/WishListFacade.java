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

/**Facade responsavel por manipular a entidade lista de desejos (wishlist), este é o Invoker dos comandos**/
public class WishListFacade {
    
    static private Command command;
    static private WishListComponent wlc;
    static private Caretaker caretaker = Caretaker.get_instance();
    
    /**Adiciona determinado produto na lista de desejos do usuarios**/
    static public void add_product(String login, Object object) throws UserNotExistException{
        
        User user = UserControl.get_user(login);
        command = new LoginUserCommand(user, login); //Utiliza o comando de Login para um usuario logar e acessar sua lista de desejos
        
        try{
            command.execute();
            
            caretaker.add_memento(user.store_wishlist_in_memento()); //Salva o estado atual da lista no caretaker para que este estado possa ser recuperado posteriormente
            
            command = new AddToWishListCommand(user.get_wishlist(), object);
            command.execute();
        }catch(InvalidLoginException ile){
            System.out.println(ile.getMessage());
        }catch(InvalidTypeException ite){
            System.out.println(ite.getMessage());
        }
    }
    
    /**Remove o produto da lista de desejos do usuario**/
    static public void remove_product(String login, Object object) throws UserNotExistException{
        
        User user = UserControl.get_user(login);
        command = new LoginUserCommand(user, login); //Utiliza o comando de Login para um usuario logar e acessar sua lista de desejos
        
        try{
            command.execute();
            
            caretaker.add_memento(user.store_wishlist_in_memento()); //Salva o estado atual da lista no caretaker para que este estado possa ser recuperado posteriormente
            
            command = new RemoveFromWishListCommand(user.get_wishlist(), object);
            command.execute();
        }catch(InvalidLoginException ile){
            System.out.println(ile.getMessage());
        }catch(InvalidTypeException ite){
            System.out.println(ite.getMessage());
        }
        
    }
    
    /**Exibe a lista de desejos do usuario**/
    static public void show_wishlist(String login) throws UserNotExistException{
        
        User user = UserControl.get_user(login);
        command = new LoginUserCommand(user, login); //Utiliza o comando de Login para um usuario logar e acessar sua lista de desejos
        
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
    
    /**Desfaz o ultimo comando executado e que modificou a lista de desejos**/
    static public void undo_last_command(String login) throws UserNotExistException{
                
        try{
            command = new UndoCommand();
            command.execute();
        }catch(Exception e){
            System.out.println("Can't execute the undo command");
        }
        
    }
    
}
