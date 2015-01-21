/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import thechase.logiikka.asiat.Asia;

/**
 *
 * @author TheArctic
 */
public class LautaTest {
    
    public LautaTest() {
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
     * Test of lisaaObjekti method, of class Lauta.
     */
    @Test
    public void testLisaaObjekti() {
        System.out.println("lisaaObjekti");
        Asia obj = null;
        Lauta instance = null;
        instance.lisaaObjekti(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKartta method, of class Lauta.
     */
    @Test
    public void testGetKartta() {
        System.out.println("getKartta");
        Lauta instance = null;
        Asia[][] expResult = null;
        Asia[][] result = instance.getKartta();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObjektit method, of class Lauta.
     */
    @Test
    public void testGetObjektit() {
        System.out.println("getObjektit");
        Lauta instance = null;
        ArrayList<Asia> expResult = null;
        ArrayList<Asia> result = instance.getObjektit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paivita method, of class Lauta.
     */
    @Test
    public void testPaivita() {
        System.out.println("paivita");
        Lauta instance = null;
        instance.paivita();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
