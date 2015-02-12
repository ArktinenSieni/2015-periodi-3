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
    private boolean keratty;
    private boolean avoinna;
    
    public Palkinto (int x, int y, Lauta lauta) {
        this.x = x;
        this.y = y;
        this.avoinna = true;
        
        lauta.lisaaObjekti(this);
    }
    
    /**
     * Kertoo onko kerätty. Jos on kerätty, ei siihen vaikuta enään hahmon toiminta.
     * @param arvo 
     */
    public void setKeratty(boolean arvo) {
        this.keratty = arvo;
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
