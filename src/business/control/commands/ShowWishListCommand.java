/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.commands;

import business.model.exceptions.InvalidTypeException;
import business.model.products.Product;
import business.model.wishlist.WishListComponent;
import business.model.wishlist.WishListComposite;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao
 */

/**Interface Command -- Implementação**/
public class ShowWishListCommand implements Command{
    
    private WishListComponent wishlist;
    
    public ShowWishListCommand(WishListComponent component){
        wishlist = component;
    }
    
    @Override
    public void execute(){
       String message = wishlist.show_whishlist();
       JOptionPane.showMessageDialog(null, message);
    }
}
