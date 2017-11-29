/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.database.reader;

import business.model.users.User;
import infra.database.reader.UserDAOReader;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo Dantas
 */
public class UserDAOReaderTest {
    
    public UserDAOReaderTest() {
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
     * Test of buscar method, of class UserDAO.
     */
    @Test
    public void testBuscar() throws Exception {
       UserDAOReader userdao = new UserDAOReader();
       userdao.load("digitalquestdb");
    }
    
}
