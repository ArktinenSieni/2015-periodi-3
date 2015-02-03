/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
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
    private ArrayDeque<int[]> vanhats;
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
        vanhats = new ArrayDeque<int[]>();
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
        this.paivita();
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
        while (!vanhats.isEmpty()) {
            int[] sij = vanhats.poll();
            kartta[sij[0]][sij[1]] = null;
        }
        
        for (Asia a : objektit) {
            int[] sijainti = a.sijainti();
            vanhats.add(sijainti);
            kartta[sijainti[0]][sijainti[1]] = a;
        }
    }

    @Override
    public Paivitettava getPaivitettava() {
        return this;
    }
    
    
}
