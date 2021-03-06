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
import business.model.exceptions.InvalidTypeException;
import business.model.exceptions.UserNotExistException;
import business.model.catalogs.ProductCatalog;
import business.model.exceptions.InvalidLoginException;
import business.model.products.*;
import business.model.users.User;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao
 */

/**Facade da questão 04 - LAB 04**/
/**Facade que registra e manipula usuarios, produtos e catalogos de produtos**/
public class RegisterFacade {
    
    static private ProductBuilder product_builder = new ProductBuilder();
    static private ProductCatalog product_catalog;
    
    static public void register_product(String type_of_product){
        try{
            Product product = product_builder.order_product(type_of_product);
            CatalogControl.add(product);
            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
        }catch(InvalidTypeException ite){
            JOptionPane.showMessageDialog(null, ite.getMessage());
        }
    }
    
    
    static public void register_product(String type_of_product, String ... arguments){
        try{
            Product product = product_builder.order_product(type_of_product, arguments);
            CatalogControl.add(product);
            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
        }catch(InvalidTypeException ite){
            JOptionPane.showMessageDialog(null, ite.getMessage());
        }
    }
    
    static public void register_product(Product product){
        try{
            CatalogControl.add(product);
        }catch(InvalidTypeException ite){
            JOptionPane.showMessageDialog(null, ite.getMessage());
        }
    }
    
    static public void register_product(Product product){
       try{
           CatalogControl.add(product);
       }catch(InvalidTypeException ite){
           System.out.println(ite.getMessage());
       }
   }
    
    static public void remove_product(Product product){
        try{
            CatalogControl.remove(product);
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
        }catch(InvalidTypeException ite){
            JOptionPane.showMessageDialog(null, ite.getMessage());
        }
    }
    
    static public Product get_product(String type_of_product, int index){
        return CatalogControl.get(type_of_product, index);
    }
    
    static public String show_catalog(String type_of_product){
        return CatalogControl.show(type_of_product);
    }
    
    static public void register_regular_user(String login, String password){
        UserControl.add_user("Regular", login, password);
    }
    
    static public void register_admin_user(String login, String password){
        UserControl.add_user("Admin", login, password);
    }
    
    static public void remove_user(String login){
        try{
            UserControl.remove_user(login);
        }catch(UserNotExistException unee){
            JOptionPane.showMessageDialog(null, unee.getMessage());
        }
    }
    
    static public User get_user(String login){
        User user = null;
        try{
            user = UserControl.get_user(login);
            return user;
        }catch(UserNotExistException unee){
            JOptionPane.showMessageDialog(null, unee.getMessage());
        }
        return user;
    }
    
    static public void user_login(String login) throws InvalidLoginException{
        try{
            User user = UserControl.get_user(login);
            Command command = new LoginUserCommand(user, login);
            command.execute();
            JOptionPane.showMessageDialog(null, "Login done successfully");
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
