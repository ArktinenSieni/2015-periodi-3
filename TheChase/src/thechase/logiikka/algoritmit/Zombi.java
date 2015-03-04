
package thechase.logiikka.algoritmit;

import java.awt.Point;
import thechase.logiikka.Suunta;
import thechase.logiikka.asiat.Asia;
import thechase.logiikka.asiat.Hahmo;

/**
 * Algoritmi joka liikkuu sokeasti kohti kohdettaan, välittämättä esteistään.
 * @author mcraty
 */
public class Zombi implements Algoritmi {
    private Hahmo hahmo;
    private Asia kohde;
    private int pieninEtaisyysKohteeseen;
    private Suunta minne;
    
    public Zombi (Hahmo hahmo, Asia kohde) {
        this.hahmo = hahmo;
        this.kohde = kohde;
        pieninEtaisyysKohteeseen = Integer.MAX_VALUE;
    }
    
    public Suunta getMinne() {
        return this.minne;
    }
    
    
    /**
     * Laskee etäisyyden hahmosta hahmon kohteeseen. Oleellinen hahmon ruudunvalinnassa.
     * @param mistaX Mistä ruudusta tarkastellaan etäisyyttä x-akselilla.
     * @param mistaY Mistä ruudusta tarkastellaan etäisyyttä y-akselilla
     * @return palauttaa Manhattan etäisyyden kohteeseen.
     */
    private int etaisyysKohteeseen(int mistaX, int mistaY) {
        Point minne = kohde.sijainti();
        int minneX = minne.x;
        int minneY = minne.y;
        
        return Math.abs(mistaX - minneX) + Math.abs(mistaY - minneY);
    }
    
    /**
     * Vertaa ehdotettua ruutua nykyiseen parhaaseen vaihtoehto-ruutuun.
     * @param ehdotus Mihin kannattaa siirtyä. Jos ehdotettu ruutu on parempi kuin vanha, se palautetaan ja päinvastoin.
     */
    public void onkoParempi(Suunta ehdotus) {
        Point hahmonSijainti = hahmo.sijainti();
        int hx = hahmo.sijainti().x;
        int hy = hahmo.sijainti().y;
        
        int ehdotusEtaisyys = etaisyysKohteeseen(hx + ehdotus.x, hy + ehdotus.y);
        if (ehdotusEtaisyys < pieninEtaisyysKohteeseen) {
            pieninEtaisyysKohteeseen = ehdotusEtaisyys;
            minne = ehdotus;
        }
    }
    
    /**
     * Valitsee parhaan vaihtoehdon vapaana olevista ruuduista
     * @return Suunta, johon kannattaa siirtyä.
     */
    @Override
    public Suunta etene() {
        pieninEtaisyysKohteeseen = Integer.MAX_VALUE;
        minne = Suunta.ISTU;
        
        if (hahmo.alasVapaa()) {
            onkoParempi(Suunta.ALAS);
        }
        if (hahmo.ylosVapaa()) {
            onkoParempi(Suunta.YLOS);
        }
        if (hahmo.vasemmalleVapaa()) {
            onkoParempi(Suunta.VASEN);
        }
        if (hahmo.oikealleVapaa()) {
            onkoParempi(Suunta.OIKEA);
        }
        
       return minne;
    }


    
    
    
}
