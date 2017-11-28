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
            System.out.println("Erro: the user it is not logged");

            System.out.println("Digit your password");
            try (Scanner scan = new Scanner(System.in)) {
                String inserted_pass = scan.next();
                user.login(login, inserted_pass);
            }
        }
    }
    
}
