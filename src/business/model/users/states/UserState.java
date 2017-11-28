/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.users.states;

/**
 *
 * @author Joao
 */

/**Uso do padrão State**/
public interface UserState {
    public void login(String login, String password);
    public void logout();
}
