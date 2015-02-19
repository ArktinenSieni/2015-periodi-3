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
import thechase.logiikka.Lauta;
import thechase.logiikka.Suunta;
import thechase.logiikka.asiat.Hahmo;
import thechase.logiikka.asiat.Palkinto;
import thechase.logiikka.asiat.Seina;

/**
 *
 * @author matti
 */
public class GreedyBestFindTest {
    private Lauta testilauta;
    private Palkinto testipalkinto;
    private Hahmo testihahmo;
    private GreedyBestFind testialgo;
    
    public GreedyBestFindTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testilauta = new Lauta(20, 20);
        
        testipalkinto = new Palkinto(10, 9, testilauta);
        
        testihahmo = new Hahmo(testilauta);
        testihahmo.setSijainti(10, 2);
        
        testialgo = new GreedyBestFind(testihahmo, testipalkinto);
        testihahmo.setAlgo(testialgo);
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testLaskeeKahdenAsianValisenManhattanEtaisyyden() {
        assertEquals(7, testialgo.etaisyys(testihahmo.sijainti().x, testihahmo.sijainti().y, testipalkinto));
    }
    
    @Test
    public void testViereisetPalauttaaViereisetVapaatRuudut() {
        testihahmo.setSijainti(1, 1);
        
        assertEquals(2, testialgo.viereiset(testihahmo.sijainti().x, testihahmo.sijainti().y).size());
    }
    
    
    @Test
    public void testPalauttaaOikeanSuunnan() {
        assertEquals(Suunta.ALAS, testialgo.etene());
    }
    
    @Test
    public void testHahmoLoytaaPalkinnon() {
        
        for (int i = 0; i < 7; i++) {
            testihahmo.liiku();
        }
        assertEquals(testipalkinto.sijainti(), testihahmo.sijainti());
    }
    
    @Test
    public void testHahmoLoytaaPalkinnonEsteenTakaa() {
        for (int i = 8; i <= 12; i++) {
            testilauta.getKartta()[i][4] = new Seina(i, 4);
        }
        
        for (int i = 0; i < 13; i++) {
            testihahmo.liiku();
        }
        assertEquals(testipalkinto.sijainti(), testihahmo.sijainti());
    }
    
}
