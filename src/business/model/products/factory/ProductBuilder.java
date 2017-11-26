/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.products.factory;

/**
 *
 * @author Joao
 */

import business.model.exceptions.FactoryException;
import business.model.products.Product;

/**Abstract Factory para produtos**/
public abstract class ProductBuilder {
    
    ProductFactory product_factory;
    
    public Product order_product(String type_of_product){
        
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
            throw new FactoryException("Erro: tipo inválido de produto");
        }
        
        product = product_factory.make_product();
        
        return product;
        
    }
}
