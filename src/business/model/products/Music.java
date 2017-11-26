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

    private String artista;
    private String album;
    private float duracao;
    
    public Music(String titulo, float preco, String categoria, String avaliacoes){
        this(titulo, preco, categoria, avaliacoes, null, null, 0);
    }
    
    public Music(String titulo, float preco, String categoria, String avaliacoes, String artista, String album, float duracao) {
        super(titulo, preco, categoria, avaliacoes);
        this.artista = artista;
        this.album = album;
        this.duracao = duracao;
    }
    
    @Override
    public String get_info(){
        String describe = super.get_info();
        describe += "" + get_artista();
        return describe;
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
    
    public String get_artista(){
        return this.artista;
    }
    
    public String get_album(){
        return this.album;
    }    
    
    public float get_duracao(){
        return this.duracao;
    }
}
