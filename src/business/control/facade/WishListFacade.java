/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.facade;

import business.control.UserControl;
import business.control.commands.Command;
import business.model.exceptions.InvalidLoginException;
import business.model.exceptions.UserNotExistException;
import business.model.products.Product;
import business.model.users.states.*;
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
    
    static public void add_product(String login, Product product) throws UserNotExistException{
        try{
            User user = UserControl.get_user(login);
            if(user.get_current_state() instanceof LogoutState){
                System.out.println("Erro: o usuário não está logado");
                return;
            }
            wlc = user.get_wishlist();
            wlc.add(product);
            user.set_wishlist(wlc);
        }catch(InvalidLoginException ile){
            System.out.println(ile.getMessage());
        }
    }
    
}
