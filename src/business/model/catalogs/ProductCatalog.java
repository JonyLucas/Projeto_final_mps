/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.catalogs;

import business.model.products.Product;

/**
 *
 * @author Joao
 */
public interface ProductCatalog {
    
    public abstract void add(Product product);
    public abstract void remove(Product product);
    public abstract Product get(int index);
    public abstract String show();
    public abstract int get_size();
    //public abstract void order_by(String type);
    
}
