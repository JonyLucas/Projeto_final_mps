/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.product.factory;

import business.model.products.Movies;
import business.model.products.Product;
import java.util.Scanner;

/**
 *
 * @author Joao
 */
class MoviesFactory extends ProductFactory{
    
    protected Product make_type_of_product(String title, float price, int year){
        
    
        String director, studio, synopsis, genre;
        float duration;    
        
        try(Scanner scan = new Scanner(System.in)){
            System.out.print("Digit the movie director\n\tDirector: ");
            director = scan.nextLine();
            
            System.out.print("Digit the studio of the movie\n\tStudio: ");
            studio = scan.nextLine();
            
            System.out.println("Digit the synopsis of the movie\n\tSynopsis: ");
            synopsis = scan.nextLine();
            
            System.out.println("Digit the genre of the movie\n\tSynopsis: ");
            genre = scan.nextLine();
            
            System.out.println("Digit the duration (in minutes) of the movie\n\tDuration: ");
            duration = scan.nextFloat();
        }
        
        return new Movies(title, price, duration, director, studio, genre, synopsis);
        
    }
    
}
