/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.ArrayList;
import thechase.logiikka.asiat.Asia;

/**
 * Karttana toimiva luokka. Tältä noudetaan kartta ja siinä olevat objektit.
 * Kartta on Hahmoja sekä piirtämistä varten, kun taas objektit-lista on
 * yksinomaan Hahmojen reitinlaskentaa varten. 
 * @author TheArctic
 */
public class Lauta implements Paivitettava{
    private Asia[][] kartta;
    private ArrayList<Asia> objektit;
    private ArrayDeque<Point> vanhats;
    private KarttaGeneroija gene;
    
    /**
     * 
     * @param korkeus kartan korkeus.
     * @param leveys kartan leveys.
     */
    public Lauta(int leveys, int korkeus) {
        gene = new KarttaGeneroija();
        setKartta(gene.generoiTemplate(new Asia[korkeus][leveys]));
        objektit = new ArrayList<Asia>();
        vanhats = new ArrayDeque<Point>();
        
    }
    
    /**
     * Voidaan asettaa uusi, valmis kartta.
     * @param uusi asetettaava kartta
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
        this.paivita();
    }
    
    /**
     * Palauttaa generoijan. Oleellinen kentän alustamisessa.
     * @return palauttaa generoijan
     */
    public KarttaGeneroija getGeneroija() {
        return this.gene;
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
            Point sij = vanhats.poll();
            kartta[sij.x][sij.y] = null;
            
            Point uusi = objektit.get(i).sijainti();
            kartta[uusi.x][uusi.y] = objektit.get(i);
            vanhats.add(uusi);
        }
        while (!vanhats.isEmpty()) {
            Point sij = vanhats.poll();
            kartta[sij.x][sij.y] = null;
        }
        
        for (Asia a : objektit) {
            Point sijainti = a.sijainti();
            vanhats.add(sijainti);
            kartta[sijainti.x][sijainti.y] = a;
        }
    }

    @Override
    public Paivitettava getPaivitettava() {
        return this;
    }
    
    
}
