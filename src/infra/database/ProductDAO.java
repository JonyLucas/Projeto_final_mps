/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.database;

import business.control.product.factory.ProductBuilder;
import business.model.products.Product;
import business.model.users.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Dantas
 */
public class ProductDAO {
     
    public List<Product> buscar() throws Exception {
         /* Define a SQL */
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT Titulo, Preco, Categoria ");
        sql.append("FROM produtos ");
        
          /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
        Connection conn = Conexao.abrir();

        /* Mapeamento objeto relacional */
        PreparedStatement comando = conn.prepareStatement(sql.toString());
        
        
         /* Executa a SQL e captura o resultado da consulta */
        ResultSet resultado = comando.executeQuery();

        /* Cria uma lista para armazenar o resultado da consulta */
        List<Product> lista = new ArrayList<>();
        
        
        /* Percorre o resultado armazenando os valores em uma lista */
        while (resultado.next()) {
            /* Cria um objeto para armazenar uma linha da consulta */
            ProductBuilder linha = new ProductBuilder();
            System.out.println(resultado.getString("Titulo"));
           
           
        }
            
        for(Product produto: lista){
            System.out.println(produto.get_info());
        }
             /* Fecha a conexão */
            resultado.close();
            comando.close();
            conn.close();
      
        /* Retorna a lista contendo o resultado da consulta */
        return lista;
        }
}