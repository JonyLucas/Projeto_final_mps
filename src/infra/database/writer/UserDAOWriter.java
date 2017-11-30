/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.database.writer;

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
                  
        int i = 0;
        
        String Login, Senha;
             
       
       
        
        //while(i < size-1){
            User user = (User) UserControl.get_user("Movies", 0);
            title = product.get_title();
            price = product.get_price();
            category = product.get_category();
            year = product.get_year();
            sql += ("( '" + title + "','" + price + "','" + category + "','" + year + "');");
        //}
        
        System.out.println(sql);
        
        try {      
            Conexao connect = new Conexao(bdName);
            Connection connection = connect.abrir();
            PreparedStatement stmt = connection.prepareStatement(sql);               
            System.out.println("TEste2");
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

