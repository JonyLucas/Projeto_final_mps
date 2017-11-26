/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.products.factory;

import business.model.exceptions.FactoryException;
import business.model.products.Product;
import java.util.Scanner;

/**
 *
 * @author Joao
 */
public abstract class ProductFactory{
    
    public Product make_product() throws FactoryException{

        Product product;
        
        String title;
        float price;
        int year;
        
        try (Scanner scan = new Scanner(System.in)) {
            
            System.out.print("Digit the title of the product\n\tTitle: ");
            title = scan.nextLine();
            
            System.out.print("Digit the price of the product\n\tPrice: ");
            price = scan.nextFloat();
            
            System.out.println("Digit the year of the product");
            year = scan.nextInt();
        
        }
        
        /**Template Method**/
        product = make_type_of_product(title, price, year);
        
        return product;
    }
    
    /**Cria o produto do tipo especifico**/
    protected abstract Product make_type_of_product(String title, float price, int year);
}
