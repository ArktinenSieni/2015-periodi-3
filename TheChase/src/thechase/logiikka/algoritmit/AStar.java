/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka.algoritmit;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import thechase.logiikka.Suunta;
import thechase.logiikka.asiat.Asia;
import thechase.logiikka.asiat.Hahmo;

/**
 *
 * @author matti
 */
public class AStar extends GreedyBestFind {

    public AStar(Hahmo hahmo, Asia kohde) {
        super(hahmo, kohde);
    }
    
    @Override
    public Suunta etene() {
        Suunta suunta = Suunta.ISTU;
        super.onkoKayty = new boolean[super.hahmo.kartanMitat().x + 1][super.hahmo.kartanMitat().y + 1];
        PriorityQueue<Solmu> tutkittavat = new PriorityQueue<Solmu>();
        Solmu nykyinen = null;
        super.onkoKayty[super.hahmo.sijainti().x][super.hahmo.sijainti().y] = true;

        ArrayDeque<Point> viereiset = this.viereiset(super.hahmo.sijainti().x, super.hahmo.sijainti().y);
        while (!viereiset.isEmpty()) {
            Point v = viereiset.poll();
            tutkittavat.add(new Solmu(v.x, v.y, etaisyys(v.x, v.y, super.kohde)));
        }

        while (!tutkittavat.isEmpty()) {
            nykyinen = tutkittavat.poll();
            super.onkoKayty[nykyinen.sijainti().x][nykyinen.sijainti().y] = true;

            if (nykyinen.sijainti().x == super.kohde.sijainti().x && nykyinen.sijainti().y == super.kohde.sijainti().y) {
                break;
            }

            viereiset = this.viereiset(nykyinen.sijainti().x, nykyinen.sijainti().y);
            while (!viereiset.isEmpty()) {
                Point v = viereiset.poll();
                tutkittavat.add(new Solmu(v.x, v.y, etaisyys(v.x, v.y, super.kohde) + nykyinen.prioriteetti, nykyinen));
            }

        }
        
        while (nykyinen.edellinen() != null) {
            nykyinen = nykyinen.edellinen();
        }

        return super.suunnassa(nykyinen);
    }
}
