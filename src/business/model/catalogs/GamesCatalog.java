/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.catalogs;

import business.model.products.Games;
import business.model.products.Product;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao
 */
/**Classe catalogo de Games**/
public class GamesCatalog implements ProductCatalog{
    
    private static GamesCatalog games_catalog = null;
    private static ArrayList<Games> games_list; //Possui uma lista de produtos cadastrados
    
    private GamesCatalog(){
        games_list = new ArrayList<Games>();
    }
    
    /**Padrão Singleton**/
    public static synchronized GamesCatalog get_instance(){
        if(games_catalog == null){
            games_catalog = new GamesCatalog();
        }
        return games_catalog;
    }

    @Override
    public void add(Product product) {
        games_list.add((Games) product);
        
    }
    
    @Override
    public Product get(int index) {
        return games_list.get(index);
    }

    @Override
    public void remove(Product product) {
        games_list.remove((Games) product);
    }
    
    @Override
    public String show(){
        String info = "";
        for(Games game : games_list){
            info += (game.get_info());
        }
        //JOptionPane.showMessageDialog(null, info);
        return info;
    }
    
    @Override
    public int get_size() {
        return games_list.size();
    }
    
}
