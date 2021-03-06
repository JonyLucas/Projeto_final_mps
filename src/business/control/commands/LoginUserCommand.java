/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.commands;

import business.control.UserControl;
import business.model.exceptions.InvalidLoginException;
import business.model.exceptions.InvalidTypeException;
import business.model.users.User;
import business.model.users.states.LogoutState;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao
 */
public class LoginUserCommand implements Command {

    private User user;
    private String login, password;
    
    public LoginUserCommand(User user, String login){
        this.user = user;
        this.login = login;
    }
    
    @Override
    public void execute() throws InvalidLoginException{
        if(user.get_current_state() instanceof LogoutState){
            JOptionPane.showMessageDialog(null, "Erro: the user it is not logged");

            String inserted_pass = JOptionPane.showInputDialog("Digit your password");
            user.login(login, inserted_pass);
        }
    }
    
}
