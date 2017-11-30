/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.facade;

import business.control.UserControl;
import business.model.users.User;
import business.model.exceptions.StorageException;
import infra.Adpter.Reader;
import infra.Adpter.Writer;
import infra.database.DatabaseProxy;
import infra.database.writer.DAOWriter;
import infra.factory.StorageFactoryReader;
import infra.factory.StorageFactoryWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StorageFacade{
    static Reader reader;
    static Writer writer;
    static DAOWriter daowriter;
    
    public static void load_storage(String path){
        //Verifica se o path consiste de um arquivo
        if(path.matches(".+\\.[\\d]+"))
            reader = StorageFactoryReader.selectStorage("file");
        
        List<User> users = null;
        
        try {
            users = (List<User>) reader.load(path);
        } catch (Exception ex) {
            System.out.println("");
        }
        
        for(User user : users){
            String login = user.get_login();
            String pass = user.get_password();
            UserControl.add_user("Regular", login, pass);
        }
        
    }
    
    public static void save_storage(String path, boolean overwrite){
        if(path.matches(".+\\.[\\d]+"))
            writer = StorageFactoryWriter.selectStorage("file");
        
        List<User> users = UserControl.get_array_list();
        
        if(overwrite)
            writer.clear_file(path);
        
        for(User user : users){
            writer.save(path, user);
        }
    }
    
    public static void save_database(String type) throws Exception{
        daowriter =  new DatabaseProxy();
        daowriter.save(type);
        
    }
    
    public static void load_database(String type) throws Exception{
        reader = new DatabaseProxy();
        reader.load(type);
    }
}
