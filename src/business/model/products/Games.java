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
public class Games extends Product{
    
    private String description;
    private String developer;
    private String publisher;
    private String oficialSite;
    private String genre;

    public Games(String titulo, float preco) {
        this(titulo, preco, "", "Unknow", "Unknow", "Unknow", "");
    }
    
    public Games(String titulo, float preco, String descricao, String desenvolvedor, String publicadora, String genre, String site_oficial){
        super(titulo, preco, "Games");
        this.description = descricao;
        this.developer = desenvolvedor;
        this.publisher = publicadora;
        this.oficialSite = site_oficial;
        this.genre = genre;
    }
    
    @Override
    public String get_info(){
        String describe = super.get_info();
        describe += "\tDescription: " + get_description() + "\n";
        describe += "\tDeveloper: " + get_developer() + "\n";
        describe += "\tPublisher: " + get_publisher() + "\n";
        describe += "\tGenre: " + get_genre() + "\n";
        describe += "\tOficial Site: " + get_oficial_site() + "\n";
        return describe;
    }
    
    public String get_description() { return this.description; }
    
    public String get_developer() { return this.developer; }
    
    public String get_publisher() { return this.publisher; }
    
    public String get_oficial_site() { return this.oficialSite; }
    
    public String get_genre() { return this.genre; }

    
    
    public void set_desciption(String newDescription) { this.description = newDescription; }
    
    public void set_developer(String newDeveloper) { this.developer = newDeveloper; }
    
    public void set_publisher(String newPublisher) { this.publisher = newPublisher; }
    
    public void set_oficial_site(String newSite) { this.oficialSite = newSite; }
    
    public void set_genre(String genero) { this.genre = genero; }

}
