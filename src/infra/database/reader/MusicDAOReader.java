/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.database.reader;

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
public class MusicDAOReader implements Reader {
     
    @Override
    public List<Product> load(String dbName) throws Exception {
        /* Define a SQL */
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * ");
        sql.append("FROM produtos INNER JOIN musicas ON produtos.idProdutos = musicas.Produtos_idProdutos");
        
        /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
        Conexao connect = new Conexao(dbName);
        Connection conn = connect.abrir();

        /* Mapeamento objeto relacional */
        PreparedStatement comando = conn.prepareStatement(sql.toString());
        
        /* Executa a SQL e captura o resultado da consulta */
        ResultSet resultado = comando.executeQuery();
        
        ProductBuilder pb = new ProductBuilder();

        /* Cria uma lista para armazenar o resultado da consulta */
        List<Product> musics = new ArrayList<Product>();  
        String[] arguments = new String[7];
        
        /* Percorre o resultado armazenando os valores em uma lista */
        while (resultado.next()) {
           /* Cria um objeto para armazenar uma linha da consulta */
           arguments[0] = resultado.getString("Titulo");
           arguments[1] = resultado.getString("Preco");
           arguments[2] = resultado.getString("Ano");
           arguments[3] = resultado.getString("Artista");
           arguments[4] = resultado.getString("Genero");
           arguments[5] = resultado.getString("Album");
           arguments[6] = resultado.getString("Duracao");
           
           musics.add(pb.order_product("Music", arguments));
           
        }
        
        for(Product product : musics){
            System.out.println(product.get_info());
        }
        
        /* Fecha a conexão */
         resultado.close();
         comando.close();
         conn.close();
      
        /* Retorna a lista contendo o resultado da consulta */
        return musics;
    }
}