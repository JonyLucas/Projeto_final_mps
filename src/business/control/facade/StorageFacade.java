/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.facade;

import business.control.UserControl;
import business.model.User;
import business.model.exceptions.StorageException;
import infra.Adpter.Reader;
import infra.Adpter.Writer;
import infra.factory.StorageFactoryReader;
import infra.factory.StorageFactoryWriter;
import java.util.List;

public class StorageFacade{
    static Reader reader;
    static Writer writer;
    
    public static void load_storage(String path){
        //Verifica se o path consiste de um arquivo
        if(path.matches(".+\\.[\\d]+"))
            reader = StorageFactoryReader.selectStorage("file");
        
        List<User> users = reader.load(path);
        
        for(User user : users){
            String login = user.get_login();
            String pass = user.get_password();
            UserControl.add_user(login, pass);
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
}
