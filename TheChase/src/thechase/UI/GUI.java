/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.UI;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import thechase.logiikka.Lauta;
import thechase.logiikka.Paivitettava;

/**
 *
 * @author TheArctic
 */
public class GUI implements Runnable, Paivitettava{
    private JFrame frame;
    private Lauta lauta;
    private Piirtoalusta alusta;
    
    public GUI(Lauta lauta) {
        this.lauta = lauta;
        this.alusta = new Piirtoalusta(lauta);
    }
    

    @Override
    public void run() {
        frame = new JFrame("Jahtimakkara");
        
        final int korkeus = lauta.getKartta().length * 10 + 20;
        final int leveys = lauta.getKartta()[0].length * 10;
        Dimension koko = new Dimension(leveys, korkeus);
        
        frame.setPreferredSize(koko);
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.add(alusta);
    }

    @Override
    public void paivita() {
        alusta.paivita();
    }

    @Override
    public Paivitettava getPaivitettava() {
        return alusta;
    }
    
}
