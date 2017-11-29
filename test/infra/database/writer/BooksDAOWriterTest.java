/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.database.writer;

import business.control.CatalogControl;
import business.control.facade.RegisterFacade;
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
public class BooksDAOWriterTest {
    
    public BooksDAOWriterTest() {
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
     * Test of save method, of class BooksDAOWriter.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        String title = "O alemao",
               price = "9.99",
               year = "2012",
               author = "Leonardo",
               publisher = "Editora Digital",
               edition = "3 edicao",
               genre = "Romance",
               num_pages = "200";
               
               
        RegisterFacade.register_product("Books", title, price, year, author, publisher, edition, genre, num_pages);
        
        CatalogControl.show("Books");
        
        BooksDAOWriter daoWriter = new BooksDAOWriter();
        daoWriter.save("digitalquestdb");
        
    }

    /**
     * Test of clear_file method, of class BooksDAOWriter.
     */
    @Test
    public void testClear_file() {
        System.out.println("clear_file");

    }
    
}
