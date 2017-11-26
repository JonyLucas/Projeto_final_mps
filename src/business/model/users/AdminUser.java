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
public class AdminUser extends UserBuilder {

    public AdminUser(String login, String password, String tipo) {
        super(login, password);
    }

    
    
    @Override
    public void buildLogin() {
        set_login("Admin");
    }

    @Override
    public void buildPassword() {
        set_password("admin123");
    }

    @Override
    public void buildTipo() {
        set_tipo("Usuário Normal");
    }

     
}
