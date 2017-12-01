/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.product.factory;

import business.model.products.Product;
import java.util.Scanner;

/**
 *
 * @author Joao
 */
/**Abstract Factory para produtos**/
public abstract class ProductFactory{
    
    /**Metodo para criar o produto, usando a entrada padrao (Scanner (System.in))**/
    public Product make_product(){

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
    
    /**Cria o produto do tipo especifico, usando a entrada padrao**/
    protected abstract Product make_type_of_product(String title, float price, int year);
    
    
    /**Metodo para criar o produto, usando os argumentos fornecidos**/
    public Product make_product(String ... arguments){

        Product product;
        
        String title = arguments[0];
        float price = Float.parseFloat(arguments[1]);
        int year = Integer.parseInt(arguments[2]);
        
        int size = arguments.length;
        String[] type_product_arguments = new String[size-3];
        for(int i = 3; i < size; i++){
            if(arguments[i] != null)
                type_product_arguments[i-3] = arguments[i];
            else
                type_product_arguments[i-3] = "";
        }
        
        /**Template Method**/
        product = make_type_of_product(title, price, year, type_product_arguments);
        
        return product;
    }
    
    /**Cria o produto do tipo especifico, usando os argumentos fornecidos**/
    protected abstract Product make_type_of_product(String title, float price, int year, String ... arguments);
    
    
}
