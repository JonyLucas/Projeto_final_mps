/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.product.factory;

import business.model.products.Games;
import business.model.products.Product;
import java.util.Scanner;

/**
 *
 * @author Joao
 */
class GamesFactory extends ProductFactory{
    
    @Override
    protected Product make_type_of_product(String title, float price, int year){
        
        String description, developer, publisher, oficialSite, genre;   
        
        try(Scanner scan = new Scanner(System.in)){
            System.out.print("Digit the Game's description\n\tDescription: ");
            description = scan.nextLine();
            
            System.out.print("Digit the Game's developer\n\tDeveloper: ");
            developer = scan.nextLine();
            
            System.out.println("Digit the Games's publisher\n\tPublisher: ");
            publisher = scan.nextLine();
            
            System.out.println("Digit the genre of the Game\n\tGenre: ");
            genre = scan.nextLine();
            
            System.out.println("Digit the Game's oficial Site\n\tGenre: ");
            oficialSite = scan.nextLine();
        }
        
        return new Games(title, price, year, description, developer, publisher, genre, oficialSite);
        
    }
    
    @Override
    protected Product make_type_of_product(String title, float price, int year, String... arguments) {
        
        String description = arguments[0],
               developer = arguments[1],
               publisher = arguments[2],
               genre = arguments[3],
               oficialSite = arguments[4];
        
        return new Games(title, price, year, description, developer, publisher, genre, oficialSite);
        
    }
    
}
