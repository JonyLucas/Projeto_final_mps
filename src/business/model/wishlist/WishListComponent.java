/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.wishlist;

/**
 *
 * @author Joao
 */

import business.model.products.*;
import business.model.users.User;

public interface WishListComponent {
    
    public User get_owner();
    public String get_name();
    public void set_name(String newListName);
    public void add(Product product);
    public void remove(Product product);
    public String show_whishlist();
    
}
