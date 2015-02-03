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
        int[] eskonSij = esko.sijainti();
        
        assertTrue(eskonSij[0] == x && eskonSij[1] == y);
    }

    

    /**
     * Test of oikealle method, of class Hahmo.
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
        
        int[] eskonSij = esko.sijainti();
        
        assertTrue(eskonSij[0] == 1 && eskonSij[1] == 1);
    }

    
    
}
