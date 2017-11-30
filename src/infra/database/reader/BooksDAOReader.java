/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.database.reader;

import business.control.facade.RegisterFacade;
import business.control.product.factory.ProductBuilder;
import business.model.products.Product;
import business.model.users.User;
import infra.Adpter.Reader;
import infra.database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Joao
 */
public class BooksDAOReader implements Reader{
     
    @Override
    public List<Product> load(String bdName) throws Exception {
        /* Define a SQL */
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * ");
        sql.append("FROM produtos INNER JOIN livros ON produtos.idProdutos = livros.Produtos_idProdutos");
        
        /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
        Conexao connect = new Conexao(bdName);
        Connection conn = connect.abrir();

        /* Mapeamento objeto relacional */
        PreparedStatement comando = conn.prepareStatement(sql.toString());
        
        /* Executa a SQL e captura o resultado da consulta */
        ResultSet resultado = comando.executeQuery();
        
        ProductBuilder pb = new ProductBuilder();

        /* Cria uma lista para armazenar o resultado da consulta */
        List<Product> books = new ArrayList<Product>();  
        String[] arguments = new String[8];
        
        /* Percorre o resultado armazenando os valores em uma lista */
        while (resultado.next()) {
           /* Cria um objeto para armazenar uma linha da consulta */
           arguments[0] = resultado.getString("Titulo");
           arguments[1] = resultado.getString("Preco");
           arguments[2] = resultado.getString("Ano");
           arguments[3] = resultado.getString("Autor");
           arguments[4] = resultado.getString("Editora");
           arguments[5] = resultado.getString("Edicao");
           arguments[6] = resultado.getString("Genero");
           arguments[7] = resultado.getString("Num_pag");
           
           books.add(pb.order_product("Books", arguments));
           
        }
        
        for(Product product : books){
            RegisterFacade.register_product(product);
        }
        
        
        /* Fecha a conexão */
         resultado.close();
         comando.close();
         conn.close();
      
        /* Retorna a lista contendo o resultado da consulta */
        return books;
    }
}