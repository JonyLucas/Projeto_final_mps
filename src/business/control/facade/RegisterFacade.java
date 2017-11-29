/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.facade;

import business.control.CatalogControl;
import business.control.UserControl;
import business.control.UserList;
import business.control.commands.*;
import business.control.product.factory.ProductBuilder;
import business.model.catalogs.*;
import business.model.exceptions.InvalidTypeException;
import business.model.exceptions.UserNotExistException;
import business.model.catalogs.ProductCatalog;
import business.model.exceptions.InvalidLoginException;
import business.model.products.*;
import business.model.users.User;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joao
 */

/**Facade da questão 04 - LAB 04**/
public class RegisterFacade {
    
    static private ProductBuilder product_builder = new ProductBuilder();
    static private ProductCatalog product_catalog;
    
    static public void register_product(String type_of_product){
        try{
            Product product = product_builder.order_product(type_of_product);
            CatalogControl.add(product);
        }catch(InvalidTypeException ite){
            System.out.println(ite.getMessage());
        }
    }
    
    static public void register_product(String type_of_product, String ... arguments){
        try{
            Product product = product_builder.order_product(type_of_product, arguments);
            CatalogControl.add(product);
        }catch(InvalidTypeException ite){
            System.out.println(ite.getMessage());
        }
    }
    
    static public void remove_product(Product product){
        try{
            CatalogControl.remove(product);
        }catch(InvalidTypeException ite){
            System.out.println(ite.getMessage());
        }
    }
    
    static public Product get_product(String type_of_product, int index){
        return CatalogControl.get(type_of_product, index);
    }
    
    static public void show_catalog(String type_of_product){
        CatalogControl.show(type_of_product);
    }
    
    static public void register_user(String login, String password){
        UserControl.add_user(login, password);
    }
    
    static public void remove_user(String login){
        try{
            UserControl.remove_user(login);
        }catch(UserNotExistException unee){
            System.out.println(unee.getMessage());
        }
    }
    
    static public void user_login(String login) throws InvalidLoginException{
        try{
            User user = UserControl.get_user(login);
            Command command = new LoginUserCommand(user, login);
            command.execute();
        } catch (UserNotExistException ex) {
            throw new InvalidLoginException("Login can not be done");
        }
    }
    
    static public void list(String user){
        if(user.equals("all")){
            UserList.list_all(UserControl.get_array_list());
        }else{
            UserList.list(UserControl.get_array_list(), user);
        }
    }
    
}
