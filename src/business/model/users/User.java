package business.model.users;

import business.model.exceptions.PasswordValidationException;
import business.model.exceptions.LoginValidationException;
import business.control.Validator;
import business.model.exceptions.InvalidLoginException;
import business.model.memento.Memento;
import business.model.users.states.*;
import business.model.wishlist.WishListComponent;
import business.model.wishlist.WishListComposite;

public class User{
    
    private String login, password;
    private WishListComposite wishlist;
    
    /**Padrão State**/
    private LoginState login_state;
    private LogoutState logout_state;
    private UserState current_state;
    
    
    public User(String login, String password, String wishlist_name){
        this.login = login;
        this.password = password;
        wishlist = new WishListComposite(this, wishlist_name);
        login_state = new LoginState(this);
        logout_state = new LogoutState(this);
        current_state = logout_state;
    }    
    
    public User(String login, String password){
        this(login, password, "Unnamed wishlist");
    }
    
    public User(String login){
        this(login, "login123", "Unnamed wishlist");
    }
    
    public User(){
        this("login","login123", "Unnamed wishlist");
    }
    
    public String get_info(){
        return "<html><strong>Login:</strong> <em>" + this.login + "</em>  <strong>Senha:</strong> <em>" + this.password + "</em></html>\n";
    }
    
    public boolean login(String login_argument, String password_argument) throws InvalidLoginException{
        if(this.login.equals(login_argument) && this.password.equals(password_argument)){
            current_state.login(login, password);
            return true;
        }else{
            throw new InvalidLoginException();
        }
    }
    
    public String get_login(){ return this.login; }
    
    public String get_password(){ return this.password; }
    
    public WishListComponent get_wishlist(){ return this.wishlist; }
    
    public UserState get_current_state() { return this.current_state; }
    
    public UserState get_login_state() { return this.login_state; }
    
    public UserState get_logout_state() { return this.logout_state; }
    
    
    public Memento store_wishlist_in_memento() throws InvalidLoginException{
        if(current_state instanceof LoginState){
            return new Memento(wishlist);
        }else
            throw new InvalidLoginException("The user must be logged");
    }
    
    public void set_wishlist(WishListComponent newWishList){ this.wishlist = (WishListComposite) newWishList; }
    
    public void set_state(UserState newState){ this.current_state = newState; }
    
    public void set_login(String login){
        try{
            Validator.validate_login(login);
            this.login = login;
        }catch(LoginValidationException uve){
            System.out.println(uve.getMessage());
        }
    }
    
    public void set_password(String password){
        try{
            Validator.validate_password(password);
            this.password = password;
        }catch(PasswordValidationException uve){
            System.out.println(uve.getMessage());
        }
    }
    
}
