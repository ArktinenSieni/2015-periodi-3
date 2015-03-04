package thechase;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import thechase.UI.GUI;
import thechase.logiikka.Lauta;
import thechase.logiikka.Paivitettava;
import thechase.logiikka.algoritmit.AStar;
import thechase.logiikka.algoritmit.GreedyBestFind;
import thechase.logiikka.algoritmit.Zombi;
import thechase.logiikka.asiat.Hahmo;
import thechase.logiikka.asiat.Palkinto;

/**
 * Pelin pääluokka. Kokoaa luokat yhteen ja hallinnoi niitä.
 *
 * @author mcraty
 */
public class Thechase {

    private Lauta lauta;
    private Hahmo sankari;
    private Hahmo hirvio;
    private Random arpoja;
    private Palkinto palkinto;
    private GUI GUI;
    private ArrayList<Paivitettava> paivitettavat;
    private Scanner lukija;

    public Thechase() {
        lukija = new Scanner(System.in);

        arpoja = new Random();

    }

    /**
     * Käynnistää ohjelman.
     */
    public void kaynnista() {
        int kierroksia = 0;
        while (true) {
            System.out.println("Aloita painamalla enteriä");
            System.out.println("Poistu syötteellä: e ");
            if (kierroksia > 0) {
                lukija.nextLine();
            }
            String komento = lukija.nextLine();
            if (komento.equals("e")) {
                System.exit(0);
            }

            System.out.println("");

            alusta();
            GUI.run();

            System.out.println("");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                continue;
            }

            peliLooppi();
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                continue;
            }
            GUI.closeWindow();
            kierroksia++;
        }
    }

    /**
     * Alustaa kaikki ohjelman objektit.
     */
    public void alusta() {
        alustaKartta();
        alustaAsiat();

        paivitettavat = new ArrayList<Paivitettava>();
        GUI = new GUI(lauta);
        paivitettavat.add(GUI);
        paivitettavat.add(lauta);
        lauta.paivita();
        GUI.paivita();
    }
    
    /**
     * Arpoo kaksi kokonaislukua Asia-olioiden sijainnin määrittelemiseksi.
     * @return x- ja y- koordinaatit point-oliossa.
     */
    public Point arvoSijainti() {
        int x = 0;
        int y = 0;

        while (!sankari.onkoVapaa(new Point(x, y))) {
            x = arpoja.nextInt(lauta.getKartta().length - 2) + 1;
            y = arpoja.nextInt(lauta.getKartta()[0].length - 2) + 1;
        }
        return new Point(x, y);
    }
    
    /**
     * Alustaa kaikki ohjelman interaktiiviset osat.
     */
    public void alustaAsiat() {
        sankari = new Hahmo(lauta);
        hirvio = new Hahmo(lauta);
        Point arvottuSijainti = arvoSijainti();
        palkinto = new Palkinto(arvottuSijainti.x, arvottuSijainti.y, lauta);

        sankari.setAlgo(new AStar(sankari, palkinto, hirvio));
        arvottuSijainti = arvoSijainti();
        sankari.setSijainti(arvottuSijainti.x, arvottuSijainti.y);

        hirvio.setPahis();
        hirvio.setAlgo(new AStar(hirvio, sankari));
        arvottuSijainti = arvoSijainti();
        hirvio.setSijainti(arvottuSijainti.x, arvottuSijainti.y);
        
//        sankari.setAlgo(new GreedyBestFind(sankari, hirvio));
//        hirvio.setAlgo(new Zombi(hirvio, sankari));
    }
    
    /**
     * Alustaa laudan ja sen kartan.
     */
    public void alustaKartta() {
        System.out.println("Anna kartan mitat");
        System.out.println("x: ");
        int syote;
        try {
            syote = lukija.nextInt();
        } catch (Exception e) {
            System.out.println("Syötteen on oltava kokonaisluku. Asetetaan x = 50");
            syote = 50;
        }
        int x = syote;

        System.out.println("y: ");
        try {
            syote = lukija.nextInt();
        } catch (Exception e) {
            System.out.println("Syötteen on oltava kokonaisluku. Asetetaan y = 50");
            syote = 50;
        }
        int y = syote;

        lauta = new Lauta(x, y);

        System.out.println("Syötä esteiden esiintymistiheys (0-30)");
        try {
            syote = lukija.nextInt();
        } catch (Exception e) {
            System.out.println("Syötteen oltava kokonaisluku. Asetetaan tiheydeksi 20");
            syote = 20;
        }

        lauta.getGeneroija().generoiTemplate(lauta.getKartta());
        lauta.getGeneroija().generoiEsteita(lauta.getKartta(), syote);
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
        while (!gameOver()) {
            try {
                Thread.sleep(15);
            } catch (InterruptedException ex) {
                continue;
            }
            hirvio.liiku();
            sankari.liiku();
            int liikkuukoKahdesti = arpoja.nextInt(100);
            if (liikkuukoKahdesti <= 3) {
                hirvio.liiku();
            }

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
