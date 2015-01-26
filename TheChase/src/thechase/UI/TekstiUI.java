/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.UI;

import thechase.logiikka.Lauta;
import thechase.logiikka.Paivitettava;

/**
 * Laudan piirtäminen tekstikäyttöliittymällä.
 * @author TheArctic
 */
public class TekstiUI implements Paivitettava{
    Lauta juma;
    
    /**
     * Such pun.
     * @param lauta piirrettävä lauta.
     */
    public TekstiUI(Lauta lauta) {
        this.juma = lauta;
    }
    
    /**
     * Piirtää/kirjoittaa laudan.
     * 
     */
    public void piirra() {
        for (int i = 0; i < juma.getKartta().length; i++) {
            for (int j = 0; j < juma.getKartta()[i].length; j++) {
                if (juma.getKartta()[i][j] == null) {
                    System.out.print(".");
                } else {
                    System.out.print(juma.getKartta()[i][j].toString());
                }
            }
            System.out.println("");
        }
    }

    @Override
    public void paivita() {
        piirra();
    }
    
}
