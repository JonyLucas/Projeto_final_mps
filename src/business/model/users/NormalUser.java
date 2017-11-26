/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.users;

import business.model.users.UserBuilder;

/**
 *
 * @author Dell
 */
public class NormalUser extends UserBuilder {

    public NormalUser(String login, String password, String tipo) {
        super(login, password);
    }

       
    @Override
    public void buildLogin() {
      set_login("João");
    }

    @Override
    public void buildPassword() {
        set_password("login123");
    }

    @Override
    public void buildTipo() {
       set_tipo("Usuário Comum");
    }
    
}
