/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.Adpter;

import business.model.User;

/**
 *
 * @author Joao
 */
public interface Writer {
    public void save(String path, User user);
    public void clear_file(String path);
}
