/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.database.writer;

import business.control.CatalogControl;
import business.model.products.Books;
import infra.database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Joao
 */
public class BooksDAOWriter implements DAOWriter{
     
    
    public void save(String bdName)  throws Exception {
        
        /* Define a SQL */
        String sql = "";
        sql += "INSERT INTO produtos (Titulo, Preco, Categoria, Ano) VALUES ";
        
        int size = CatalogControl.get_size("Books");
        
        int i = 0;
        
        String title, category, author, publisher, edition, genre;
        float price;
        int year;
        int number_pages;
        //System.out.println(size);
        
        /**Insere os dados de cada produto na query**/
        while(i < size-1){
            Books product = (Books) CatalogControl.get("Books", i);
            title = product.get_title();
            price = product.get_price();
            category = product.get_category();
            year = product.get_year();
            sql += ("( '" + title + "','" + price + "','" + category + "','" + year + "'),");
            i++;
        }
        
        /**Insere os dados do ultimo produto na query, para terminar a query com ';' **/
        Books product = (Books) CatalogControl.get("Books", i);
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