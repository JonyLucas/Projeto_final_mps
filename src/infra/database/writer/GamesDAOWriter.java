/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.database.writer;

import business.control.CatalogControl;
import business.model.products.Games;
import infra.database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Joao
 */
public class GamesDAOWriter implements DAOWriter{
     
   
    @Override
    public void save(String bdName)  throws Exception {
        /* Define a SQL */
        String sql = "";
        sql += "INSERT INTO produtos (Titulo, Preco, Categoria, Ano) VALUES ";
        
        int size = CatalogControl.get_size("Games");
        
        int i = 0;
        
        String title, category, description, developer, publisher, genre, site_oficial;
        float price;
        int year;
        
        //System.out.println(size);
        
        /**Insere os dados dos produtos na query**/
        while(i < size-1){
            Games product = (Games) CatalogControl.get("Games", i);
            title = product.get_title();
            price = product.get_price();
            category = product.get_category();
            year = product.get_year();
            sql += ("( '" + title + "','" + price + "','" + category + "','" + year + "'),");
            i++;
        }
        
        /**Insere os dados do ultimo produto na query, para terminar a query com ';' **/
        Games product = (Games) CatalogControl.get("Games", i);
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