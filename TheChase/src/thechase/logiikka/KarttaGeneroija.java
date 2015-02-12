/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka;

import java.util.Random;
import thechase.logiikka.asiat.Asia;
import thechase.logiikka.asiat.Seina;

/**
 * Sisältää kartan generointimetodit.
 * @author TheArctic
 */
public class KarttaGeneroija {
    private Random arpoja;
    
    public KarttaGeneroija() {
        arpoja = new Random();
    }
    /**
     * Piirtää ulkoseinät
     * @param kartta johon seinät lisätään
     * @return generoitu kartta
     */
    public Asia[][] generoiTemplate(Asia[][] kartta) {
        for (int i = 0; i < kartta.length; i++) {
            kartta[i][0] = new Seina(i, 0);
            kartta[i][kartta[0].length - 1] = new Seina(i, kartta[0].length - 1);
        }
        
        for (int i = 0; i < kartta[0].length; i++) {
            kartta[0][i] = new Seina(0, i);
            kartta[kartta.length - 1][i] = new Seina(kartta.length - 1, i);
        }
        
        return kartta;
    }
    
    public Asia[][] generoiEsteita(Asia[][] kartta, int tiheys) {
        int tih = tiheys;
        
        if (tih > 50) {
            tih = 49;
        }
        
        for (int i = 0; i < kartta.length; i++) {
            for (int j = 0; j < kartta[0].length; j++) {
                int arpa = arpoja.nextInt(100);
                
                if (arpa <= tih) {
                    kartta[i][j] = new Seina(i, j);
                }
            }
        }
        
        return kartta;
    }
    
}
