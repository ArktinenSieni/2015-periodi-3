/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TheArctic
 */
public class PaivitettavaTest {
    
    public PaivitettavaTest() {
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
     * Test of paivita method, of class Paivitettava.
     */
    @Test
    public void testPaivita() {
        System.out.println("paivita");
        Paivitettava instance = new PaivitettavaImpl();
        instance.paivita();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PaivitettavaImpl implements Paivitettava {

        public void paivita() {
        }

        @Override
        public Paivitettava getPaivitettava() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
