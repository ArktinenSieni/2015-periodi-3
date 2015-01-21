/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechase.logiikka;

import thechase.logiikka.asiat.Asia;
import thechase.logiikka.asiat.Seina;

/**
 *
 * @author TheArctic
 */
public class KarttaGeneroija {
    
    public KarttaGeneroija() {
        
    }
    
    public Asia[][] generoiTemplate(Asia[][] kartta) {
        int i = 0;
        int j = 0;
        while (i < kartta.length) {
            kartta[i][j] = new Seina(i, j);
            i++;
        }
        while (j < kartta[i].length) {
            kartta[i][j] = new Seina(i, j);
            j++;
        }
        while (i >= 0) {
            kartta[i][j] = new Seina(i, j);
            i--;
        }
        while (j >= 0) {
            kartta[i][j] = new Seina(i, j);
            j--;
        }
        return kartta;
    }
}
