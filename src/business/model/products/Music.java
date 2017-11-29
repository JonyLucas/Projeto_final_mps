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

    private String genre;
    private String artist;
    private String album;
    private float duration;
    
    public Music(String titulo, float preco, int year, String artista, String genero, String album, float duracao) {
        super(titulo, preco, "Music", year);
        this.artist = artista;
        this.album = album;
        this.duration = duracao;
        this.genre = genero;
    }
    
    public Music(String titulo, float preco, int year){
        this(titulo, preco, year, "Unknow", "Unknow", "Unknow", 0);
    }
    
    @Override
    public String get_info(){
        String describe = super.get_info();
        describe += "\tArtist: " + get_artist() + "\n";
        describe += "\tAlbum: " + get_album() + "\n";
        describe += "\tGenre: " + get_genre() + "\n";
        describe += "\tDuration: " + get_duration() + "\n";
        return describe;
    }
        
    public String get_artist(){ return this.artist; }
    
    public String get_album(){ return this.album; }    
    
    public String get_genre() { return this.genre; }
    
    public float get_duration(){ return this.duration; }
    
    
    public void set_artist(String newArtist) { this.artist = newArtist; }
    
    public void set_album(String newAlbum) { this.album = newAlbum; }
    
    public void set_genre(String genero) { this.genre = genero; }
    
    public void set_duration(int newDuration) { this.duration = newDuration; }
    
}
