/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.users.states;

import business.model.users.User;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao
 */
public class LogoutState implements UserState{

    private User user;
    
    public LogoutState(User user){
        this.user = user;
    }
    
    @Override
    public void login(String login, String password) {
        JOptionPane.showMessageDialog(null, "You're logged in your account");
        user.set_state(user.get_login_state());
    }

    @Override
    public void logout() {
        JOptionPane.showMessageDialog(null, "You're already logged out");
    }
    
}
