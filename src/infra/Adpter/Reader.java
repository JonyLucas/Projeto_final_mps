/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.Adpter;

import business.model.users.User;
import java.util.List;

/**
 *
 * @author Joao
 */
public interface Reader {
    public abstract List<User> load(String path);
}
