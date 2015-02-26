package thechase.logiikka.algoritmit;

import java.awt.Point;
import java.util.PriorityQueue;
import thechase.logiikka.Suunta;
import thechase.logiikka.asiat.Asia;
import thechase.logiikka.asiat.Hahmo;

/**
 *
 * @author matti
 */
public class AStar implements Algoritmi{
    private Hahmo hahmo;
    private Asia kohde;
    private Solmu[][] kartta;
    
    public AStar(Hahmo hahmo, Asia kohde) {
        this.hahmo = hahmo;
        this.kohde = kohde;
        
    }

    @Override
    public Suunta etene() {
        kartta = new Solmu[hahmo.kartanMitat().x + 1][hahmo.kartanMitat().y + 1];
        Solmu alku = uusiSolmu(hahmo.sijainti());
        alku.setKayty();
        
        Solmu reitti = ATahti(alku);
        Solmu viereinen = etsiReitistaViereinen(reitti, alku);
                
        return suunta(alku, viereinen);
    }
    
    public Solmu ATahti(Solmu alku) {
        Solmu nykyinen = null;
        
        PriorityQueue<Solmu> rajaseutu = new PriorityQueue<Solmu>();
        alku.setPrioriteetti(0);
        rajaseutu.add(alku);
        
        while (!rajaseutu.isEmpty()) {
            nykyinen = rajaseutu.poll();
            
            if (nykyinen.sijainti().x == kohde.sijainti().x 
                    && nykyinen.sijainti().y == kohde.sijainti().y) {
                break;
            }
            
            Solmu[] viereiset = viereiset(nykyinen);
            for (Solmu vierus : viereiset) {
                if (vierus == null) {
                    continue;
                }
                int uusiPaino = nykyinen.getPaino() + 1;
                
                if (!vierus.getKayty() || uusiPaino < vierus.getPaino()) {
                    vierus.setKayty();
                    vierus.setPaino(uusiPaino);
                    vierus.setPrioriteetti(uusiPaino + heuristiikka(vierus, kohde));
                    rajaseutu.add(vierus);
                    vierus.setEdellinen(nykyinen);
                }
            }
        }
        
        return nykyinen;
    }

    private Solmu uusiSolmu(Point sijainti) {
        if (kartta[sijainti.x][sijainti.y] == null) {
            kartta[sijainti.x][sijainti.y] = new Solmu(sijainti.x, sijainti.y, 0);
        }
        return kartta[sijainti.x][sijainti.y];
    }

    private Solmu[] viereiset(Solmu nykyinen) {
        Solmu[] viereiset = new Solmu[4];
        
        Point suunta = new Point(nykyinen.sijainti().x + Suunta.ALAS.x, nykyinen.sijainti().y + Suunta.ALAS.y);
        if (hahmo.onkoVapaa(suunta)) {
            viereiset[0] = uusiSolmu(suunta);
        }
        suunta = new Point(nykyinen.sijainti().x + Suunta.YLOS.x, nykyinen.sijainti().y + Suunta.YLOS.y);
        if (hahmo.onkoVapaa(suunta)) {
            viereiset[1] = uusiSolmu(suunta);
        }
        suunta = new Point(nykyinen.sijainti().x + Suunta.VASEN.x, nykyinen.sijainti().y + Suunta.VASEN.y);
        if (hahmo.onkoVapaa(suunta)) {
            viereiset[2] = uusiSolmu(suunta);
        }
        suunta = new Point(nykyinen.sijainti().x + Suunta.OIKEA.x, nykyinen.sijainti().y + Suunta.OIKEA.y);
        if (hahmo.onkoVapaa(suunta)) {
            viereiset[3] = uusiSolmu(suunta);
        }
        
        
        return viereiset;
    }

    private int heuristiikka(Solmu seuraava, Asia kohde) {
        return Math.abs(seuraava.sijainti().x - kohde.sijainti().x) 
                + Math.abs(seuraava.sijainti().y - kohde.sijainti().y);
    }
    
    private Solmu etsiReitistaViereinen(Solmu loppu, Solmu alku) {
        Solmu vierus = loppu;
        
        while(vierus.edellinen()!= alku) {
            vierus = vierus.edellinen();
        }
        
        return vierus;
    }

    private Suunta suunta(Solmu alku, Solmu viereinen) {
        int eroX = viereinen.sijainti().x - alku.sijainti().x;
        int eroY = viereinen.sijainti().y - alku.sijainti().y;
        
        if (eroX == 0 && eroY == -1) return Suunta.YLOS;
        else if (eroX == 0 && eroY == 1) return Suunta.ALAS;
        else if (eroX == 1 && eroY == 0) return Suunta.OIKEA;
        else if (eroX == -1 && eroY == 0) return Suunta.VASEN;
        return Suunta.ISTU;
    }
}
