package business.control;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import business.model.users.User;
import business.model.exceptions.UserNotExistException;
import business.model.exceptions.LoginValidationException;
import business.model.exceptions.PasswordValidationException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserControl {
    
    private static ArrayList<User> users = new ArrayList<User>();
    
    public static void add_user(String login, String password){
        try{
            Validator.validate_login(login);
            Validator.validate_password(password);
            User user = new User(login, password);
            users.add(user);
        }catch(LoginValidationException | PasswordValidationException lve){
            JOptionPane.showMessageDialog(null, lve.getMessage());
        }

    }
    
    public static void remove_user(String login) throws UserNotExistException{
        boolean exist = false;
        
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
        
        return null;
        
    }
    
    public static void login_user(String login, String password){
        try {
            User user = get_user(login);
            user.login(login, password);
        } catch (UserNotExistException ex) {
            System.out.println("Não foi possivel realizar o login, este usuario não existe");
        }
        
    }
    
    /**Metodos usados no teste unitario
     * @return o**/
    public static ArrayList<User> get_array_list(){
    	return users;
    }
    
    public static void clear(){
    	users.clear();
    }
    
}
