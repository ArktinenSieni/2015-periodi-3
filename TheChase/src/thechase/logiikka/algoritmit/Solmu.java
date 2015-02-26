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
    private Solmu seuraava;
    int prioriteetti;
    int paino;
    boolean kayty;

    public Solmu(int x, int y, int prioriteetti) {
        this.x = x;
        this.y = y;
        this.prioriteetti = prioriteetti;
        this.edellinen = null;
        this.seuraava = null;
        this.kayty = false;
        this.paino = 0;
    }

    public Solmu(int x, int y, int prioriteetti, Solmu edel) {
        this.x = x;
        this.y = y;
        this.prioriteetti = prioriteetti;
        this.edellinen = edel;
        this.seuraava = null;
        this.kayty = false;
        this.paino = 0;
    }
    
    public int getPaino() {
        return this.paino;
    }
    
    public void setPaino(int paino) {
        this.paino = paino;
    }
    
    public void setKayty() {
        this.kayty = true;
    }
    
    public boolean getKayty() {
        return this.kayty;
    }
    
    public void setPrioriteetti(int prioriteetti) {
        this.prioriteetti = prioriteetti;
    }
    
    public int getPrioriteetti() {
        return this.prioriteetti;
    }
    
    public void setSeuraava(Solmu solmu) {
        this.seuraava = solmu;
    }
    
    public Solmu getSeuraava() {
        return this.seuraava;
    }

    /**
     * Palauttaa solmun sijainnin.
     *
     * @return ensimmäinen on x-arvo, toinen y-arvo.
     */
    public Point sijainti() {
        return new Point(x, y);
    }

    public void setEdellinen(Solmu solmu) {
        this.edellinen = solmu;
    }

    /**
     * Palauttaa edellisen solmun. Solmut muodostavat linkitetyn listan kohteesta Hahmoon.
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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Solmu other = (Solmu) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

}
