/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.catalogs;

import business.model.products.Music;
import business.model.products.Product;
import java.util.ArrayList;

/**
 *
 * @author Joao
 */
public class MusicCatalog extends ProductCatalog{
    
    MusicCatalog music_catalog;
    
    private MusicCatalog(){
        super.products = new ArrayList<Product>();
    }
    
    public void add(Music music){
        super.products.add(music);
    }
    
    public void remove(Music music){
        super.products.remove(music);
    }
    
    public void show(){
        for(Product music : super.products){
            
        }
    }
}
