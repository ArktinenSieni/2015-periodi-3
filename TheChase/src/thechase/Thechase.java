/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase;

import java.util.Random;
import thechase.UI.TekstiUI;
import thechase.logiikka.Lauta;
import thechase.logiikka.asiat.Hahmo;
import thechase.logiikka.asiat.Palkinto;

/**
 * Pelin pääluokka. Kokoaa luokat yhteen ja hallinnoi niitä.
 * @author TheArctic
 */
public class Thechase {
    private boolean gameOver;
    private Lauta lauta;
    private Hahmo sankari;
    private Hahmo hirvio;
    private Random arpoja;
    private Palkinto palkinto;
    
    // testiolioita
    
    private TekstiUI UITesti;
    
    
    public Thechase() {
        gameOver = false;
        lauta = new Lauta(20, 20);
        sankari = new Hahmo(lauta);
        hirvio = new Hahmo(lauta);
        arpoja = new Random();
        palkinto = new Palkinto(15, 15, lauta);
        
        hirvio.setSijainti(5, 5);
        lauta.paivita();
        
        // testimetodeita
        this.UITesti = new TekstiUI(lauta);
    }
    
    public void kaynnista() {
        UITesti.piirra();
    }
    
    public void gameOver() {
        
    }
}
