/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.database.reader;

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
public class UserDAOReader implements Reader{
   
    @Override
    public List<User> load(String dbName) throws Exception {
         /* Define a SQL */
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT Login, Senha ");
        sql.append("FROM usuarios ");
        
          /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
        Conexao connect = new Conexao(dbName);
        Connection conn = connect.abrir();

        /* Mapeamento objeto relacional */
        PreparedStatement comando = conn.prepareStatement(sql.toString());
        
        
         /* Executa a SQL e captura o resultado da consulta */
        ResultSet resultado = comando.executeQuery();

        /* Cria uma lista para armazenar o resultado da consulta */
        List<User> lista = new ArrayList<>();
        
        
        /* Percorre o resultado armazenando os valores em uma lista */
        while (resultado.next()) {
            /* Cria um objeto para armazenar uma linha da consulta */
            User linha = new User();
            linha.set_login(resultado.getString("Login"));
            linha.set_password(resultado.getString("Senha"));
            /* Armazena a linha lida em uma lista */
            lista.add(linha);
        }
            
        //for(User user: lista){
          //  System.out.println(user.get_info());
        //}
             /* Fecha a conexão */
            resultado.close();
            comando.close();
            conn.close();
      
        /* Retorna a lista contendo o resultado da consulta */
        return lista;
        }   
}    

