/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.users.User;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao
 */
public class UserList {
    
    /**Exibe o login e senha do usuario cadastrado na lista de usuarios**/
    public static String list(List<User> users, String login){ //Deve-se deixar mais generico
        String list = "";
        
        for(User user : users){
            if(user.get_login().equals(login)){
                list += user.get_info();
            }
        }
        
        JOptionPane.showMessageDialog(null, list);
        
        return list;
        
    }
    
    /**Exibe todos os logins e senhas dos usuarios cadastrados no sistema**/
    public static String list_all(List<User> users){
        String list = "";
        
        for(User user : users){
            list += user.get_info();
        }
        
        JOptionPane.showMessageDialog(null, list);
        
        return list;
    }
}
