/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.commands;

import business.model.exceptions.InvalidLoginException;
import business.model.users.User;
import business.model.users.states.LoginState;
import business.model.users.states.LogoutState;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao
 */
public class LogoutUserCommand implements Command{
    
    private User user;
    
    public LogoutUserCommand(User user){
        this.user = user;
    }
    
    @Override
    public void execute() throws InvalidLoginException{
        if(user.get_current_state() instanceof LogoutState)
           JOptionPane.showMessageDialog(null, "The user is already logged out");
        else
            user.logout();
    }
}
