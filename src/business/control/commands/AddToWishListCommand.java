/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.commands;

import business.model.exceptions.InvalidTypeException;
import business.model.products.Product;
import business.model.wishlist.*;

/**
 *
 * @author Joao
 */

/**Interface Command -- Implementação**/
public class AddToWishListCommand implements Command{
    
    private WishListComponent wishlist;
    private Object obj;
    
    public AddToWishListCommand(WishListComponent component, Object obj_to_add){
        wishlist = component;
        obj = obj_to_add;
    }
    
    @Override
    public void execute() throws InvalidTypeException{
        
        if(obj instanceof WishListComponent){
            WishListComposite wlc = (WishListComposite) wishlist;
            wlc.add((WishListComponent) obj);
        }else if(obj instanceof Product){
            wishlist.add((Product) obj);
        }else{
            throw new InvalidTypeException("Erro: invalid type of object");
        }
        
    }
    
}
