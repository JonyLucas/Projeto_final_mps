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
public class Movies extends Product{

    private float duration;
    private String director;
    private String studio;
    private String synopsis;
    private String genre;
 
    public Movies(String titulo, float preco, float duration, String director, String studio, String genre, String synopsis){
        super(titulo, preco, "Movie");
        this.duration = duration;
        this.director = director;
        this.studio = studio;
        this.synopsis = synopsis;
        this.genre = genre;
    }
    
    public Movies(String titulo, float preco) {
        this(titulo, preco, 0, "Unknow", "Unknow", "Unknow", "Unknow");
    }
    
    @Override
    public String get_info(){
        String describe = super.get_info();
        describe += "\tDirector: " + get_director() + "\n";
        describe += "\tStudio: " + get_studio() + "\n";
        describe += "\tSynopsis: " + get_synopsis() + "\n";
        describe += "\tGenre: " + get_genre() + "\n";
        describe += "\tDuration: " + get_duration() + " min\n";
        return describe;
    }

    public float get_duration() { return this.duration; }
    
    public String get_director() { return this.director; }
    
    public String get_studio() { return this.studio; }
    
    public String get_synopsis() { return this.synopsis; }
    
    public String get_genre() { return this.genre; }
    
    

    public void set_duration(float newDuration) { this.duration = newDuration; }
    
    public void get_directors(String newDirector) { this.director = newDirector; }
    
    public void get_studio(String newStudio) { this.studio = newStudio; }
    
    public void get_synopsis(String newSynopsis) { this.synopsis = newSynopsis; }
    
    public void set_genre(String newGenre) { this.genre = newGenre; }   
    
}
