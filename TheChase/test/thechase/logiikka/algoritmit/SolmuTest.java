/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka.algoritmit;

import java.awt.Point;
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
public class SolmuTest {
    Solmu testisolmu;
    
    public SolmuTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         testisolmu = new Solmu(5, 5, 0);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSolmuPalauttaaSijainnin() {
        assertEquals(new Point(5,5), testisolmu.sijainti());
    }
    
    
    
    @Test
    public void testPalauttaaNullJosEiEdellista() {
        assertEquals(null, testisolmu.edellinen());
    }
    
    @Test
    public void testPalauttaaEdellisenSolmunJosMaaritelty() {
        Solmu testisolmu2 = new Solmu(testisolmu.sijainti().x + Suunta.YLOS.x,
                testisolmu.sijainti().y + Suunta.YLOS.y , 0, testisolmu);
        
        assertEquals(testisolmu, testisolmu2.edellinen());
    }
    
}
