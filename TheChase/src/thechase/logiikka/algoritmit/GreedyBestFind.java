package thechase.logiikka.algoritmit;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import thechase.logiikka.Suunta;
import thechase.logiikka.asiat.Asia;
import thechase.logiikka.asiat.Hahmo;
import thechase.logiikka.asiat.Palkinto;

/**
 * Greedy-Best-Find algoritmi.
 * http://www.redblobgames.com/pathfinding/a-star/introduction.html Etsii
 * ensimmäisen lyhimmän etäisyyden omaavan mukaan.
 *
 * @author mcraty
 */
public class GreedyBestFind implements Algoritmi {

    private Hahmo hahmo;
    private Asia kohde;
    private boolean[][] onkoKayty;

    public GreedyBestFind(Hahmo hahmo, Asia kohde) {
        this.hahmo = hahmo;
        this.kohde = kohde;
        onkoKayty = new boolean[hahmo.kartanMitat().x + 1][hahmo.kartanMitat().y + 1];

    }

    @Override
    public Suunta etene() {
        Suunta suunta = Suunta.ISTU;
        onkoKayty = new boolean[hahmo.kartanMitat().x + 1][hahmo.kartanMitat().y + 1];
        PriorityQueue<Solmu> tutkittavat = new PriorityQueue<Solmu>();
        Solmu nykyinen = null;
        onkoKayty[hahmo.sijainti().x][hahmo.sijainti().y] = true;

        ArrayDeque<Point> viereiset = this.viereiset(hahmo.sijainti().x, hahmo.sijainti().y);
        while (!viereiset.isEmpty()) {
            Point v = viereiset.poll();
            tutkittavat.add(new Solmu(v.x, v.y, etaisyys(v.x, v.y, kohde)));
        }

        while (!tutkittavat.isEmpty()) {
            nykyinen = tutkittavat.poll();
            onkoKayty[nykyinen.sijainti().x][nykyinen.sijainti().y] = true;

            if (nykyinen.sijainti().x == kohde.sijainti().x && nykyinen.sijainti().y == kohde.sijainti().y) {
                break;
            }

            viereiset = this.viereiset(nykyinen.sijainti().x, nykyinen.sijainti().y);
            while (!viereiset.isEmpty()) {
                Point v = viereiset.poll();
                tutkittavat.add(new Solmu(v.x, v.y, etaisyys(v.x, v.y, kohde)));
            }

        }
        
        while (nykyinen.edellinen() != null) {
            nykyinen = nykyinen.edellinen();
        }

        return suunnassa(nykyinen);
    }

    /**
     * Laskee manhattan-etäisyyden kahden Asian välillä
     *
     * @param mista lähtö Asia
     * @param minne kohde Asia
     * @return manhattan-etäisyys
     */
    public int etaisyys(int mistaX, int mistaY, Asia kohde) {
        return Math.abs(mistaX - kohde.sijainti().x)
                + Math.abs(mistaY - kohde.sijainti().y);
    }

    /**
     * Palauttaa listan viereisistä vapaista ruuduista. Pahoittelen
     * copy-pastesta.
     *
     * @param x tarkasteltavan ruudun x-koordinaatti
     * @param y tarkasteltavan ruudun y-koordinaatti
     * @return tarkasteltavan ruudun ympärillä olevalt vapaat ruudut.
     */
    public ArrayDeque<Point> viereiset(int x, int y) {
        ArrayDeque<Point> viereiset = new ArrayDeque<Point>();

        //alas
        int minneX = x;
        int minneY = y + 1;

        if (minneX <= hahmo.kartanMitat().x && minneY <= hahmo.kartanMitat().y && minneX >= 0 && minneY >= 0) {
            if (hahmo.getKartta()[minneX][minneY] != null && !hahmo.getKartta()[minneX][minneY].ylitettava()) {

            } else if (!onkoKayty[minneX][minneY]) {
                viereiset.add(new Point(minneX, minneY));
            }
        }
        //ylös
        minneX = x;
        minneY = y - 1;

        if (minneX <= hahmo.kartanMitat().x && minneY <= hahmo.kartanMitat().y && minneX >= 0 && minneY >= 0) {
            if (hahmo.getKartta()[minneX][minneY] != null && !hahmo.getKartta()[minneX][minneY].ylitettava()) {

            } else if (!onkoKayty[minneX][minneY]) {
                viereiset.add(new Point(minneX, minneY));
            }
        }
        //vasemmalle
        minneX = x - 1;
        minneY = y;

        if (minneX <= hahmo.kartanMitat().x && minneY <= hahmo.kartanMitat().y && minneX >= 0 && minneY >= 0) {
            if (hahmo.getKartta()[minneX][minneY] != null && !hahmo.getKartta()[minneX][minneY].ylitettava()) {

            } else if (!onkoKayty[minneX][minneY]) {
                viereiset.add(new Point(minneX, minneY));
            }
        }
        //oikealle
        minneX = x + 1;
        minneY = y;

        if (minneX <= hahmo.kartanMitat().x && minneY <= hahmo.kartanMitat().y && minneX >= 0 && minneY >= 0) {
            if (hahmo.getKartta()[minneX][minneY] != null && !hahmo.getKartta()[minneX][minneY].ylitettava()) {

            } else if (!onkoKayty[minneX][minneY]) {
                viereiset.add(new Point(minneX, minneY));
            }
        }

        return viereiset;
    }

    private Suunta suunnassa(Solmu nykyinen) {
        int eroX = nykyinen.sijainti().x- hahmo.sijainti().x;
        int eroY = nykyinen.sijainti().y - hahmo.sijainti().y;
        
        if (eroX == 0 && eroY == -1) return Suunta.YLOS;
        else if (eroX == 0 && eroY == 1) return Suunta.ALAS;
        else if (eroX == 1 && eroY == 0) return Suunta.OIKEA;
        return Suunta.VASEN;
    }

}
