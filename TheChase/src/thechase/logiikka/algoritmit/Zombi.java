/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka.algoritmit;

import thechase.logiikka.Suunta;
import thechase.logiikka.asiat.Asia;
import thechase.logiikka.asiat.Hahmo;

/**
 *
 * @author TheArctic
 */
public class Zombi implements Algoritmi {
    private Hahmo h;
    private Asia kohde;
    private int pienin;
    private Suunta minne;
    
    public Zombi (Hahmo hahmo, Asia kohde) {
        this.h = hahmo;
        this.kohde = kohde;
    }
    
    private int etaisyysKohteeseen(int mistaX, int mistaY) {
        int[] minne = kohde.sijainti();
        int minneX = minne[0];
        int minneY = minne[1];
        
        return Math.abs(mistaX - minneX) + Math.abs(mistaY - minneY);
    }
    
    public void onkoParempi(Suunta ehdotus) {
        int[] hsij = h.sijainti();
        int hx = hsij[0];
        int hy = hsij[1];
        
        int ehdotusEtaisyys = etaisyysKohteeseen(hx + ehdotus.x, hy + ehdotus.y);
        if (ehdotusEtaisyys < pienin) {
            pienin = ehdotusEtaisyys;
            minne = ehdotus;
        }
    }
    
    @Override
    public Suunta etene() {
        pienin = Integer.MAX_VALUE;
        minne = Suunta.ISTU;
        
        if (h.alasVapaa()) {
            onkoParempi(Suunta.ALAS);
        }
        if (h.ylosVapaa()) {
            onkoParempi(Suunta.YLOS);
        }
        if (h.vasemmalleVapaa()) {
            onkoParempi(Suunta.VASEN);
        }
        if (h.oikealleVapaa()) {
            onkoParempi(Suunta.OIKEA);
        }
        
       return minne;
    }


    
    
    
}
