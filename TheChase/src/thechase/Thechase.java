
package thechase;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import thechase.UI.GUI;
import thechase.UI.TekstiUI;
import thechase.logiikka.Lauta;
import thechase.logiikka.Paivitettava;
import thechase.logiikka.algoritmit.AStar;
import thechase.logiikka.algoritmit.GreedyBestFind;
import thechase.logiikka.algoritmit.Zombi;
import thechase.logiikka.asiat.Hahmo;
import thechase.logiikka.asiat.Palkinto;

/**
 * Pelin pääluokka. Kokoaa luokat yhteen ja hallinnoi niitä.
 * @author TheArctic
 */
public class Thechase {
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
        lauta = new Lauta(50, 50);
        lauta.getGeneroija().generoiEsteita(lauta.getKartta(), 20);
        
        //objektit testejä varten. Myöhemmin koodaan niin ettei tarvitse kovakoodata
        sankari = new Hahmo(lauta);
        hirvio = new Hahmo(lauta);
        arpoja = new Random();
        palkinto = new Palkinto(arpoja.nextInt(lauta.getKartta().length - 2) + 1, arpoja.nextInt(lauta.getKartta()[0].length - 2) + 1, lauta);
        
        
        hirvio.setSijainti(arpoja.nextInt(lauta.getKartta().length - 2) + 1, arpoja.nextInt(lauta.getKartta()[0].length - 2) + 1);
        sankari.setSijainti(arpoja.nextInt(lauta.getKartta().length - 2) + 1, arpoja.nextInt(lauta.getKartta()[0].length - 2) + 1);
        
        lauta.paivita();
        
        // testimetodeita
        this.UITesti = new TekstiUI(lauta);
        this.GUITesti = new GUI(lauta);
        
        //Päivitettävät objektit
        paivitettavat = new ArrayList<Paivitettava>();
        paivitettavat.add(lauta);
        paivitettavat.add(GUITesti);
    }
    
    /**
     * Käynnistää ohjelman.
     */
    public void kaynnista() {
        hirvio.setPahis();
        
        sankari.setAlgo(new AStar(sankari, palkinto, hirvio));
        hirvio.setAlgo(new AStar(hirvio, sankari));
        GUITesti.run();
        peliLooppi();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.exit(0);
        }
        System.exit(0);
    }
    
    /**
     * Tarkastaa pelin jatkumisen ehdot.
     * 
     * @return Päättyikö peli?
     */
    public boolean gameOver() {
        // Sankarin Sijainti
        Point SS = sankari.sijainti();
        // Hirviön sijainti
        Point HS = hirvio.sijainti();
        // Palkinnon sijainti
        Point PS = palkinto.sijainti();
        
        if (SS.x == HS.x && SS.y == HS.y) {
            System.out.println("Sankari syötiin!");
            return true;
        } else if (SS.x == PS.x && SS.y == PS.y) {
            System.out.println("Aarre löytyi!");
            return true;
        }
        
        return false;
    }
    
    /**
     * Huolehtii pelin tapahtumien toteuttamisesta oikeassa järjestyksessä.
     */
    private void peliLooppi() {
//        Scanner lukija = new Scanner(System.in);
        while(!gameOver()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                continue;
            }
            hirvio.liiku();
            sankari.liiku();
            
            for (Paivitettava p : paivitettavat) {
//                System.out.println("Paina enteriä edetäksesi");
//                String komento = "kana";
//                
//                while (!komento.equals("")) {
//                    komento = lukija.nextLine();
//                }
                p.paivita();
            }
        }
        
    }
    
    
}
