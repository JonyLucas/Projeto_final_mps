/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.products.factory;

import business.model.products.Product;
import business.model.products.Music;
import java.util.Scanner;

/**
 *
 * @author Joao
 */
class MusicFactory extends ProductFactory{
    
    protected Product make_type_of_product(String title, float price, int year){
        
        String genre, artist, album;
        float duration;
        
        try(Scanner scan = new Scanner(System.in)){
            System.out.print("Digit the music genre\n\tGenre: ");
            genre = scan.nextLine();
            
            System.out.print("Digit the artist of the music\n\tArtist: ");
            artist = scan.nextLine();
            
            System.out.println("Digit the album of the music\n\tAlbum: ");
            album = scan.nextLine();
            
            System.out.println("Digit the album of the music\n\tAlbum: ");
            duration = scan.nextFloat();
        }

        return new Music(title, price, artist, genre, album, duration);
        
    }
            
}
