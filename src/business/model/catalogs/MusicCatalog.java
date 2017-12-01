/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.catalogs;

import business.model.products.Music;
import business.model.products.Product;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao
 */
/**Classe catalogo de Musica**/
public class MusicCatalog implements ProductCatalog{
    
    private static MusicCatalog music_catalog = null;
    private static ArrayList<Music> musics_list; //Possui uma lista de produtos cadastrados
    
    private MusicCatalog(){
        musics_list = new ArrayList<Music>();
    }
    
    /**Padrão Singleton**/
    public static synchronized MusicCatalog get_instance(){
        if(music_catalog == null){
            music_catalog = new MusicCatalog();
        }
        return music_catalog;
    }

    @Override
    public void add(Product product) {
        musics_list.add((Music) product);
        
    }

    @Override
    public void remove(Product product) {
        musics_list.remove((Music) product);
    }
    
    @Override
    public Product get(int index) {
        return musics_list.get(index);
    }
    
    @Override
    public String show(){
        String info = "";
        for(Music music : musics_list){
            info += (music.get_info());
        }
        //JOptionPane.showMessageDialog(null, info);
        return info;
    }

    @Override
    public int get_size() {
        return musics_list.size();
    }

}
