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
public class Music extends Product{

    public String artista;
    public String album;
    public float duracao;
    
    public Music(String titulo, float preco, String categoria, String avaliacoes) {
        super(titulo, preco, categoria, avaliacoes);
    }

    @Override
    public String get_titulo() {
        return this.titulo;
    }

    @Override
    public float get_preco() {
        return this.preco;
    }

    @Override
    public String get_categoria() {
        return this.categoria;
    }

    @Override
    public String get_avaliacoes() {
        return this.avaliacoes;
    }

    @Override
    public String get_genero() {
        return this.genero;
    }

    @Override
    public void set_genero(String genero) {
        this.genero = genero;
    }

    @Override
    public int get_ano() {
        return this.ano;
    }

    @Override
    public void set_ano(int ano) {
        this.ano = ano;
    }
    
    
}
