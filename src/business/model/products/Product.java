/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.products;

/**
 *
 * @author Joao
 */
public abstract class Product{
    
    private String title;
    private float price;
    private String category;
    private String score = "n/a";
    private int year;
    
    public Product(String titulo, float preco, String categoria, int year){
        this.title = titulo;
        this.price = preco;
        this.category = categoria;
        this.year = year;
    }
    
    public String get_info(){
        String describe = "\nProduct description\n" + 
                          "\tTitulo: " + get_title() + "\n" +
                          "\tPreço: " + get_price() + "\n" + 
                          "\tcategoria: " + get_category() + "\n" +
                          "\tAno: " + get_year() + "\n" +
                          "\tAvaliações: " + get_score() + "\n";

        return describe;
    }

    public String get_title() { return this.title; }

    public float get_price() { return this.price; }

    public String get_category() { return this.category; }

    public String get_score() { return this.score; }    

    public int get_year() { return this.year; }
    
    public void set_year(int ano) { this.year = ano; }
    
    public void set_titulo(String titulo){ this.title = titulo; }
    
    public void set_preco(float preco){ this.price = preco; }
    
    public void set_avaliacoes(String avaliacoes){ this.score = avaliacoes; }
    
}
