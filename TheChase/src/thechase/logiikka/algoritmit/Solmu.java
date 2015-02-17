package thechase.logiikka.algoritmit;

import java.awt.Point;
import thechase.logiikka.Suunta;

/**
 * Solmu reitinlaskemisen avuksi.
 *
 * @author mcraty
 */
public class Solmu implements Comparable<Solmu> {

    private int x;
    private int y;
    private Solmu edellinen;
    int prioriteetti;

    public Solmu(int x, int y, int prioriteetti) {
        this.x = x;
        this.y = y;
        this.prioriteetti = prioriteetti;
        this.edellinen = null;
    }

    public Solmu(int x, int y, int prioriteetti, Solmu edel) {
        this.x = x;
        this.y = y;
        this.prioriteetti = prioriteetti;
        this.edellinen = edel;
    }

    /**
     * Palauttaa solmun sijainnin.
     *
     * @return ensimmäinen on x-arvo, toinen y-arvo.
     */
    public Point sijainti() {
        return new Point(x, y);
    }

    

    /**
     * Palauttaa edellisen solmun.
     *
     * @return solmu
     */
    public Solmu edellinen() {
        return edellinen;
    }

    @Override
    public int compareTo(Solmu s) {
        if (this.prioriteetti == s.prioriteetti) {
            return 0;
        } else {
            return this.prioriteetti > s.prioriteetti ? 1 : -1;
        }
    }

}
