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
public class HahmoTest {
    
    public HahmoTest() {
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
     * Test of setSijainti method, of class Hahmo.
     */
    @Test
    public void testSetSijainti() {
        System.out.println("setSijainti");
        int x = 0;
        int y = 0;
        Hahmo instance = null;
        instance.setSijainti(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ylos method, of class Hahmo.
     */
    @Test
    public void testYlos() {
        System.out.println("ylos");
        Hahmo instance = null;
        instance.ylos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alas method, of class Hahmo.
     */
    @Test
    public void testAlas() {
        System.out.println("alas");
        Hahmo instance = null;
        instance.alas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vasemmalle method, of class Hahmo.
     */
    @Test
    public void testVasemmalle() {
        System.out.println("vasemmalle");
        Hahmo instance = null;
        instance.vasemmalle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of oikealle method, of class Hahmo.
     */
    @Test
    public void testOikealle() {
        System.out.println("oikealle");
        Hahmo instance = null;
        instance.oikealle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sijainti method, of class Hahmo.
     */
    @Test
    public void testSijainti() {
        System.out.println("sijainti");
        Hahmo instance = null;
        int[] expResult = null;
        int[] result = instance.sijainti();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ylitettava method, of class Hahmo.
     */
    @Test
    public void testYlitettava() {
        System.out.println("ylitettava");
        Hahmo instance = null;
        boolean expResult = false;
        boolean result = instance.ylitettava();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
