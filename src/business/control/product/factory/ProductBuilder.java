/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.product.factory;

/**
 *
 * @author Joao
 */

import business.model.exceptions.InvalidTypeException;
import business.model.products.Product;

/**Abstract Factory para produtos**/
public class ProductBuilder {
    
    ProductFactory product_factory;

    
    public Product order_product(String type_of_product, String ... arguments) throws InvalidTypeException{
        
        Product product;
        
        /**Padrao Strategy**/
        if(type_of_product.equals("Music")){
            product_factory = new MusicFactory();
        }else if(type_of_product.equals("Books")){
            product_factory = new BooksFactory();
        }else if(type_of_product.equals("Games")){
            product_factory = new GamesFactory();
        }else if(type_of_product.equals("Movies")){
            product_factory = new MoviesFactory();
        }else{
            throw new InvalidTypeException();
        }
        
        if(arguments.length == 0)
            product = product_factory.make_product();
        else
            product = product_factory.make_product(arguments);
        
        return product;
        
    }
}
