package business.control;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import business.model.User;
import business.model.exceptions.UserNotExistException;
import business.model.exceptions.LoginValidationException;
import business.model.exceptions.PasswordValidationException;


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
        int size = users.size();
        
        for(int i = 0; i < size; i++){
            User user = users.get(i);
            if(user.get_login().equals(login)){
                users.remove(user);
                exist = true;
                i--;
                size = users.size();
            }
        }
        
        if(!exist)
            throw new UserNotExistException();
        
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
