/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.catalogs;

import business.model.products.Books;
import business.model.products.Product;
import java.util.ArrayList;

/**
 *
 * @author Joao
 */
public class BooksCatalog implements ProductCatalog{
    
        
    private static BooksCatalog books_catalog = null;
    private static ArrayList<Books> books_list;
    
    private BooksCatalog(){
        books_list = new ArrayList<Books>();
    }
    
    /**Padrão Singleton**/
    public static synchronized BooksCatalog get_instance(){
        if(books_catalog == null){
            books_catalog = new BooksCatalog();
        }
        return books_catalog;
    }

    @Override
    public void add(Product product) {
        books_list.add((Books) product);
        
    }

    @Override
    public void remove(Product product) {
        books_list.remove((Books) product);
    }
    
    @Override
    public Product get(int index) {
        return books_list.get(index);
    }
    
    @Override
    public void show(){
        for(Books book : books_list){
            System.out.println(book.get_info());
        }
    }
    
    @Override
    public int get_size() {
        return books_list.size();
    }
    
    
}
