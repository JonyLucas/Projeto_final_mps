package infra.adaptee;

import infra.Adpter.Writer;
import business.model.exceptions.StorageException;
import business.model.User;

import java.io.FileWriter;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**Esta classe faz um Adapter para FileWriter**/
public class StorageWriter implements Writer{
    
    private static FileWriter fout = null;
    private static StorageWriter sw = null;
    
    private StorageWriter(){}
    
    public static synchronized StorageWriter get_instance(){
        if(sw == null){
            sw = new StorageWriter();
        }
        return sw;
    }
    
    public void save(String path, User user){
        try {
            fout = new FileWriter(path, true);
            fout.write(user.get_login() + ",");
            fout.write(user.get_password() + "\n");
            fout.close();
        } catch (IOException ex) {
            Logger.getLogger(StorageWriter.class.getName()).log(Level.SEVERE, null, ex);
            throw new StorageException();
        }
    }
    
    public void clear_file(String path){
        try {
            fout = new FileWriter(path);
            fout.write("");
            fout.close();
        } catch (IOException ex) {
            throw new StorageException();
        }
    }
}
