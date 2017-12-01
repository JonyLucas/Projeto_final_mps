/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.facade;

import business.control.UserControl;
import business.model.users.User;
import business.model.exceptions.StorageException;
import business.model.products.Product;
import infra.Adpter.Reader;
import infra.Adpter.Writer;
import infra.database.DatabaseProxy;
import infra.database.writer.DAOWriter;
import infra.factory.StorageFactoryReader;
import infra.factory.StorageFactoryWriter;
import java.util.ArrayList;
import java.util.List;

/**Facade responsavel pelo armazenamento e obtencao de dados persistentes**/
public class StorageFacade{
    static Reader reader;
    static Writer writer;
    static DAOWriter daowriter; //Usado para escrever no banco de dados (MySQL)
    
    /**Carrega os usuarios de um arquivo TXT**/
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
    
    /**Salva os usuarios cadastrados em um arquivo TXT**/
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
    
    /**Salva as entidades (usuarios e produtos) especificada no banco de dados do sistema**/
    public static void save_database(String type) throws Exception{
        daowriter =  new DatabaseProxy();
        daowriter.save(type);
        
    }
    
    /**Carrega os registros de determinada entidade (type) do banco de dados**/
    public static void load_database(String type) throws Exception{
        
        reader = new DatabaseProxy();
        
        if(type.equals("User")){
            ArrayList<User> users = (ArrayList<User>) reader.load(type); //Carrega em um ArrayList os usuarios lidos no banco de dados
            for(User user : users){
                RegisterFacade.register_regular_user(user.get_login(), user.get_password()); //Registra cada um dos usuarios lidos no sistema
            }
        }else{
            ArrayList<Product> products = (ArrayList<Product>) reader.load(type);
            for(Product product : products){
                RegisterFacade.register_product(product); //Registra cada produto lido no seu respectivo catalogo
            }
        }
        
    }
}
