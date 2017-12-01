/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Leonardo Dantas
 */
/**Classe para estabelecer a conexao com o MySQL**/
public class Conexao {
    private String USUARIO = "root";
    private String SENHA = "";
    private String URL = "jdbc:mysql://127.0.0.1:3306/"; //Servidor local, utilizando a porta 3306
    private String DRIVER = "com.mysql.jdbc.Driver";

    public Conexao(String bdName){
        URL += bdName; // Adiciona o nome do banco de dados na URL
    }
    
    // Conectar ao banco
    public Connection abrir() throws Exception {
        // Registrar o driver
        Class.forName(DRIVER);
        // Capturar a conexão
        Connection conn = (Connection) DriverManager.getConnection(URL, USUARIO, SENHA);
        // Retorna a conexao aberta
        return conn;


    }
}
