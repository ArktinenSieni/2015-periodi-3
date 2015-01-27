/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka.asiat;

import java.awt.Color;
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
    private boolean pahis;

    /**
     * Luo Hahmon.
     *
     * @param lauta Lauta jolle Hahmo luodaan.
     */
    public Hahmo(Lauta lauta) {
        this.kartta = lauta.getKartta();
        this.objektit = lauta.getObjektit();
        this.maxX = kartta.length - 1;
        this.maxY = kartta[0].length - 1;
        this.x = maxX / 2;
        this.y = maxY / 2;
        lauta.lisaaObjekti(this);
        pahis = false;

    }

    /**
     * Asettaa Hahmon sijainnin.
     *
     * @param x
     * @param y
     */
    public boolean setSijainti(int x, int y) {
        if ((x < maxX && x > 0) && (y < maxY && y > 0)) {
            this.x = x;
            this.y = y;
            return true;
        } else {
            System.out.println("Virheelliset parametrit" + x + " " + y);
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
     * Liikuttaa <Code>Hahmo</Code>a ylös.
     * @return onnustuiko siirtyminen.
     */
    public boolean ylos() {
        if (this.y > 0 && kartta[x][y - 1].ylitettava()) {
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
        if (this.y < this.maxY && kartta[x][y + 1].ylitettava()) {
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
        if (this.x > 0 && kartta[x - 1][y].ylitettava()) {
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
        if (this.x < this.maxX && kartta[x + 1][y].ylitettava()) {
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

    @Override
    public String toString() {
        if(pahis) {
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

}
