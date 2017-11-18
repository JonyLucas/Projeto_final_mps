/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model.products;

import business.model.interfaces.Entity;

/**
 *
 * @author Joao
 */
public abstract class Product implements Entity{
    
    public String titulo;
    public float preco;
    public String categoria;
    public String avaliacoes;
    public String genero;
    public int ano;
    
    //Modificar
    public String get_info(){
        String describe = "Titulo: " + get_titulo() + "\n" +
                          "Preço: " + get_preco() + "\n" + 
                          "categoria: " + get_categoria() + "\n" +
                          "Avaliações: " + get_avaliacoes();

        return describe;
    }
    
     public Product(String titulo, float preco, String categoria, String avaliacoes){
        this.titulo = titulo;
        this.preco = preco;
        this.categoria = categoria;
        this.avaliacoes = avaliacoes;
    }
    
    public abstract String get_titulo();
    public abstract float get_preco();
    public abstract String get_categoria();
    public abstract String get_avaliacoes();
    public abstract String get_genero();
    public abstract void set_genero(String genero);
    public abstract int get_ano();
    public abstract void set_ano(int ano);
    
    
    public void set_titulo(String titulo){
        this.titulo = titulo;
    }
    
     public void set_preco(float preco){
        this.preco = preco;
    }
     
    public void set_categoria(String categoria){
        this.categoria = categoria;
    }
    
    public void set_avaliacoes(String avaliacoes){
        this.avaliacoes = avaliacoes;
    }

    
    
}
