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
import javax.swing.JOptionPane;

public class CatalogControl {
    
    /**Adiciona o produto ao catalogo de produtos**/
    public static void add(Product product) throws InvalidTypeException{
        
        ProductCatalog product_catalog;
        
        /**Utiliza o padrao Strategy para definir em qual catalogo adicionar o produto**/
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
    
    /**Remove o produto do catalogo de produtos**/
    public static void remove(Product product) throws InvalidTypeException{
        ProductCatalog product_catalog;
        
        /**Padrao Strategy**/
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
    
    /**Retorna o produto de determinado catalogo e de determinado indice**/
    public static Product get(String type_of_product, int index) throws InvalidTypeException{
        
        ProductCatalog product_catalog;
        
        /**Padrao Strategy**/
        
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
    
    /**Exibe o catalago de determinados tipos de produtos**/
    public static String show(String type_of_product) throws InvalidTypeException{
        
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
        
        return product_catalog.show();
    }
    
    /**Pega o tamanho do catalogo de determinado tipo de produto**/
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
