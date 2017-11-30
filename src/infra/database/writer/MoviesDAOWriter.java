/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.database.writer;

import business.control.CatalogControl;
import infra.database.reader.*;
import business.control.product.factory.ProductBuilder;
import business.model.products.Movies;
import business.model.products.Product;
import business.model.users.User;
import infra.Adpter.Reader;
import infra.database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Dantas
 */
public class MoviesDAOWriter implements DAOWriter{
     
  @Override
  public void save(String bdName)  throws Exception {
        /* Define a SQL */
        String sql = "";
        sql += "INSERT INTO produtos (Titulo, Preco, Categoria, Ano) VALUES ";
        
        int size = CatalogControl.get_size("Movie");
        
        int i = 0;
        
        String title, category, director,duration, studio, synopsis, genre;
        float price;
        int year;
        
       
        System.out.println(size);
        
        while(i < size-1){
            Movies product = (Movies) CatalogControl.get("Movies", i);
            title = product.get_title();
            price = product.get_price();
            category = product.get_category();
            year = product.get_year();
            sql += ("( '" + title + "','" + price + "','" + category + "','" + year + "'),");
            i++;
        }
        
        Movies product = (Movies) CatalogControl.get("Movies", i);
        title = product.get_title();
        price = product.get_price();
        category = product.get_category();
        year = product.get_year();
        sql += ("( '" + title + "','" + price + "','" + category + "','" + year + "');");
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
  
}