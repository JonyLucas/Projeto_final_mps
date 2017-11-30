/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.database.writer;

import business.control.UserControl;
import infra.database.reader.*;
import business.model.users.User;
import infra.Adpter.Reader;
import infra.database.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Dantas
 */
public class UserDAOWriter{
   
    public void save(String bdName)  throws Exception {
        /* Define a SQL */
        String sql = "";
        sql += "INSERT INTO usuarios (Login, Senha) VALUES ";
        
        ArrayList<User> users = UserControl.get_array_list();
        int size = UserControl.get_array_list().size();
        int i = 0;
        
        String Login, Senha;
               
        while(i < size-1){
            User user = (User) UserControl.get_user(users.get(i).get_login());
            Login = user.get_login();
            Senha = user.get_password();
            sql += ("( '" + Login + "','" + Senha + "'),");
            i++;
        }
        
        User user = (User) UserControl.get_user(users.get(i).get_login());
        Login = user.get_login();
        Senha = user.get_password();
        sql += ("( '" + Login + "','" + Senha + "');");
            
        System.out.println(sql);
        
        try {      
            Conexao connect = new Conexao(bdName);
            Connection connection = connect.abrir();
            PreparedStatement stmt = connection.prepareStatement(sql);               
            //System.out.println("TEste2");
            stmt.execute(); //executa comando     
            stmt.close();
            connection.close();
        } catch (SQLException u) {      
            throw new RuntimeException(u);      
        }
    
    }

    public void clear_file(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}    

