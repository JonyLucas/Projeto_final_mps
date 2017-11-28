/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.memento;

import business.model.wishlist.WishListComponent;

/**
 *
 * @author Joao
 */
public class Memento {
    
    private WishListComponent wlc;
    
    public Memento(WishListComponent component){
        wlc = component;
    }
    
    public WishListComponent get_saved_wishlist(){
        return this.wlc;
    }
    
}
