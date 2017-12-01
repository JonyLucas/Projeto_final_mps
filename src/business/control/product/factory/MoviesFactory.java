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
/**Fabricador de Filmes**/
class MoviesFactory extends ProductFactory{
    
    /**Cria o filme usando a entrada padrao (System.in), no caso de nao ter sido passado os parametros necessarios para criar o objeto**/
    @Override
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
        
        return new Movies(title, price, year, duration, director, studio, genre, synopsis);
        
    }
    
    /**Cria o filme usando os argumentos fornecidos (String ... arguments)**/
    @Override
    protected Product make_type_of_product(String title, float price, int year, String... arguments) {
        
        float duration;
        try{
            duration = Float.parseFloat(arguments[0]);
        }catch(NumberFormatException e){
            duration = 0;
        }
        String director = arguments[1],
               studio = arguments[2],
               genre = arguments[3],
               synopsis = arguments[4];
        
        return new Movies(title, price, year, duration, director, studio, genre, synopsis);
        
    }
    
}
