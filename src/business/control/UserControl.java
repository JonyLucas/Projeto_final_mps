package business.control;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import business.model.users.User;
import business.model.exceptions.UserNotExistException;
import business.model.exceptions.LoginValidationException;
import business.model.exceptions.PasswordValidationException;
import business.model.users.AdministratorUser;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserControl {
    
    private static ArrayList<User> users = new ArrayList<User>();
    
    /**Adiciona o determinado usuario na lista de usuarios cadastrados (users) **/
    public static void add_user(String type_of_user, String login, String password){
        try{
            /**Verifica se o login ja foi usado no cadastro de outro usuario**/
            for(User user : users){
                if(login.equals(user.get_login()))
                    throw new LoginValidationException("Login já cadastrado");
            }
            Validator.validate_login(login); //Valida Login
            Validator.validate_password(password); //Valida Senha
            
            User user = null;
            
            if(type_of_user.equals("Regular")){
                user = new User(login, password); //Adiciona um usuario comum
            }else if(type_of_user.equals("Admin")){
                user = new AdministratorUser(login, password); //Adiciona um usuario administrador
            }
            
            users.add(user);
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
        }catch(LoginValidationException | PasswordValidationException lve){
            JOptionPane.showMessageDialog(null, lve.getMessage());
        }

    }
    
    /**Remove o usuario da lista de usuarios cadastrados**/
    public static void remove_user(String login) throws UserNotExistException{
        
        User user = get_user(login);
        
        if(user != null)
            users.remove(user);
        else
            throw new UserNotExistException();
        
    }
    
    public static User get_user(String login) throws UserNotExistException{
        boolean exist = false;
        int size = users.size();
        
        for(int i = 0; i < size; i++){
            User user = users.get(i);
            if(user.get_login().equals(login)){                
                return user;
            }
        }
        
        throw new UserNotExistException();
        
    }
    
    /**Efetuar o login do usuario**/
    public static void login_user(String login, String password){
        try {
            User user = get_user(login);
            user.login(login, password);
        } catch (UserNotExistException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar o login, este usuario não existe");
        }
        
    }
    
    /**Metodos usados no teste unitario **/
    public static ArrayList<User> get_array_list(){
    	return users;
    }
    
    public static void clear(){
    	users.clear();
    }
    
}
