/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase;

import java.util.ArrayList;
import java.util.Random;
import thechase.UI.GUI;
import thechase.UI.TekstiUI;
import thechase.logiikka.Lauta;
import thechase.logiikka.Paivitettava;
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
    private GUI GUITesti;
    private ArrayList<Paivitettava> paivitettavat;
    
    
    public Thechase() {
        gameOver = false;
        lauta = new Lauta(50, 30);
        
        //objektit testejä varten. Myöhemmin koodaan niin ettei tarvitse kovakoodata
        sankari = new Hahmo(lauta);
        hirvio = new Hahmo(lauta);
        arpoja = new Random();
        palkinto = new Palkinto(3, 4, lauta);
        
        hirvio.setSijainti(arpoja.nextInt(lauta.getKartta().length - 2) + 1, arpoja.nextInt(lauta.getKartta()[0].length - 2) + 1);
        lauta.paivita();
        
        // testimetodeita
        this.UITesti = new TekstiUI(lauta);
        this.GUITesti = new GUI(lauta);
    }
    
    public void kaynnista() {
        hirvio.setPahis();
        GUITesti.run();
        
    }
    
    public void gameOver() {
        // Sankarin Sijainti
        int[] SS = sankari.sijainti();
        // Hirviön sijainti
        int[] HS = hirvio.sijainti();
        // Palkinnon sijainti
        int[] PS = palkinto.sijainti();
        
        if (SS[0] == HS[0] && SS[1] == HS[1]) {
            this.gameOver = true;
            System.out.println("Sankari syötiin!");
        } else if (SS[0] == PS[0] && SS[1] == PS[1]) {
            this.gameOver = true;
            System.out.println("Aarre löytyi!");
        }
        
    }
    
    private void peliLooppi() {
        
        while(!gameOver) {
            for (Paivitettava p : paivitettavat) {
                p.paivita();
            }
        }
    }
    
    
}
