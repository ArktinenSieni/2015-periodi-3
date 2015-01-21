/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka.asiat;

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
public class AsiaTest {
    
    public AsiaTest() {
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
     * Test of sijainti method, of class Asia.
     */
    @Test
    public void testSijainti() {
        System.out.println("sijainti");
        Asia instance = new AsiaImpl();
        int[] expResult = null;
        int[] result = instance.sijainti();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ylitettava method, of class Asia.
     */
    @Test
    public void testYlitettava() {
        System.out.println("ylitettava");
        Asia instance = new AsiaImpl();
        boolean expResult = false;
        boolean result = instance.ylitettava();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AsiaImpl implements Asia {

        public int[] sijainti() {
            return null;
        }

        public boolean ylitettava() {
            return false;
        }
    }
    
}
