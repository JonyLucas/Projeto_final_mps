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
        try{
            RegisterFacade.register_product("Games");
            RegisterFacade.register_product("Games");
            RegisterFacade.show_catalog("Games");
            
            RegisterFacade.register_product("Movies");
            RegisterFacade.register_product("Movies");
            RegisterFacade.show_catalog("Movies");
        }catch(Exception e){
            fail();
        }
    }

    /**
     * Test of remove_product method, of class RegisterFacade.
     */
    @Test
    public void testRemove_product() {
        System.out.println("remove_product");
        try{
            Product product = RegisterFacade.get_product("Movies", 0);
            RegisterFacade.remove_product(product);
            RegisterFacade.show_catalog("Movies");
        }catch(Exception e){
            fail();
        }
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
