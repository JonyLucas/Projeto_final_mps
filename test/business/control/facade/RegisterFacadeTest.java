/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control.facade;

import business.model.catalogs.MovieCatalog;
import business.model.products.Product;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joao
 */
public class RegisterFacadeTest {
    
    public RegisterFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of register_product method, of class RegisterFacade.
     */
    @Test
    public void testRegister_product() {
        System.out.println("register_product");
        
        String title = "Novo mundo",
        price = "29.99",
        year = "2017",
        author = "Joao Lucas",
        publisher = "Abril",
        edition = "1 edicao",
        genre = "Acao",
        num_pages = "384";     
               
        RegisterFacade.register_product("Books", title, price, year, author, publisher, edition, genre, num_pages);
        
        title = "Novo mundo 2";
        price = "49.99";
        year = "2020";
        author = "Joao Lucas";
        publisher = "Abril";
        edition = "1 edicao";
        genre = "Acao e aventura";
        num_pages = "384";     
        
        RegisterFacade.register_product("Books", title, price, year, author, publisher, edition, genre, num_pages);
        
        RegisterFacade.show_catalog("Books");
        
    }

    /**
     * Test of remove_product method, of class RegisterFacade.
     */
    @Test
    public void testRemove_product() {
        
        System.out.println("remove_product");
        
        Product product = RegisterFacade.get_product("Books", 0);
        RegisterFacade.remove_product(product);
        RegisterFacade.show_catalog("Books");

    }
    
    /**
     * Test of register_user method, of class RegisterFacade.
     */
    @Test
    public void testRegister_user() {
        System.out.println("register_user");
    }

    /**
     * Test of remove_user method, of class RegisterFacade.
     */
    @Test
    public void testRemove_user() {
        System.out.println("remove_user");
    }

    /**
     * Test of list method, of class RegisterFacade.
     */
    @Test
    public void testList() {
        System.out.println("list");
    }
    
}
