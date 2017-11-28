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

public interface WishListComponent {
    
    public String get_name();
    public void set_name(String newListName);
    public void add(Product product);
    public void remove(Product product);
    public void show_whishlist();
    
}
