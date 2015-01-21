/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka.asiat;

import java.util.ArrayList;
import thechase.logiikka.Lauta;

/**
 * Sankari ja hirviö perivät tämän luokan omaten sijainnin palauttamisen ja
 * perusliikkumismetodit.
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

    /**
     * Luo <Code>Hahmo</Code>n.
     *
     * @param lauta Lauta jolle Hahmo luodaan.
     */
    public Hahmo(Lauta lauta) {
        this.kartta = lauta.getKartta();
        this.objektit = lauta.getObjektit();
        this.maxX = kartta.length - 1;
        this.maxY = kartta[0].length - 1;
        lauta.lisaaObjekti(this);

        this.x = maxX / 2;
        this.y = maxY / 2;
    }

    /**
     * Asettaa <code>Hahmo</code>n sijainnin.
     *
     * @param x
     * @param y
     */
    public boolean setSijainti(int x, int y) {
        if ((x < maxX && x >= 0) && (y < maxY && y >= 0)) {
            this.x = x;
            this.y = y;
            return true;
        } else {
            System.out.println("Virheelliset parametrit");
            return false;
        }

    }

    /**
     * Liikuttaa <Code>Hahmo</Code>a ylös.
     * @return onnustuiko siirtyminen.
     */
    public boolean ylos() {
        if (this.y > 0) {
            setSijainti(x, y - 1);
            return true;
        } else {
            System.out.println("Yngh!");
            return false;
        }
    }

    /**
     * Liikuttaa <Code>Hahmo</Code>a alas.
     * @return onnustuiko siirtyminen.
     */
    public boolean alas() {
        if (this.y < this.maxY) {
            setSijainti(x, y + 1);
            return true;
        } else {
            System.out.println("Yngh!");
            return false;
        }
    }

    /**
     * Liikuttaa <Code>Hahmo</Code>a vasemmalle.
     * @return onnustuiko siirtyminen.
     */
    public boolean vasemmalle() {
        if (this.x > 0) {
            setSijainti(x - 1, y);
            return true;
        } else {
            System.out.println("Yngh!");
            return false;
        }
    }

    /**
     * Liikuttaa <Code>Hahmo</Code>a oikealle.
     * @return onnustuiko siirtyminen.
     */
    public boolean oikealle() {
        if (this.x < this.maxX) {
            setSijainti(x + 1, y);
            return true;
        } else {
            System.out.println("Yngh!");
            return false;
        }
    }

    @Override
    public int[] sijainti() {
        int[] s = new int[2];
        s[0] = x;
        s[1] = y;

        return s;
    }

    @Override
    public boolean ylitettava() {
        return true;
    }

}
