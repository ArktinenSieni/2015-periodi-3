/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka;

import java.util.ArrayList;
import thechase.logiikka.asiat.Asia;

/**
 * Karttana toimiva luokka. Tältä noudetaan kartta ja siinä olevat objektit.
 * Kartta on <Code>Hahmo</Code>ja sekä piirtämistä varten, kun taas objektien on
 * yksinomaan <Code>Hahmo</Code>jen reitinlaskennan nopeuttamista varten.
 * @author TheArctic
 */
public class Lauta implements Paivitettava{
    private Asia[][] kartta;
    private ArrayList<Asia> objektit;
    
    /**
     * 
     * @param korkeus kartan korkeus.
     * @param leveys kartan leveys.
     */
    public Lauta(int korkeus, int leveys) {
        kartta = new Asia[korkeus][leveys];
    }
    
    public void lisaaObjekti(Asia obj) {
        objektit.add(obj);
    }

    public Asia[][] getKartta() {
        return kartta;
    }

    public ArrayList<Asia> getObjektit() {
        return objektit;
    }

    @Override
    public void paivita() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
