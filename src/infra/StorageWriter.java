package infra;

import business.model.StorageException;
import business.model.User;

import java.io.FileWriter;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**Esta classe faz um Adapter para FileWriter**/
public class StorageWriter implements Writer{
    
    private FileWriter fout = null;
    
    public StorageWriter(String path){
        try {
            fout = new FileWriter(path);
        } catch (IOException ex) {
            System.out.println("Erro de entrada");
        }
    }
    
    public void save(User user){
        try {
            fout.write(user.get_login() + ",");
            fout.write(user.get_password() + "\n");
            fout.close();
        } catch (IOException ex) {
            Logger.getLogger(StorageWriter.class.getName()).log(Level.SEVERE, null, ex);
            throw new StorageException();
        }
    }
    
    public void clear_file(){
        try {
            
            fout.write("");
            fout.close();
        } catch (IOException ex) {
            throw new StorageException();
        }
    }
}
