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

/**Esta classe implementa o padrão composite**/
public class WishListComposite implements WishListComponent{

    private String name;
    private ArrayList <WishListComponent> components;
    private ArrayList <Product> desired_products;
    
    public WishListComposite(String name){
        this.name = name;
        components = new ArrayList<WishListComponent>();
        desired_products = new ArrayList<Product>();
    }
    
    public WishListComposite(){
        this("Unnamed Wishlist");
    }
    
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
    public void show_whishlist() {
        
        System.out.println("--- WishList's name: " + this.get_name() + " ---");
        System.out.println("\t\tDesired products: ");
        
        for(Product product : desired_products){
            System.out.println("\t" + product.get_info());
        }
        
        System.out.println("\t--- Sub wishlists ---");
        
        for(WishListComponent comp : components){
            comp.show_whishlist();
        }
        
        System.out.println("---------------------");
    }
    
}
