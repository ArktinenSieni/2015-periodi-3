/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka.algoritmit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import thechase.logiikka.Suunta;

/**
 *
 * @author matti
 */
public class ZombiTest {
    
    public ZombiTest() {
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
     * Test of onkoParempi method, of class Zombi.
     */
    @Test
    public void testOnkoParempi() {
        System.out.println("onkoParempi");
        Suunta ehdotus = null;
        Zombi instance = null;
        instance.onkoParempi(ehdotus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        
        
    }

    /**
     * Test of etene method, of class Zombi.
     */
    @Test
    public void testEtene() {
        System.out.println("etene");
        Zombi instance = null;
        Suunta expResult = null;
        Suunta result = instance.etene();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
