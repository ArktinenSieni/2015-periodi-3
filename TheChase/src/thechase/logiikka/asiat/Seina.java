/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka.asiat;

/**
 * 
 * @author TheArctic
 */
public class Seina implements Asia {
    private int x;
    private int y;
    
    public Seina(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int[] sijainti() {
        int [] sij = new int[2];
        sij[0] = x;
        sij[1] = y;
        
        return sij;
    }

    @Override
    public boolean ylitettava() {
        return false;
    }
    
}
