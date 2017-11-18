package infra.adaptee;

import infra.Adpter.Reader;
import business.control.UserControl;
import business.model.exceptions.StorageException;
import business.model.users.User;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**Esta classe faz um Adapter para BufferedReader**/
public class StorageReader implements Reader{
    private static FileReader fin;
    private static StorageReader sr = null;
    
    private StorageReader(){}
    
    public static synchronized StorageReader get_instance(){
        if(sr == null){
            sr = new StorageReader();
        }
        
        return sr;
    }
    
    public List<User> load(String path){
        BufferedReader bf;
        String line, login, password;
        String[] tokens;
        ArrayList<User> users = new ArrayList<User>();
        
        try {
            fin = new FileReader(path);
            bf = new BufferedReader(fin);
            
            while(bf.ready()){
                line = bf.readLine();
                //System.out.println(line);
                tokens = line.split(",");
                login = tokens[0];
                password = tokens[1];
                users.add(new User(login, password));
            }            
            bf.close();
            fin.close();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo nao encontrado");
        } catch (IOException ex) {
            throw new StorageException();
        }        
        return users;
        
    }
}
