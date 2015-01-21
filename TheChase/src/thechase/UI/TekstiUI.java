/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.UI;

import thechase.logiikka.Lauta;
import thechase.logiikka.Paivitettava;

/**
 *
 * @author TheArctic
 */
public class TekstiUI implements Paivitettava{
    Lauta juma;
    
    public TekstiUI(Lauta lauta) {
        this.juma = lauta;
    }
    
    public void piirra() {
        for (int i = 0; i < juma.getKartta().length; i++) {
            for (int j = 0; j < juma.getKartta()[i].length; j++) {
                if (juma.getKartta()[i][j] == null) {
                    System.out.print(".");
                } else if (juma.getKartta()[i][j].nimi().equals("hahmo")) {
                    System.out.print("S");
                } else if (juma.getKartta()[i][j].nimi().equals("seina")) {
                    System.out.print("#");
                }
            }
            System.out.println("");
        }
    }

    @Override
    public void paivita() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
