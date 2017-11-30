/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.database;

import business.model.exceptions.InvalidTypeException;
import business.model.products.Product;
import infra.Adpter.Reader;
import infra.database.reader.BooksDAOReader;
import infra.database.reader.GamesDAOReader;
import infra.database.reader.MoviesDAOReader;
import infra.database.reader.MusicDAOReader;
import infra.database.reader.UserDAOReader;
import infra.database.writer.BooksDAOWriter;
import infra.database.writer.DAOWriter;
import infra.database.writer.GamesDAOWriter;
import infra.database.writer.MoviesDAOWriter;
import infra.database.writer.MusicDAOWriter;
import infra.database.writer.UserDAOWriter;
import java.util.ArrayList;

/**
 *
 * @author Leonardo Dantas
 */

/**Implementa o padrão Proxy, possivel adição de segurança extra, impede que os dados do banco de dados sejam completamente apagados**/
public class DatabaseProxy implements DAOWriter, Reader{
    
    private DAOWriter db_writer;
    private Reader db_reader;
    
    @Override
    public void save(String type) throws Exception {
        
        if(type.equals("Music")){
            db_writer = new MusicDAOWriter();
        }else if(type.equals("Books")){
            db_writer = new BooksDAOWriter();
        }else if(type.equals("Games")){
            db_writer = new GamesDAOWriter();
        }else if(type.equals("Movies")){
            db_writer = new MoviesDAOWriter();
        }else if(type.equals("User")){
            db_writer = new UserDAOWriter();
        }else{
            throw new InvalidTypeException();
        }
        
        db_writer.save("digitalquestdb");

    }
    
    @Override
    public Object load(String type) throws Exception {
         
        if(type.equals("Music")){
            db_reader = new MusicDAOReader();
        }else if(type.equals("Books")){
            db_reader = new BooksDAOReader();
        }else if(type.equals("Games")){
            db_reader = new GamesDAOReader();
        }else if(type.equals("Movies")){
            db_reader = new MoviesDAOReader();
        }else if(type.equals("User")){
            db_reader = new UserDAOReader();
        }else{
            throw new InvalidTypeException();
        }
        
       return db_reader.load("digitalquestdb");
    } 
    
    
}
