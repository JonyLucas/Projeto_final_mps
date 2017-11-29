/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.catalogs;

import business.model.products.Movies;
import business.model.products.Product;
import java.util.ArrayList;

/**
 *
 * @author Joao
 */
public class MovieCatalog implements ProductCatalog{
    
    private static MovieCatalog movie_catalog = null;
    private static ArrayList<Movies> movies_list;
    
    private MovieCatalog(){
        movies_list = new ArrayList<Movies>();
    }
    
    /**Padrão Singleton**/
    public static synchronized MovieCatalog get_instance(){
        if(movie_catalog == null){
            movie_catalog = new MovieCatalog();
        }
        return movie_catalog;
    }

    @Override
    public void add(Product product) {
        movies_list.add((Movies) product);
        
    }

    @Override
    public void remove(Product product) {
        movies_list.remove((Movies) product);
    }
    
    @Override
    public Product get(int index) {
        return movies_list.get(index);
    }
    
    @Override
    public void show(){
        for(Movies movie : movies_list){
            System.out.println(movie.get_info());
        }
    }
    
    @Override
    public int get_size() {
        return movies_list.size();
    }
    
}
