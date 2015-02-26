/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka.asiat;

import java.awt.Color;
import java.awt.Point;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import thechase.logiikka.Lauta;
import thechase.logiikka.Suunta;

/**
 *
 * @author matti
 */
public class SeinaTest {
    Lauta testilauta;
    Seina testiseina;
    Hahmo testihahmo;
    
    public SeinaTest() {
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
        testiseina = new Seina(10, 10);
        testilauta.getKartta()[10][10] = testiseina;
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testEiVoiLiikkuaPaalta() {
        
        testihahmo = new Hahmo(testilauta);
        testihahmo.setSijainti(9, 10);
        
        testihahmo.setSijainti(testihahmo.sijainti().x + Suunta.OIKEA.x, testihahmo.sijainti().y + Suunta.OIKEA.y);
        
        assertTrue(testihahmo.sijainti().x == 9 && testihahmo.sijainti().y == 10);
    }
    
    @Test
    public void testEiLoydyLaudanObjekteista() {
        
        testihahmo = new Hahmo(testilauta);
        assertTrue(testilauta.getObjektit().size() == 1);
    }
}
