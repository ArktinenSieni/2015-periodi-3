/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka;

import java.util.ArrayList;
import java.util.PriorityQueue;
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
    private PriorityQueue<int[]> vanhats;
    
    /**
     * 
     * @param korkeus kartan korkeus.
     * @param leveys kartan leveys.
     */
    public Lauta(int korkeus, int leveys) {
        kartta = new Asia[korkeus][leveys];
    }
    
    /**
     * Voidaan asettaa uusi, valmis kartta.
     * @param uusi 
     */
    public void setKartta(Asia[][] uusi) {
        this.kartta = uusi;
    }
    /**
     * Lisää liikkuvan/muuttuvan objektin.
     * @param obj Joko Hahmo tai Asia
     */
    public void lisaaObjekti(Asia obj) {
        objektit.add(obj);
        vanhats.add(obj.sijainti());
    }

    public Asia[][] getKartta() {
        return kartta;
    }

    public ArrayList<Asia> getObjektit() {
        return objektit;
    }

    @Override
    public void paivita() {
        for (int i = 0; i < objektit.size(); i++) {
            int[] sij = vanhats.poll();
            kartta[sij[0]][sij[1]] = null;
            
            int uusi[] = objektit.get(i).sijainti();
            kartta[uusi[0]][uusi[1]] = objektit.get(i);
            vanhats.add(uusi);
        }
    }
    
    
}
