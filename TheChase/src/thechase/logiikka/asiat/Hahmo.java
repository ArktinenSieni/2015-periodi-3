
package thechase.logiikka.asiat;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import thechase.logiikka.Lauta;
import thechase.logiikka.Suunta;
import thechase.logiikka.algoritmit.Algoritmi;

/**
 * Tästä luokasta tehdään hirviö- ja sankari-oliot.
 *
 * @author TheArctic
 *
 */
public class Hahmo implements Asia {

    private int x;
    private int y;
    private ArrayList<Asia> objektit;
    private Asia[][] kartta;
    private int maxX;
    private int maxY;
    private boolean pahis;
    private Algoritmi algoritmi;
    private Lauta lauta;

    /**
     * Luo Hahmon.
     *
     * @param lauta Lauta jolle Hahmo luodaan.
     */
    public Hahmo(Lauta lauta) {
        this.lauta = lauta;
        this.kartta = lauta.getKartta();
        this.objektit = lauta.getObjektit();
        this.maxX = kartta.length - 1;
        this.maxY = kartta[0].length - 1;
        this.x = maxX / 2;
        this.y = maxY / 2;
        lauta.lisaaObjekti(this);
        pahis = false;

    }
    
    public Asia[][] getKartta() {
        return lauta.getKartta();
    }
    
    public Point kartanMitat() {
        return new Point(maxX, maxY);
    }
    
    /**
     * Asettaa aktiivisen algoritmin, joka antaa liikkumisohjeet.
     * @param algo haluttu algoritmi
     */
    public void setAlgo(Algoritmi algo) {
        this.algoritmi = algo;
    }

    /**
     * Liikkuu valitun algoritmin ohjeiden mukaan.
     */
    public void liiku() {
        if (algoritmi != null) {
            Suunta suunta = this.algoritmi.etene();
            this.x += suunta.x;
            this.y += suunta.y;
        }
    }

    /**
     * Asettaa Hahmon sijainnin.
     *
     * @param x
     * @param y
     */
    public boolean setSijainti(int x, int y) {
        if ((x < maxX && x > 0) && (y < maxY && y > 0) && (kartta[x][y] == null || kartta[x][y].ylitettava())) {
            this.x = x;
            this.y = y;
            return true;
        } else {
            System.out.println("Virheelliset parametrit: " + x + " " + y);
            return false;
        }

    }

    public void setPahis() {
        if (this.pahis) {
            pahis = false;
        } else {
            pahis = true;
        }
    }

    public boolean getPahis() {
        return pahis;
    }

    /**
     * Onko yläruutu vapaa.
     *
     * @return onko vapaa.
     */
    public boolean ylosVapaa() {
        if (this.y > 0 && (kartta[x][y - 1] == null || kartta[x][y - 1].ylitettava())) {
            return true;
        }
        return false;
    }

    /**
     * Liikuttaa Hahmoa ylös.
     *
     * @return onnustuiko siirtyminen.
     */
    public boolean ylos() {
        if (ylosVapaa()) {
            setSijainti(x, y - 1);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Onko alempi ruutu vapaa.
     *
     * @return onko vapaa.
     */
    public boolean alasVapaa() {
        if (this.y < this.maxY && (kartta[x][y + 1] == null || kartta[x][y + 1].ylitettava())) {
            return true;
        }
        return false;
    }

    /**
     * Liikuttaa Hahmoa alas.
     *
     * @return onnustuiko siirtyminen.
     */
    public boolean alas() {
        if (alasVapaa()) {
            setSijainti(x, y + 1);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Onko vasemmanpuoleinen ruutu vapaa.
     *
     * @return onko vapaa.
     */
    public boolean vasemmalleVapaa() {
        if (this.x > 0 && (kartta[x - 1][y] == null || kartta[x - 1][y].ylitettava())) {
            return true;
        }
        return false;
    }

    /**
     * Liikuttaa Hahmoa vasemmalle.
     *
     * @return onnustuiko siirtyminen.
     */
    public boolean vasemmalle() {
        if (vasemmalleVapaa()) {
            setSijainti(x - 1, y);
            return true;
        } else {
            return false;
        }
    }

    public boolean oikealleVapaa() {
        if (this.x < this.maxX && (kartta[x + 1][y] == null || kartta[x + 1][y].ylitettava())) {
            return true;
        }
        return false;
    }

    /**
     * Liikuttaa Hahmoa oikealle.
     *
     * @return onnustuiko siirtyminen.
     */
    public boolean oikealle() {
        if (oikealleVapaa()) {
            setSijainti(x + 1, y);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Point sijainti() {
        return new Point(x, y);
    }

    @Override
    public boolean ylitettava() {
        return true;
    }

    @Override
    public String toString() {
        if (pahis) {
            return "M";
        }
        return "H";
    }

    @Override
    public Color GetVari() {
        if (pahis) {
            return Color.RED;
        }
        return Color.BLUE;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.x;
        hash = 89 * hash + this.y;
        hash = 89 * hash + (this.pahis ? 1 : 0);
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
        final Hahmo other = (Hahmo) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        if (this.pahis != other.pahis) {
            return false;
        }
        return true;
    }

}
