/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.wishlist;

import business.model.memento.Memento;
import business.model.products.Product;
import business.model.users.User;
import java.util.ArrayList;

/**
 *
 * @author Joao
 */

/**Esta classe implementa o padrão composite**/
public class WishListComposite implements WishListComponent{

    private User owner;
    private String name;
    private ArrayList <WishListComponent> components; // Padrao Composite
    private ArrayList <Product> desired_products;
    
    public WishListComposite(User user, String name){
        this.owner = user;
        this.name = name;
        components = new ArrayList<WishListComponent>();
        desired_products = new ArrayList<Product>();
    }
    
    public WishListComposite(User user){
        this(user, "Unnamed Wishlist");
    }
    
    @Override
    public User get_owner() { return this.owner; }
    
    @Override
    public String get_name() { return this.name; }

    @Override
    public void set_name(String newListName) { this.name = newListName; }
    
    @Override
    public void add(Product product){ this.desired_products.add(product); }
    
    public void add(WishListComponent component) { this.components.add(component); }

    @Override
    public void remove(Product product) { this.desired_products.remove(product); }
    
    public void delete(WishListComponent component){ this.components.remove(component); }
    
    @Override
    public String show_whishlist() {
        
        String message = ("--- WishList's name: " + this.get_name() + " ---");
        message += ("\t\tDesired products: ");
        
        for(Product product : desired_products){
            message += "\t" + product.get_info();
        }
        
        message += ("\t--- Sub wishlists ---");
        
        for(WishListComponent comp : components){
            message += "\t" + comp.show_whishlist();
        }
        
        message += ("---------------------");
        
        return message;
    }
    
}
