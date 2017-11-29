/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.database;

import infra.Adpter.Writer;

/**
 *
 * @author Joao
 */

/**Implementa o padrão Proxy, possivel adição de segurança extra, impede que os dados do banco de dados sejam completamente apagados**/
public class DatabaseProxyWriter {
    
    private Writer db_writer;
    
}
