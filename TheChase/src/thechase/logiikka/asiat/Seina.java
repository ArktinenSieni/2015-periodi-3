/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka.asiat;

import java.awt.Color;
import java.awt.Point;

/**
 * Seinän luova luokka. Asia jota ei voi ylittää, siitä ei  voi alittaa. 
 * Täytyy mennä ympäri!
 * @author TheArctic
 */
public class Seina implements Asia {
    private final int x;
    private final int y;
    
    public Seina(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Point sijainti() {
        return new Point(x, y);
    }

    @Override
    public boolean ylitettava() {
        return false;
    }

    @Override
    public String toString() {
        return "#";
    }

    @Override
    public Color GetVari() {
        return Color.LIGHT_GRAY;
    }

    
    
}
