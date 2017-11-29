/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.commands;

import business.model.exceptions.InvalidTypeException;
import business.model.memento.Caretaker;
import business.model.memento.Memento;
import business.model.users.User;
import business.model.wishlist.WishListComponent;

/**
 *
 * @author Joao
 */
public class UndoCommand implements Command {

    private Memento memento;
    private WishListComponent wishlist;
    
    @Override
    public void execute() {
        Caretaker caretaker = Caretaker.get_instance();
        memento = caretaker.get_lastest_memento();
        wishlist = memento.get_saved_wishlist();
        User owner = wishlist.get_owner();
        owner.set_wishlist(wishlist);
    }
    
}
