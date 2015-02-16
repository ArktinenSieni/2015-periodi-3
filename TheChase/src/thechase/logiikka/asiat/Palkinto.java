/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka.asiat;

import java.awt.Color;
import java.awt.Point;
import thechase.logiikka.Lauta;

/**
 * Sankarin kohde.
 * @author TheArctic
 */
public class Palkinto implements Asia{
    private final int x;
    private final int y;
    
    public Palkinto (int x, int y, Lauta lauta) {
        this.x = x;
        this.y = y;
        lauta.lisaaObjekti(this);
    }
    
    
    
    @Override
    public Point sijainti() {
        return new Point(x,y);       
    }

    @Override
    public boolean ylitettava() {
        return true;
    }
    
    @Override
    public String toString() {
        return "P";
    }

    @Override
    public Color GetVari() {
        return Color.YELLOW;
    }
    
}
