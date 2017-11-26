/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.catalogs;

import business.model.products.Product;
import java.util.List;

/**
 *
 * @author Joao
 */
public abstract class ProductCatalog {
    
    protected List<Product> products;
    
    public abstract void add(Product product);
    public abstract void remove(Product product);
    public abstract void show();
    public abstract void order_by(String type);
    
}
