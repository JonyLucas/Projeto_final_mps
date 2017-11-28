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

/**
 *
 * @author Joao
 */

/**Interface Command -- Implementação**/
public class RemoveFromWishListCommand implements Command{
    
    private WishListComponent wishlist;
    private Object obj;
    
    public RemoveFromWishListCommand(WishListComponent component, Object obj_to_remove){
        wishlist = component;
        obj = obj_to_remove;
    }
    
    @Override
    public void execute() throws InvalidTypeException{
        
        if(obj instanceof WishListComponent){
            WishListComposite wlc = (WishListComposite) wishlist;
            wlc.delete((WishListComponent) obj);
        }else if(obj instanceof Product){
            wishlist.remove((Product) obj);
        }else{
            throw new InvalidTypeException("Erro: invalid type of object");
        }
        
    }
}
