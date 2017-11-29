/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.database.reader;

import business.model.products.Product;
import infra.database.reader.MoviesDAOReader;
import java.util.List;
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
public class MoviesDAOReaderTest {
    
    public MoviesDAOReaderTest() {
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
     * Test of buscar method, of class MoviesDAO.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        MoviesDAOReader movieDAO = new MoviesDAOReader();
        movieDAO.load("digitalquestdb");
    }
    
}
