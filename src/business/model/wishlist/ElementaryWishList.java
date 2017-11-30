/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.wishlist;

import business.model.products.Product;
import business.model.users.User;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Joao
 */
public class ElementaryWishList implements WishListComponent{
    
    private User owner;
    private String name;
    private ArrayList<Product> desired_products;
    
    public ElementaryWishList(User user, String name){
        owner = user;
        this.name = name;
        desired_products = new ArrayList<Product>();
    }
    
    public ElementaryWishList(User user){
        this(user, "Unnamed wishlist");
    }
    
    @Override
    public User get_owner() { return this.owner; }
    
    @Override
    public String get_name() { return this.name; }

    @Override
    public void set_name(String newListName) { this.name = newListName; }
    
    
    @Override
    public void add(Product product) { desired_products.add(product); }

    @Override
    public void remove(Product product) { desired_products.remove(product); }
    
    @Override
    public String show_whishlist() {
        String message = ("--- WishList's name: " + this.get_name() + " ---");
        message += ("\t\tDesired products: ");
        
        for(Product product : desired_products){
            message += "\t" + product.get_info();
        }
        
        return message;
    } 
    
}
