/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka;

/**
 *
 * @author TheArctic
 */
public enum Suunta {
    YLOS(0, -1), ALAS(0, 1), VASEN(-1, 0), OIKEA(1, 0), ISTU(0, 0);
    public final int x,y;
    
    private Suunta(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
}
