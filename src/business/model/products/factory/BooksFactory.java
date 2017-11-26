/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.products.factory;

import business.model.products.Books;
import business.model.products.Product;
import java.util.Scanner;

/**
 *
 * @author Joao
 */
class BooksFactory extends ProductFactory{
    
    protected Product make_type_of_product(String title, float price, int year){
        
        String author, publisher, edition, genre;
        int number_pages;  
        
        try(Scanner scan = new Scanner(System.in)){
            
            System.out.print("Digit the author of the Book\n\tAuthor: ");
            author = scan.nextLine();
            
            System.out.print("Digit the Book's publisher\n\tPublisher: ");
            publisher = scan.nextLine();
            
            System.out.println("Digit the Book's edition\n\tEdition: ");
            edition = scan.nextLine();
            
            System.out.println("Digit the genre of the Book\n\tGenre: ");
            genre = scan.nextLine();
            
            System.out.println("Digit the number of pages of the book\n\tGenre: ");
            number_pages = scan.nextInt();
        }
        
        return new Books(title, price, author, publisher, edition, genre, number_pages);
        
    }
}
