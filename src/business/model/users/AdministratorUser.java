/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.users;

/**
 *
 * @author Joao
 */
/**
 * Classe usuario administrador, faz as mesma coisas que um usario comum faz, alem de poder registrar produtos.
 * A restricao de registrar produto é garantida na interface grafica (Olhar o codigo do JPanel Home)
 **/
public class AdministratorUser extends User{
    
    public AdministratorUser(String login, String password){
        super(login, password);
    }
    
}
