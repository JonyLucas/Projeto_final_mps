/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.wishlist;

import business.model.products.Product;
import java.util.ArrayList;
/**
 *
 * @author Joao
 */
public class ElementaryWishList implements WishListComponent{
    
    private String name;
    private ArrayList<Product> desired_products;
    
    public ElementaryWishList(String name){
        this.name = name;
        desired_products = new ArrayList<Product>();
    }
    
    public ElementaryWishList(){
        this("Unnamed wishlist");
    }
    
    @Override
    public String get_name() { return this.name; }

    @Override
    public void set_name(String newListName) { this.name = newListName; }
    
    
    @Override
    public void add(Product product) { desired_products.add(product); }

    @Override
    public void remove(Product product) { desired_products.remove(product); }

    @Override
    public void show_whishlist() {
        
        System.out.println("--- WishList's name: " + this.get_name() + " ---");
        System.out.println("\t\tDesired products: ");
        
        for(Product product : desired_products){
            System.out.println("\t" + product.get_info());
        }
        
    }    
    
}
