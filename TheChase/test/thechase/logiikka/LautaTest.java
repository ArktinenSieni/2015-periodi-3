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
import thechase.logiikka.asiat.Hahmo;

/**
 *
 * @author TheArctic
 */
public class LautaTest {
    Lauta testiLauta;
    
    public LautaTest() {
        this.testiLauta = new Lauta(30, 20);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testiLauta = new Lauta(30, 20);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testKartanLuontiReunat() {
        System.out.println("Reunojen luonti");
        for (int i = 0; i < testiLauta.getKartta().length; i++) {
            assertFalse(testiLauta.getKartta()[i][0] == null 
                    && testiLauta.getKartta()[i][testiLauta.getKartta()[i].length - 1] == null);
        }
        for (int i = 0; i < testiLauta.getKartta()[0].length; i++) {
            assertFalse(testiLauta.getKartta()[0][i] == null 
                    && testiLauta.getKartta()[testiLauta.getKartta().length - 1][i] == null);
        }
    }

    /**
     * Test of setKartta method, of class Lauta.
     */
    @Test
    public void testSetKartta() {
        System.out.println("Kartan asettaminen");
        Asia[][] UusiKartta = new Asia[10][20];
        testiLauta.setKartta(UusiKartta);
        
        assertEquals(10, testiLauta.getKartta().length);
        assertEquals(20, testiLauta.getKartta()[0].length);
    }

    /**
     * Test of lisaaObjekti method, of class Lauta.
     */
    @Test
    public void testLisaaObjekti() {
        System.out.println("Objektin lisääminen");
        Hahmo testi = new Hahmo(testiLauta);
        
        assertTrue(testiLauta.getObjektit().contains(testi));
    }

    /**
     * Test of paivita method, of class Lauta.
     */
    @Test
    public void testPaivita() {
        System.out.println("Laudan päivittäminen");
        Hahmo esko = new Hahmo(testiLauta);
        int[] eskonSij = esko.sijainti();
        
        while(esko.oikealle()) {
            testiLauta.paivita();
        }
        
        assertTrue(esko.equals(testiLauta.getKartta()[testiLauta.getKartta().length - 2][eskonSij[1]]));
    }

    
    
}
