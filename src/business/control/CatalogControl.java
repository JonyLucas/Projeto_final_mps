/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

/**
 *
 * @author Joao
 */

import business.model.catalogs.BooksCatalog;
import business.model.catalogs.GamesCatalog;
import business.model.catalogs.MovieCatalog;
import business.model.catalogs.MusicCatalog;
import business.model.exceptions.InvalidTypeException;
import business.model.catalogs.ProductCatalog;
import business.model.products.*;

public class CatalogControl {
    
    public static void add(Product product) throws InvalidTypeException{
        
        ProductCatalog product_catalog;
        
        if(product instanceof Music){
            product_catalog = MusicCatalog.get_instance();
        }else if(product instanceof Movies){
            product_catalog = MovieCatalog.get_instance();
        }else if(product instanceof Games){
            product_catalog = GamesCatalog.get_instance();
        }else if(product instanceof Books){
            product_catalog = BooksCatalog.get_instance();
        }else{
            throw new InvalidTypeException();
        }
        
        product_catalog.add(product);
    }
    
    public static void remove(Product product) throws InvalidTypeException{
        ProductCatalog product_catalog;
        
        if(product instanceof Music){
            product_catalog = MusicCatalog.get_instance();
        }else if(product instanceof Movies){
            product_catalog = MovieCatalog.get_instance();
        }else if(product instanceof Games){
            product_catalog = GamesCatalog.get_instance();
        }else if(product instanceof Books){
            product_catalog = BooksCatalog.get_instance();
        }else{
            throw new InvalidTypeException();
        }
        
        product_catalog.remove(product);
    }
    
    public static Product get(String type_of_product, int index) throws InvalidTypeException{
        
        ProductCatalog product_catalog;
        
        if(type_of_product.equals("Music")){
            product_catalog = MusicCatalog.get_instance();
        }else if(type_of_product.equals("Movies")){
            product_catalog = MovieCatalog.get_instance();
        }else if(type_of_product.equals("Games")){
            product_catalog = GamesCatalog.get_instance();
        }else if(type_of_product.equals("Books")){
            product_catalog = BooksCatalog.get_instance();
        }else{
            throw new InvalidTypeException();
        }
        
        return product_catalog.get(index);
    }
    
    public static void show(String type_of_product) throws InvalidTypeException{
        
        ProductCatalog product_catalog;
        
        if(type_of_product.equals("Music")){
            product_catalog = MusicCatalog.get_instance();
        }else if(type_of_product.equals("Movies")){
            product_catalog = MovieCatalog.get_instance();
        }else if(type_of_product.equals("Games")){
            product_catalog = GamesCatalog.get_instance();
        }else if(type_of_product.equals("Books")){
            product_catalog = BooksCatalog.get_instance();
        }else{
            throw new InvalidTypeException();
        }
        
        product_catalog.show();
    }
    
    public static int get_size(String type_of_product) throws InvalidTypeException{
        
        ProductCatalog product_catalog;
        
        if(type_of_product.equals("Music")){
            product_catalog = MusicCatalog.get_instance();
        }else if(type_of_product.equals("Movies")){
            product_catalog = MovieCatalog.get_instance();
        }else if(type_of_product.equals("Games")){
            product_catalog = GamesCatalog.get_instance();
        }else if(type_of_product.equals("Books")){
            product_catalog = BooksCatalog.get_instance();
        }else{
            throw new InvalidTypeException();
        }
        
        return product_catalog.get_size();
    }
    
}
