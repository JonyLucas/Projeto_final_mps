/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.users.states;

import business.model.users.User;

/**
 *
 * @author Joao
 */
public class LoginState implements UserState{

    private User user;
    
    public LoginState(User user){
        this.user = user;
    }
    
    @Override
    public void login(String login, String password) {
        System.out.println("You're already logged");
    }

    @Override
    public void logout() {
        System.out.println("You're now logged out");
        user.set_state(user.get_logout_state());
    }
    
}
