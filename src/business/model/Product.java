/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model;

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
    
    //Modificar
    public String get_info(){
        String describe;
        
        
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
    public abstract String avaliacoes();
    
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
