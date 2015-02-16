/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka.asiat;

import java.awt.Point;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import thechase.logiikka.Lauta;

/**
 *
 * @author TheArctic
 */
public class HahmoTest {
    Lauta testiLauta;
    Hahmo esko;
    
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
        testiLauta = new Lauta(20, 20);
        esko = new Hahmo(testiLauta);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setSijainti method, of class Hahmo.
     */
    @Test
    public void testSetSijainti() {
        int x = 4;
        int y = 7;
        
        esko.setSijainti(x, y);
        Point eskonSij = esko.sijainti();
        
        assertTrue(eskonSij.x == x && eskonSij.y == y);
    }
    
    @Test
    public void testSetSijainti2() {
        
        assertFalse(esko.setSijainti(20, 20));
    }
    
    @Test public void testSetSijainti3() {
        
        assertFalse(esko.setSijainti(0, 0));
    }

    /**
     * Test of directions method, of class Hahmo.
     */
    @Test
    public void testSuunnat() {
        
        
        
        while(esko.oikealle()) {
            testiLauta.paivita();
        }
        
        
        while(esko.alas()) {
            testiLauta.paivita();
        }
        
        
        while(esko.vasemmalle()) {
            testiLauta.paivita();
        }
        
        
        while(esko.ylos()) {
            testiLauta.paivita();
        }
        
        Point eskonSij = esko.sijainti();
        
        assertTrue(eskonSij.x == 1 && eskonSij.y == 1);
    }

    
    
}
