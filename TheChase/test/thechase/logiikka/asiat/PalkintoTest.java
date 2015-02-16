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

/**
 *
 * @author matti
 */
public class PalkintoTest {
    private Lauta testilauta;
    private Palkinto testipalkinto;
    
    public PalkintoTest() {
        
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
        
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testLoytyyLaudanObjekteista() {
        
        testipalkinto = new Palkinto(10, 10, testilauta);
        
        assertTrue(testilauta.getObjektit().contains(testipalkinto));
    }

    @Test
    public void testLoytyyLaudanKartalta() {
        
        testipalkinto = new Palkinto(10,10, testilauta);
       
        assertEquals(testipalkinto, testilauta.getKartta()[10][10]);
    }
    
    @Test
    public void testPalauttaaOmanSijaintinsa() {
        
        testipalkinto = new Palkinto(19, 2, testilauta);
        
        assertTrue(testipalkinto.sijainti().x == 19 && testipalkinto.sijainti().y == 2);
    }
    
    @Test
    public void testPalkinnonSijantiOnSamaKuinLaudalla() {
        
        testipalkinto = new Palkinto(19, 2, testilauta);
        
        assertEquals(testipalkinto, testilauta.getKartta()[19][2]);
    }
}
