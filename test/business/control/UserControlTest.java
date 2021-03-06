/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.users.User;
import business.model.exceptions.UserNotExistException;
import infra.adaptee.StorageReader;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joao
 */
public class UserControlTest {
    
    private ArrayList<User> collection;
    
    public UserControlTest() {
        collection = new ArrayList<User>();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        collection = new ArrayList<User>();
    }
    
    @After
    public void tearDown() {
        collection.clear();
        UserControl.clear();
    }

    /**
     * Test of add_user method, of class UserControl.
     */
    @Test
    public void testAdd_user_String_String() {
        System.out.println("add_user");
        
        String login_valido = "Joao Lucas", 
               login_valido2 = "Alexandre", 
               login_valido3 = "LeonardoLuiz";
        
        String password_valido = "H3LL0W0RLD", 
               password_valido2 = "H3110W0R1D", 
               password_valido3 = "OLAMUNDO123";
        
        
        User user1 = new User(login_valido, password_valido), 
             user2 = new User(login_valido2, password_valido2),
             user3 = new User(login_valido3, password_valido3);
        
        collection.add(user1);
        collection.add(user2);
        collection.add(user3);
        
        UserControl.add_user("Regular", login_valido, password_valido);
        UserControl.add_user("Regular", login_valido2, password_valido2);
        UserControl.add_user("Regular", login_valido3, password_valido3);
        
        ArrayList<User> uc_users = UserControl.get_array_list();
        
        for(int i = 0; i < collection.size(); i++){
            String login1 = collection.get(i).get_login(),
                   login2 = uc_users.get(i).get_login();
            String senha1 = collection.get(i).get_password(),
                   senha2 = uc_users.get(i).get_password();
            
            if(!login1.equals(login2) || !senha1.equals(senha2))
                fail("Ocorreu uma falha na logica de adicao de usuario");
        }

    }

    /**
     * Test of remove_user method, of class UserControl.
     */
    @Test
    public void testRemove_user() throws Exception {
        System.out.println("remove_user");
        
        String login_valido = "Joao Lucas", 
               login_valido2 = "Alexandre", 
               login_valido3 = "LeonardoLuiz";
        
        String password_valido = "H3LL0W0RLD", 
               password_valido2 = "H3110W0R1D", 
               password_valido3 = "OLAMUNDO123";
        
        
        User user1 = new User(login_valido, password_valido),
             user2 = new User(login_valido2, password_valido2),
             user3 = new User(login_valido3, password_valido3);
        
        collection.add(user1);
        collection.add(user3);
        
        UserControl.add_user("Regular", login_valido, password_valido);
        UserControl.add_user("Regular", login_valido2, password_valido2);
        UserControl.add_user("Regular", login_valido3, password_valido3);
        
        try{
            UserControl.remove_user(user2.get_login());
            
            ArrayList<User> uc_users = UserControl.get_array_list();
            
            for(int i = 0; i < collection.size(); i++){
            String login1 = collection.get(i).get_login(),
                   login2 = uc_users.get(i).get_login();
            String senha1 = collection.get(i).get_password(),
                   senha2 = uc_users.get(i).get_password();
            
            if(!login1.equals(login2) || !senha1.equals(senha2))
                fail("Ocorreu uma falha na logica de remocao de usuario");
        }
            
        }catch(UserNotExistException unee){
            fail("Ocorreu uma falha na remocao de usuario");
        }
        
        try{
            UserControl.remove_user("inexistente");
        }catch(UserNotExistException unee){
            //Tudo certo
        }
        
    }

}
