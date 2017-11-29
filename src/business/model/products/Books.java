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
public class Books extends Product{
    
    private String author;
    private String publisher;
    private String edition;
    private String genre;
    private int number_pages;

    public Books(String titulo, float preco, int year) {
        this(titulo, preco, year, null, "Unknow", "Unknow", "Unknow", 0);
    }
    
    public Books(String titulo, float preco, int year, String autor, String editora, String edicao, String genre, int num_page) {
        super(titulo, preco, "Books", year);
        this.author = autor;
        this.publisher =  editora;
        this.edition = edicao;
        this.number_pages = num_page;
        this.genre = genre;
    }
    
    @Override
    public String get_info(){
        String describe = super.get_info();
        describe += "\tAuthor: " + get_author() + "\n";
        describe += "\tPublisher: " + get_publisher() + "\n";
        describe += "\tEdition: " + get_edition() + "\n";
        describe += "\tGenre: " + get_genre() + "\n";
        describe += "\tNumber of Pages: " + get_number_pages() + "\n";
        return describe;
    }

    public String get_author() { return this.author; }
    
    public String get_publisher() { return this.publisher; }
    
    public String get_edition() { return this.edition; }
    
    public String get_genre() { return this.genre; }
    
    public int get_number_pages() { return this.number_pages; }
    
    

    public void set_publisher(String newPublisher) { this.publisher = newPublisher; }
    
    public void set_edition(String newEdition) { this.edition = newEdition; }
    
    public void set_genre(String newGenre) { this.genre = newGenre; }
    
    public void set_number_pages(int num_page) { this.number_pages = num_page; }
    
}
